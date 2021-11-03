package com.junittest.utils;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.junittest.utils.impl.JdbcUtil;

public class JdbcUtilTest {

	@Test
	public void testGetConnection() {
		assertNotNull(new JdbcUtil<Object>().getConnection());
	}

}
