package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.RequestParameter;
import com.epam.admissions.office.controller.constant.SessionAttribute;
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
 * Command delete application.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class DeleteApplicantCommand implements Command {
    private final Logger logger = Logger.getLogger(DeleteApplicantCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getInstance().getUserService();

        try {
            int userId = Integer.parseInt(request.getParameter(RequestParameter.USER_ID));
            userService.deleteById(userId);
            session.setAttribute(SessionAttribute.APPLICANTS, userService.getAllApplicants());
            response.sendRedirect((String) session.getAttribute(SessionAttribute.URL));
        } catch (ServiceException | NumberFormatException exception) {
            logger.error("Unable to delete applicant.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
