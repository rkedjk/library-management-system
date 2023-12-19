package org.rsreu.library.command.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class AdminDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = null;
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "searchuser":
                    page = ConfigurationManager.getProperty("path.page.manageUsers");
                    break;
                case "adduser":
                    page = ConfigurationManager.getProperty("path.page.addUserForm");
                    break;
                case "deleteuser":
                    page = ConfigurationManager.getProperty("path.page.deleteUserById");
                    break;
                case "changestatus":
                    page = ConfigurationManager.getProperty("path.page.changeUserStatusForm");
                    break;
                case "userupdate":
                    page = ConfigurationManager.getProperty("path.page.insertuserupdate");
                    break;
                case "userlist":

                    UserManagementAPI userManagementAPI = new UserManagementAPI();
                    // Assuming you have a service method to get the user list
                    List<Object> userList = null; // Replace userService with your actual service
                    try {
                        userList = userManagementAPI.searchUsers("none","","","");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    // Set the user list as an attribute in the request
                    request.setAttribute("userList", userList);

                    page = ConfigurationManager.getProperty("path.page.viewUserList");
                    break;

                default:
                    // Handle other cases or leave it blank if not needed
                    break;
            }
        }

        return page;
    }
}