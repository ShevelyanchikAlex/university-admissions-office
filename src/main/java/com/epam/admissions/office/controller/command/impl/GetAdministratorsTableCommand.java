package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.user.User;
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
import java.util.List;

public class GetAdministratorsTableCommand implements Command {
    private final Logger logger = Logger.getLogger(GetApplicantsTableCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = ServiceFactory.getInstance().getUserService();

        try {
            List<User> administrators = userService.getAllAdministrators();

            session.setAttribute(SessionAttribute.ADMINISTRATORS, administrators);
            session.setAttribute(SessionAttribute.ADMIN_TABLE, SessionAttributeValue.ADMINISTRATORS_TABLE);
            response.sendRedirect(SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ADMIN_PAGE);
        } catch (ServiceException e) {
            logger.error("It is not possible to get Administrators.", e);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_500_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
