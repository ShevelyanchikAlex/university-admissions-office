package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.CommandName;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.controller.constant.SessionAttributeValue;
import com.epam.admissions.office.entity.user.UserRole;
import com.epam.admissions.office.service.ApplicationService;
import com.epam.admissions.office.service.FacultyAdmissionInfoService;
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
 * Command get statistics.
 * To get all statistics about users and applications.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class GetStatisticsCommand implements Command {
    private final Logger logger = Logger.getLogger(GetStatisticsCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        ApplicationService applicationService = serviceFactory.getApplicationService();
        FacultyAdmissionInfoService facultyAdmissionInfoService = serviceFactory.getFacultyAdmissionInfoService();

        try {
            session.setAttribute(SessionAttribute.COUNT_OF_APPLICATIONS, applicationService.countAllApplication());
            session.setAttribute(SessionAttribute.COUNT_OF_RESPONDED_APPLICATIONS, applicationService.countAllRespondedApplication());
            session.setAttribute(SessionAttribute.COUNT_OF_ADMINISTRATORS, userService.countByUserRole(UserRole.ADMIN));
            session.setAttribute(SessionAttribute.COUNT_OF_APPLICANTS, userService.countByUserRole(UserRole.USER));
            session.setAttribute(SessionAttribute.FACULTIES_ADMISSION_INFO_LIST, facultyAdmissionInfoService.getAllFacultyAdmissionInfos());
            session.setAttribute(SessionAttribute.ADMIN_TABLE, SessionAttributeValue.STATISTICS);
            response.sendRedirect(SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ADMIN_PAGE);
        } catch (ServiceException exception) {
            logger.error("It is not possible to get Statistics.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
