package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

import com.merico.selenium.test.ee.utils.Utilities;

public class LogoutControls {
	private static Properties props = null;
	static{
		try {
			props = new Properties();
			InputStream in = LogoutControls.class.getClassLoader().getResourceAsStream("logout-control.properties");
			props.load(in);
		} catch (Exception e) {
			throw new RuntimeException("Failed to initiate the configuration file", e);
		}
	}
	
	/**
	 * Get configuration value
	 * 
	 * @param propertyName
	 * @return string
	 */
	private static String getProperty(String propertyName){
		return props.getProperty(propertyName);
	}
	
	private LogoutControls() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * User Account
	 */
	public static final String User_Account_Css = getProperty("user_account_css");
	
	/**
	 * 退出
	 */
	public static final String Logout_Xpath = Utilities.utf8Char(getProperty("logout_xpath"));
}
