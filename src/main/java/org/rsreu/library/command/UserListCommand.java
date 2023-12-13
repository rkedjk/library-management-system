/*package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import org.rsreu.library.databaseutil.api.admin.UserManagementAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class UserListCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            // Получаем параметры поиска из атрибутов запроса, установленных предыдущей командой
            String searchInput = (String) request.getAttribute("searchInput");
            String searchParam = (String) request.getAttribute("searchParam");

            // Логика обработки списка пользователей на основе параметров поиска
            UserManagementAPI userManagementAPI = new UserManagementAPI();
            List<Account> userList = userManagementAPI.searchUserByProperty(searchParam, searchInput);

            request.setAttribute("userList", userList);
            page = ConfigurationManager.getProperty("path.page.userlist"); // Страница JSP для отображения списка пользователей
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка SQLException
            // Можно установить атрибут ошибки или перенаправить на страницу ошибки
            request.setAttribute("error", "An error occurred while processing your request.");
            page = "error.jsp"; // Установка страницы ошибки или другой подходящей страницы
        }
        return page;
    }
}
*/