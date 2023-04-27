package beans;

import java.util.Date;

/**
 *
 * @author Brayan
 */
public class Alquiler
{

    private int id;
    private String userName;
    private Date fecha;
    private String comentario;

    public Alquiler()
    {
    }

    public Alquiler(int id, String userName, Date fecha, String comentario)
    {
        this.id = id;
        this.userName = userName;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public String getComentario()
    {
        return comentario;
    }

    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    @Override
    public String toString()
    {
        return "Alquiler{" + "id=" + id + ", userName=" + userName + ", fecha=" + fecha + ", comentario=" + comentario + '}';
    }

}
