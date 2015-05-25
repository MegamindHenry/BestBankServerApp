package trastienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Customer;
import trastienda.util.ConexionBD;

public class CustomerDAO extends BaseDAO {

    public Customer login(String username, String password) throws DAOExcepcion {

        Customer cu = new Customer();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Boolean granted = false;

        try {

            String query = "select Username, Salutation, FirstName, MiddleName, Lastname, NameSuffix from customer where Username=? and Password=?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            if (rs.next()) {
                cu.setUsername(rs.getString(1));
                cu.setSalutation(rs.getString(2));
                cu.setFirstName(rs.getString(3));
                cu.setMiddleName(rs.getString(4));
                cu.setLastName(rs.getString(5));
                cu.setNameSuffix(rs.getString(6));
                granted = true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return cu;

    }

		
}
