package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Equipment;
import model.Product;
import model.SaleOrder;

class testAddProduct {
	
	private Product p;
	private SaleOrder so;
	
	@BeforeEach
	void setUp() throws Exception {
		so = new SaleOrder(0, false, 0, 0);
		p = new Equipment(123, "Cowboy hat", "A hat worn by cowboys", 14.99, 8.99, "Clothing", "USA", 5, 120, "Blank", 0, null);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddProductShouldComplete() {
		so.addProduct(p, 3);
		assertEquals(so.getProducts().get(0).getProduct(),p);
	}
	
	@Test
	void testAddNullProductShouldFail() {
		so.addProduct(null, 3);
		assertEquals(so.getProducts().size(),0);
	}
	
	@Test
	void testAddProductAlreadyInTheOrderShouldComplete() {
		so.addProduct(p, 3);
		so.addProduct(p, 2);
		assertEquals(so.getProducts().get(0).getQuantity(),5);
	}
	@Test
	void testAddProductZeroQuantityShouldFail() {
		so.addProduct(p, 0);
		assertEquals(so.getProducts().size(),0);
	}

}
