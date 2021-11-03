package com.junittest.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ResourceBundleUtilTest {

	public static final String BASE_NAME = "application";
	public ResourceBundleUtil bundleUtil;
	
	@Before
	public void testResourceBundleUtilString() {
		bundleUtil = new ResourceBundleUtil(BASE_NAME);
	}

	@Test
	public void testGetBundle() {
		assertEquals("Failure!!!","sa", bundleUtil.getValue("username"));
	}

}
