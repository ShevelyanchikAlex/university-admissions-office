package com.epam.admissions.office.controller.command.impl.goto_command;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToRejectApplicationPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_REJECT_APPLICATION_PAGE);

        request.setAttribute(RequestParameter.APPLICATION_ID, request.getParameter(RequestParameter.APPLICATION_ID));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.REJECT_APPLICATION_PAGE);
        requestDispatcher.forward(request, response);
    }
}
