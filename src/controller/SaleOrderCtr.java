
package controller;


import model.Customer;
import model.Product;
import model.SaleOrder;
import model.OrderLine;

import java.util.List;

/**
 * This class will handle all the communication between the SaleUI and itself,
 * while also being the class that communicates to the other controller classes.
 * 
 */
public class SaleOrderCtr {
	
	private CustomerCtr customerCtr;
	private ProductCtr productCtr;
	

	/**
	 * Constructor for objects of class SaleCtr
	 */
	public SaleOrderCtr() {
		
		
		customerCtr = new CustomerCtr();
		productCtr = new ProductCtr();
	}

	
	

	/**
	 * Finds a customer by its customerID
	 */
	public Customer findCustomerByCustomerID(int customerID) {
		return (Customer) customerCtr.findCustomerByCustomerID(customerID);
	}

	/**
	 * Creates a sale
	 */
	public SaleOrder createSaleOrder(Customer customer) {
		SaleOrder saleOrder = new SaleOrder(customer);
		return saleOrder;
	}

	/**
	 * Pays for a sale
	 */
	public boolean pay(Sale sale, double payment) {
		boolean paid = false;
		double tempTotal = sale.getTotal();
		double total = tempTotal * (1 - (sale.getCustomer().getCustomerDiscount()));
		double paymentRecieved = payment;
		double missing = total - paymentRecieved;
		double change = paymentRecieved - total;
		if (total <= paymentRecieved) {

			System.out.println("Salg betalt. Restbeløb: " + change + "kr");
			paid = true;
			sale.isPaid();
		} else if (total > paymentRecieved) {
			System.out.println("Der mangler: " + missing);
		}
		return paid;
	}

	/**
	 * Confirms the sale and finishes the creation of it by adding it to the
	 * container
	 */
	public boolean finishSale(Sale sale) {
		boolean success = false;
		if (sale.isPaid()) {
			success = true;
			saleContainer.add(sale);
		} else {
			System.out.println("Fejl under salg. Kontroller følgende: Betaling modtaget.");
		}
		return success;
	}

	/**
	 * Finds a product by the barcode of the product
	 */
	public Product findProductByBarcode(String barcode) {
		return productController.findProductByBarcode(barcode);
	}

	/**
	 * Adds a sale object to the container class
	 */
	public void addSaleToContainer(Sale sale) {
		saleContainer.add(sale);
	}

	public void addSalesLine(Object item, SalesLine saleLine) {
		if (item instanceof Sale) {
			((Sale) item).addSalesLine(saleLine);
		} else if (item instanceof Proposition) {
			((Proposition) item).addSalesLine(saleLine);
		}
	}

	public Proposition createProposition(Employee employee) {
		Proposition proposition = new Proposition(employee);
		return proposition;
	}

	public void addPropositionToContainer(Proposition proposition) {
		propositionContainer.add(proposition);
	}

	public List<Proposition> getAllPropositions() {
		return propositionContainer.getAll();
	}

	public void removeProposition(Proposition proposition) {
		propositionContainer.remove(proposition);
	}

	public void setCustomer(Object item, Customer customer) {
		if (item instanceof Sale) {
			((Sale) item).setCustomer(customer);
		}
		if (item instanceof Proposition) {
			((Proposition) item).setCustomer(customer);
		}
	}
	
	public SalesLine createSalesLine(Product product, int quantity) {
		SalesLine salesLine = new SalesLine(product, quantity);		
		return salesLine;	
	}
	
	public void setDesiredPrice(Proposition proposition, double price) {
		proposition.setDesiredPrice(price);
	}
}
