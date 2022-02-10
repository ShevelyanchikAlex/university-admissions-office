package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.Application;
import com.epam.admissions.office.entity.Result;
import com.epam.admissions.office.entity.faculty.FacultyHasSubject;
import com.epam.admissions.office.service.ApplicationService;
import com.epam.admissions.office.service.FacultiesHasSubjectsService;
import com.epam.admissions.office.service.ResultService;
import com.epam.admissions.office.service.ServiceFactory;
import com.epam.admissions.office.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Command edit application.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class EditApplicationCommand implements Command {
    private static final int FIRST_SUBJECT_INDEX = 0;
    private static final int SECOND_SUBJECT_INDEX = 1;
    private static final int THIRD_SUBJECT_INDEX = 2;

    private final Logger logger = Logger.getLogger(EditApplicationCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            Application application = (Application) session.getAttribute(SessionAttribute.APPLICATION);
            int facultyId = Integer.parseInt(request.getParameter(RequestParameter.SELECTED_FACULTY_ID));
            double firstSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_FIRST_SUBJECT));
            double secondSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_SECOND_SUBJECT));
            double thirdSubjectPoints = Double.parseDouble(request.getParameter(RequestParameter.POINTS_THIRD_SUBJECT));

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ApplicationService applicationService = serviceFactory.getApplicationService();
            ResultService resultService = serviceFactory.getResultService();
            List<Result> resultList = resultService.getResultsByApplicationId(application.getApplicationId());
            List<FacultyHasSubject> facultyHasSubjectList = serviceFactory.getFacultiesHasSubjectsService().getSubjectsIdOfFacultyById(facultyId);

            if (applicationService.updateFacultyIdOfApplication(application.getApplicationId(), facultyId)
                    && resultService.updateResult(resultList.get(SessionAttributeValue.FIRST_SUBJECT_INDEX).getResultId(),
                    firstSubjectPoints, facultyHasSubjectList.get(FIRST_SUBJECT_INDEX).getSubjectId())
                    && resultService.updateResult(resultList.get(SessionAttributeValue.SECOND_SUBJECT_INDEX).getResultId(),
                    secondSubjectPoints, facultyHasSubjectList.get(SECOND_SUBJECT_INDEX).getSubjectId())
                    && resultService.updateResult(resultList.get(SessionAttributeValue.THIRD_SUBJECT_INDEX).getResultId(),
                    thirdSubjectPoints, facultyHasSubjectList.get(THIRD_SUBJECT_INDEX).getSubjectId())) {

                session.setAttribute(SessionAttribute.APPLICATION, applicationService.getApplicationById(application.getApplicationId()));
                session.setAttribute(SessionAttribute.POINTS_FIRST_SUBJECT, firstSubjectPoints);
                session.setAttribute(SessionAttribute.POINTS_SECOND_SUBJECT, secondSubjectPoints);
                session.setAttribute(SessionAttribute.POINTS_THIRD_SUBJECT, thirdSubjectPoints);
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_PROFILE_PAGE);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.PROFILE_PAGE);
                requestDispatcher.forward(request, response);
            } else {
                response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
            }
        } catch (ServiceException | NumberFormatException exception) {
            logger.error("Exception in time creating new Application.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
