
package control;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.DBUtil;
import modelo.Usuario;


public class SVUsuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        Usuario usuario = DBUtil.obtenerUsuarioPorNombre(username);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        if (usuario != null) {
            out.println("<h2>Resultado</h2>");
            out.println("<p>ID: " + usuario.getId() + "</p>");
            out.println("<p>Usuario: " + usuario.getUsername() + "</p>");
            out.println("<p>Contraseña: " + usuario.getPassword() + "</p>");
        } else {
            out.println("<p>No se encontró el usuario.</p>");
        }
        out.println("</body></html>");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("insertar".equals(accion)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            boolean exito = DBUtil.insertarUsuario(username, password);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (exito) {
                out.println("<h3>Usuario agregado correctamente.</h3>");
            } else {
                out.println("<h3>Error al agregar usuario. El nombre puede estar repetido.</h3>");
            }
            out.println("<a href='index.jsp'>Volver</a>");
            out.println("</body></html>");
        }
        else if ("eliminar".equals(accion)) {
            String username = request.getParameter("username");

            boolean eliminado = DBUtil.eliminarUsuarioPorNombre(username);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (eliminado) {
                out.println("<h3>Usuario eliminado correctamente.</h3>");
            } else {
                out.println("<h3>No se pudo eliminar. ¿Existe ese usuario?</h3>");
            }
            out.println("<a href='index.jsp'>Volver</a>");
            out.println("</body></html>");
        }
        else if ("modificar".equals(accion)) {
            String username = request.getParameter("username");
            String nuevaPassword = request.getParameter("password");

            boolean actualizado = DBUtil.actualizarContrasena(username, nuevaPassword);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if (actualizado) {
                out.println("<h3>Contraseña actualizada correctamente.</h3>");
            } else {
                out.println("<h3>Error al actualizar. ¿Existe ese usuario?</h3>");
            }
            out.println("<a href='index.jsp'>Volver</a>");
            out.println("</body></html>");
        }
    }
}

