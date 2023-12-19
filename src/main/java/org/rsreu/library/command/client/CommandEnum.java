package org.rsreu.library.command.client;

import org.rsreu.library.command.*;
import org.rsreu.library.command.admin.*;
import org.rsreu.library.command.reader.*;
import org.rsreu.library.command.librarian.*;

public enum CommandEnum {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    USERDASHBOARD(new ReaderDashboardCommand()),
    ADMINDASHBOARD(new AdminDashboardCommand()),
    ADDUSERFORM(new AddUserFormCommand()),
    SEARCHUSERS(new SearchUsersCommand()),
    DELETEUSERFORM(new DeleteUserFormCommand()),
    DELETEUSERBYID(new DeleteUserByIdCommand()),
    CHANGEUSERSTATUSFORM(new ChangeUserStatusFormCommand()),
    LIBRARIANDASHBOARD(new LibrarianDashboardCommand()),
    USERUPDATE(new UserUpdateCommand()),

    ADDNEWCOPYCOMMAND(new AddNewCopyCommand()),

    SEARCHBOOKCATALOGCOMMAND(new SearchBookCatalogCommand()),
    INSERTUSERUPDATE(new InsertUserUpdateCommand());
    private final ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
