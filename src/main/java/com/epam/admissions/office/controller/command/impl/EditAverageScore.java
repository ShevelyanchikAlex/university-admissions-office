package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.faculty.FacultyAdmissionInfo;
import com.epam.admissions.office.service.FacultyAdmissionInfoService;
import com.epam.admissions.office.service.ServiceFactory;
import com.epam.admissions.office.service.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Command edit average score.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class EditAverageScore implements Command {
    private final Logger logger = Logger.getLogger(EditAverageScore.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        FacultyAdmissionInfoService facultyAdmissionInfoService = ServiceFactory.getInstance().getFacultyAdmissionInfoService();

        int facultyId = Integer.parseInt(request.getParameter(RequestParameter.SELECTED_FACULTY_ID));
        double passingScore = Double.parseDouble(request.getParameter(RequestParameter.SELECTED_FACULTY_SCORE));

        try {
            if (facultyAdmissionInfoService.updateFacultyAdmissionInfo(facultyId, passingScore)) {
                session.setAttribute(SessionAttribute.FACULTIES_ADMISSION_INFO_LIST, facultyAdmissionInfoService.getAllFacultyAdmissionInfos());
                session.setAttribute(SessionAttribute.ADMIN_TABLE, SessionAttributeValue.STATISTICS);
                response.sendRedirect(SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ADMIN_PAGE);
            } else {
                response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
            }
        } catch (ServiceException | NumberFormatException exception) {
            logger.error("Exception in time editing average score.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
