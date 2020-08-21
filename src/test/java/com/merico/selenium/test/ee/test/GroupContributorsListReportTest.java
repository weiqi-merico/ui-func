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

public class GroupContributorsListReportTest extends TestBase {
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
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testIntoOverallReport"}, alwaysRun = true)
	public void testContributorsSearchByCalendar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.contributorsSearchByCalendar();
		
		Assert.assertNotEquals(repoReportPage.getSearchResult4ContributorsReport().length(), 0, "Search Result By Calendar for Contributors Report Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testContributorsSearchByCalendar"}, alwaysRun = true)
	public void testContributorsSearch() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.contributorsSearch();
		
		Assert.assertEquals(repoReportPage.getSearchResult4ContributorsReport(), "Yanghui Lin", "Search Result for Contributors Report Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testContributorsSearch"}, alwaysRun = true)
	public void testContributorsDetail() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.contributorsDetail();
		
		Assert.assertEquals(repoReportPage.getFunctionPageHeader(), "贡献者报告", "Detail Page Info for Contributors Report Page Failed!");
		
		repoReportPage.back();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testContributorsDetail"}, alwaysRun = true)
	public void testContributorsSortByDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.contributorsDeleteContributorFlagAndSearch();
		repoReportPage.contributorsSortByDevEq();
//		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "点击降序", "Commit Sort by Dev Val for Commits Report Page Failed!");
		repoReportPage.contributorsSortByDevEq();
//		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "取消排序", "Commit Sort by Dev Val for Commits Report Page Failed!");
		repoReportPage.contributorsSortByDevEq();
//		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "点击升序", "Commit Sort by Dev Val for Commits Report Page Failed!");
		repoReportPage.contributorsSortByDevEq();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testContributorsSortByDevEq"}, alwaysRun = true)
	public void testPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.paginationJumper4ContributorsListTable();
		
		Assert.assertEquals(repoReportPage.getPaginationFocus4ContributorsTaskList(), "rgba(202, 69, 33, 1)", "Pagination Jumper for Contributors List Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagination"}, alwaysRun = true)
	public void testFixedPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.fixedPagination4ContributorsTable();
		
		Assert.assertNotEquals(repoReportPage.getTableRowNum4ContributorsList(), 10, "Fixed Pagination Jumper for Commits List Page Failed!");
	}
}
