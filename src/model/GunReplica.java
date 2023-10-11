package model;

public class GunReplica extends Product{

	private double calibre;
	
	public GunReplica(int productID, String productName, String productDescription, double productPrice,
			String productType, String countryOfOrigin, double purchasePrice, double calibre) {
		super(productID, productName, productDescription, productPrice, productType, countryOfOrigin, purchasePrice);
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
