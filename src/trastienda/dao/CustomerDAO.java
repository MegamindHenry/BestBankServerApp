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
		Customer vo = new Customer();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select firstName, lastName from customer where username=? AND password =?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);

			rs = stmt.executeQuery();
			if (rs.next()) {
				
				vo.setFirstName(rs.getString(1));
				vo.setLastName(rs.getString(2));
			}
			else
			{
				throw new DAOExcepcion("Login is incorrect");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

		
}
