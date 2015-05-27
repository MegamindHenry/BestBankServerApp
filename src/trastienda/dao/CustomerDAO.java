package trastienda.dao;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Customer;
import trastienda.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends BaseDAO {

    public Customer login(String username, String password) throws DAOExcepcion {

        Customer cu = new Customer();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            String query = "select Username, Salutation, FirstName, MiddleName, Lastname, NameSuffix from customer where Username=? and Password=? and Status=?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, 0);

            rs = stmt.executeQuery();
            if (rs.next()) {
                cu.setUsername(rs.getString(1));
                cu.setSalutation(rs.getString(2));
                cu.setFirstName(rs.getString(3));
                cu.setMiddleName(rs.getString(4));
                cu.setLastName(rs.getString(5));
                cu.setNameSuffix(rs.getString(6));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
        	this.closeResultSet(rs);
			this.closeStatement(stmt);
			this.closeConnection(con);
        }
        return cu;

    }

    public Integer getCounterByUsername(String username) throws DAOExcepcion {

        Integer count = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            String query = "select AttemptCounter from customer where Username=?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, username);

            rs = stmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
        	this.closeResultSet(rs);
			this.closeStatement(stmt);
			this.closeConnection(con);
        }
        return count;

    }

    public Boolean changeStatus(String username, Integer status) throws DAOExcepcion {

        Connection con = null;
        PreparedStatement stmt = null;
        Boolean r = false;
        try {

            String query = "UPDATE customer SET Status = ? where Username = ?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, status);
            stmt.setString(2, username);
            r = true;

            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo actualizar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.closeStatement(stmt);
            this.closeConnection(con);
        }
        return r;
    }

    public Boolean addCount(String username, Integer count) throws DAOExcepcion {

        Connection con = null;
        PreparedStatement stmt = null;
        Boolean r = false;
        try {


            String query = "UPDATE customer SET AttemptCounter = ? where Username = ?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, count);
            stmt.setString(2, username);
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo actualizar");
            }

            r = true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());

        } finally {
            this.closeStatement(stmt);
            this.closeConnection(con);
        }
        return r;
    }

		
}
