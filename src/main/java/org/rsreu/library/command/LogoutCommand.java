/* LogoutCommand.java */
package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import org.rsreu.library.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        // Invalidate the session
        request.getSession().invalidate();
        return page;
    }
}
