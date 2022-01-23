package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.service.ServiceFactory;
import com.epam.admissions.office.service.UserService;
import com.epam.admissions.office.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LogInCommand implements Command {
    private final Logger logger = Logger.getLogger(LogInCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter(RequestParameter.USER_EMAIL);
        String password = request.getParameter((RequestParameter.USER_PASSWORD));

        try {
            UserService userService = ServiceFactory.getInstance().getUserService();
            User user = userService.login(email, password);
            if (user != null) {
                session.setAttribute(SessionAttribute.USER_ID, user.getUserId());
                session.setAttribute(SessionAttribute.USER_NAME, user.getName());
                session.setAttribute(SessionAttribute.USER_SURNAME, user.getSurname());
                session.setAttribute(SessionAttribute.USER_PASSWORD, user.getPasswordHash());
                session.setAttribute(SessionAttribute.USER_EMAIL, user.getEmail());
                session.setAttribute(SessionAttribute.USER_PASSPORT_ID, user.getPassportId());
                session.setAttribute(SessionAttribute.USER_IS_DELETED, user.isDeleted());
                session.setAttribute(SessionAttribute.USER_ROLE, user.getUserRole());
                logger.info("User " + user.getEmail() + "was log in.");
            } else {
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_LOG_IN_PAGE);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.LOG_IN_PAGE);
                requestDispatcher.forward(request, response);
            }
            session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_HOME_PAGE);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.HOME_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            logger.error("It is not possible to check user data at login.", e);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
        requestDispatcher.forward(request, response);
    }
}
