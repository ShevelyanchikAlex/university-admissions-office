package com.epam.admissions.office.controller.command.impl.goto_command;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.CommandName;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.controller.constant.SessionAttributeValue;
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

public class GoToFacultiesPageCommand implements Command {
    private final Logger logger = Logger.getLogger(GoToFacultiesPageCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        FacultyAdmissionInfoService facultyAdmissionInfoService = ServiceFactory.getInstance().getFacultyAdmissionInfoService();

        try {
            session.setAttribute(SessionAttribute.FACULTIES_ADMISSION_INFO_LIST, facultyAdmissionInfoService.getAllFacultyAdmissionInfos());
            session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_FACULTIES_PAGE);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.FACULTIES_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException exception) {
            logger.error("It is not possible to get faculty admission info.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
