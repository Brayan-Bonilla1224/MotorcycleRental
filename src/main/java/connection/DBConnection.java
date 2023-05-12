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
    static final String PORT = "5432";
    static final String USER = "postgres";
    static final String PASSWORD = "admin";

    public DBConnection()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:" + PORT + "/" + DB;
            connection = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException e)
        {
            System.out.println("Error de conexion");
        } catch (ClassNotFoundException ex)
        {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void disconnect()
    {

        try
        {
            if (connection != null)
            {
                connection.close();
                connection = null;
            }
        } catch (SQLException ex)
        {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }

}
