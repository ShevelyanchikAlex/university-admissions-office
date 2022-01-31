package com.epam.admissions.office.service.util.mail;

import com.epam.admissions.office.service.exception.ServiceException;

import javax.mail.Message;
import javax.mail.Session;

public interface MailUtil {
    void sendMail(String recipient) throws ServiceException;

    Message prepareMessage(Session session, String sender, String recipient) throws ServiceException;
}
