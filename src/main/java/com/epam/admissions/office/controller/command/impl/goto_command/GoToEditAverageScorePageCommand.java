package com.epam.admissions.office.controller.command.impl.goto_command;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToEditAverageScorePageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setAttribute(RequestAttribute.SELECTED_FACULTY_ID, request.getParameter(RequestParameter.SELECTED_FACULTY_ID));
        request.setAttribute(RequestAttribute.SELECTED_FACULTY_SCORE, request.getParameter(RequestParameter.SELECTED_FACULTY_SCORE));

        session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_EDIT_AVERAGE_SCORE_PAGE);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.EDIT_AVERAGE_SCORE_PAGE);
        requestDispatcher.forward(request, response);
    }
}
