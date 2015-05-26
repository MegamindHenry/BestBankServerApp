package trastienda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Account;
import trastienda.modelo.Checking;
import trastienda.modelo.Saving;
import trastienda.modelo.Transaction;
import trastienda.util.ConexionBD;

public class TransactionDAO extends BaseDAO 
{

	public Transaction getTransId(int transId) throws DAOExcepcion 
	{
		Transaction vo = new Transaction();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try 
		{
			String query = "select * from transaction where TransactionID=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, transId);

			rs = stmt.executeQuery();
			if (rs.next()) 
			{
				vo.setTransId(rs.getInt(1));
				vo.setTransType(rs.getString(2));
				vo.setTransDateTime(rs.getString(3));
				vo.setTransAmount(rs.getDouble(4));
				vo.setTransDescription(rs.getString(5));
				vo.setTransStatus(rs.getString(6));
				vo.setTransAccountType(rs.getString(8));
				//Not sure how to fix this error
				if(rs.getString(8).equals("0"))
				{
					Checking account = new Checking();
					account.setAccountNumber(rs.getInt(7));
					vo.setAccount(account);
				}
				else
				{
					Saving account = new Saving();
					account.setAccountNumber(rs.getInt(7));
					vo.setAccount(account);
				}
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

	public Collection<Transaction> searchTransType(String transType)
			throws DAOExcepcion 
			{
		/*!!!not sure how to do this query*/ 
		String query = "select transaction.*, account.nombre as ncategoria from producto,categoria where producto.nombre like ? and categoria.id_categoria=producto.id_categoria";
		Collection<Transaction> t = new ArrayList<Transaction>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + transType + "%");
			rs = stmt.executeQuery();
			while (rs.next()) 
			{
				Transaction vo = new Transaction();
				vo.setTransId(rs.getInt("transId"));
				vo.setTransType(rs.getString("transType"));
				vo.setTransDateTime(rs.getString("transDateTime"));
				vo.setTransAmount(rs.getDouble("transAmount"));
				vo.setTransDescription(rs.getString("transDescription"));
				vo.setTransStatus(rs.getString("transStatus"));
				vo.setTransAccountTarget(rs.getInt("transAccountTarget"));
				vo.setTransAccountType(rs.getString("transAccountType"));
				//Not sure how to fix this error
				if(rs.getString(8).equals("0"))
				{
					Checking account = new Checking();
					account.setAccountNumber(rs.getInt("accountNumber"));
					vo.setAccount(account);
				}
				else
				{
					Saving account = new Saving();
					account.setAccountNumber(rs.getInt("accountNumber"));
					vo.setAccount(account);
				}
				t.add(vo);
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
		return t;
	}

	public Transaction insert(Transaction vo) throws DAOExcepcion 
	{
		String query = "INSERT INTO transaction(TransactionID, Type, DateTime, Amount, Description, Status, AccountTarget, AccountType) VALUES (?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			
			stmt.setInt(1, vo.getTransId());
			stmt.setString(2, vo.getTransType());
			stmt.setString(3, (String) vo.getTransDateTime());
			stmt.setDouble(4, vo.getTransAmount());
			stmt.setString(5, vo.getTransDescription());
			stmt.setString(6, vo.getTransStatus());
			stmt.setInt(7, vo.getTransAccountTarget());
			stmt.setString(8, vo.getTransAccountType());
			stmt.setInt(9, vo.getAccount().getAccountNumber());
			
			
			int i = stmt.executeUpdate();
			if (i != 1) 
			{
				throw new SQLException("This cannot be inserted");
			}

			int id = 0;
			query = "SELECT LAST_INSERT_ID()";
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if (rs.next()) 
			{
				id = rs.getInt(1);
			}
			vo.setTransId(id);
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

	public void delete(int transId) throws DAOExcepcion 
	{
		String query = "DELETE FROM transaction WHERE TransactionID=?";
		Connection con = null;
		PreparedStatement stmt = null;
		try 
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, transId);
			int i = stmt.executeUpdate();
			if (i != 1) 
			{
				throw new SQLException("This cannot be deleted");
			}
		} 
		
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} 
		
		finally 
		{
			this.closeStatement(stmt);
			this.closeConnection(con);
		}
	}

	public Collection<Transaction> listTransactionsByType(String transType)
			throws DAOExcepcion 
			{
		String query = "select TransactionID, Type, DateTime, Amount, Description, Status, AccountTarget, AccountType from transaction where Type="+ transType;
		Collection<Transaction> t = new ArrayList<Transaction>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) 
			{
				Transaction vo = new Transaction();
				vo.setTransId(rs.getInt("TransactionID"));				
				vo.setTransType(rs.getString("Type"));
				vo.setTransDateTime(rs.getString("DateTime"));
				vo.setTransAmount(rs.getDouble("Amount"));
				vo.setTransDescription(rs.getString("Description"));
				vo.setTransStatus(rs.getString("Status"));
				vo.setTransAccountTarget(rs.getInt("AccountTarget"));
				vo.setTransAccountType(rs.getString("AccountType"));
				//seems like it needs to be converted..? not sure. Could be related to instantiation problem possibly
				//vo.setAccount(rs.getAccount("AccountNumber"));
				t.add(vo);
				
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
		return t;
	}

}
