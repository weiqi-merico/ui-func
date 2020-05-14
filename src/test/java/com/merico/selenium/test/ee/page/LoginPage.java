package com.merico.selenium.test.ee.page;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.merico.selenium.autoscreenshot.AutoIntercept;
import com.merico.selenium.page.Page;
import com.merico.selenium.test.ee.control.LoginControls;
import com.merico.selenium.test.ee.utils.Utilities;

public class LoginPage extends Page {
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isLoaded() {
		// No Ajax content, which can be considered to create the Page object has finished loading.
		return true;
	}
	
	@AutoIntercept
	public void inputUsernameAndPwd(String username, String password) {
		Utilities.staticTimeDelay(1000);
		Utilities.waitForControlPresent(driver, By.name(LoginControls.Username_Textbox_Name));
		driver.findElement(By.name(LoginControls.Username_Textbox_Name)).clear();
		driver.findElement(By.name(LoginControls.Username_Textbox_Name)).sendKeys(username);
		driver.findElement(By.name(LoginControls.Password_Textbox_Name)).clear();
		driver.findElement(By.name(LoginControls.Password_Textbox_Name)).sendKeys(password);
	}
	
	@AutoIntercept
	public void login4Admin() {
		this.languageSwitch();
		Utilities.waitForControlPresent(driver, By.cssSelector(LoginControls.Login_Button_Css));
		driver.findElement(By.cssSelector(LoginControls.Login_Button_Css)).click();
		Utilities.staticTimeDelay(12000);
	}
	
	public String getAccountName() {
		Utilities.waitForControlPresent(driver, By.cssSelector(LoginControls.Account_Name_Css));
		String accountName = driver.findElement(By.cssSelector(LoginControls.Account_Name_Css)).getText().trim();
		
		return accountName;
	}
	
	@AutoIntercept
	public void login4Ldap() {
//		this.languageSwitch();
		Utilities.waitForControlPresent(driver, By.cssSelector(LoginControls.Login_Button_4_Ldap_Css));
		driver.findElement(By.cssSelector(LoginControls.Login_Button_4_Ldap_Css)).click();
		Utilities.staticTimeDelay(12000);
	}
	
	private void languageSwitch() {
		Locale locale = Locale.getDefault();
		if (locale.getLanguage() == "en") {
			Utilities.waitForControlPresent(driver, By.cssSelector(LoginControls.Language_Switch_Button_Css));
			driver.findElement(By.cssSelector(LoginControls.Language_Switch_Button_Css)).click();
		}
	}
}
