package com.agumon.mail.service.impl;


import com.agumon.config.MainConfigManager;
import com.agumon.mail.factory.MailProviderType;
import com.agumon.mail.model.MailRequest;
import com.agumon.mail.model.EmailType;
import com.agumon.mail.service.SendGridMailService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class SendGridMailServiceImpl implements SendGridMailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendGridMailServiceImpl.class);

    private static final String EMAIL_ENPOINT = "mail/send";

    @Override
    public boolean sendMailByTemplate(MailRequest mailRequest) {
        this.buildMailRequest(mailRequest);
        return requestSendGrid(convertToMail(mailRequest, true));
    }

    @Override
    public boolean sendMailByEmailData(MailRequest mailRequest) {
        this.buildMailRequest(mailRequest);
        return requestSendGrid(convertToMail(mailRequest, false));
    }


    private void buildMailRequest(MailRequest request) {
        Set<String> toMails = new HashSet<>();
        String[] listDomain = MainConfigManager.config().mailSendDomain().split(",");

        // check toMails
        for (String email : request.getToMails()) {
            String domainRequest = email.split("@")[1];
            for (String domain : listDomain) {
                if (domain.equalsIgnoreCase(domainRequest)) {
                    toMails.add(email);
                }
            }
        }
        request.setToMails(toMails);
    }

    private boolean requestSendGrid(Mail mail) {
        // Config api key and send mail request
        final String sendGridToken = MainConfigManager.config().token();
        SendGrid sendGrid = new SendGrid(StringUtils.isNotEmpty(sendGridToken) ? sendGridToken : Strings.EMPTY);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint(EMAIL_ENPOINT);
            request.setBody(mail.build());

            Response response = sendGrid.api(request);
            if (Objects.nonNull(response)) {
                parseJsonMessage(response);
                LOGGER.info(response.getBody());
            }
        } catch (IOException e) {
            LOGGER.error(getClass().toString().concat("SEND MAIL USE SENDGRID::: ").concat(e.getMessage()));
            return false;
        }
        return true;
    }

    private void parseJsonMessage(final Response response) {
        try {
            JSONObject jsonObject = new JSONObject(response.getBody());
            JSONArray jsonArray = jsonObject.has("errors") ? jsonObject.getJSONArray("errors") : null;
            if (Objects.nonNull(jsonArray)) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject dataObject = jsonArray.getJSONObject(i);
                    if (Objects.nonNull(dataObject)) {
                        String message = dataObject.has("config") ? dataObject.getString("config") : null;
                        if (StringUtils.isNotEmpty(message)) {
                            LOGGER.error(message);
                            //throw new Exception(message);
                        }
                    }
                }
            }
        } catch (JSONException ignored) {
            ignored.printStackTrace();
        }
    }

    private Mail convertToMail(final MailRequest mailRequest, final boolean hasTemplate) {
        String fromEmail = MainConfigManager.config().fromAccount();
        Email from = new Email(fromEmail);
        Mail mail = new Mail();
        if (hasTemplate) {
            mail.setFrom(from);
            mail.setTemplateId(getTemplateId(mailRequest.getEmailType()));
            mail.setTemplateId("");
            if (CollectionUtils.isNotEmpty(mailRequest.getToMails())) {
                Personalization personalization = new Personalization();
                mailRequest.getToMails().forEach(it -> personalization.addTo(new Email(it)));
                mailRequest.getData().forEach(personalization::addDynamicTemplateData);
                mail.addPersonalization(personalization);
            }
        } else {
            String subject = "Agumon Test Report";
            Content content = new Content("text/plain", mailRequest.getData().toString());
            Email to = new Email(mailRequest.getTo());
            mail = new Mail(from, subject, to, content);
        }
        return mail;
    }

    private String getTemplateId(final EmailType type) {
        switch (type) {
            case REQUEST_USER:
                return MainConfigManager.config().requestUserTemplate();
            case CREATE_USER:
            default:
                return StringUtils.EMPTY;
        }
    }

    @Override
    public MailProviderType mailProviderType() {
        return MailProviderType.SEND_GRID;
    }
}
