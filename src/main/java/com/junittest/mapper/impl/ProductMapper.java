package com.junittest.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.junittest.mapper.IMapper;
import com.junittest.model.ProductModel;

public class ProductMapper implements IMapper<ProductModel> {

	public ProductModel ObjectMapper(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		ProductModel productModel = ProductModel.builder()
				.id(resultSet.getString("id"))
				.name(resultSet.getString("name"))
				.quantity(resultSet.getInt("quantity"))
				.price(resultSet.getDouble("price"))
				.build();
		return productModel;
		// TODO Auto-generated catch block
	}

}
