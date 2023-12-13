import java.sql.Connection;
import java.sql.SQLException;
import org.rsreu.library.databaseutil.OracleConnectionManager;
import org.rsreu.library.databaseutil.DAO.CredentialDAO;
import org.rsreu.library.databaseutil.entity.User;
public class ConsoleTest {

    public static void main(String[] args) {
        try {
            // Подключение к базе данных (ваша реализация)
            Connection connection = OracleConnectionManager.getConnection();

            // Создание DAO объекта
            CredentialDAO credentialDAO = new CredentialDAO(connection);

            // Выборочный вызов метода для тестирования
            User user = credentialDAO.getUserByLoginAndPassword("admin", "123");

            if (user != null) {
                // Вывод данных пользователя в консоль
                System.out.println("User ID: " + user.getId());
                System.out.println("User Type: " + user.getType());
                System.out.println("User Login: " + user.getLogin());
                System.out.println("User Password: " + user.getPassword());
                System.out.println("User Status: " + user.getStatus());
                System.out.println("User Name: " + user.getName());
            } else {
                System.out.println("User not found!");
            }

            // Закрытие соединения (не забывайте об этом)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибок
        }
    }
}
