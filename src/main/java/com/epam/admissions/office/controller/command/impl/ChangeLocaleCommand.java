package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.RequestParameter;
import com.epam.admissions.office.controller.constant.SessionAttribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Command change locale.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ChangeLocaleCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.LOCALE, request.getParameter(RequestParameter.LOCALE));
        response.sendRedirect((String) request.getSession().getAttribute(SessionAttribute.URL));
    }
}
