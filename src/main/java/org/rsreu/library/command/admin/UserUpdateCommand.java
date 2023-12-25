package org.rsreu.library.command.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class UserUpdateCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = null;

        // Retrieve updated user credentials from the form
        long userId = Long.parseLong(request.getParameter("userId"));
        String type = request.getParameter("type");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String name = request.getParameter("name");

        // Update user credentials using API
        UserManagementAPI userManagementAPI = new UserManagementAPI();
        try {
            boolean isSuccess = userManagementAPI.updateUser(userId, type, login, password, status, name);
            if (isSuccess) {
                page = ConfigurationManager.getProperty("path.page.success");
            } else {
                // Handle update failure, redirect to an error page or the update form again
                page = ConfigurationManager.getProperty("path.page.error");
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // Redirect to success page upon successful update

        return page;
    }
}
