package org.rsreu.library.command.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class AddUserFormCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String page = null;

        // Получение данных пользователя из формы
        String type = request.getParameter("type");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String name = request.getParameter("name");

        // Вставка нового пользователя с использованием API
        UserManagementAPI userManagementAPI = new UserManagementAPI();
        try {
            boolean isSuccess = userManagementAPI.insertUser(type, login, password, status, name);
            if (isSuccess) {
                page = ConfigurationManager.getProperty("path.page.success");
            } else {
                // Обработка неудачного добавления пользователя
                page = ConfigurationManager.getProperty("path.page.error");
            }
        } catch (SQLException e) {
            // Обработка ошибки SQL
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error");
        }

        // Перенаправление на страницу с результатом

        return page;
    }
}
