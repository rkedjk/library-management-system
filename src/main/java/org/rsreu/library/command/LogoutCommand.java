/* LogoutCommand.java */
package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;

import java.io.IOException;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = ConfigurationManager.getProperty("path.page.index");
        // Invalidate the session
        request.getSession().invalidate();
        return page;
    }
}
