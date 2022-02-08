package com.epam.admissions.office.controller.filter;

import com.epam.admissions.office.controller.command.Command;
import com.epam.admissions.office.controller.command.CommandProvider;
import com.epam.admissions.office.controller.constant.*;
import com.epam.admissions.office.entity.user.UserRole;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * CacheFilter class.
 * Filter, that controls access of users with different roles to commands.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public class UserAccessFilter implements Filter {
    private final CommandProvider commandProvider = new CommandProvider();
    private final Map<UserRole, List<String>> availableToUserRolesCommands = new EnumMap<>(UserRole.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        availableToUserRolesCommands.put(UserRole.USER, Arrays.asList(
                CommandName.GO_TO_HOME_PAGE,
                CommandName.GO_TO_LOG_IN_PAGE,
                CommandName.GO_TO_SIGN_UP_PAGE,
                CommandName.GO_TO_CONTACTS_PAGE,
                CommandName.GO_TO_PROFILE_PAGE,
                CommandName.GO_TO_ERROR_404_PAGE,
                CommandName.GO_TO_ERROR_500_PAGE,
                CommandName.GO_TO_EDIT_PERSONAL_DATA_PAGE,
                CommandName.GO_TO_EDIT_APPLICATION_PAGE,
                CommandName.GO_TO_ABOUT_PAGE,
                CommandName.GO_TO_FACULTIES_PAGE,
                CommandName.CHANGE_LOCALE,
                CommandName.LOG_IN,
                CommandName.LOG_OUT,
                CommandName.SIGN_UP,
                CommandName.EDIT_PERSONAL_DATA,
                CommandName.EDIT_APPLICATION,
                CommandName.CHANGE_INPUT_HINT_STATUS
        ));

        availableToUserRolesCommands.put(UserRole.USER_WITHOUT_APPLICATION, Arrays.asList(
                CommandName.GO_TO_HOME_PAGE,
                CommandName.GO_TO_LOG_IN_PAGE,
                CommandName.GO_TO_SIGN_UP_PAGE,
                CommandName.GO_TO_CONTACTS_PAGE,
                CommandName.GO_TO_PROFILE_PAGE,
                CommandName.GO_TO_ERROR_404_PAGE,
                CommandName.GO_TO_ERROR_500_PAGE,
                CommandName.GO_TO_EDIT_PERSONAL_DATA_PAGE,
                CommandName.GO_TO_ABOUT_PAGE,
                CommandName.GO_TO_FACULTIES_PAGE,
                CommandName.CHANGE_LOCALE,
                CommandName.LOG_IN,
                CommandName.LOG_OUT,
                CommandName.SIGN_UP,
                CommandName.EDIT_PERSONAL_DATA,
                CommandName.GO_TO_ADD_APPLICATION_PAGE,
                CommandName.ADD_APPLICATION,
                CommandName.CHANGE_INPUT_HINT_STATUS
        ));

        availableToUserRolesCommands.put(UserRole.GUEST, Arrays.asList(
                CommandName.GO_TO_HOME_PAGE,
                CommandName.GO_TO_LOG_IN_PAGE,
                CommandName.GO_TO_SIGN_UP_PAGE,
                CommandName.GO_TO_CONTACTS_PAGE,
                CommandName.GO_TO_ERROR_404_PAGE,
                CommandName.GO_TO_ERROR_500_PAGE,
                CommandName.GO_TO_ABOUT_PAGE,
                CommandName.GO_TO_FACULTIES_PAGE,
                CommandName.CHANGE_LOCALE,
                CommandName.LOG_IN,
                CommandName.SIGN_UP,
                CommandName.CHANGE_INPUT_HINT_STATUS
        ));

        availableToUserRolesCommands.put(UserRole.ADMIN, Arrays.asList(
                CommandName.GO_TO_HOME_PAGE,
                CommandName.GO_TO_LOG_IN_PAGE,
                CommandName.GO_TO_SIGN_UP_PAGE,
                CommandName.GO_TO_CONTACTS_PAGE,
                CommandName.GO_TO_PROFILE_PAGE,
                CommandName.GO_TO_ERROR_404_PAGE,
                CommandName.GO_TO_ERROR_500_PAGE,
                CommandName.GO_TO_EDIT_PERSONAL_DATA_PAGE,
                CommandName.GO_TO_ABOUT_PAGE,
                CommandName.GO_TO_FACULTIES_PAGE,
                CommandName.GO_TO_ADMIN_PAGE,
                CommandName.GO_TO_EDIT_AVERAGE_SCORE_PAGE,
                CommandName.GO_TO_REJECT_APPLICATION_PAGE,
                CommandName.CHANGE_LOCALE,
                CommandName.LOG_IN,
                CommandName.LOG_OUT,
                CommandName.SIGN_UP,
                CommandName.EDIT_PERSONAL_DATA,
                CommandName.GET_STATISTICS,
                CommandName.GET_APPLICATIONS_TABLE,
                CommandName.GET_RESPONDED_APPLICATIONS_TABLE,
                CommandName.GET_ADMINISTRATORS_TABLE,
                CommandName.GET_APPLICANTS_TABLE,
                CommandName.DELETE_APPLICANT,
                CommandName.EDIT_AVERAGE_SCORE,
                CommandName.CONFIRM_APPLICATION,
                CommandName.REJECT_APPLICATION,
                CommandName.CHANGE_INPUT_HINT_STATUS
        ));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        UserRole userRole = (UserRole) session.getAttribute(SessionAttribute.USER_ROLE);
        if (userRole == null) {
            userRole = UserRole.GUEST;
        }

        String commandName = request.getParameter(RequestParameter.COMMAND);

        if (commandName != null) {
            Command command = commandProvider.getCommand(commandName);

            if (command == null) {
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ERROR_404_PAGE);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_404_PAGE);
                requestDispatcher.forward(request, response);
                return;
            }

            if (!availableToUserRolesCommands.get(userRole).contains(commandName)) {
                session.setAttribute(SessionAttribute.URL, SessionAttributeValue.CONTROLLER_COMMAND + CommandName.GO_TO_ERROR_403_PAGE);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PagePath.ERROR_403_PAGE);
                requestDispatcher.forward(request, response);
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
