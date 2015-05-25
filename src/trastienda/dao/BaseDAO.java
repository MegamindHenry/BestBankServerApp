package trastienda.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// dao 2
public class BaseDAO {
	
	protected void closeConnection(Connection con) throws RuntimeException {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException se) {
			System.err.println("Error: closeConnection: " + se);
		}
	}

	protected void closeResultSet(ResultSet rs) throws RuntimeException {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException se) {
			System.err.println("Error: closeResultSet: " + se);
		}
	}

	protected void closeStatement(PreparedStatement stmt)
			throws RuntimeException {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException se) {
			System.err.println("Error: closeStatement: " + se);
		}
	}

	protected void closeCallable(CallableStatement callstmt)
			throws RuntimeException {
		try {
			if (callstmt != null) {
				callstmt.close();
			}
		} catch (SQLException se) {
			System.err.println("Error: closeCallable: " + se);
		}
	}
}