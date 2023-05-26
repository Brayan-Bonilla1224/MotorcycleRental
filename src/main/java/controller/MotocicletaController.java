/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import beans.Motocicleta;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class MotocicletaController implements IMotocicletaController
{

    @Override
    public String findAll()
    {
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "select * from motocicleta";
        try
        {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<String> listMoto = new ArrayList<>();
            while (rs.next())
            {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String valor = rs.getString("valor");
                String modelo = rs.getString("modelo");
                int disponibles = rs.getInt("disponibles");
                String comentario = rs.getString("comentarios");
                Motocicleta motocicleta = new Motocicleta();
                motocicleta.setId(id);
                motocicleta.setMarca(marca);
                motocicleta.setValor(valor);
                motocicleta.setModelo(modelo);
                motocicleta.setDisponibles(disponibles);
                motocicleta.setComentarios(comentario);
                listMoto.add(gson.toJson(motocicleta));
            }
            return gson.toJson(listMoto);
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
