/* ActionCommand.java */
package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request);
}
