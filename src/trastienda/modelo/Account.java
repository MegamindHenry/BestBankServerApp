package trastienda.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Account {
	private int AccountNumber;
	private int CustomerID;
	private Date DateOpened;
	private Collection<Transaction> transactions = new ArrayList<Transaction>();

	public Account() {

	}


	public Account(int AccountNumber, int CustomerID, Date DateOpened){
		super();
		this.AccountNumber = AccountNumber;
		this.CustomerID = CustomerID;
		this.DateOpened = DateOpened;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int AccountNumber) {
		this.AccountNumber = AccountNumber;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}

	public Date getDateOpened() {
		return DateOpened;
	}

	public void setDateOpened(Date DateOpened) {
		this.DateOpened = DateOpened;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}
}
