package com.junittest.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.junittest.model.ProductModel;
import com.junittest.service.impl.ProductService;

public class IProductServiceTest {
	
	private static IProductService productService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		productService = new ProductService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() throws SQLException {
		List<ProductModel> list = productService.findAll();
		assertEquals(2, list.size());
//		assertNotNull(list);
	}

	@Test
	public void testSave() throws SQLException {
		ProductModel model1 = ProductModel.builder()
				.id("C4")
				.name("IPHONE")
				.quantity(12)
				.price(3201220.0)
				.build();
		int k = productService.save(model1);
		assertTrue(k == -1);
	}

	@Test
	public void testUpdate() throws SQLException {
		ProductModel model1 = ProductModel.builder()
				.id("C4")
				.name("IPHONE")
				.quantity(12)
				.price(9999990.0)
				.build();
		int k = productService.update(model1);
		assertTrue(k == 1);
	}

	@Test
	public void testDelete() throws SQLException {
		String id = "C4";
		int k = productService.deleteById(id);
		assertTrue(k == 1);
	}

	@Test
	public void testFindById() throws SQLException {
		String id = "C3";
		ProductModel productModel = ProductModel.builder().name("IPHONE").build();
		assertEquals(productModel.getName(), productService.findById(id).getName());
	}

}
