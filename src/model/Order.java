package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderNumber;
    private LocalDate date;
    private LocalDate deliveryDate;
    private boolean deliveryStatus;
    private List<OrderLine> products;
    private Customer c;

    public Order() {
        date = LocalDate.now();
        products = new ArrayList<>();
    }
    

    // Metode til at tilføjre et produkt til en ordre
    public OrderLine addProduct(Product p, int quantity) {
        OrderLine res = null; 
        if (p != null && quantity > 0) {
            res = checkDuplicateItems(p, quantity); //Vi tjekker om produktet allerede er i ordren
            if (res == null) {
                res = new OrderLine(quantity, this.orderNumber, p.getProductID(), p.getProductPrice(), p);
                products.add(res);
            }
        }
        return res;
    }

    // Privat metode til at tjekke om produktet allerede er i ordren
    private OrderLine checkDuplicateItems(Product p, int quantity) {
        OrderLine res = null; // Initialize the result as null
        for (OrderLine orderLine : products) {
            if (orderLine.getProduct().getProductID() == p.getProductID()) {
                // Hvis produktet allerede er tilføjet til ordren, opdaterer vi quantity
                res = orderLine;
                res.setQuantity(res.getQuantity() + quantity);
            }
        }
        return res;
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public boolean getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public List<OrderLine> getProducts() {
        return products;
    }

    public void setProducts(List<OrderLine> products) {
        this.products = products;
    }

    public void addCustomer(Customer c) {
        this.c = c;
    }

    public Customer getCustomer() {
        return c;
    }

    public double calculateTotal() {
        double res = 0;
        for (OrderLine orderLine : products) {
            double price = orderLine.getUnitPrice();
            int quantity = orderLine.getQuantity();
            res += price * quantity;
        }
        return res;
    }
}

