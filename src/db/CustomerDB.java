package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

import controller.DataAccessException;

public class CustomerDB implements CustomerDBIF{

	
	
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
			
			insertPS = con.prepareStatement(INSERT_Q);// using identity, we'd have to add
														// Statement.RETURN_GENERATED_KEYS as a second argument
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}
	
	
	public List<Customer> findCustomerByCustomerID(int customerID, boolean fullAssociation) throws DataAccessException {
	    List<Customer> result = null;
	    try {
	    	findCustomerByCustomerID.setInt(1, customerID);
	        ResultSet rs = findCustomerByCustomerID.executeQuery();
	        result = buildCustomerObjects(rs, fullAssociation);
	    } catch (SQLException e) {
	        // Handle the exception, you can throw a custom DataAccessException.
	        throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e);
	    }
	    return result;
	}


//	private List<Customer> buildCustomerObjects(ResultSet rs, boolean fullAssociation) {
//		List<Customer> foundCustomers = new ArrayList<Customer>();
//		String lName, fName, streetName, houseNo, zipCode, phones, customerType, clubType, clubName;
//		if(!fullAssociation ) {
//			//LastName, FirstName, StreetName, HouseNo, ZipCode, Phones, CustomerType, ClubType, ClubName
//			while(rs.next()){
//				lName = rs.getString("LastName");
//				fName = rs.getString("FirstName"); 
//				streetName = rs.getString("StreetName");
//				houseNo = rs.getString("HouseNo");
//				phones = rs.getString("Phones");
//				zipCode = rs.getString("ZipCode");
//				customerType = rs.getString("CustomerType");
//				customerType = rs.getString("ClubType");
//				clubName = rs.getString("ClubName");
//				
//				Customer customer = new Customer();
//				
//				// create a customer object
//				// put customer object in a list
//			}
//			
//		}
//		return foundCustomers;
//	}

	private List<Customer> buildCustomerObjects(ResultSet rs, boolean fullAssociation) throws SQLException {
	    List<Customer> foundCustomers = new ArrayList<Customer>();
	    
	    while (rs.next()) {
	        Customer customer = new Customer();
	        customer.setLastName(rs.getString("LastName"));
	        customer.setFirstName(rs.getString("FirstName"));
	        customer.setStreetName(rs.getString("StreetName"));
	        customer.setHouseNo(rs.getString("HouseNo"));
	        customer.setZipCode(rs.getString("ZipCode"));
	       // customer.setPhones(rs.getString("Phones"));
	        customer.setCustomerType(rs.getString("CustomerType"));
	        customer.setClubType(rs.getString("ClubType"));
	        customer.setClubName(rs.getString("ClubName"));
	        
	        foundCustomers.add(customer);
	    }
	    
	    return foundCustomers;
	}

	
	
	
	
	
//	public CustomerDB() throws DataAccessException {
//		departmentDB = new CustomerDB(this);
//		init();
//	
	}
	
}
