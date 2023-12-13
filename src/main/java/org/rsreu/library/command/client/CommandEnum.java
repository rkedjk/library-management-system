package org.rsreu.library.command.client;

import org.rsreu.library.command.*;
//import org.rsreu.library.command.UserListCommand;

public enum CommandEnum {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    USERDASHBOARD(new UserDashboardCommand()),
    ADMINDASHBOARD(new AdminDashboardCommand()),
    LIBRARIANDASHBOARD(new LibrarianDashboardCommand());
   //SEARCHUSER(new SearchUserCommand()),
    //USERLIST(new UserListCommand());

    private final ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
