package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LogInCommand implements Command {
    Logger logger = Logger.getLogger(LogInCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //TODO
    }
}
