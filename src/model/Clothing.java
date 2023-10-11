package model;

public class Clothing extends Product{

	private String size;
	private String colour;
	
	public Clothing(String productID, String productName, String productDescription, double productPrice,
			String productType, String countryOfOrigin, double purchasePrice, String size, String colour) {
		super(productID, productName, productDescription, productPrice, productType, countryOfOrigin, purchasePrice);
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
