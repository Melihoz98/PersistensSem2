package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;
import model.Product;
import controller.DataAccessException;

public class ProductDB implements ProductDBIF {
    // Define SQL queries and prepared statements

	
	private static final String FIND_ALL_PRODUCTS_Q = "select Name, PurchasePrice, SalePrice, RentPrice, CountryOfOrigin, MinStock, SupplierID, Type from Product";
	private PreparedStatement findAllProductsPS;
	
	
	private static final String FIND_PRODUCT_BY_PRODUCTID_Q = FIND_ALL_PRODUCTS_Q
			+ " where ProductID = ?";
	private PreparedStatement findProductByProductIDPS;
	
	
	private static final String INSERT_Q = "insert into Customer ( Name, PurchasePrice, SalePrice, RentPrice, CountryOfOrigin, MinStock, SupplierID, Type)values (?, ?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertPS;
	
	
	
	private void init() throws DataAccessException {
		DBConnection dbcon = DBConnection.getInstance();
		Connection con = dbcon.getDBcon();
		try {
			findAllProductsPS = con.prepareStatement(FIND_ALL_PRODUCTS_Q);
			findProductByProductID = con.prepareStatement(FIND_PRODUCT_BY_PRODUCTID_Q);
			insertPS = con.prepareStatement(INSERT_Q);
														
		} catch (SQLException e) {
			
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}
	
	
	
	
    // Implement the interface methods
   
    
    public Product findProductByProductID(int productID, boolean fullAssociation) throws DataAccessException {
    	Product res = null;
		try {
			findProductByProductIDPS.setInt(1, productID);
			ResultSet rs = findProductByProductIDPS.executeQuery();
			if (rs.next()) {
				res = buildProductObjects(rs, fullAssociation);
			}
		} catch (SQLException e) {
			
			throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e);
		}
		return res;
	}


    private Product buildProductObjects(ResultSet rs, boolean fullAssociation) {
		// TODO Auto-generated method stub
		return null;
	}



    public List<Product> findAllProducts(boolean fullAssociation) throws DataAccessException {
    	List<Product> res = null;
		try {
			rs = this.findAllProductsPS.executeQuery();
		} catch (SQLException e) {
			// e.printStackTsrace();
			throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
		}
		List<Product> res = buildObjects(rs, fullAssociation);
		return res;
	}
	
    
    
    

	@Override
    public Product findProductById(int productID, boolean fullAssociation) throws DataAccessException {
        // Implement the logic to retrieve a product by its ID from the database
    }

    @Override
    public void insertProduct(Product product) throws DataAccessException {
        // Implement the logic to insert a product into the database
    }

    @Override
    public void updateProduct(Product product) throws DataAccessException {
        // Implement the logic to update a product in the database
    }

    @Override
    public void deleteProduct(int productID) throws DataAccessException {
        // Implement the logic to delete a product from the database
    }
}
