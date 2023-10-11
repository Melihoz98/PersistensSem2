package model;

public class SaleOrder {
	
	private int ID;
	private boolean deliveryStatus;
	private int deliveryDate;
	private int customerID;

	public SaleOrder (int ID, boolean deliveryStatus, int deliveryDate, int customerID) {
		this.ID = ID;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.customerID = customerID;
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
	
}
