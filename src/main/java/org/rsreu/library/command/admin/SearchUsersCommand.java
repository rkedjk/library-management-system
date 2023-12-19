package org.rsreu.library.command.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.command.ActionCommand;

import java.sql.SQLException;
import java.util.List;

public class SearchUsersCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        try {
            // Extract parameters for search from the request
            String searchType = request.getParameter("searchType");
            String searchValue = request.getParameter("searchValue");
            String userType = request.getParameter("userType");
            String userStatus = request.getParameter("userStatus");

            UserManagementAPI userManagementAPI = new UserManagementAPI();
            List<Object> userList = userManagementAPI.searchUsers(searchType, searchValue, userType, userStatus);

            // Set the user list as an attribute in the request
            request.setAttribute("userList", userList);

            // Forward to the user list display page
            page = ConfigurationManager.getProperty("path.page.viewUserList");
        } catch (SQLException e) {
            // Handle the SQLException here or log it
            e.printStackTrace();
            // Optionally, set an error attribute or redirect to an error page
            request.setAttribute("error", "An error occurred while processing your request.");
            page = "error.jsp"; // Set the error page or any other appropriate page
        }

        return page;
    }
}
