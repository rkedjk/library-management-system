package org.rsreu.library.servlet;

import java.io.*;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.command.factory.ActionFactory;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.resource.MessageManager;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String page = null;
        // определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = ActionFactory.defineCommand(request);
        /*
         * вызов реализованного метода execute() и передача параметров
         * классу-обработчику конкретной команды
         */
        page = command.execute(request,response);
        // метод возвращает страницу ответа
        // page = null; // поэксперементировать!
        if (page != null) {
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            // установка страницы с сообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
