package model;

public class Product {

    private String productID;
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productType;
    private String countryOfOrigin;
    private double purchasePrice;

    public Product(String productID, String productName, String productDescription, double productPrice, String productType, String countryOfOrigin, double purchasePrice) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productType = productType;
        this.countryOfOrigin = countryOfOrigin;
        this.purchasePrice = purchasePrice;
        }
        
        public String getProductID() {
        return productID;
        }
        
        public void setProductID(String productID) {
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
        
        public double getProductPrice() {
        return productPrice;
        }
        
        public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
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
        

}
