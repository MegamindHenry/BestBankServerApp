package trastienda.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Question;
import trastienda.modelo.SecurityQuestion;
import trastienda.util.ConexionBD;


public class QuestionDAO extends BaseDAO {

	public Collection<Question> getAll() throws DAOExcepcion {

        Collection<Question> c = new ArrayList<Question>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from question";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);

			rs = stmt.executeQuery();
			while (rs.next()) {
                Question vo = new Question();
                vo.setQuestionNum(rs.getInt(1));
				vo.setQuestion(rs.getString(2));
                c.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.closeResultSet(rs);
			this.closeStatement(stmt);
			this.closeConnection(con);
		}
		return c;
	}

	public Question getByQuestionNumber(int QuestionNum) throws DAOExcepcion {
		Question vo = new Question();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select * from question where QuestionNum=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, QuestionNum);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setQuestionNum(rs.getInt(1));
				vo.setQuestion(rs.getString(2));
				SecurityQuestion securityQuestion = new SecurityQuestion();
				securityQuestion.setQuestionNum(rs.getInt(3));
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


	public Question insert(Question vo) throws DAOExcepcion {
		String query = "INSERT INTO question(question,securityquestions) VALUES (?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, ((Question) vo.getSecurityQuestion()).getQuestionNum());
			stmt.setString(2, vo.getQuestion());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("Cant insert");
			}
			int id = 0;
			query = "SELECT LAST_INSERT_ID()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			vo.setQuestionNum(id);
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

	public void delete(int QuestionNum) throws DAOExcepcion {
		String query = "DELETE FROM question WHERE QuestionNum=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, QuestionNum);
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

	public Question update(Question vo) throws DAOExcepcion {
		String query = "update question set question=? where questionnum=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getQuestion());
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
