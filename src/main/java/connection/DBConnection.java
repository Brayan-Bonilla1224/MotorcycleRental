package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Brayan
 */
public class DBConnection
{

    Connection connection;

    static final String DB = "motorcycle_rental";
    static final String PORT = "3306";
    static final String USER = "root";
    static final String PASSWORD = "admin";

    public DBConnection()
    {
        try
        {
            String url = "jdbc:mariadb://localhost:" + PORT + "/" + DB;
            connection = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException e)
        {
            System.out.println("Error de conexion");
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void disconnect()
    {

        connection = null;
    }

}
