package db;

import java.util.List;

import controller.DataAccessException;
import model.Customer;

public interface CustomerDBIF {

	List<Customer> findByCustomerID(String name, boolean fullAssociation) throws DataAccessException;
//	Customer findBySSN(String ssn, boolean fullAssociation) throws DataAccessException;
//	List<Employee> findAll(boolean fullAssociation) throws DataAccessException;
//	Employee insert(Employee employee) throws DataAccessException;
//	
	
	
	
	
	
	
}
