package com.merico.selenium.test.ee.control;

import java.io.InputStream;
import java.util.Properties;

public class LoginControls {
	private static Properties props = null;
	static{
		try {
			props = new Properties();
			InputStream in = LoginControls.class.getClassLoader().getResourceAsStream("login-control.properties");
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
	
	private LoginControls() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Username Textbox
	 */
	public static final String Username_Textbox_Name = getProperty("username_textbox_name");
	
	/**
	 * Password Textbox
	 */
	public static final String Password_Textbox_Name = getProperty("password_textbox_name");
	
	/**
	 * Login Button
	 */
	public static final String Login_Button_Xpath = getProperty("login_button_xpath");
	
	/**
	 * Account Name
	 */
	public static final String Account_Name_Css = getProperty("account_name_css");
	
	/**
	 * Login Button for LDAP
	 */
	public static final String Login_Button_4_Ldap_Css = getProperty("login_button_4_ldap_css");
	
	/**
	 * Language Switch Button
	 */
	public static final String Language_Switch_Button_Css = getProperty("language_switch_button_css");
}
