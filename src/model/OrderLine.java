package model;

public class OrderLine {
	private int quantity;
	private int saleOrderID;
	private int productID;
	private double unitPrice;



	public OrderLine(int quantity, int saleOrderID, int productID, double unitprice) {

		this.quantity = quantity;
		this.saleOrderID = saleOrderID;
		this.productID = productID;
		this.unitPrice = unitPrice;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getSaleOrderID() {
		return saleOrderID;
	}



	public void setSaleOrderID(int saleOrderID) {
		this.saleOrderID = saleOrderID;
	}



	public int getProductID() {
		return productID;
	}



	public void setProductID(int productID) {
		this.productID = productID;
	}



	public double getUnitPrice() {
		return unitPrice;
	}



	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


}