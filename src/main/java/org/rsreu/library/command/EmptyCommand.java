/* EmptyCommand.java */
package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;

import java.io.IOException;

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        // Redirect to the login page in case of an error or direct access to the controller
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
