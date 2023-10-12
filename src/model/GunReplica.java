package model;

public class GunReplica extends Product{

	private double calibre;
	
	public GunReplica(int productID, String productName, String productDescription, 
			double salePrice, double rentPrice, String productType, String countryOfOrigin, 
			int minStock, int supplierID, String type, double purchasePrice, double calibre) {
		super(productID, productName, productDescription, salePrice, rentPrice,productType, 
				countryOfOrigin, minStock, supplierID, type, purchasePrice);
		this.calibre = calibre;
	}

	 // Getter-metode for calibre
    public double getCalibre() {
        return calibre;
    }

    // Setter-metode for calibre
    public void setCalibre(double calibre) {
        this.calibre = calibre;
    }
	
}
