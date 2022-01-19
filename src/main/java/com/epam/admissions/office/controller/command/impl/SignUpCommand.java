package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.service.ServiceFactory;
import com.epam.admissions.office.service.UserService;
import com.epam.admissions.office.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUpCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String firstName = request.getParameter("FIRST_NAME");
        String lastName = request.getParameter("SECOND_NAME");
        String email = request.getParameter("EMAIL");
        String password = request.getParameter("PASSWORD");

        UserService userService = ServiceFactory.getInstance().getUserService();
        try {
            if (userService.getByEmail(email) != null) {
            //TODO
            }
//            userService.signUp(firstName, lastName, email, password);
            request.setAttribute("EMAIL", email);
//            logger.info("User" + email + "is registered.");
        } catch (ServiceException e) {
//            logger.error("Unable to register new user.", e);
            //TODO
        }
        session.setAttribute("URL", "/controller?command=goto-log-in-page");
        //TODO
    }
}
