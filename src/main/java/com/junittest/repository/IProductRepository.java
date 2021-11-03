package com.junittest.repository;

import java.sql.SQLException;
import java.util.List;

import com.junittest.model.ProductModel;

public interface IProductRepository {

	public List<ProductModel> findAll() throws SQLException;
	
	public int save(ProductModel productModel) throws SQLException;
	
	public int update(ProductModel productModel) throws SQLException;
	
	public int deleteById(String id) throws SQLException;
	
	public ProductModel findOneById(String id) throws SQLException;
	
	public List<ProductModel> search(String keyword) throws SQLException;
	
}
