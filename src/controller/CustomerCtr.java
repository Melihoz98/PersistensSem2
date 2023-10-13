package controller;

import java.util.List;

import controller.DataAccessException;

import db.CustomerDB;
import db.CustomerDBIF;
import model.Customer;


public class CustomerCtr {

	private CustomerDBIF cusDB;
	
	
	
	public CustomerCtr() throws DataAccessException {
		cusDB = new CustomerDB();
		
	}

	public Customer findCustomerByCustomerID(int customerID) throws DataAccessException {
		Customer res = cusDB.findCustomerByCustomerID(customerID, true);
		return res;
	}

	public List<Customer> findAllCustomers() throws DataAccessException {
		List<Customer> res = cusDB.findAllCustomers(false);
		return res;
	}
	
	
	public Customer createCustomer(int customerID, String lastName, String firstName,  String streetName, String houseNo,  String zipCode, String phoneNo, String customerType, String clubType, String clubName) throws DataAccessException {
	    Customer newCustomer = new Customer(0, lastName, firstName, streetName, houseNo, zipCode,  phoneNo, customerType, clubType, clubName);
	    // Insert the new customer into the database
	    Customer insertedCustomer = cusDB.insert(newCustomer);
	    return insertedCustomer;
	}

	
	
}
