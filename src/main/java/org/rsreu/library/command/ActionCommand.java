/* ActionCommand.java */
package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.SQLException;

public interface ActionCommand {
    String execute(HttpServletRequest request,HttpServletResponse response) throws SQLException;
}