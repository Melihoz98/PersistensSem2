package db;

import java.util.List;

import controller.DataAccessException;
import model.Customer;

public interface CustomerDBIF {

	List<Customer> findCustomerByCustomerID(int customerID, boolean fullAssociation) throws DataAccessException;
//	Customer findBySSN(String ssn, boolean fullAssociation) throws DataAccessException;
	List<Customer> findAllCustomers(boolean fullAssociation) throws DataAccessException;
//	Employee insert(Employee employee) throws DataAccessException;
//	
	
	
	
	
	
	
}
