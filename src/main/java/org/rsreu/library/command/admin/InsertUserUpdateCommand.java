package org.rsreu.library.command.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.databaseutil.entity.User;
import org.rsreu.library.command.ActionCommand;
import java.sql.SQLException;
import org.rsreu.library.resource.ConfigurationManager;

public class InsertUserUpdateCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = null;

        // Retrieve the user ID from the request
        long userId = Long.parseLong(request.getParameter("userId"));

        // Retrieve user credentials using API
        UserManagementAPI userManagementAPI = new UserManagementAPI();
        try {
            Object user = userManagementAPI.getUserById(userId);
            request.setAttribute("user", user);
        }
        catch (SQLException e) {
                throw new RuntimeException(e);
            }

        // Pass user object to the update form

        page = ConfigurationManager.getProperty("path.page.userUpdate");

        return page;
    }
}
