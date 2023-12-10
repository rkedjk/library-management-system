package org.rsreu.library.databaseutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OracleConnectionManager {
    private static final String CONFIG_FILE = "database"; // Название файла ресурсов без расширения

    public static Connection getConnection() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(CONFIG_FILE);

        String jdbcUrl = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("db.username");
        String password = resourceBundle.getString("db.password");

        Connection connection = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Успешное соединение с базой данных Oracle!");
            } else {
                System.out.println("Не удалось установить соединение с базой данных Oracle.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver не найден. Убедитесь, что вы добавили JDBC-драйвер в свой проект.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ошибка при установлении соединения с базой данных Oracle.");
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Соединение с базой данных Oracle закрыто.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
