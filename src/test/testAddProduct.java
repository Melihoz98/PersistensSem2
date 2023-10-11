package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Equipment;
import model.Order;
import model.Product;

class testAddProduct {
	
	private Product p;
	private Order o;
	
	@BeforeEach
	void setUp() throws Exception {
		o = new Order();
		p = new Equipment(123, "Replica Revolver", "A replica of a Revolver", 14.99, "Equipment", "USA", 9.99, "Blank");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddProductShouldComplete() {
		o.addProduct(p, 3);
		assertEquals(o.getProducts().get(0).getProduct(),p);
	}
	
	@Test
	void testAddNullProductShouldFail() {
		o.addProduct(null, 3);
		assertEquals(o.getProducts().size(),0);
	}
	
	@Test
	void testAddProductAlreadyInTheOrderShouldComplete() {
		o.addProduct(p, 3);
		o.addProduct(p, 2);
		assertEquals(o.getProducts().get(0).getQuantity(),5);
	}
	@Test
	void testAddProductZeroQuantityShouldFail() {
		o.addProduct(p, 0);
		assertEquals(o.getProducts().size(),0);
	}

}
