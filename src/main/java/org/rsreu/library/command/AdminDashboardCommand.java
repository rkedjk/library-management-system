package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;

import java.io.IOException;

public class AdminDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request){
        String page = null;
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "searchuser":
                    page = ConfigurationManager.getProperty("path.page.searchuser");
                    break;
                case "adduser":
                    page = ConfigurationManager.getProperty("path.page.adduser");
                    break;
                case "deleteuser":
                    page = ConfigurationManager.getProperty("path.page.deleteuser");
                    break;
                case "changestatus":
                    page = ConfigurationManager.getProperty("path.page.change_status");
                    break;
                default:
                    // Handle other cases or leave it blank if not needed
                    break;
            }
        }

        return page;
    }
}
