package com.junittest.utils.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.junittest.mapper.IMapper;
import com.junittest.utils.IJdbcUtil;
import com.junittest.utils.ResourceBundleUtil;

public class JdbcUtil<T> implements IJdbcUtil<T>{

	public final String BASE_NAME = "application";

	public Connection getConnection() {
		Connection connection = null;
		try {
			ResourceBundleUtil bundleUtil = new ResourceBundleUtil(BASE_NAME);
			Class.forName(bundleUtil.getValue("driver"));
			connection = DriverManager.getConnection(
					bundleUtil.getValue("url"), 
					bundleUtil.getValue("username"),
					bundleUtil.getValue("password"));
			System.out.println("Connect Successfully");
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Connect Falure!!");
		}
		return null;
	}
	
	public void setParameter(PreparedStatement statement, Object... objects) throws NumberFormatException, SQLException {
		for (int i = 0; i < objects.length; i++) {
			int index = i + 1;
			Object object = objects[i];
			if (object instanceof Integer) {
				statement.setInt(index, (int) object);
			} else if (object instanceof Double) {
				statement.setDouble(index, (double) object);
			} else if (object instanceof String) {
				statement.setString(index, (String) object);
			}
		}
	}
	
	public void closeAllStream(Object... objects) throws SQLException {
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] instanceof Connection && objects[i] != null) {
				Connection connection = (Connection) objects[i];
				connection.close();
			}
			else if (objects[i] instanceof PreparedStatement && objects[i] != null) {
				PreparedStatement statement = (PreparedStatement) objects[i];
				statement.close();
			}
			else if (objects[i] instanceof ResultSet && objects[i] != null) {
				ResultSet resultSet = (ResultSet) objects[i];
				resultSet.close();
			}
		}
	}

	public List<T> queryForList(String sql, IMapper<T> mapper) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<T> lists = new ArrayList<T>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			T model = null;
			while (resultSet.next()) {
				model = mapper.ObjectMapper(resultSet);
				lists.add(model);
			}
			return lists;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Truy van that bai!!");
		} finally {
			closeAllStream(resultSet, statement, connection);
		}
		return null;
	}



	@Override
	public int excuteUpdate(String sql, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, params);
			Integer res = statement.executeUpdate();
			connection.commit();
			return res;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Truy van that bai!!");
			connection.rollback();
		} finally {
			closeAllStream(connection, statement);
		}
		return -1;
	}

	@Override
	public T queryForObject(String sql, IMapper<T> mapper, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, params);
			resultSet = statement.executeQuery();
			T model = null;
			while (resultSet.next()) {
				model = mapper.ObjectMapper(resultSet);
			}
			return model;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Truy van that bai!!");
		} finally {
			closeAllStream(resultSet, statement, connection);
		}
		return null;
	}

	@Override
	public List<T> queryForList(String sql, IMapper<T> mapper, Object... params) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<T> lists = new ArrayList<T>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			setParameter(statement, params);
			T model = null;
			while (resultSet.next()) {
				model = mapper.ObjectMapper(resultSet);
				lists.add(model);
			}
			return lists;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Truy van that bai!!");
		} finally {
			closeAllStream(resultSet, statement, connection);
		}
		return null;
	}
	
}
