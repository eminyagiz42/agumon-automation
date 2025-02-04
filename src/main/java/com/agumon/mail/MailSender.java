package com.agumon.mail;

import com.agumon.mail.facade.MailFacade;
import com.agumon.mail.facade.impl.MailFacadeImpl;
import com.agumon.mail.factory.MailProvider;
import com.agumon.mail.factory.MailProviderType;
import com.agumon.mail.model.EmailType;
import com.agumon.mail.model.EmployeeSendEmailData;
import com.agumon.mail.model.MailRequest;
import com.agumon.mail.service.impl.SendGridMailServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.agumon.config.MainConfigManager.config;

public class MailSender {

    private static final Logger LOGGER = LogManager.getLogger(MailSender.class);

    public boolean sendMail(ITestContext context) {
        final String testResults = prepareEmailBody(context);
        boolean isSendSuccess = false;
        try {
            EmployeeSendEmailData emailData = new EmployeeSendEmailData();
            emailData.setFirstName("FirstName");
            emailData.setLastName("LastName");
            emailData.setCompany("Agumon Digimon");
            emailData.setNotes(testResults);
            emailData.setEmail(config().sendTo());
            Set<String> toMails = new HashSet<>();

            isSendSuccess = this.sendEmail(emailData, toMails);
            if (isSendSuccess) {
                LOGGER.info("Send Mail is Successful");
            }
        } catch (Exception exception) {
            LOGGER.error("Send Mail is NOT Successful ");
        }
        return isSendSuccess;
    }

    private String prepareEmailBody(ITestContext context) {
        if (context == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (ITestNGMethod method : context.getAllTestMethods()) {
            builder
                    .append("methodName :")
                    .append(method.getMethodName())
                    .append("id :")
                    .append(method.getId())
                    .append("qualifedname :")
                    .append(method.getQualifiedName())
                    .append("description :")
                    .append(method.getDescription())
                    .append("date :")
                    .append(method.getDate())
                    .append("testName :")
                    .append(method.getTestClass().getTestName())
                    .append("name :")
                    .append(method.getTestClass().getName())
                    .append("successPercentage :").append(method.getSuccessPercentage());
            for (String group : method.getGroups()) {
                builder.append("group : ").append(group);
            }
            builder.append(" \n -- \n");
        }
        return builder.toString();
    }

    private boolean sendEmail(EmployeeSendEmailData emailData, Set<String> toMails) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(emailData, Map.class);

        MailRequest mailRequest = new MailRequest();
        mailRequest.setToken(config().token());
        mailRequest.setEmailType(EmailType.REQUEST_USER);
        mailRequest.setSubject("Your customer request is under review");
        mailRequest.setData(map);
        mailRequest.setTo(emailData.getEmail());
        mailRequest.setToMails(toMails);
        mailRequest.setFromName(config().fromName());
        //Attachments attachments = new Attachments();
        //attachments.setContent();
        //https://docs.sendgrid.com/v2-api/mail
        //mailRequest.setAttachments(attachments);

        Map<MailProviderType, SendGridMailServiceImpl> mailServiceByType = new HashMap<>();
        MailProvider mailProvider = new MailProvider(mailServiceByType);
        MailFacade mailFacade = new MailFacadeImpl(mailProvider);
        return mailFacade.sendMailByEmailData(mailRequest);
    }
}
