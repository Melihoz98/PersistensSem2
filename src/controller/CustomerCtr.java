package controller;

import java.util.List;

import controller.DataAccessException;

import db.CustomerDB;
import db.CustomerDBIF;
import model.Customer;

public class CustomerCtr implements CustomerDBIF{

	private CustomerDBIF cusDB;
	
	
	
	public CustomerCtr() throws DataAccessException {
		cusDB = new CustomerDB();
		
	}

	public List<Customer> findByCustomerID(int customerID) throws DataAccessException {
		List<Customer> res = cusDB.findByCustomerID(customerID, true);
		return res;
	}

	
	
	
}
