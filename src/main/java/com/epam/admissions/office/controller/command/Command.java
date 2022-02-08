package com.epam.admissions.office.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Command interface.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public interface Command {
    /**
     * Method for executing each command that comes in a request to a servlet.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException thrown when a servlet operation exception occurs
     * @throws IOException      is thrown when redirect exception occurs
     */
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
