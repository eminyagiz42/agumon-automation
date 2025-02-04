package com.agumon.utility.listener;


import com.agumon.mail.MailSender;
import com.agumon.utility.logger.AgumonCustomLogger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;

import static com.agumon.utility.global.Constants.SEND_EMAIL_FLAG;
import static org.junit.Assert.assertTrue;


public class AgumonTestNGListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(AgumonTestNGListener.class);
    public static final String MAIL_NOT_SUCCESSFUL = "Send Mail NOT Successful ";

    @Override
    public void onStart(final ITestContext context) {
        AgumonCustomLogger.printBanner();
    }

    @Override
    public void onFinish(final ITestContext context) {
        if (SEND_EMAIL_FLAG) {
            MailSender mailSender = new MailSender();
            assertTrue(MAIL_NOT_SUCCESSFUL, mailSender.sendMail(context));
            LOGGER.debug("Send grid mail is sending");
        }
    }
}
