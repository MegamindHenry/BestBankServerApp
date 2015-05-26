package trastienda.rest;

import java.sql.Date;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import trastienda.dao.TransactionDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Checking;
import trastienda.modelo.Saving;
import trastienda.modelo.Transaction;
import trastienda.modelo.Account;

@Path("/transaction")
public class TransactionRest 
{
	
	@GET
	@Path("/byType/{Type}")
	@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
	public String searchByTransType( @PathParam("{Type}") String transType ) 
	{
		
		System.out.println("searchByTransId() : Transaction ID: " + transType);
		JSONArray arrayObj = new JSONArray();
		
		try 
		{
			TransactionDAO dao = new TransactionDAO();
			Collection<Transaction> transaction =  dao.searchTransType(transType);
			System.out.println(transaction.size());
			arrayObj.addAll(transaction);
			
		} 
		
		catch (DAOExcepcion e) 
		{	
			System.out.println(e.getMessage());
		}
		return arrayObj.toString();
	}

	@GET
	@Path("/byId/{TransactionID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTransId( @PathParam("TransactionID") int transId ) 
	{		

		System.out.println("getTransId()");
		JSONObject jsonObj = new JSONObject();
		
		try 
		{
			TransactionDAO dao = new TransactionDAO();
			Transaction transaction =  dao.getTransId(transId);
			System.out.println (transaction.getTransId());
			jsonObj.put("Type", transaction.getTransType());
			jsonObj.put("DateTime", transaction.getTransDateTime());
			jsonObj.put("Amount", transaction.getTransAmount());
			jsonObj.put("Description", transaction.getTransDescription());
			jsonObj.put("Status", transaction.getTransStatus());
			jsonObj.put("AccountTarget", transaction.getTransAccountTarget());
			jsonObj.put("AccountType", transaction.getTransAccountType());
			jsonObj.put("Account", transaction.getAccount());
			// something with Account??? ---> jsonObj.put("precio", transaction.getPrecio());
		} 
		
		catch (DAOExcepcion e) 
		{	
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertar(@FormParam("TransactionID") int transId, 
							@FormParam("Type") String transType, 
							@FormParam("DateTime") String transDateTime,
							@FormParam("Amount") double transAmount,
							@FormParam("Description") String transDescription,
							@FormParam("Status") String transStatus,
							@FormParam("AccountTarget") int transAccountTarget,
							@FormParam("AccountType") String transAccountType,
							@FormParam("AccountNumber") int tranAccountNumber)
							
	{
		System.out.println("Insert within(): " + transId);

		JSONObject jsonObj = new JSONObject();
		
		try 
		{
			TransactionDAO dao = new TransactionDAO();
			
			Transaction vo = new Transaction();
			vo.setTransId(transId);
			vo.setTransType(transType);
			vo.setTransDateTime(transDateTime);
			vo.setTransAmount(transAmount);
			vo.setTransDescription(transDescription);
			vo.setTransStatus(transStatus);
			vo.setTransAccountTarget(transAccountTarget);
			vo.setTransAccountType(transAccountType);
			//Account cvo = new Account();
			if(transAccountType.equals("0"))
			{
				Checking account = new Checking();
				account.setAccountNumber(tranAccountNumber);
			}
			else
			{
				Saving account = new Saving();
				account.setAccountNumber(tranAccountNumber);
			}
			
			vo = dao.insert(vo);
			System.out.println(vo.getTransId());
			jsonObj.put("state", "CORRECT");
						
		} 
		catch (DAOExcepcion e) 
		{
			jsonObj.put("state", "FAILED");
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}
	
	@DELETE
	@Path("/transaction/{TransactionID}")
	@Produces(MediaType.APPLICATION_JSON)
	public String delete( @PathParam("TransactionID") int transId ) 
	{		

		System.out.println("delete within(): ");
		
		JSONObject jsonObj = new JSONObject();
		
		try 
		{
			TransactionDAO dao = new TransactionDAO();
			dao.delete(transId);
			jsonObj.put("state", "CORRECT");
						
		} 
		
		catch (DAOExcepcion e) 
		{	
			jsonObj.put("state", "FAILED");
			System.out.println(e.getMessage());
		}
		return jsonObj.toString();
	}

}
