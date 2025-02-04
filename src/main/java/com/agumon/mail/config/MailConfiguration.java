package com.agumon.mail.config;

import com.agumon.mail.factory.MailProviderType;
import com.agumon.mail.service.impl.SendGridMailServiceImpl;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MailConfiguration {

    private final List<SendGridMailServiceImpl> mailServices;

    public MailConfiguration(List<SendGridMailServiceImpl> mailServices) {
        this.mailServices = mailServices;
    }

    public Map<MailProviderType, SendGridMailServiceImpl> mailServiceByType() {
        Map<MailProviderType, SendGridMailServiceImpl> mailServicesByType = new EnumMap<>(MailProviderType.class);
        mailServices.forEach(mailService -> mailServicesByType.put(mailService.mailProviderType(),
                mailService));
        return mailServicesByType;
    }
}
