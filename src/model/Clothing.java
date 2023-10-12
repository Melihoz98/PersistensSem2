package model;

public class Clothing extends Product{

	private String size;
	private String colour;
	
	public Clothing(int productID, String productName, String productDescription, 
			double salePrice, double rentPrice, String productType, String countryOfOrigin, 
			int minStock, int supplierID, String type, double purchasePrice, String size, String colour) {
		super(productID, productName, productDescription, salePrice, rentPrice,productType, 
				countryOfOrigin, minStock, supplierID, type, purchasePrice);
		this.size  = size;
		this.colour = colour;
		
	}

	
    // Getter-metode for size
    public String getSize() {
        return size;
    }

    // Setter-metode for size
    public void setSize(String size) {
        this.size = size;
    }

    // Getter-metode for colour
    public String getColour() {
        return colour;
    }

    // Setter-metode for colour
    public void setColour(String colour) {
        this.colour = colour;
    }
	
}
