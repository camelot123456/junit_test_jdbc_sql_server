package com.junittest.utils;

import java.sql.SQLException;
import java.util.List;

import com.junittest.mapper.IMapper;

public interface IJdbcUtil<T> {

	public List<T> queryForList(String sql, IMapper<T> mapper) throws SQLException;
	
	public int excuteUpdate(String sql, Object... params) throws SQLException;
	
	public T queryForObject(String sql, IMapper<T> mapper, Object... params) throws SQLException;
	
}
