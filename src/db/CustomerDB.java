package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

import controller.DataAccessException;

public class CustomerDB implements CustomerDBIF {
	
	public CustomerDB() throws DataAccessException {
	init();

	}
	
	private static final String FIND_ALL_CUSTOMERS_Q = "select LastName, FirstName, StreetName, HouseNo, ZipCode, Phones, CustomerType, ClubType, ClubName from Customer";
	private PreparedStatement findAllCustomersPS;
	
	
	private static final String FIND_CUSTOMER_BY_CUSTOMERID_Q = FIND_ALL_CUSTOMERS_Q
			+ " where CustomerID = ?";
	private PreparedStatement findCustomerByCustomerID;
	
	
	private static final String INSERT_Q = "insert into Customer (LastName, FirstName, StreetName, HouseNo, ZipCode, Phones, CustomerType, ClubType, ClubName)values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertPS;
	
	
	
	
	
	
	
	private void init() throws DataAccessException {
		DBConnection dbcon = DBConnection.getInstance();
		Connection con = dbcon.getDBcon();
		try {
			findAllCustomersPS = con.prepareStatement(FIND_ALL_CUSTOMERS_Q);
			findCustomerByCustomerID = con.prepareStatement(FIND_CUSTOMER_BY_CUSTOMERID_Q);
			insertPS = con.prepareStatement(INSERT_Q);
														
		} catch (SQLException e) {
			
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}
	
	
	public Customer findCustomerByCustomerID(int customerID, boolean fullAssociation) throws DataAccessException {
	    Customer result = null;
	    try {
	    	findCustomerByCustomerID.setInt(1, customerID);
	        ResultSet rs = findCustomerByCustomerID.executeQuery();
	        result = buildCustomerObjects(rs, fullAssociation);
	    } catch (SQLException e) {
	        
	        throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e);
	    }
	    return result;
	}

	
	
	

	public List<Customer> findAllCustomers(boolean fullAssociation) throws DataAccessException {
		ResultSet rs;
		try {
			rs = this.findAllCustomersPS.executeQuery();
		} catch (SQLException e) {
			throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
		}
		List<Customer> res = buildObjects(rs, fullAssociation);
		return res;
	}
	
	
	
	
	private List<Customer> buildObjects(ResultSet rs, boolean fullAssociation) throws DataAccessException {
	    List<Customer> res = new ArrayList<>();
	    try {
	        while (rs.next()) {
	            Customer currCustomer = buildObject(rs, fullAssociation);
	            res.add(currCustomer);
	        }
	    } catch (SQLException e) {
	        throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
	    }
	    return res;
	}



	private Customer buildCustomerObjects(ResultSet rs, boolean fullAssociation) throws SQLException {
	    Customer foundCustomers = new Customer();
	    
	    while (rs.next()) {
	        Customer customer = new Customer();
	        customer.setLastName(rs.getString("LastName"));
	        customer.setFirstName(rs.getString("FirstName"));
	        customer.setStreetName(rs.getString("StreetName"));
	        customer.setHouseNo(rs.getString("HouseNo"));
	        customer.setZipCode(rs.getString("ZipCode"));
	        customer.setCustomerType(rs.getString("CustomerType"));
	        customer.setClubType(rs.getString("ClubType"));
	        customer.setClubName(rs.getString("ClubName"));
	        
	        foundCustomers = customer;
	    }
	    
	    return foundCustomers;
	}

	
	private Customer buildObject(ResultSet rs, boolean fullAssociation) throws DataAccessException {
	    Customer currCustomer = new Customer();
	    try {
	        currCustomer.setCustomerID(rs.getInt("customerID")); 
	        currCustomer.setLastName(rs.getString("lastName"));
	        currCustomer.setFirstName(rs.getString("firstName"));
	        currCustomer.setStreetName(rs.getString("streetName"));
	        currCustomer.setHouseNo(rs.getString("houseNo"));
	        currCustomer.setZipCode(rs.getString("zipCode"));
	        currCustomer.setCustomerType(rs.getString("customerType"));
	        currCustomer.setClubType(rs.getString("clubType"));
	        currCustomer.setClubName(rs.getString("clubName"));
	    } catch (SQLException e) {
	        throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
	    }
	    return currCustomer;
	}

	
	
	public Customer insert(Customer customer) throws DataAccessException {
	    try {
	        insertPS.setString(1, customer.getLastName());
	        insertPS.setString(2, customer.getFirstName());
	        insertPS.setString(3, customer.getStreetName());
	        insertPS.setString(4, customer.getHouseNo());
	        insertPS.setString(5, customer.getZipCode());
	        insertPS.setString(6, customer.getCustomerType());
	        insertPS.setString(7, customer.getClubType());
	        insertPS.setString(8, customer.getClubName());
	        
	        insertPS.executeUpdate();
	    } catch (SQLException e) {
	        throw new DataAccessException(DBMessages.COULD_NOT_INSERT, e);
	    }

	    return customer;
	}

	
	
	
	
	}
	

