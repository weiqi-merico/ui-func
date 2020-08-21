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

public class GroupCodeQualityTest extends TestBase {
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
		repoReportPage.enterIntoCodeQuality4GroupCodeQuality();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testIntoOverallReport"}, alwaysRun = true)
	public void testSearchByAuthor() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByAuthor4GroupReportProblems();
		
		Assert.assertFalse(repoReportPage.getSearchResultByAuthor4ReportProblems().isEmpty(), "Search By Author Failed!");
		
		repoReportPage.clearAuthor4GroupReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByAuthor"}, alwaysRun = true)
	public void testSearchByRule() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByRule4GroupReportProblems();
		
		Assert.assertFalse(repoReportPage.getSearchResultByRule4ReportProblems().isEmpty(), "Search By Rule Failed!");
		
		repoReportPage.clearRule4GroupReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByRule"}, alwaysRun = true)
	public void testSearchByType() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByType4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getSearchResultByType4ReportProblems().contains("漏洞"), "Search By Type Failed!");
		
		repoReportPage.clearType4GroupReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByType"}, alwaysRun = true)
	public void testSearchBySeverity() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchBySeverity4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getSearchResultBySeverity4ReportProblems().contains("阻塞"), "Search By Severity Failed!");
		
		repoReportPage.clearSeverity4GroupReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchBySeverity"}, alwaysRun = true)
	public void testSearchByFile() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByFile4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getSearchResultByFile4ReportProblems().contains(".js"), "Search By File Failed!");
		Assert.assertTrue(repoReportPage.getSearchResultByFileDiagram4ReportProblems().contains(".js"), "Search By File Diagram Failed!");
		Assert.assertTrue(repoReportPage.getSearchResultByFileSource4ReportProblems(), "Source File Diagram Displayed Failed!");
		
		repoReportPage.clearFile4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByFile"}, alwaysRun = true)
	public void testPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.paginationJumper4GroupReportProblems();
		
		Assert.assertEquals(repoReportPage.getPaginationFocus4ReportProblems(), "rgba(202, 69, 33, 1)", "Pagination Jumper for Report Problems Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagination"}, alwaysRun = true)
	public void testFixedPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.fixedPagination4GroupReportProblems();
		
		Assert.assertNotEquals(repoReportPage.getTableRowNum4ReportProblems(), 10, "Fixed Pagination Jumper for Commits List Page Failed!");
	}
}
