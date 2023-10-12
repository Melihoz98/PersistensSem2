
package db;

import java.util.List;
import model.Product;
import controller.DataAccessException;

public interface ProductDBIF {
    List<Product> findAllProducts(boolean fullAssociation) throws DataAccessException;
    Product findProductByProductID(int productID, boolean fullAssociation) throws DataAccessException;
//    void insertProduct(Product product) throws DataAccessException;
  
}


