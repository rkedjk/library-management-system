package org.rsreu.library;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/LibraryServlet") // Указываем URL-адрес, по которому будет доступен сервлет
public class LibraryServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Получение логина и пароля из формы
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Здесь можно реализовать проверку логина и пароля
        // Например, можно использовать базу данных для проверки учетных данных

        // Проверка демонстрационная, нужно заменить ее на реальную авторизацию
        if (username != null && password != null && username.equals("admin") && password.equals("admin123")) {
            // Если логин и пароль верные, перенаправляем на следующую страницу
            response.sendRedirect("nextPage.jsp");
        } else {
            // Если логин или пароль неверные, выводим сообщение об ошибке
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<h1>Invalid username or password</h1>");
            out.println("</body></html>");
        }

        out.close();
    }
}
