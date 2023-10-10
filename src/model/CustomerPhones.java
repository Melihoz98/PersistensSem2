package model;

public class CustomerPhones extends Phones {

    private String phoneID;
    private String customerID;

    public CustomerPhones(String phoneID, String customerID, String phoneNumber, String phoneType) {
        this.phoneID = phoneID;
        this.customerID = customerID;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
