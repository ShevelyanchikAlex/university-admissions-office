package com.epam.admissions.office.service.util.mail.impl;

import com.epam.admissions.office.service.exception.ServiceException;
import com.epam.admissions.office.service.util.mail.MailUtil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtilImpl implements MailUtil {

    @Override
    public void sendMail(String recipient) throws ServiceException {
        //TODO refactor
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "25");

        String myAccountEmail = "shevelyanchik.alex@gmail.com";
        String password = "";

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        try {
            Message message = prepareMessage(session, myAccountEmail, recipient);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Message prepareMessage(Session session, String sender, String recipient) throws ServiceException {
        Message message;
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("My first email!");
            String htmlCode = "<h1> Hello </h1> <br/> <h2><b>Next Line</b></h2>";
            message.setContent(htmlCode, "html/text");
        } catch (MessagingException e) {
            throw new ServiceException(e);
        }
        return message;
    }
}
