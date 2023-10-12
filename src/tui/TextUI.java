package tui;

import controller.CustomerCtr;
import controller.ProductCtr;
import controller.SaleOrderCtr;
import model.Customer;
import controller.DataAccessException;

import java.util.Scanner;

public class TextUI {

    private CustomerCtr customerController;
    private ProductCtr productController;
    private SaleOrderCtr saleOrderController;
    private Scanner scanner;

    public TextUI() {
        try {
            customerController = new CustomerCtr();
            productController = new ProductCtr();
            saleOrderController = new SaleOrderCtr();
            scanner = new Scanner(System.in);
        } catch (DataAccessException e) {
            System.err.println("Error initializing controllers: " + e.getMessage());
        }
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("========== Sale System Menu ==========");
            System.out.println("1. Create a new sale order");
            System.out.println("2. Add a product to the sale order");
            System.out.println("3. Create a new customer and associate with the sale order");
            System.out.println("4. Confirm and save the sale order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createSaleOrder();
                    break;
                case 2:
                    addProductToSaleOrder();
                    break;
                case 3:
                    createCustomerAndAssociate();
                    break;
                case 4:
                    confirmAndSaveSaleOrder();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the Sale System.");
    }

    private void createSaleOrder() {
        saleOrderController.createSaleOrder();
        System.out.println("New sale order created.");
    }

    private void addProductToSaleOrder() {
        System.out.print("Enter product ID: ");
        int productID = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        try {
            saleOrderController.addProduct(productID, quantity);
            System.out.println("Product added to the sale order.");
        } catch (DataAccessException e) {
            System.err.println("Error adding the product to the sale order: " + e.getMessage());
        }
    }

    private void createCustomerAndAssociate() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();
        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        try {
            Customer newCustomer = customerController.createCustomer(name, address, phone);
            if (newCustomer != null) {
                saleOrderController.associateCustomer(newCustomer);
                System.out.println("Customer created and associated with the sale order.");
            } else {
                System.err.println("Error creating the customer.");
            }
        } catch (DataAccessException e) {
            System.err.println("Error creating the customer: " + e.getMessage());
        }
    }

    private void confirmAndSaveSaleOrder() {
        try {
            boolean success = saleOrderController.confirm();
            if (success) {
                System.out.println("Sale order confirmed and saved.");
            } else {
                System.err.println("Error confirming and saving the sale order.");
            }
        } catch (DataAccessException e) {
            System.err.println("Error confirming and saving the sale order: " + e.getMessage());
        }
    }
}

