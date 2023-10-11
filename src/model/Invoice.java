package model;

public class Invoice {

	private int invoiceNo;
	private String paymentDate;
	private double amount;
	private int saleOrderID;
	
	public Invoice(int invoiceNo, String paymentDate, double amount, int saleOrderID) {
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.saleOrderID = saleOrderID;
	
	}
	
	public int getInvoiceNo() {
		return invoiceNo;
	}
	
	public void setInvoiceNo(int invoice) {
		this.invoiceNo = invoice;
	}
	
	
	
	public String getPaymentDate(){
		return paymentDate;
	}
	
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	public int getSaleOrderID() {
		return saleOrderID;
	}
	
	public void setSaleOrderID(int saleOrderID) {
		this.saleOrderID = saleOrderID;
	}
	
	
}

