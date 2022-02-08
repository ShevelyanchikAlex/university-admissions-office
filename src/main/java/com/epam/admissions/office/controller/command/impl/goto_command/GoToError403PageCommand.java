package com.epam.admissions.office.controller.command.impl.goto_command;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.CommandName;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.controller.constant.SessionAttributeValue;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Command go to 403 page.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class GoToError403PageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ERROR_403_PAGE);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_403_PAGE);
        requestDispatcher.forward(request, response);
    }
}
