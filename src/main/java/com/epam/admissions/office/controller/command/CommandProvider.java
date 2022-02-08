package com.epam.admissions.office.controller.command;

import com.epam.admissions.office.controller.command.impl.*;
import com.epam.admissions.office.controller.command.impl.goto_command.*;
import com.epam.admissions.office.controller.constant.CommandName;

import java.util.HashMap;
import java.util.Map;

/**
 * CommandProvider class.
 * Provides command with given name.
 *
 * @author Alex Shevelyanchik
 * @version 1.0
 */
public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.GO_TO_HOME_PAGE, new GoToHomePageCommand());
        commands.put(CommandName.GO_TO_LOG_IN_PAGE, new GoToLogInPageCommand());
        commands.put(CommandName.GO_TO_SIGN_UP_PAGE, new GoToSignUpPageCommand());
        commands.put(CommandName.GO_TO_CONTACTS_PAGE, new GoToContactsPageCommand());
        commands.put(CommandName.GO_TO_PROFILE_PAGE, new GoToProfilePageCommand());
        commands.put(CommandName.GO_TO_EDIT_PERSONAL_DATA_PAGE, new GoToEditPersonalDataPageCommand());
        commands.put(CommandName.GO_TO_ERROR_404_PAGE, new GoToError404PageCommand());
        commands.put(CommandName.GO_TO_ERROR_403_PAGE, new GoToError403PageCommand());
        commands.put(CommandName.GO_TO_ERROR_500_PAGE, new GoToError500PageCommand());
        commands.put(CommandName.GO_TO_ADMIN_PAGE, new GoToAdminPage());
        commands.put(CommandName.GO_TO_REJECT_APPLICATION_PAGE, new GoToRejectApplicationPageCommand());
        commands.put(CommandName.GO_TO_ADD_APPLICATION_PAGE, new GoToAddApplicationPageCommand());
        commands.put(CommandName.GO_TO_EDIT_APPLICATION_PAGE, new GoToEditApplicationPage());
        commands.put(CommandName.GO_TO_EDIT_AVERAGE_SCORE_PAGE, new GoToEditAverageScorePageCommand());
        commands.put(CommandName.GO_TO_ABOUT_PAGE, new GoToAboutPageCommand());
        commands.put(CommandName.GO_TO_FACULTIES_PAGE, new GoToFacultiesPageCommand());
        commands.put(CommandName.CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CommandName.LOG_IN, new LogInCommand());
        commands.put(CommandName.LOG_OUT, new LogOutCommand());
        commands.put(CommandName.SIGN_UP, new SignUpCommand());
        commands.put(CommandName.EDIT_PERSONAL_DATA, new EditPersonalDataCommand());
        commands.put(CommandName.ADD_APPLICATION, new AddApplicationCommand());
        commands.put(CommandName.EDIT_APPLICATION, new EditApplicationCommand());
        commands.put(CommandName.GET_APPLICATIONS_TABLE, new GetApplicationsTableCommand());
        commands.put(CommandName.GET_RESPONDED_APPLICATIONS_TABLE, new GetRespondedApplicationsTableCommand());
        commands.put(CommandName.GET_ADMINISTRATORS_TABLE, new GetAdministratorsTableCommand());
        commands.put(CommandName.GET_APPLICANTS_TABLE, new GetApplicantsTableCommand());
        commands.put(CommandName.GET_STATISTICS, new GetStatisticsCommand());
        commands.put(CommandName.DELETE_APPLICANT, new DeleteApplicantCommand());
        commands.put(CommandName.CONFIRM_APPLICATION, new ConfirmApplicationCommand());
        commands.put(CommandName.REJECT_APPLICATION, new RejectApplicationCommand());
        commands.put(CommandName.EDIT_AVERAGE_SCORE, new EditAverageScore());
        commands.put(CommandName.CHANGE_INPUT_HINT_STATUS, new ChangeInputHintStatus());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
