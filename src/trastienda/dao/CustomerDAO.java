package trastienda.dao;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Address;
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

    public Customer create(String username, String password, String email, String phone, String firstName, String lastName, String ssn, String dob) throws DAOExcepcion {

        Customer cu = new Customer();
        Address ad = new Address();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            String query = "INSERT INTO customer(Username, Password, Email, Phone, FirstName, LastName, SSN, DOB) values (?,?,?,?,?,?,?,?)";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setString(5, firstName);
            stmt.setString(6, lastName);
            stmt.setString(7, ssn);
            stmt.setString(8, dob);

            rs = stmt.executeQuery();
            if (rs.next()) {
                cu.setUsername(rs.getString(1));
                cu.setPassword(rs.getString(2));
                cu.setEmail(rs.getString(3));
                cu.setPhoneNumber(rs.getString(4));
                cu.setFirstName(rs.getString(5));
                cu.setLastName(rs.getString(6));
                cu.setSocialSecurityNumber(rs.getString(7));
                cu.setBirthDate(rs.getString(8));
            }

            String lid = "SELECT LAST_INSERT_ID() from customer";
            stmt = con.prepareStatement(lid);

            rs = stmt.executeQuery();
            if (rs.next()) {
                cu.setCustomerID(rs.getInt(1));
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
