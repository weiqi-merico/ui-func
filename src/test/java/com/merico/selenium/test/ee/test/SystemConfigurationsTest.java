package com.merico.selenium.test.ee.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.merico.selenium.page.PageUrlMapping;
import com.merico.selenium.page.factory.PageFactory;
import com.merico.selenium.page.support.DefaultUrlNavigator;
import com.merico.selenium.test.CasePriority;
import com.merico.selenium.test.TestBase;
import com.merico.selenium.test.ee.data.TestDataProvider;
import com.merico.selenium.test.ee.page.LoginPage;
import com.merico.selenium.test.ee.page.LogoutPage;
import com.merico.selenium.test.ee.page.SettingsPage;
import com.merico.selenium.test.ee.utils.Crypt;
import com.merico.selenium.test.ee.utils.Utilities;

public class SystemConfigurationsTest extends TestBase {
protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void initBeforeClass() {
		// TODO Auto-generated method stub
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup() {
		String targetUrl = PageUrlMapping.getAbsoluteUrl(LoginPage.class);
		new DefaultUrlNavigator().doNavigation(driver, targetUrl);
	}
	
	@AfterClass(alwaysRun = true)
	public void teardown() {
		LogoutPage logoutPage = PageFactory.createPage(LogoutPage.class, driver);
		logoutPage.logout();
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "loginData4AdminProvider", dataProviderClass = TestDataProvider.class, alwaysRun = true)
	public void testLogin4Admin(String username, String password, Crypt crypt) throws Exception {
		LoginPage loginPage = PageFactory.createPage(LoginPage.class, driver);
		loginPage.inputUsernameAndPwd(username, crypt.decrypt(password));
		loginPage.login4Admin();
		
		Assert.assertEquals(username, loginPage.getAccountName(), "Admin login failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLogin4Admin"}, alwaysRun = true)
	public void testBasicSettings() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.navigateToSettings();
		settingsPage.navigateToSystemConfigurations();
		settingsPage.basicSettings4SystemConfigurations();
		
		Assert.assertEquals(settingsPage.getBasicSettingsInfo4SystemIntegration(), "http://i.test.meri.co/", "Basic Settings Saving for System Configurations Failed!");
		Utilities.staticTimeDelay(3000);
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "smtpInfoProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testBasicSettings"}, alwaysRun = true)
	public void testSmtpSettings(String email, String password, String smtp) throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.smtpSettings4SystemConfigurations(email, password, smtp);
		
		Assert.assertEquals(settingsPage.getSmtpSettingsInfo4SystemIntegration(), email, "Smtp Settings Saving for System Configurations Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "oauthInfoProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testSmtpSettings"}, alwaysRun = true)
	public void testOauthSettings(String siteUrl, String appId, String appSecret) throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.oauthSettings4SystemConfigurations(siteUrl, appId, appSecret);
		
		Assert.assertEquals(settingsPage.getOauthSettingsInfo4SystemIntegration(), siteUrl, "Oauth Settings Saving for System Configurations Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testOauthSettings"}, alwaysRun = true)
	public void testLdapSettings() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.saveLdapSettings4SystemConfigurations();
		
		Assert.assertEquals(settingsPage.getLdapSettingsInfo4SystemIntegration(), "ldap://114.116.225.29:10001", "Ldap Settings Saving for System Configurations Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLdapSettings"}, alwaysRun = true)
	public void testfunctionSwitchs() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.functionSwitchs4SystemConfigurations();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testfunctionSwitchs"}, alwaysRun = true)
	public void testScheduleSettings() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.scheduleSettings4SystemConfigurations();
		
		Assert.assertNotEquals(settingsPage.getScheduleSettingsInfo4SystemIntegration().length(), 0, "Schedule Settings Saving for System Configurations Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testScheduleSettings"}, alwaysRun = true)
	public void testAnalysisSettings() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.analysisSettings4SystemConfigurations();
		
		Assert.assertEquals(settingsPage.getAnalysisSettingsInfo4SystemIntegration(), "100", "Analysis Settings Saving for System Configurations Failed!");
	}
}
