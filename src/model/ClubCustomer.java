package model;

public class ClubCustomer extends Customer{

	private String clubType;
	private String clubName;
	
	public ClubCustomer(int customerID, String lastName, String firstName, String streetName, String houseNo,
			String zipCode, String customerType, String clubType, String clubName) {
		super(customerID, lastName, firstName, streetName, houseNo, zipCode, customerType);
		this.clubType = clubType;
		this.clubName = clubName;
		// TODO Auto-generated constructor stub
	}

}
