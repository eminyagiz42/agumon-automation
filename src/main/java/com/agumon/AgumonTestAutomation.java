package com.agumon;


import com.agumon.mail.MailSender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AgumonTestAutomation {

	private static final Logger LOGGER = LogManager.getLogger(AgumonTestAutomation.class);

	public static void main(final String[] args) {
		LOGGER.warn("Welcome to Agumon Test Automation Project");
		MailSender mailSender = new MailSender();
		mailSender.sendMail(null);
	}
}
