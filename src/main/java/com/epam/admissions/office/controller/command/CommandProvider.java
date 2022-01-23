package com.epam.admissions.office.controller.command;

import com.epam.admissions.office.controller.command.impl.ChangeLocaleCommand;
import com.epam.admissions.office.controller.command.impl.LogInCommand;
import com.epam.admissions.office.controller.command.impl.LogOutCommand;
import com.epam.admissions.office.controller.command.impl.SignUpCommand;
import com.epam.admissions.office.controller.command.impl.goto_command.*;
import com.epam.admissions.office.controller.constant.CommandName;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put(CommandName.GO_TO_HOME_PAGE, new GoToHomePageCommand());
        commands.put(CommandName.GO_TO_LOG_IN_PAGE, new GoToLogInPageCommand());
        commands.put(CommandName.GO_TO_SIGN_UP_PAGE, new GoToSignUpCommand());
        commands.put(CommandName.GO_TO_CONTACTS_PAGE, new GoToContactsCommand());
        commands.put(CommandName.GO_TO_PROFILE_PAGE, new GoToProfilePageCommand());
        commands.put(CommandName.GO_TO_ERROR_404_PAGE, new GoToError404PageCommand());
        commands.put(CommandName.CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CommandName.LOG_IN, new LogInCommand());
        commands.put(CommandName.LOG_OUT, new LogOutCommand());
        commands.put(CommandName.SIGN_UP, new SignUpCommand());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
