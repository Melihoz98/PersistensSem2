package model;

public class Equipment extends Product{

	private String description;
	
	public Equipment(String productID, String productName, String productDescription, double productPrice,
			String productType, String countryOfOrigin, double purchasePrice, String description) {
		super(productID, productName, productDescription, productPrice, productType, countryOfOrigin, purchasePrice);
		this.description = description;
		
	}

	  // Getter-metode for description
    public String getDescription() {
        return description;
    }

    // Setter-metode for description
    public void setDescription(String description) {
        this.description = description;
    }

}
