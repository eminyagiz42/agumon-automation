package com.agumon.mail.facade.impl;

import com.agumon.mail.facade.MailFacade;
import com.agumon.mail.factory.MailProvider;
import com.agumon.mail.model.MailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MailFacadeImpl implements MailFacade {
    private final Logger logger = LoggerFactory.getLogger(MailFacadeImpl.class);

    private final MailProvider mailProvider;

    public MailFacadeImpl(MailProvider mailProvider) {
        this.mailProvider = mailProvider;
    }


    @Override
    public boolean sendMailByTemplate(final MailRequest mailRequest) {
        return mailProvider.execute(true, mailRequest);
    }

    @Override
    public boolean sendMailByEmailData(final MailRequest mailRequest) {
        boolean success = false;
        if (mailProvider.execute(false, mailRequest)) {
            for (String item : mailRequest.getToMails()) {
                if (logger.isDebugEnabled()) {
                    logger.debug(String.format("Email is : %s And Send When : sendMail", item));
                }
            }
            success = true;
        }
        return success;
    }
}
