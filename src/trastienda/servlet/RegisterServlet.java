package trastienda.servlet;

import trastienda.dao.AdressDAO;
import trastienda.dao.CustomerDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Address;
import trastienda.modelo.Customer;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException, DAOExcepcion {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_confirmation = request.getParameter("password_confirmation");
        String email = request.getParameter("email");
        String email_confirmation = request.getParameter("email_confirmation");
        String phone = request.getParameter("phone");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String ssn = request.getParameter("ssn");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String dob = request.getParameter("dob");


        String securityQuestion1 = request.getParameter("securityQuestion1");
        String answer1 = request.getParameter("answer1");
        String securityQuestion2 = request.getParameter("securityQuestion2");
        String answer2 = request.getParameter("answer2");
        String securityQuestion3 = request.getParameter("securityQuestion3");
        String answer3 = request.getParameter("answer3");
        String securityQuestion4 = request.getParameter("securityQuestion4");
        String answer4 = request.getParameter("answer4");
        String securityQuestion5 = request.getParameter("securityQuestion5");
        String answer5 = request.getParameter("answer5");

        CustomerDAO dao = new CustomerDAO();
        AdressDAO ad = new AdressDAO();

        Customer customer = dao.create(username, password, email, phone, firstName, lastName, ssn, dob);
        Address add = ad.create(customer.getCustomerID(),address, city, province);

    }

}
