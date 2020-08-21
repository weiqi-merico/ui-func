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
import com.merico.selenium.test.ee.page.RepoReportPage;
import com.merico.selenium.test.ee.utils.Crypt;

public class GroupCodeDuplicatesTest extends TestBase {
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
	public void testIntoOverallReport() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.enterIntoOverallReport();
		repoReportPage.enterIntoCodeDuplicates4GroupCodeDuplicates();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testIntoOverallReport"}, alwaysRun = true)
	public void testSelectFileToCompare() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.selectFileToCompare4CodeDuplicates();
		
		Assert.assertTrue(repoReportPage.getSource4CodeDuplicates(), "Select File To Compare for Code Duplicates Failed!");
		Assert.assertTrue(repoReportPage.getCompareTooltip4CodeDuplicates().contains("勾选"), "Select File To Compare for Code Duplicates Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSelectFileToCompare"}, alwaysRun = true)
	public void testFixedPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.fixedPagination4GroupCodeDuplicates();
		
		Assert.assertNotEquals(repoReportPage.getTableRowNum4CodeDuplicates(), 10, "Fixed Pagination Jumper for Code Duplicates Failed!");
		
	}
}
