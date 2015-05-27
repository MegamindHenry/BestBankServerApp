package trastienda.dao;


import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Address;
import trastienda.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdressDAO extends BaseDAO {

    public Address create(int customerId, String street, String city, String province) throws DAOExcepcion {

        Address ad = new Address();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            String queryAddress = "INSERT INTO address(CustomerID, Street, City, Province) values (?,?,?,?)";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(queryAddress);

            stmt.setInt(1, customerId);
            stmt.setString(2, street);
            stmt.setString(3, city);
            stmt.setString(4, province);

            rs = stmt.executeQuery();
            if (rs.next()) {
                ad.setStreet(street);
                ad.setCity(city);
                ad.setProvince(province);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.closeResultSet(rs);
            this.closeStatement(stmt);
            this.closeConnection(con);
        }

        return ad;

    }

}
