package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.RequestParameter;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.service.ApplicationService;
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
 * Command confirm application.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ConfirmApplicationCommand implements Command {
    private static final boolean APPROVED = true;

    private final Logger logger = Logger.getLogger(ConfirmApplicationCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ApplicationService applicationService = ServiceFactory.getInstance().getApplicationService();
        int applicationId = Integer.parseInt(request.getParameter(RequestParameter.APPLICATION_ID));

        try {
            applicationService.updateConfirmStatusOfApplication(applicationId, APPROVED, null);
            session.setAttribute(SessionAttribute.NOT_RESPONDED_APPLICATIONS, applicationService.getAllNotConfirmedApplications());
            response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
        } catch (ServiceException exception) {
            logger.error("Exception in time confirmation of application.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
