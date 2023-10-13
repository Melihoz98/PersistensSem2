package model;

public class PrivateCustomer extends Customer {
    public PrivateCustomer(int customerID, String lastName, String firstName, String streetName, String houseNo, String zipCode, String phoneNo, String customerType) {
        super(customerID, lastName, firstName, streetName, houseNo, zipCode, phoneNo, customerType, null, null);
    }
}
