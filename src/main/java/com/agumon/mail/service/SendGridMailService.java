package com.agumon.mail.service;

import com.agumon.mail.factory.MailProviderType;
import com.agumon.mail.model.MailRequest;

public interface SendGridMailService {

    boolean sendMailByTemplate(MailRequest mailRequest);

    boolean sendMailByEmailData(MailRequest mailRequest);

    MailProviderType mailProviderType();
}

