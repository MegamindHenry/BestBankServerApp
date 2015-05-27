package trastienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Saving;
import trastienda.modelo.Transaction;
import trastienda.util.ConexionBD;


public class SavingDAO extends BaseDAO
{
	public Saving getByAccountNumber(int accountNumber) throws DAOExcepcion{
		Saving vo = new Saving();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try
		{
			String query = "select * from Saving where accountNumber=?";
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

	public Collection<Transaction> searchByAccountNum(String accountNum)
			throws DAOExcepcion {
		String query = "select Type, DateTime, Amount, Status from transaction where AccountTarget = ?";
		Collection<Transaction> c = new ArrayList<Transaction>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, accountNum);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Transaction vo = new Transaction();
				//vo.setIdProducto(rs.getInt("id_producto"));				
				//vo.setNombre(rs.getString("nombre"));
				//System.out.println("----------->" + vo.getNombre());
				//vo.setDescripcion(rs.getString("descripcion"));
				//vo.setPrecio(rs.getFloat("precio"));
				//vo.setStock(rs.getInt("stock"));
				//vo.setImportancia(rs.getInt("importancia"));
				//vo.setImagen(rs.getString("imagen"));
				vo.setTransType(rs.getString("Type"));
				vo.setTransDateTime(rs.getString("DateTime"));
				vo.setTransAmount(rs.getDouble("Amount"));
				vo.setTransStatus(rs.getString("Status"));
				
				
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

public Saving insert(Saving vo) throws DAOExcepcion
{
	String query = "insert into Saving(CurrentBal, MinimumBal, AvailableBal, Status, Interest, Type, CustomerID, DateOpened) values (?,?,?,?,?,?,?,?,?)";
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
	String query = "DELETE FROM Saving WHERE AccountNumber=?";
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

public Saving update(Saving vo) throws DAOExcepcion {
	String query = "update Saving CurrentBal=?, MinimumBal=?, AvailableBal=?, Status=?, Interest=?, Type=?, CustomerID=?, DateOpened=? where AccountNumber=?";
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