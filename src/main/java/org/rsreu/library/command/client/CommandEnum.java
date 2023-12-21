package org.rsreu.library.command.client;

import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.command.LoginCommand;
import org.rsreu.library.command.LogoutCommand;
import org.rsreu.library.command.admin.*;
import org.rsreu.library.command.librarian.*;
import org.rsreu.library.command.reader.*;

public enum CommandEnum {
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
    SEARCHBOOKSINVENTORYCOMMAND(new SearchBooksInventoryCommand()),
    CREATELOANCOMMAND(new CreateLoanCommand()),
    DISPLAYBOOKDATACOMMAND(new DisplayBookDataCommand()),
    INSERTPENALTYCOMMAND(new InsertPenaltyCommand()),
    UPDATEBOOKDATACPMMAND(new UpdateBookDataCommand()),
    UPDATELOANDATACOMMAND(new UpdateLoanDataCommand()),
    UPDATEPENALTYDATACOMMAND(new UpdatePenaltyDataCommand()),
    VIEWEDITPENALTYDATACOMMAND(new ViewEditPenaltyDataCommand()),
    INSERTBOOKINVENTORYCOMMAND(new InsertBookInventoryCommand()),
    UPDATEBOOKSTATUSCOMMAND(new UpdateBookStatusCommand()),
    INSERTBOOKCATALOGCOMMAND(new InsertBookCatalogCommand()),
    INSERTENTITYCOMMAND(new InsertEntityCommand()),
    VIEWLOANSBYREADERCOMMAND(new ViewLoansByReaderCommand()),
    VIEWPENALTIESBYREADERCOMMAND(new ViewPenaltiesByReaderCommand()),
    USERUPDATE(new UserUpdateCommand());
    private final ActionCommand command;

    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
