package com.junittest.service;

import java.sql.SQLException;
import java.util.List;

import com.junittest.model.ProductModel;

public interface IProductService {

	public List<ProductModel> findAll() throws SQLException;
	
	public int save(ProductModel productModel) throws SQLException;
	
	public int update(ProductModel productModel) throws SQLException;
	
	public int deleteById(String id) throws SQLException;
	
	public ProductModel findById(String id) throws SQLException;
	
	public List<ProductModel> search(String keyword) throws SQLException;
	
}
