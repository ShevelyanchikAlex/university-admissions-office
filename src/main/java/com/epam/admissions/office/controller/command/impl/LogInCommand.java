package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.Application;
import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.entity.user.User;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.*;
import com.epam.admissions.office.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class LogInCommand implements Command {
    private final Logger logger = Logger.getLogger(LogInCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getInstance().getUserService();

        String email = request.getParameter(RequestParameter.USER_EMAIL);
        String password = request.getParameter((RequestParameter.USER_PASSWORD));

        try {
            User user = userService.login(email, password);
            if (user != null) {
                session.setAttribute(SessionAttribute.USER_ID, user.getUserId());
                session.setAttribute(SessionAttribute.USER_NAME, user.getName());
                session.setAttribute(SessionAttribute.USER_SURNAME, user.getSurname());
                session.setAttribute(SessionAttribute.USER_EMAIL, user.getEmail());
                session.setAttribute(SessionAttribute.USER_PASSPORT_ID, user.getPassportId());
                session.setAttribute(SessionAttribute.USER_ROLE, user.getUserRole());

                if (user.getUserRole() == UserRole.USER) {
                    initUserApplicationDataInSession(session, user.getUserId());
                }
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_HOME_PAGE);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.HOME_PAGE);
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
            }
        } catch (ServiceException exception) {
            logger.error("It is not possible to check user data at login.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }


    private void initUserApplicationDataInSession(HttpSession session, int userId) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ApplicationService applicationService = serviceFactory.getApplicationService();
        ResultService resultService = serviceFactory.getResultService();

        Application application = applicationService.getApplicationByUserId(userId);
        List<Result> resultList = resultService.getResultsByApplicationId(application.getApplicationId());

        session.setAttribute(SessionAttribute.APPLICATION, application);
        session.setAttribute(SessionAttribute.POINTS_FIRST_SUBJECT, resultList.get(SessionAttributeValue.FIRST_SUBJECT_INDEX).getScore());
        session.setAttribute(SessionAttribute.POINTS_SECOND_SUBJECT, resultList.get(SessionAttributeValue.SECOND_SUBJECT_INDEX).getScore());
        session.setAttribute(SessionAttribute.POINTS_THIRD_SUBJECT, resultList.get(SessionAttributeValue.THIRD_SUBJECT_INDEX).getScore());
    }
}
