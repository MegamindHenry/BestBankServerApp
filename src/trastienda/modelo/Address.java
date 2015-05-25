package trastienda.modelo;


public class Address {

	private int CustomerID;
	private String Street;
	private String City;
	private String Province;
	private String Zipcode;

	public Address() {

	}

	public Address(int CustomerID, String Street, String City, String Province, String Zipcode) {
		super();
		this.setCustomerID(CustomerID);
		this.Street = Street;
		this.City = City;
		this.Province = Province;
		this.Zipcode = Zipcode;
	}


	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

}
