package trastienda.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Checking;
import trastienda.util.ConexionBD;



public class CheckingDAO extends BaseDAO
{
	public Checking getByAccountNumber(int accountNumber) throws DAOExcepcion{
		Checking vo = new Checking();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			String query = "select * from Checking where accountNumber=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, accountNumber);
			
			rs = stmt.executeQuery();
			if(rs.next())
			{
				vo.setAccountNumber(rs.getInt(1));
				vo.setCurrentBal(rs.getInt(2));
				vo.setMinimumBal(rs.getInt(3));
				vo.setAvailableBal(rs.getInt(4));
				vo.setStatus(rs.getString(5));
				vo.setInterest(rs.getInt(6));
				vo.setCustomerID(rs.getInt(7));
				vo.setDateOpened(rs.getDate(8));
			}	
		}
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} 
		finally 
		{
			this.closeResultSet(rs);
			this.closeStatement(stmt);
			this.closeConnection(con);
		}
		return vo;
}

//public Collection<Checking> searchByAccountNumber(int accountNumber) throws DAOException
//{
//	String query = "select account.CustomerID, account.DateOpened, checking.* from account, checking where account.AccountNumber = checking.AccountNumber";
//	Collection<Checking> c = new ArrayList<Checking>();
//	Connection con = null;
//	PreparedStatement stmt = null;
//	ResultSet rs = null;
//	try
//	{
//		con = ConnectionBD.openConnection();
//		stmt = con.prepareStatement(query);
//		stmt.setString(1, accountNumber)
//	}
//}

public Checking insert(Checking vo) throws DAOExcepcion
{
	String query = "insert into checking(CurrentBal, MinimumBal, AvailableBal, Status, Interest, Type, CustomerID, DateOpened) values (?,?,?,?,?,?,?,?,?)";
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try
	{
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setDouble(1, vo.getCurrentBal());
		stmt.setDouble(2, vo.getMinimumBal());
		stmt.setDouble(3, vo.getAvailableBal());
		stmt.setString(4, vo.getStatus());
		stmt.setDouble(5, vo.getInterest());
		stmt.setString(6, vo.getStatus());
		stmt.setInt(7, vo.getCustomerID());
		stmt.setDate(8, vo.getDateOpened());
		int i = stmt.executeUpdate();
		if(i != 1)
		{
			throw new SQLException("You cannot insert");
		}
		int id = 0;
		query = "SELECT LAST_INSERT_ID()";
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		vo.setAccountNumber(id);
	}
	catch (SQLException e) {
		System.err.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
	} 
	finally 
	{
		this.closeResultSet(rs);
		this.closeStatement(stmt);
		this.closeConnection(con);
	}
	return vo;
}

public void delete(int accountNumber) throws DAOExcepcion {
	String query = "DELETE FROM Checking WHERE AccountNumber=?";
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setInt(1, accountNumber);
		int i = stmt.executeUpdate();
		if (i != 1) {
			throw new SQLException("You can not delete");
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
		throw new DAOExcepcion(e.getMessage());
	} finally {
		this.closeStatement(stmt);
		this.closeConnection(con);
	}
}

public Checking update(Checking vo) throws DAOExcepcion {
	String query = "update checking CurrentBal=?, MinimumBal=?, AvailableBal=?, Status=?, Interest=?, Type=?, CustomerID=?, DateOpened=? where AccountNumber=?";
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = ConexionBD.obtenerConexion();
		stmt = con.prepareStatement(query);
		stmt.setDouble(1, vo.getCurrentBal());
		stmt.setDouble(2, vo.getMinimumBal());
		stmt.setDouble(3, vo.getAvailableBal());
		stmt.setString(4, vo.getStatus());
		stmt.setDouble(5, vo.getInterest());
		stmt.setInt(6, vo.getAccountNumber());
		stmt.setInt(7, vo.getCustomerID());
		stmt.setDate(8, vo.getDateOpened());
		int i = stmt.executeUpdate();
		if (i != 1) {
			throw new SQLException("You cannot update");
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