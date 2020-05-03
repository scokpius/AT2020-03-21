import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUserDatabase {
    static final String url= "jdbc:mysql://localhost/megaapp?serverTimezone=Europe/Moscow&useSSL=false";
    static final String user = "root";
    static final String password = "_______";

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        try (Connection сonnection = DriverManager.getConnection(url, user, password);
             Statement statement = сonnection.createStatement()) {

            String SQL = "CREATE TABLE users (user_id int(11), user_login varchar(255), user_password char(40) ,PRIMARY KEY (user_id))";
            String SQL1 = "INSERT users(user_id, user_login, user_password) Values (1,'buga','02c489c2827bdc42fb9159cb98fccdf174fe3b2e')";
            statement.executeUpdate(SQL);
            statement.executeUpdate(SQL1);



        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
