package beans;

/**
 *
 * @author Brayan
 */
public class Usuarios
{

    private String userName;
    private String contrasena;
    private String nombres;
    private String apellidos;
    private String email;
    private int premium;
    private String celular;

    public Usuarios()
    {
    }

    public Usuarios(String userName, String contrasena, String nombres, String apellidos, String email, int premium, String celular)
    {
        this.userName = userName;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.premium = premium;
        this.celular = celular;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getPremium()
    {
        return premium;
    }

    public void setPremium(int premium)
    {
        this.premium = premium;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    @Override
    public String toString()
    {
        return "Usuarios{" + "userName=" + userName + ", contrasena=" + contrasena + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", premium=" + premium + ", celular=" + celular + '}';
    }

}
