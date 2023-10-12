package model;

public class Phones {

    private int phoneID;
    private String phone;
    private int customerID;
    private Customer customer;
    
    
    public Phones(int phoneID, String phone, int customerID) {
    	this.phoneID = phoneID;
    	this.phone = phone;
    	this.customerID = customer.getCustomerID();
    }

    
    public int getPhoneID() {
    	return phoneID;
    }

    public void setPhoneID(int phoneID) {
    	this.phoneID = phoneID;
    }
    
    
    public String getPhone() {
    	return phone;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
   
}
