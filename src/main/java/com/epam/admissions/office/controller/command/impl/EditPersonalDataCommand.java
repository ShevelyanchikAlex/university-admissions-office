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

public class EditPersonalDataCommand implements Command {
    private final Logger logger = Logger.getLogger(LogInCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getInstance().getUserService();

        int userId = (int) session.getAttribute(SessionAttribute.USER_ID);
        String name = request.getParameter(RequestParameter.USER_NAME);
        String surname = request.getParameter(RequestParameter.USER_SURNAME);
        String email = request.getParameter(RequestParameter.USER_EMAIL);
        String passportId = request.getParameter(RequestParameter.USER_PASSPORT_ID);

        try {
            if (userService.editPersonalData(userId, name, surname, email, passportId)) {
                session.setAttribute(SessionAttribute.USER_NAME, name);
                session.setAttribute(SessionAttribute.USER_SURNAME, surname);
                session.setAttribute(SessionAttribute.USER_EMAIL, email);
                session.setAttribute(SessionAttribute.USER_PASSPORT_ID, passportId);

                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_PROFILE_PAGE);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.PROFILE_PAGE);
                requestDispatcher.forward(request, response);
            } else {
                session.setAttribute(SessionAttribute.ERROR, session.getAttribute(SessionAttribute.LOCALE) == SessionAttributeValue.LOCALE_RU
                        ? SessionAttributeValue.ALERT_MESSAGE_INCORRECT_LOGIN_DATA_RU : SessionAttributeValue.ALERT_MESSAGE_INCORRECT_LOGIN_DATA_EN);

                response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
            }
        } catch (ServiceException e) {
            logger.error("Exception in time edition personal data.", e);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
