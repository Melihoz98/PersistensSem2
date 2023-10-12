package model;

public class Product {

    private int productID;
    private String productName;
    private String productDescription;
    private double salePrice;
    private double rentPrice;
    private String productType;
    private String countryOfOrigin;
    private int minStock;
    private int supplierID;
    private String type;
    private double purchasePrice;

    
    public Product() {
    	
    }
    
    
    public Product(int productID, String productName, String productDescription, 
    		double salePrice, double rentPrice, String productType, String countryOfOrigin, 
    		int minStock, int supplierID, String type, double purchasePrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.salePrice = salePrice;
        this.rentPrice = rentPrice;
        this.productType = productType;
        this.countryOfOrigin = countryOfOrigin;
        this.minStock = minStock;
        this.supplierID = supplierID;
        this.type = type;
        this.purchasePrice = purchasePrice;
        }
        
        public int getProductID() {
        return productID;
        }
        
        public void setProductID(int productID) {
        this.productID = productID;
        }
        
        public String getProductName() {
        return productName;
        }
        
        public void setProductName(String productName) {
        this.productName = productName;
        }
        
        public String getProductDescription() {
        return productDescription;
        }
        
        public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
        }
        
        public double getSalePrice() {
        return salePrice;
        }
        
        public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
        }
        
        public double getRentPrice() {
        	return rentPrice;
        }
        
        public void setRentPrice(double rentPrice) {
        	this.rentPrice = rentPrice;
        }
        
        public String getProductType() {
        return productType;
        }
        
        public void setProductType(String productType) {
        this.productType = productType;
        }
        
        public String getCountryOfOrigin() {
        return countryOfOrigin;
        }
        
        public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        }
        
        public double getPurchasePrice() {
        return purchasePrice;
        }
        
        public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
        }


		public int getMinStock() {
			return minStock;
		}


		public void setMinStock(int minStock) {
			this.minStock = minStock;
		}


		public int getSupplierID() {
			return supplierID;
		}


		public void setSupplierID(int supplierID) {
			this.supplierID = supplierID;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}
        

        
        
}
