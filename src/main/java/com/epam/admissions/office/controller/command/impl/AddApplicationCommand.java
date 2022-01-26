package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.ApplicationService;
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

public class AddApplicationCommand implements Command {
    private final Logger logger = Logger.getLogger(AddApplicationCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ApplicationService applicationService = ServiceFactory.getInstance().getApplicationService();
        UserService userService = ServiceFactory.getInstance().getUserService();

        String faculty = request.getParameter(RequestParameter.SELECTED_FACULTY);
        //TODO refactor
        int facultyId = 1;
        int userId = (int) session.getAttribute(SessionAttribute.USER_ID);
        double firstSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_FIRST_SUBJECT));
        double secondSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_SECOND_SUBJECT));
        double thirdSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_THIRD_SUBJECT));

        try {
            if (!applicationService.createApplication(faculty, userId, facultyId, firstSubjectPoints, secondSubjectPoints, thirdSubjectPoints)) {
                session.setAttribute(SessionAttribute.ERROR, session.getAttribute(SessionAttribute.LOCALE) == SessionAttributeValue.LOCALE_RU
                        ? SessionAttributeValue.ALERT_MESSAGE_INCORRECT_DATA_RU : SessionAttributeValue.ALERT_MESSAGE_INCORRECT_DATA_EN);

                response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
            } else {
                userService.changeUserRole(userId, UserRole.USER);
                session.setAttribute(SessionAttribute.USER_ROLE, UserRole.USER);
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_PROFILE_PAGE);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.PROFILE_PAGE);
                requestDispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            logger.error("Exception in time creating new Application.", e);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
