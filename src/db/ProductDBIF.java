package db;

import java.util.List;

import controller.DataAccessException;
import model.Product;

public interface ProductDBIF {
		public Product findByProductID(int productID) throws DataAccessException;

		public boolean saveProduct(Product p) throws DataAccessException;
		
		public List<Product> findAll ();


}
