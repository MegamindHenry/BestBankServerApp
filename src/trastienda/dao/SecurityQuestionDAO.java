package trastienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.SecurityQuestion;
import trastienda.util.ConexionBD;


public class SecurityQuestionDAO extends BaseDAO {

	public SecurityQuestion getByCustomerID(int CustomerID) throws DAOExcepcion {
		SecurityQuestion vo = new SecurityQuestion();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from securityquestion where CustomerID=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, CustomerID);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setCustomerID(rs.getInt(1));
				vo.setQuestionNum(rs.getInt(2));
				vo.setAnswer(rs.getString(3));
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(stmt);
			this.closeConnection(con);
		}
		return vo;
	}


	public SecurityQuestion insert(SecurityQuestion vo) throws DAOExcepcion {
		String query = "INSERT INTO securityquestion(question,securityquestions) VALUES (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getCustomerID());
			stmt.setInt(2, vo.getQuestionNum());
			stmt.setString(3, vo.getAnswer());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("Cant insert");
			}
			//int id = 0;
			//query = "SELECT LAST_INSERT_ID()";
			//stmt = con.prepareStatement(query);
			//rs = stmt.executeQuery();
			//if (rs.next()) {
				//	id = rs.getInt(1);
			//}
			//vo.setQuestionNum(id);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(stmt);
			this.closeConnection(con);
		}
		return vo;
	}

	public void delete(int QuestionNum, int CustomerID) throws DAOExcepcion {
		String query = "DELETE FROM securityquestion WHERE QuestionNum=? and CustomerID=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, QuestionNum);
			stmt.setInt(2, CustomerID);
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("Cant delete");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.closeStatement(stmt);
			this.closeConnection(con);
		}
	}

	public SecurityQuestion update(SecurityQuestion vo) throws DAOExcepcion {
		String query = "update question set question=? where questionnum=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getAnswer());
//			stmt.setString(2, vo.getDescripcion());
			//stmt.setDouble(2, vo.getPrecio());
//			stmt.setInt(4, vo.getStock());
//			stmt.setInt(5, vo.getImportancia());
//			stmt.setString(6, vo.getImagen());
//			stmt.setInt(7, vo.getCategoria().getIdCategoria());
			//stmt.setInt(3, vo.getIdProducto());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("Cant Update");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.closeStatement(stmt);
			this.closeConnection(con);
		}
		return vo;
	}

}
