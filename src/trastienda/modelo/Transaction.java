package trastienda.modelo;

// import java.util.ArrayList;
import java.util.*;

import trastienda.modelo.Account;

public class Transaction 
{
	private int transId;
	private String transType;
	private String transDateTime;	
	private Double transAmount;
	private String transDescription;
	private String transStatus;
	private int transAccountTarget;
	private String transAccountType;
	private Account account;
	
	public Transaction() 
	{

	}

	public Transaction(int transId, String transType, String transDateTime, Double transAmount, String transDescription, String transStatus, int transAccountTarget, String transAccountType, Account account) 
	{
		super();
		this.transId = transId;
		this.transType = transType;
		this.transDateTime = transDateTime;
		this.transAmount = transAmount;
		this.transDescription = transDescription;
		this.transStatus = transStatus;
		this.transAccountTarget = transAccountTarget;
		this.transAccountType = transAccountType;
		this.account = account;
	}

	public int getTransId() 
	{
		return transId;
	}

	public void setTransId(int transId) 
	{
		this.transId = transId;
	}
	
	public String getTransType() 
	{
		return transType;
	}

	public void setTransType(String transType) 
	{
		this.transType = transType;
	}
	
	public String getTransDateTime() 
	{
		return transDateTime;
	}

	public void setTransDateTime(String transDateTime) 
	{
		this.transDateTime = transDateTime;
	}
	
	public Double getTransAmount() 
	{
		return transAmount;
	}

	public void setTransAmount(Double transAmount) 
	{
		this.transAmount = transAmount;
	}
	
	public String getTransDescription() 
	{
		return transDescription;
	}

	public void setTransDescription(String transDescription) 
	{
		this.transDescription = transDescription;
	}
	
	public String getTransStatus() 
	{
		return transStatus;
	}

	public void setTransStatus(String transStatus) 
	{
		this.transStatus = transStatus;
	}
	
	public int getTransAccountTarget() 
	{
		return transAccountTarget;
	}

	public void setTransAccountTarget(int transAccountTarget) 
	{
		this.transAccountTarget = transAccountTarget;
	}
	
	public String getTransAccountType() 
	{
		return transAccountType;
	}

	public void setTransAccountType(String transAccountType) 
	{
		this.transAccountType = transAccountType;
	}
	
	public void setAccount(Account account) 
	{
		this.account = account;
	}

	public Account getAccount() 
	{
		return account;
	}

}
