package com.agumon.mail.factory;

import com.agumon.mail.service.impl.SendGridMailServiceImpl;
import com.agumon.mail.model.MailRequest;

import java.util.Map;

public class MailProvider {

    private final Map<MailProviderType, SendGridMailServiceImpl> mailServiceByType;

    public MailProvider(Map<MailProviderType, SendGridMailServiceImpl> mailServiceByType) {
        this.mailServiceByType = mailServiceByType;
    }

    public boolean execute(boolean template, MailRequest mailRequest) {
        SendGridMailServiceImpl mailService = new SendGridMailServiceImpl();
        if (template) {
            return mailService.sendMailByTemplate(mailRequest);
        } else {
            return mailService.sendMailByEmailData(mailRequest);
        }
    }
}
