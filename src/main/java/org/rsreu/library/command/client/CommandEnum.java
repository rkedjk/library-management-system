package org.rsreu.library.command.client;

import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.command.LoginCommand;
import org.rsreu.library.command.LogoutCommand;
import org.rsreu.library.command.admin.*;
import org.rsreu.library.command.librarian.*;
import org.rsreu.library.command.reader.*;

public enum CommandEnum {
    ADDNEWBOOKCOMMAND(new AddNewBookCommand()),
    ADDNEWCOPYCOMMAND(new AddNewBookCommand()),
    ADDUSERFORM(new AddUserFormCommand()),
    ADMINDASHBOARD(new AdminDashboardCommand()),
    CHANGEUSERSTATUSFORM(new ChangeUserStatusFormCommand()),
    DELETEUSERBYID(new DeleteUserByIdCommand()),
    DELETEUSERFORM(new DeleteUserFormCommand()),
    INSERTUSERUPDATE(new InsertUserUpdateCommand()),
    LIBRARIANDASHBOARD(new LibrarianDashboardCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),

    SEARCHBOOKCATALOGCOMMAND(new SearchBookCatalogCommand()),
    SEARCHBOOKSCOMMAND(new SearchBooksCommand()),
    SEARCHUSERS(new SearchUsersCommand()),
    USERDASHBOARD(new ReaderDashboardCommand()),
    RESERVATIONCOMMAND(new ReservationCommand()),
    ADDNEWAPGCOMMAND(new AddNewAPGCommand()),
    SEARCHBOOKINVENTORYCOMMAND(new SearchBookInventoryCommand()),
    CREATELOANCOMMAND(new CreateLoanCommand()),
    DISPLAYBOOKDATACOMMAND(new DisplayBookDataCommand()),
    INSERTPENALTYCOMMAND(new InsertPenaltyCommand()),
    UPDATEBOOKDATACPMMAND(new UpdateBookDataCommand()),
    UPDATELOANDATACOMMAND(new UpdateLoanDataCommand()),
    UPDATEPENALTYDATACOMMAND(new UpdatePenaltyDataCommand()),
    VIEWEDITLOANDATACOMMAND(new ViewEditLoanDataCommand()),
    VIEWEDITPENALTYDATACOMMAND(new ViewEditPenaltyDataCommand()),
    USERUPDATE(new UserUpdateCommand());
    private final ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
