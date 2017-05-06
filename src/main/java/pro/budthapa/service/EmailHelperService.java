package pro.budthapa.service;

import javax.mail.internet.InternetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Service
public class EmailHelperService {
	Logger log = LoggerFactory.getLogger(EmailHelperService.class);
	
	private static final String SUBJECT ="New User Registration";
	private static final String ENCODING ="UTF-8";
	private static final String FROM ="info@budthapa.pro";
	private static final String FROM_NAME ="Buddhi Bal Thapa";
	
	@Autowired
	public EmailService emailService;

	
	public void sendEmailWithoutTemplating(String registeredEmail, String messageBody) throws Exception{
	   final Email email = DefaultEmail.builder()
	        .from(new InternetAddress(FROM, FROM_NAME))
	        .to(Lists.newArrayList(new InternetAddress(registeredEmail, "")))
	        .subject(SUBJECT)
	        .body("Please click the link to activate your account within 24 hours. "+messageBody)
	        .encoding(ENCODING).build();

	   emailService.send(email);
	}
}
