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
        UserService userService = ServiceFactory.getInstance().getUserService();

        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter((RequestParameter.PASSWORD));
        try {
            User user = userService.login(email, password);
            if (user != null) {
                session.setAttribute(SessionAttribute.USER_ID, user.getUserId());
                session.setAttribute(SessionAttribute.USER_NAME, user.getName());
                session.setAttribute(SessionAttribute.USER_SURNAME, user.getSurname());
                session.setAttribute(SessionAttribute.USER_PASSWORD, user.getPasswordHash());
                session.setAttribute(SessionAttribute.USER_EMAIL, user.getEmail());
                session.setAttribute(SessionAttribute.USER_PASSPORT_ID, user.getPassportId());
                session.setAttribute(SessionAttribute.USER_STATUS, user.getUserStatus());
                session.setAttribute(SessionAttribute.USER_ROLE, user.getUserRole());
            } else {
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_LOG_IN_PAGE);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.LOG_IN_PAGE);
                requestDispatcher.forward(request, response);
            }
            session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_HOME_PAGE);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.HOME_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException e) {
            logger.error("Unable check user date in log-in.", e);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_404_PAGE);
            requestDispatcher.forward(request, response);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
        requestDispatcher.forward(request, response);
    }
}
