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
@WebServlet(name = "UsuarioLoginServlet", urlPatterns =
{
    "/UsuarioLoginServlet"
})
public class UsuarioLoginServlet extends HttpServlet
{

    public UsuarioLoginServlet()
    {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        UserController controller = new UserController();
        String userName = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
        String result = controller.login(userName, contrasena);
        response.setContentType("text/html:charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            out.println(result);
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
