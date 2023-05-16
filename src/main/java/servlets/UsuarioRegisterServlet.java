/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import controller.UserController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brayan
 */
@WebServlet(name = "UsuarioRegisterServlet", urlPatterns =
{
    "/UsuarioRegisterServlet"
})
public class UsuarioRegisterServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        UserController controller = new UserController();
        String username = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String result = controller.register(username, contrasena, nombres, apellidos, email, celular);
        response.setContentType("text/html:charset=UTF-8");
        try ( PrintWriter out = response.getWriter())
        {
            out.println(result);
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
