package trastienda.servlet;

import trastienda.dao.CustomerDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CustomerDAO dao = new CustomerDAO();

        try {
            Customer c = new Customer();
            c = dao.login(username, password);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            if(c.getUsername() != null) {
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("login", c);
                rd = request.getRequestDispatcher("dashboard.jsp");
            } else {
                Integer count = dao.getCounterByUsername(username);
                count++;
                if(count > 2) {
                    dao.changeStatus(username, "Blocked");
                }
            }
            rd.forward(request, response);
        } catch (DAOExcepcion daoExcepcion) {
            daoExcepcion.printStackTrace();
        }

        return;

    }
}
