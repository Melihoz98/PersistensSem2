package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
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
			findProductByProductIDPS = con.prepareStatement(FIND_PRODUCT_BY_PRODUCTID_Q);
			insertPS = con.prepareStatement(INSERT_Q);
														
		} catch (SQLException e) {
			
			throw new DataAccessException(DBMessages.COULD_NOT_PREPARE_STATEMENT, e);
		}
	}

	
	
	@Override
    public Product findProductByProductID(int productID, boolean fullAssociation) throws DataAccessException {
    	Product res = null;
		try {
			findProductByProductIDPS.setInt(1, productID);
			ResultSet rs = findProductByProductIDPS.executeQuery();
			if (rs.next()) {
				res = buildProductObject(rs, fullAssociation);
			}
		} catch (SQLException e) {
			
			throw new DataAccessException(DBMessages.COULD_NOT_BIND_OR_EXECUTE_QUERY, e);
		}
		return res;
	}


    private Product buildProductObject(ResultSet rs, boolean fullAssociation) throws DataAccessException {
        Product currProduct = new Product();
        try {
            currProduct.setProductID(rs.getInt("productID"));
            currProduct.setProductName(rs.getString("productName"));
            currProduct.setProductDescription(rs.getString("productDescription"));
            currProduct.setSalePrice(rs.getDouble("productPrice"));
            currProduct.setProductType(rs.getString("productType"));
            currProduct.setCountryOfOrigin(rs.getString("countryOfOrigin"));
            currProduct.setPurchasePrice(rs.getDouble("purchasePrice"));


            if (fullAssociation) {
                
            }
        } catch (SQLException e) {
            // Handle exceptions and throw DataAccessException if needed
            throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
        }
        return currProduct;
    }



    
    @Override
    public List<Product> findAllProducts(boolean fullAssociation) throws DataAccessException {
        ResultSet rs;
        try {
            rs = this.findAllProductsPS.executeQuery();
        } catch (SQLException e) {
            
            throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
        }
        List<Product> products = findAllProducts(fullAssociation);

        List<Product> res = buildProductObjects(rs, fullAssociation);
        return res;
    }

    
    private List<Product> buildProductObjects(ResultSet rs, boolean fullAssociation) throws DataAccessException {
        List<Product> products = new ArrayList<>();
        try {
            while (rs.next()) {
                Product product = buildProductObject(rs, fullAssociation);
                products.add(product);
            }
        } catch (SQLException e) {
            
            throw new DataAccessException(DBMessages.COULD_NOT_READ_RESULTSET, e);
        }
        return products;
    }


    public void addProduct(Product product) throws DataAccessException {
        // Define your SQL insert query for products
        String insertQuery = "INSERT INTO Product (Name, PurchasePrice, SalePrice, RentPrice, CountryOfOrigin, MinStock, SupplierID, Type) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
   
            insertPS.setString(1, product.getProductName());
            insertPS.setDouble(2, product.getPurchasePrice());
            insertPS.setDouble(3, product.getSalePrice());
            insertPS.setDouble(4, product.getRentPrice());
            insertPS.setString(5, product.getCountryOfOrigin());
            insertPS.setInt(6, product.getMinStock());
            insertPS.setInt(7, product.getSupplierID());
            insertPS.setString(8, product.getType());
           
            insertPS.executeUpdate();
        } catch (SQLException e) {
           
            throw new DataAccessException(DBMessages.COULD_NOT_INSERT, e);
        }
    
}

  



    
}
