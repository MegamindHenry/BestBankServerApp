package trastienda.modelo;


public class Checking extends Account{

	private int AccountNumber;
	private double CurrentBal;
	private double MinimumBal;
	private double AvailableBal;
	private String Status;
	private double Interest;
	
	public Checking() {

	}

	public Checking(int AccountNumber, double CurrentBal, double MinimumBal, 
			double AvailableBal, String Status, double Interest) {
		super();
		this.AccountNumber = AccountNumber;
		this.CurrentBal = CurrentBal;
		this.MinimumBal = MinimumBal;
		this.AvailableBal = AvailableBal;
		this.Status = Status;
		this.Interest = Interest;
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int AccountNumber) {
		this.AccountNumber = AccountNumber;
	}

	public double getCurrentBal() {
		return CurrentBal;
	}

	public void setCurrentBal(double CurrentBal) {
		this.CurrentBal = CurrentBal;
	}

	public double getMinimumBal() {
		return MinimumBal;
	}

	public void setMinimumBal(double MinimumBal) {
		this.MinimumBal = MinimumBal;
	}

	public double getAvailableBal() {
		return AvailableBal;
	}

	public void setAvailableBal(double AvailableBal) {
		this.AvailableBal = AvailableBal;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public double getInterest() {
		return Interest;
	}

	public void setInterest(double Interest) {
		this.Interest = Interest;
	}
}
