package test;

import beans.Motocicleta;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Brayan
 */
public class OperationsDB
{

    public static void main(String[] args)
    {
        findAll();
        //updateMotorcycle(1, "CR5 200");
    }

    public static void updateMotorcycle(int id, String modelo)
    {
        DBConnection dBConnection = new DBConnection();
        String sql = "update motocicleta set modelo = '" + modelo + "' where id = " + id;
        try
        {
            Statement st = dBConnection.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            dBConnection.disconnect();
        }
    }

    public static void findAll()
    {
        DBConnection dBConnection = new DBConnection();
        String sql = "SELECT * FROM motocicleta;";
        try
        {
            Statement st = dBConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next())
            {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                double valor = rs.getDouble("valor");
                String modelo = rs.getString("modelo");
                int disponibles = rs.getInt("disponibles");
                String comentarios = rs.getString("comentarios");

                Motocicleta motocicleta = new Motocicleta();
                motocicleta.setId(id);
                motocicleta.setMarca(marca);
                motocicleta.setValor(valor);
                motocicleta.setModelo(modelo);
                motocicleta.setDisponibles(disponibles);
                motocicleta.setComentarios(comentarios);
                System.out.println(motocicleta.toString());
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            dBConnection.disconnect();
        }
    }
}
