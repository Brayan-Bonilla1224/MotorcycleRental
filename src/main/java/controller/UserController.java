package controller;

import beans.Usuarios;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Brayan
 */
public class UserController implements IUserController
{

    @Override
    public String login(String userName, String contrasena)
    {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "select * from usuarios where username = '" + userName + "' and contrasena = '" + contrasena + "'";
        try
        {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String username = rs.getString("username");
                String contrasenaR = rs.getString("contrasena");
                String email = rs.getString("email");
                String celular = rs.getString("celular");
                int premium = rs.getInt("premium");
                Usuarios usuarios = new Usuarios();
                usuarios.setNombres(nombres);
                usuarios.setApellidos(apellidos);
                usuarios.setUserName(username);
                usuarios.setContrasena(contrasenaR);
                usuarios.setEmail(email);
                usuarios.setCelular(celular);
                usuarios.setPremium(premium);
                return gson.toJson(usuarios);
            }
            return "false";
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return "false";
        } finally
        {
            con.disconnect();
        }

    }

}
