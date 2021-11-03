package com.junittest.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IMapper<T> {

	public T ObjectMapper(ResultSet resultSet) throws SQLException;
	
}
