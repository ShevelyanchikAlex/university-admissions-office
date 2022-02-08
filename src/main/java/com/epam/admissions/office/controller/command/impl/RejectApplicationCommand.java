package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
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
 * Command reject application.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class RejectApplicationCommand implements Command {
    private static final boolean APPROVED = false;

    private final Logger logger = Logger.getLogger(RejectApplicationCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ApplicationService applicationService = ServiceFactory.getInstance().getApplicationService();

        try {
            int applicationId = Integer.parseInt(request.getParameter(RequestParameter.APPLICATION_ID));
            String rejectionReason = request.getParameter(RequestParameter.REJECTION_REASON);
            applicationService.updateConfirmStatusOfApplication(applicationId, APPROVED, rejectionReason);

            session.setAttribute(SessionAttribute.NOT_RESPONDED_APPLICATIONS, applicationService.getAllNotConfirmedApplications());
            session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ADMIN_PAGE);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ADMIN_PAGE);
            requestDispatcher.forward(request, response);
        } catch (ServiceException | NumberFormatException exception) {
            logger.error("Exception in time rejection of application.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
