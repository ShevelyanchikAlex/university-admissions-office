package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.Application;
import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;
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

public class AddApplicationCommand implements Command {
    private static final int FIRST_SUBJECT_INDEX = 0;
    private static final int SECOND_SUBJECT_INDEX = 1;
    private static final int THIRD_SUBJECT_INDEX = 2;

    private final Logger logger = Logger.getLogger(AddApplicationCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ApplicationService applicationService = serviceFactory.getApplicationService();
        FacultiesHasSubjectsService facultiesHasSubjectsService = serviceFactory.getFacultiesHasSubjectsService();
        ResultService resultService = serviceFactory.getResultService();
        UserService userService = serviceFactory.getUserService();

        int userId = (int) session.getAttribute(SessionAttribute.USER_ID);
        int facultyId = Integer.parseInt(request.getParameter(RequestParameter.SELECTED_FACULTY_ID));
        double firstSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_FIRST_SUBJECT));
        double secondSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_SECOND_SUBJECT));
        double thirdSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_THIRD_SUBJECT));

        try {
            int applicationId = applicationService.createApplication(userId, facultyId);
            if (applicationId > 0) {
                List<FacultyHasSubject> facultyHasSubjectList = facultiesHasSubjectsService.getSubjectsIdOfFacultyById(facultyId);
                if (resultService.createResult(firstSubjectPoints, applicationId, facultyHasSubjectList.get(FIRST_SUBJECT_INDEX).getSubjectId())
                        && resultService.createResult(secondSubjectPoints, applicationId, facultyHasSubjectList.get(SECOND_SUBJECT_INDEX).getSubjectId())
                        && resultService.createResult(thirdSubjectPoints, applicationId, facultyHasSubjectList.get(THIRD_SUBJECT_INDEX).getSubjectId())) {
                    initUserApplicationDataInSession(session, applicationId);
                    userService.changeUserRole(userId, UserRole.USER);
                    session.setAttribute(SessionAttribute.USER_ROLE, UserRole.USER);
                    session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_PROFILE_PAGE);

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.PROFILE_PAGE);
                    requestDispatcher.forward(request, response);
                }
            } else {
                response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
            }
        } catch (ServiceException exception) {
            logger.error("Exception in time creating application.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }

    private void initUserApplicationDataInSession(HttpSession session, int applicationId) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ApplicationService applicationService = serviceFactory.getApplicationService();
        ResultService resultService = serviceFactory.getResultService();

        Application application = applicationService.getApplicationById(applicationId);
        List<Result> resultList = resultService.getResultsByApplicationId(application.getApplicationId());

        session.setAttribute(SessionAttribute.APPLICATION, application);
        session.setAttribute(SessionAttribute.POINTS_FIRST_SUBJECT, resultList.get(SessionAttributeValue.FIRST_SUBJECT_INDEX).getScore());
        session.setAttribute(SessionAttribute.POINTS_SECOND_SUBJECT, resultList.get(SessionAttributeValue.SECOND_SUBJECT_INDEX).getScore());
        session.setAttribute(SessionAttribute.POINTS_THIRD_SUBJECT, resultList.get(SessionAttributeValue.THIRD_SUBJECT_INDEX).getScore());
    }
}
