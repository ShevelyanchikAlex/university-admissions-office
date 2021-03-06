package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
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

/**
 * Command signup.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class SignUpCommand implements Command {
    private final Logger logger = Logger.getLogger(SignUpCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getInstance().getUserService();

        String name = request.getParameter(RequestParameter.USER_NAME);
        String surname = request.getParameter(RequestParameter.USER_SURNAME);
        String password = request.getParameter(RequestParameter.USER_PASSWORD);
        String confirmPassword = request.getParameter(RequestParameter.CONFIRM_PASSWORD);
        String email = request.getParameter(RequestParameter.USER_EMAIL);
        String passportId = request.getParameter(RequestParameter.USER_PASSPORT_ID);

        try {
            if (userService.getByEmail(email) != null || !userService.signUp(name, surname, email, passportId, password, confirmPassword)) {
                response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
            } else {
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_LOG_IN_PAGE);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.LOG_IN_PAGE);
                requestDispatcher.forward(request, response);
            }
        } catch (ServiceException exception) {
            logger.error("Exception in SignUpCommand: unable to register new user.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
