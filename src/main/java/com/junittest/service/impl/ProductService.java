package com.junittest.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.junittest.model.ProductModel;
import com.junittest.repository.IProductRepository;
import com.junittest.repository.impl.ProductRepository;
import com.junittest.service.IProductService;

public class ProductService implements IProductService{

	private IProductRepository productRepository = new ProductRepository();
	
	public List<ProductModel> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public int save(ProductModel productModel) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.save(productModel);
	}

	public int update(ProductModel productModel) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.update(productModel);
	}

	public int deleteById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.deleteById(id);
	}

	public ProductModel findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.findOneById(id);
	}
	
}
