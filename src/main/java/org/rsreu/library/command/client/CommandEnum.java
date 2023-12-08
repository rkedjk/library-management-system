package org.rsreu.library.command.client;

import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.command.LoginCommand;
import org.rsreu.library.command.LogoutCommand;

public enum CommandEnum {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand());

    private final ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
