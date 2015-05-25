package trastienda.negocio;

import trastienda.dao.CustomerDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Customer;

import java.util.Collection;

public class Session {

    public Customer login(String username, String password) throws DAOExcepcion {
        CustomerDAO dao = new CustomerDAO();
        return dao.login(username, password);
    }

}
