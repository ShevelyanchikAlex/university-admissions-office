package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.CommandName;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.controller.constant.SessionAttributeValue;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOutCommand implements Command {
    private final Logger logger = Logger.getLogger(LogOutCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        logger.info("User " + session.getAttribute(SessionAttribute.USER_EMAIL) + " was log out.");

        session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_HOME_PAGE);

        session.removeAttribute(SessionAttribute.USER_ID);
        session.removeAttribute(SessionAttribute.USER_NAME);
        session.removeAttribute(SessionAttribute.USER_SURNAME);
        session.removeAttribute(SessionAttribute.USER_EMAIL);
        session.removeAttribute(SessionAttribute.USER_PASSPORT_ID);
        session.removeAttribute(SessionAttribute.USER_ROLE);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.HOME_PAGE);
        requestDispatcher.forward(request, response);
    }
}
