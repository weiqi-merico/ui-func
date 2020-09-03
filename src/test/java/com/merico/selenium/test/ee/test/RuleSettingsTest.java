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

public class RuleSettingsTest extends TestBase {
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
	public void testSearchByRule() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.navigateToSettings();
		settingsPage.searchByRule4RuleSettings();
		
		Assert.assertTrue(settingsPage.getRuleSearchResult4RuleSettings().contains("Array"), "Search Rule for Rule Settings Failed!");
		settingsPage.clearRuleSearch4RuleSettings();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByRule"}, alwaysRun = true)
	public void testSearchByType() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.searchByType4RuleSettings();
		
		Assert.assertEquals(settingsPage.getTypeSearchResult4RuleSettings(), "异味", "Search Type for Rule Settings Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByType"}, alwaysRun = true)
	public void testSearchBySeverities() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.searchBySeverities4RuleSettings();
		
		Assert.assertEquals(settingsPage.getSeveritiesSearchResult4RuleSettings(), "次要", "Search Severities for Rule Settings Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchBySeverities"}, alwaysRun = true)
	public void testFixedPaging() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.fixedPaging4RuleSettings();
		
		Assert.assertNotEquals(settingsPage.getFixedPagingRows4RuleSettings(), 20, "Fixed Paging for Rule Settings Failed!");
	}
}
