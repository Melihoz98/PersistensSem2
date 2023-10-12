
package controller;


import model.Customer;
import model.SaleOrder;
import model.Product;
import model.OrderLine;

import db.SaleOrderDB;

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
    CustomerCtr cc = new CustomerCtr();
    
    try {
        Customer customer = (Customer) cc.findCustomerByCustomerID(customerID);

        order.addCustomer(customer);

        return order.calculateTotal();
    } catch (DataAccessException e) {
        throw e;
    }
    
    }

	public OrderLine addProduct(int productID, int quantity) throws DataAccessException {
		ProductCtr pc = new ProductCtr();
		Product p = pc.findProductByProductID(productID);
		OrderLine ol = order.addProduct(p,quantity);
		return ol;

}
	public boolean confirm() throws DataAccessException{
		SaleOrder o = order;
		order = null;
		return SaleOrderDB.saveOrder(o);
	}


	public CustomerCtr getCustomerCtr() {
		return customerCtr;
	}


	public void setCustomerCtr(CustomerCtr customerCtr) {
		this.customerCtr = customerCtr;
	}
}
