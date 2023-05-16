package controller;

/**
 *
 * @author Brayan
 */
public interface IUserController
{

    public String login(String userName, String contrasena);

    public String register(String userName, String contrasena, String nombres,
            String apellidos, String email, String celular);
}
