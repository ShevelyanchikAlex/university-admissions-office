package com.epam.admissions.office.controller;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.command.CommandProvider;
import com.epam.admissions.office.controller.constant.CommandName;
import com.epam.admissions.office.controller.constant.RequestParameter;

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
        Command command = commandProvider.getCommand(request.getParameter(RequestParameter.COMMAND));

        if (command == null) {
            command = commandProvider.getCommand(CommandName.GO_TO_ERROR_404_PAGE);
        }

        command.execute(request, response);
    }
}
