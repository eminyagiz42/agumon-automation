package com.agumon.mail.facade;

import com.agumon.mail.model.MailRequest;

public interface MailFacade {

    boolean sendMailByTemplate(final MailRequest mailRequest);

    boolean sendMailByEmailData(final MailRequest mailRequest);
}
