package trastienda.servlet;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Customer;
import trastienda.negocio.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");

    }
}
