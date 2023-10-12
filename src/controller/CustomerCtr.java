package controller;

import java.util.List;

import controller.DataAccessException;

import db.CustomerDB;
import db.CustomerDBIF;
import model.Customer;
import model.Employee;

public class CustomerCtr {

	private CustomerDBIF cusDB;
	
	
	
	public CustomerCtr() throws DataAccessException {
		cusDB = new CustomerDB();
		
	}

	public List<Customer> findCustomerByCustomerID(int customerID) throws DataAccessException {
		List<Customer> res = cusDB.findCustomerByCustomerID(customerID, true);
		return res;
	}

	public List<Customer> findAllCustomers() throws DataAccessException {
		List<Customer> res = cusDB.findAllCustomers(false);
		return res;
	}
	
	
	public Customer insert(Customer customer) throws DataAccessException {
		Customer res = cusDB.insert(customer);
		return res;
	}
	
	
}
