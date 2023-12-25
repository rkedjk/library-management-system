package org.rsreu.library.command.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class DeleteUserFormCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve the user ID from the request
        long userId = Long.parseLong(request.getParameter("userId"));

        // Delete user by ID using API
        UserManagementAPI userManagementAPI = new UserManagementAPI();
        try {
            boolean isDeleted = userManagementAPI.deleteUserById(userId);
            if (isDeleted) {
                page = ConfigurationManager.getProperty("path.page.success");
            } else {
                // Handle deletion failure, redirect to an error page or confirmation form again
                page = ConfigurationManager.getProperty("path.page.error");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Redirect to success page upon successful deletion

        return page;
    }
}
