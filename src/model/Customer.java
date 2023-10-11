
package model;

import java.util.List;

public class Customer {

    private int customerID;
    private String lastName;
    private String firstName;
    private String streetName;
    private String houseNo;
    private String zipCode;
    private String customerType;
    private String clubType;
    private String clubName;
    private List<Phones> phoneNo;

    
    public Customer() {
    	
    }

    public Customer(int customerID, String lastName, String firstName, String streetName, String houseNo, String zipCode, String customerType, String clubType, String clubName) {
        this.customerID = customerID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetName = streetName;
        this.houseNo = houseNo;
        this.zipCode = zipCode;
        this.customerType = customerType;
        this.clubType = clubType;
        this.clubName = clubName;
        
    }

    // Getter methods
    public int getCustomerID() {
        return customerID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCustomerType() {
        return customerType;
    }


    // Setter methods
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
    
    

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    
    
    public String getClubType() {
    	return clubType;
    }
    
    public void setClubType(String clubType) {
    	this.clubType = clubType;
    }
    
    
    public String getClubName() {
    	return clubName;
    }
    
    public void setClubName(String clubName) {
    	this.clubName = clubName;
    }
    
    
    public List<Phones> getPhoneNumbers() {
        return phoneNo;
    }
}
