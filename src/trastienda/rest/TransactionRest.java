package trastienda.rest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import trastienda.dao.SavingDAO;
import trastienda.dao.TransactionDAO;
import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Checking;
import trastienda.modelo.Saving;
import trastienda.modelo.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/transaction")
public class TransactionRest 
{
	
	@GET
	@Path("/byType/{Type}")
	@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
	public String searchByTransType( @PathParam("Type") String transType)
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
	
	//Make Withdraw
	@POST
	@Path("/withdraw")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String makeWithdraw( @FormParam("account") int accountNum, @FormParam("amount") Double amount , @FormParam("type") String accountType) 
	{
		
		JSONObject obj = new JSONObject();    
		
		try 
		{
			TransactionDAO transDao = new TransactionDAO();

			
			Transaction withdraw = new Transaction();
			withdraw.setTransAmount(amount);
			withdraw.setTransType("Withdrawal");
			withdraw.setTransAccountTarget(accountNum);
			if("1".equals("1"))
			{
				Saving account = new Saving();
				double balance = account.getAvailableBal();
				withdraw.setTransAccountType("Saving");
				if(balance > amount)
				{
					account.setAvailableBal(balance - amount);
					System.out.println("It may have worked");
				}
			}
			transDao.insertAbc(withdraw);
            obj.put("response", "success");
			
		} 
		
		catch (DAOExcepcion e) 
		{	
			System.out.println(e.getMessage());
            obj.put("response", "error");
		}
		return obj.toString();
	}
	
	//Make Deposit
		@POST
		@Path("/deposit")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public String makeDeposit( @FormParam("account") int accountNum, @FormParam("amount") Double amount , @FormParam("type") String accountType) 
		{
			
			JSONObject obj = new JSONObject();    
			
			try 
			{
				TransactionDAO transDao = new TransactionDAO();

				
				Transaction deposit = new Transaction();
				deposit.setTransAmount(amount);
				deposit.setTransType("Deposit");
				deposit.setTransAccountTarget(accountNum);
				if("1".equals("1"))
				{
					Saving account = new Saving();
					double balance = account.getAvailableBal();
					deposit.setTransAccountType("Saving");
					account.setAvailableBal(balance + amount);
					System.out.println("It may have worked");
					
				}
				transDao.insertAbc(deposit);
				
			} 
			
			catch (DAOExcepcion e) 
			{	
				System.out.println(e.getMessage());
			}
			return obj.toString();
		}
	
	//Show all transactions
	
	@GET
	@Path("Saving/{AccountNumber}")
	@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
	public String searchByAccountNum( @PathParam("AccountNumber") String accountNum ) {

		System.out.println("Dentro de buscarPorNombre() : accountNum: " + accountNum);
		JSONArray arrayObj = new JSONArray();
		
		try {
			SavingDAO dao = new SavingDAO();
			Collection<Transaction> transactions =  dao.searchByAccountNum(accountNum);
			System.out.println(transactions.size());
			arrayObj.addAll(transactions);
			
		} catch (DAOExcepcion e) {	
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
