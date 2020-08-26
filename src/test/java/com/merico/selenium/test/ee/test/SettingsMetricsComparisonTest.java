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

public class SettingsMetricsComparisonTest extends TestBase {
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
	public void testTooltip() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.navigateToSettings();
		settingsPage.tooltip4MetricsComparison();
		
		Assert.assertTrue(settingsPage.getNumOfDevTooltip4MetricsComparison().contains("部门开发者数"), "Number of Developer Tooltip for Metrics Comparison Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTooltip"}, alwaysRun = true)
	public void testDepartmentComparison() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.departmentComparison4MetricsComparison();
		
		Assert.assertNotEquals(settingsPage.getComparisonCount4MetricsComparison(), 2, "Department Comparison for Metrics Comparison Failed!");
		settingsPage.delComparison4MetricsComparison();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDepartmentComparison"}, alwaysRun = true)
	public void testMemberComparison() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.memberComparison4MetricsComparison();
		
		Assert.assertNotEquals(settingsPage.getComparisonCount4MetricsComparison(), 2, "Member Comparison Tooltip for Metrics Comparison Failed!");
		settingsPage.delComparison4MetricsComparison();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testMemberComparison"}, alwaysRun = true)
	public void testErrExportDataMsg() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.errExportData4MetricsComparison();
		
		Assert.assertTrue(settingsPage.getErrExportDataMsg4MetricsComparison().contains("数据尚未准备好"), "Error Export Data for Metrics Comparison Failed!");
	}
}
