package model;

public class Phones {

    private int phoneID;
    private String phone;
    
    
    public Phones(int phoneID, String phone) {
    	this.phoneID = phoneID;
    	this.phone = phone;
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
