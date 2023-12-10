package org.rsreu.library.command.client;

import org.rsreu.library.command.*;
public enum CommandEnum {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    USERDASHBOARD(new UserDashboardCommand());
    private final ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
