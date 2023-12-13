/* package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class SearchUserCommand implements ActionCommand {
    private static final String PARAM_NAME_SEARCH_INPUT = "searchInput";
    private static final String PARAM_NAME_SEARCH_PARAM = "searchParam";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            String searchInput = request.getParameter(PARAM_NAME_SEARCH_INPUT);
            String searchParam = request.getParameter(PARAM_NAME_SEARCH_PARAM);

            // Your logic for handling user search
            // Example: Get users based on search criteria from your database using UserManagementAPI
            UserManagementAPI userManagementAPI = new UserManagementAPI();
            List<Account> userList = userManagementAPI.searchUserByProperty(searchParam, searchInput);

            request.setAttribute("userList", userList);
            page = ConfigurationManager.getProperty("path.page.userlist"); // Your userlist JSP page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException
            // Optionally, set an error attribute or redirect to an error page
            request.setAttribute("error", "An error occurred while processing your request.");
            page = "error.jsp"; // Set the error page or any other appropriate page
        }
        return page;
    }
}
*/