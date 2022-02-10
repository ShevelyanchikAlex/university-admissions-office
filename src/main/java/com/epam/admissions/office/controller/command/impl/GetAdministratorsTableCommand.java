package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.CommandName;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.controller.constant.SessionAttributeValue;
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
 * Command get administrators table.
 * To get information about administrators.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class GetAdministratorsTableCommand implements Command {
    private final Logger logger = Logger.getLogger(GetApplicantsTableCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        try {
            session.setAttribute(SessionAttribute.ADMINISTRATORS, ServiceFactory.getInstance().getUserService().getAllAdministrators());
            session.setAttribute(SessionAttribute.ADMIN_TABLE, SessionAttributeValue.ADMINISTRATORS_TABLE);
            response.sendRedirect(SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ADMIN_PAGE);
        } catch (ServiceException exception) {
            logger.error("It is not possible to get Administrators.", exception);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
