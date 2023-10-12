
package controller;


import model.Customer;
import model.Product;
import model.SaleOrder;
import model.OrderLine;

import java.util.List;

import ctr.ProductCtr;
import db.DataAccessException;

/**
 * This class will handle all the communication between the SaleUI and itself,
 * while also being the class that communicates to the other controller classes.
 * 
 */
public class SaleOrderCtr {
	
	private CustomerCtr customerCtr;
	private ProductCtr productCtr;
	private SaleOrder order;
	
public SaleOrderCtr() {
	
}
	
	
public SaleOrder createSaleOrder() {
	order = new SaleOrder();
	return order;
}
	

public double findCustomerByCustomerID(int customerID) throws DataAccessException {
    // Assuming you have a CustomerController (cc) that can retrieve a customer by ID
    CustomerCtr cc = new CustomerCtr();
    
    try {
        // Find the customer by their ID
        Customer customer = (Customer) cc.findCustomerByCustomerID(customerID);

        // Assuming you have an "order" object to add the customer to
        // You should have an "order" object available or create one
        order.addCustomer(customer);

        // Assuming you have a method in your "order" object to calculate the total
        return order.calculateTotal();
    } catch (DataAccessException e) {
        // Handle the exception or rethrow it
        throw e;
    }








	
}
