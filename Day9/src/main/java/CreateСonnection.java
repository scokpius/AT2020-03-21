import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CreateСonnection {

    public class CreateConnection {

        Connection connection;
        Properties prop;

        public CreateConnection() throws SQLException {
            this.prop = PropertiesParser.getProperties();
            this.connection = PropertiesParser.getDataSource(prop).getConnection();
        }

        public Connection createConnection() {
            return connection;
        }

        public void closeConnection() throws SQLException {
            connection.close();
        }
    }
}
