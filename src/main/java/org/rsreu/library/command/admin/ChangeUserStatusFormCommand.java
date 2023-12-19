package org.rsreu.library.command.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.command.ActionCommand;

public class ChangeUserStatusFormCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("path", ConfigurationManager.getProperty("path.page.changeUserStatusForm"));
        return "/admin/changeUserStatusForm.jsp";
    }
}