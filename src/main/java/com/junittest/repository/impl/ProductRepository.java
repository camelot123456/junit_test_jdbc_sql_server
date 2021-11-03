package com.junittest.repository.impl;

import java.sql.SQLException;
import java.util.List;

import com.junittest.mapper.impl.ProductMapper;
import com.junittest.model.ProductModel;
import com.junittest.repository.IProductRepository;
import com.junittest.utils.impl.JdbcUtil;

public class ProductRepository extends JdbcUtil<ProductModel> implements IProductRepository{

	public List<ProductModel> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from PRODUCTS";
		ProductMapper mapper = new ProductMapper();
		List<ProductModel> lists = queryForList(sql, mapper);
		return lists;
	}

	@Override
	public int save(ProductModel productModel) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into PRODUCTS(id, name, quantity, price) values(?, ?, ?, ?)";
		Object[] params = new Object[] {
				productModel.getId(), 
				productModel.getName(), 
				productModel.getQuantity(), 
				productModel.getPrice()
		};
		return excuteUpdate(sql, params);
	}

	@Override
	public int update(ProductModel productModel) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update PRODUCTS set name = ?, quantity = ?, price = ? where id = ?";
		Object[] params = new Object[] {
				productModel.getName(), 
				productModel.getQuantity(), 
				productModel.getPrice(),
				productModel.getId() 
		};
		return excuteUpdate(sql, params);
	}

	@Override
	public int deleteById(String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from PRODUCTS where id = ?";
		Object[] params = new Object[] {id};
		return excuteUpdate(sql, params);
	}

	@Override
	public ProductModel findOneById(String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from PRODUCTS where id = ?";
		Object[] params = new Object[] {id};
		return queryForObject(sql, new ProductMapper(), params);
	}

	
	
}
