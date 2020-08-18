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

public class ComplexityFunctionsTest extends TestBase {
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
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "searchRepoProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testLogin4Admin"}, alwaysRun = true)
	public void testBranchHashCopy(String repoUrl) throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchRepoByNameOrGitAddr(repoUrl);
		repoReportPage.branchHashCopy4ComplexityFunctions();
		
		Assert.assertEquals(repoReportPage.getHashCopyTooltip4ComplexityFunctions(), "复制成功", "Hash Copy for Complexity Functions Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testBranchHashCopy"}, alwaysRun = true)
	public void testSortBySignature() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.sortBySignature4ComplexityFunctions();
		
//		Assert.assertEquals(repoReportPage.getSignatureColTooltip4ComplexityFunctions(), "点击降序", "Sort By Signature for Complexity Functions Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortBySignature"}, alwaysRun = true)
	public void testFilterByLocation() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.filterByLocation4ComplexityFunctions();
		
		Assert.assertTrue(repoReportPage.getFilterByLocationResult4ComplexityFunctions().contains(".ts"), "Filter By Location for Complexity Functions Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFilterByLocation"}, alwaysRun = true)
	public void testResetFilterByLocation() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.resetFilterByLocation4ComplexityFunctions();
		
		Assert.assertNotEquals(repoReportPage.getFilterByLocationResult4ComplexityFunctions().length(), 0, "Reset Filter By Location for Complexity Functions Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testResetFilterByLocation"}, alwaysRun = true)
	public void testPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.paginationJumper4ComplexityFunctions();
		
		Assert.assertEquals(repoReportPage.getPaginationFocus4ComplexityFunctions(), "rgba(202, 69, 33, 1)", "Pagination Jumper for Complexity Functions Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagination"}, alwaysRun = true)
	public void testFixedPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.fixedPagination4ComplexityFunctions();
		
		Assert.assertNotEquals(repoReportPage.getTableRowNum4ComplexityFunctions(), 10, "Fixed Pagination Jumper for Complexity Functions Failed!");
	}
}
