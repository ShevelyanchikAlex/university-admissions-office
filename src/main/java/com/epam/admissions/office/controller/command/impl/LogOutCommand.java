package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.CommandName;
import com.epam.admissions.office.controller.constant.PagePath;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.controller.constant.SessionAttributeValue;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

/**
 * Command logout.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class LogOutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.HOME_PAGE);
        requestDispatcher.forward(request, response);
    }
}
