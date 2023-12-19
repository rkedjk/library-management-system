package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.command.ActionCommand;

public class LibrarianDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                // Book Inventory Management
                case "add_new_copy":
                    page = ConfigurationManager.getProperty("path.page.addNewCopy");
                    break;
                case "search_copy":
                    page = ConfigurationManager.getProperty("path.page.searchCopy");
                    break;
                case "update_copy_data":
                    page = ConfigurationManager.getProperty("path.page.updateCopyData");
                    break;
                case "change_copy_status":
                    page = ConfigurationManager.getProperty("path.page.changeCopyStatus");
                    break;
                case "list_of_copies":
                    page = ConfigurationManager.getProperty("path.page.listOfCopies");
                    break;

                // Book Catalog Management
                case "add_new_book":
                    page = ConfigurationManager.getProperty("path.page.addNewBook");
                    break;
                case "search_book":
                    page = ConfigurationManager.getProperty("path.page.searchBook");
                    break;
                case "update_book_data":
                    page = ConfigurationManager.getProperty("path.page.updateBookData");
                    break;
                case "add_new_apg":
                    page = ConfigurationManager.getProperty("path.page.addNewAPG");
                    break;
                case "list_of_books":
                    page = ConfigurationManager.getProperty("path.page.listOfBooks");
                    break;
                case "list_of_authors":
                    page = ConfigurationManager.getProperty("path.page.listOfAuthors");
                    break;
                case "list_of_publishers":
                    page = ConfigurationManager.getProperty("path.page.listOfPublishers");
                    break;
                case "list_of_genres":
                    page = ConfigurationManager.getProperty("path.page.listOfGenres");
                    break;

                // Reader Management
                case "add_new_loan":
                    page = ConfigurationManager.getProperty("path.page.addNewLoan");
                    break;
                case "update_loan_data":
                    page = ConfigurationManager.getProperty("path.page.updateLoanData");
                    break;
                case "add_new_penalty":
                    page = ConfigurationManager.getProperty("path.page.addNewPenalty");
                    break;
                case "update_penalty_data":
                    page = ConfigurationManager.getProperty("path.page.updatePenaltyData");
                    break;
                case "search_readers_loans":
                    page = ConfigurationManager.getProperty("path.page.searchReadersLoans");
                    break;
                case "search_readers_penalties":
                    page = ConfigurationManager.getProperty("path.page.searchReadersPenalties");
                    break;
                default:
                    // Handle other cases or leave it blank if not needed
                    break;
            }
        }
        return page;
    }
}
