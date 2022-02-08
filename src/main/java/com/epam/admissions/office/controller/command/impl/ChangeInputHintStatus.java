package com.epam.admissions.office.controller.command.impl;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.constant.SessionAttribute;
import com.epam.admissions.office.controller.constant.SessionAttributeValue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Command change hint status.
 * Changed the status to display additional information for the correctness of the input on the form.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class ChangeInputHintStatus implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String inputHintStatus = (String) session.getAttribute(SessionAttribute.INPUT_HINT_STATUS);

        if (inputHintStatus == null || inputHintStatus.equals(SessionAttributeValue.INPUT_HINT_HIDE)) {
            session.setAttribute(SessionAttribute.INPUT_HINT_STATUS, SessionAttributeValue.INPUT_HINT_SHOW);
        } else {
            session.setAttribute(SessionAttribute.INPUT_HINT_STATUS, SessionAttributeValue.INPUT_HINT_HIDE);
        }
        response.sendRedirect((String) request.getSession().getAttribute(SessionAttribute.URL));
    }
}
