package beans;

/**
 *
 * @author Brayan
 */
public class Motocicleta
{

    private int id;
    private String marca;
    private double valor;
    private String modelo;
    private int disponibles;
    private String comentarios;

    public Motocicleta()
    {
    }

    public Motocicleta(int id, String marca, double valor, String modelo, int disponibles, String comentarios)
    {
        this.id = id;
        this.marca = marca;
        this.valor = valor;
        this.modelo = modelo;
        this.disponibles = disponibles;
        this.comentarios = comentarios;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public int getDisponibles()
    {
        return disponibles;
    }

    public void setDisponibles(int disponibles)
    {
        this.disponibles = disponibles;
    }

    public String getComentarios()
    {
        return comentarios;
    }

    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }

    @Override
    public String toString()
    {
        return "Motocicleta{" + "id=" + id + ", marca=" + marca + ", valor=" + valor + ", modelo=" + modelo + ", disponibles=" + disponibles + ", comentarios=" + comentarios + '}';
    }

}
