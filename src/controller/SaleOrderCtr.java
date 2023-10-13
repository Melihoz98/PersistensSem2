
package controller;


import model.Customer;
import model.SaleOrder;
import model.Product;
import model.OrderLine;

import db.SaleOrderDB;


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
    CustomerCtr cc = getCustomerCtr();
    
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
	public boolean confirm() throws DataAccessException {
	    if (order != null && order.getCustomer() != null) {
	        SaleOrder o = order;
	        order = null;
	        return SaleOrderDB.saveOrder(o);
	    } else {
	        System.err.println("Cannot confirm and save the order. Customer information is missing.");
	        return false; 
	    }
	}


	public CustomerCtr getCustomerCtr() {
		return customerCtr;
	}


	public void setCustomerCtr(CustomerCtr customerCtr) {
		this.customerCtr = customerCtr;
	}


	public void associateCustomer(Customer newCustomer) {
	    if (order != null) {
	        order.addCustomer(newCustomer);
	    } else {
	        System.err.println("Cannot associate a customer. SaleOrder is missing.");
	    }
	}
		
	}

