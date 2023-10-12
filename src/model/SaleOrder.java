package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder {
	
	private int ID;
	private boolean deliveryStatus;
	private int deliveryDate;
	private int customerID;
	private List <OrderLine>products;
	private LocalDate date;
    private Customer c;
    
    
    public SaleOrder() {
    	
    }

	public SaleOrder (int ID, boolean deliveryStatus, int deliveryDate, int customerID) {
		this.ID = ID;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customerID = customerID;
		products = new ArrayList<>();
		setDate(LocalDate.now());
	}
	
	
	
	 // Metode til at tilføjre et produkt til en ordre
    public OrderLine addProduct(Product p, int quantity) {
        OrderLine res = null; 
        if (p != null && quantity > 0) {
            res = checkDuplicateItems(p, quantity); //Vi tjekker om produktet allerede er i ordren
            if (res == null) {
                res = new OrderLine(quantity, this.ID, p.getProductID(), p.getSalePrice(), p);
                products.add(res);
            }
        }
        return res;
    }
    
    
    
    // Privat metode til at tjekke om produktet allerede er i ordren
    private OrderLine checkDuplicateItems(Product p, int quantity) {
        OrderLine res = null; // Initialize the result as null
        for (OrderLine orderLine : products) {
            if (orderLine.getProduct().getProductID() == p.getProductID()) {
                // Hvis produktet allerede er tilføjet til ordren, opdaterer vi quantity
                res = orderLine;
                res.setQuantity(res.getQuantity() + quantity);
            }
        }
        return res;
    }




	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	
	public boolean getDeliveryStatus() {
		return deliveryStatus;
	}
	
	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	
	public int getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(int deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	
	public List<OrderLine> getProducts() {
	    return products;
	}
	
	public void setProducts(List<OrderLine> products) {
        this.products = products;
    }
	
	public void addCustomer(Customer c) {
        this.c = c;
    }

    public Customer getCustomer() {
        return c;
    }

    public double calculateTotal() {
        double res = 0;
        for (OrderLine orderLine : products) {
            double price = orderLine.getUnitPrice();
            int quantity = orderLine.getQuantity();
            res += price * quantity;
        }
        return res;
    }

	public OrderLine[] getOrderLines() {
		return null;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
	
}
