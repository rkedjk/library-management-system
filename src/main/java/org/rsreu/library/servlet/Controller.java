package org.rsreu.library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.command.factory.ActionFactory;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.resource.MessageManager;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The Controller servlet acts as the central hub to process incoming requests.
 * It delegates commands to appropriate handlers and manages responses.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if servlet encounters a servlet-specific problem
     * @throws IOException      if an input or output error occurs while servlet handles the GET request
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles HTTP POST requests.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if servlet encounters a servlet-specific problem
     * @throws IOException      if an input or output error occurs while servlet handles the POST request
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Processes the incoming request and forwards it to the appropriate handler.
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @throws ServletException if servlet encounters a servlet-specific problem
     * @throws IOException      if an input or output error occurs while servlet processes the request
     * @throws SQLException     if a database access error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String page = null;

        // Determine the command from JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = ActionFactory.defineCommand(request);

        // Execute the command and obtain the page
        page = command.execute(request, response);

        // Forward to the response page or display an error message
        if (page != null) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            // Set error message page
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
