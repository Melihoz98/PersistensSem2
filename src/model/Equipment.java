package model;

public class Equipment extends Product{

	private String description;
	
	public Equipment(int productID, String productName, String productDescription, 
			double salePrice, double rentPrice, String productType, String countryOfOrigin, 
			int minStock, int supplierID, String type, double purchasePrice, String description) {
		super(productID, productName, productDescription, salePrice, rentPrice,productType, 
				countryOfOrigin, minStock, supplierID, type, purchasePrice);
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
