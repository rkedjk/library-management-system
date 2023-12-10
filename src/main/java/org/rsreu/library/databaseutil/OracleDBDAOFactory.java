package org.rsreu.library.databaseutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class OracleDBDAOFactory {

    public static void main(String[] args) {
        // Замените параметры подключения своими данными
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "C##denis";
        String password = "Admin1234";

        Connection connection = null;

        try {
            // Загружаем драйвер JDBC для Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Устанавливаем соединение
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Успешное соединение с базой данных Oracle!");
                // Дальнейшие операции с базой данных могут быть выполнены здесь
            } else {
                System.out.println("Не удалось установить соединение с базой данных Oracle.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver не найден. Убедитесь, что вы добавили JDBC-драйвер в свой проект.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ошибка при установлении соединения с базой данных Oracle.");
            e.printStackTrace();
        } finally {
            // Закрываем соединение в блоке finally, чтобы гарантировать его закрытие даже в случае исключения
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

