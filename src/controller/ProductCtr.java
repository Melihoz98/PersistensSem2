package controller;

import controller.DataAccessException;
import db.ProductDBIF;
import model.Product;

public class ProductCtr {
	
	private ProductDBIF ProductDB;
	
	
	public ProductCtr() throws DataAccessException {
		ProductDB = new db.ProductDB();
	}
	//2.1
	public Product findProductByProductID(int productID) throws DataAccessException {
		return ProductDB.findProductByProductID(productID, false);
		
	}
}




	
	
	
	
	

