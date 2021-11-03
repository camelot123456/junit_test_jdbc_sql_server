package com.junittest.utils;

import java.util.ResourceBundle;

public class ResourceBundleUtil{

	public String baseName;
	public ResourceBundle bundle;
	
	public ResourceBundleUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public ResourceBundleUtil(String baseName) {
		this.baseName = baseName;
		bundle = ResourceBundle.getBundle(baseName);
	}
	
	public String getValue(String key) {
		return bundle.getString(key);
	}
	
}
