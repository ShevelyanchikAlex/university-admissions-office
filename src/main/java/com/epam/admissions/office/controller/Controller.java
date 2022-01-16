package com.epam.admissions.office.controller;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
//        if (session.getAttribute(SessionAttribute.LOCALE) == null) {
//            session.setAttribute(SessionAttribute.LOCALE, "en");
//        }

        String commandName = request.getParameter("command");
//
//        if (commandName == null || command == null) {
//            session.setAttribute(SessionAttribute.URL, "/controller?command=goto-404-page");
//            request.getRequestDispatcher(Page.ERROR_404_PAGE).forward(request, response);
//            return;
//        }


        Command command = commandProvider.getCommand(commandName);

        if (command != null) {
            command.execute(request, response);
        } else {

        }
    }
}
