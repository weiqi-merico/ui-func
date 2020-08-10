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

public class CommitsListReportTest extends TestBase {
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
	public void testCommitsSearch(String repoUrl) throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchRepoByNameOrGitAddr(repoUrl);
		repoReportPage.commitsSearch();
		
		Assert.assertEquals(repoReportPage.getSearchResult4CommitsReport(), "yanghui@meri.co", "Search Result for Commits Report Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCommitsSearch"}, alwaysRun = true)
	public void testCommitsDetail() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.commitsDetail();
		
		Assert.assertEquals(repoReportPage.getDetailInfo4CommitsReport(), "开发价值", "Detail Page Info for Commits Report Page Failed!");
		
		repoReportPage.back();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCommitsDetail"}, alwaysRun = true)
	public void testCommitsSearchByTitle() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.commitsSearchByTitle();
		
		Assert.assertTrue(repoReportPage.getSearchTitleResult4CommitsReport().contains("Merge"), "Search Commit Title for Commits Report Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCommitsSearchByTitle"}, alwaysRun = true)
	public void testCommitsSearchTooltipByTitle() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.commitsSearchByTitleTooltip();
		
		Assert.assertTrue(repoReportPage.getSearchTitleResult4CommitsReport().contains("Merge"), "Search Commit Title Tooltip for Commits Report Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCommitsSearchTooltipByTitle"}, alwaysRun = true)
	public void testCommitsSortByDevVal() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.commitsSortByDevVal();
//		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "点击降序", "Commit Sort by Dev Val for Commits Report Page Failed!");
		repoReportPage.commitsSortByDevVal();
//		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "取消排序", "Commit Sort by Dev Val for Commits Report Page Failed!");
		repoReportPage.commitsSortByDevVal();
//		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "点击升序", "Commit Sort by Dev Val for Commits Report Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCommitsSortByDevVal"}, alwaysRun = true)
	public void testCommitsSortByCommitTime() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.moveToCommitTimeCol();
		repoReportPage.commitsSortByCommitTime();
		repoReportPage.moveToCommitTimeCol();
		repoReportPage.hoverToCommitTimeCol();
		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "点击降序", "Commit Sort by Dev Val for Commits Report Page Failed!");
		
		repoReportPage.commitsSortByCommitTime();
		repoReportPage.moveToCommitTimeCol();
		repoReportPage.hoverToCommitTimeCol();
		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "取消排序", "Commit Sort by Dev Val for Commits Report Page Failed!");
		
		repoReportPage.commitsSortByCommitTime();
		repoReportPage.moveToCommitTimeCol();
		repoReportPage.hoverToCommitTimeCol();
		Assert.assertEquals(repoReportPage.getCommitTableColTooltip4CommitsReport(), "点击升序", "Commit Sort by Dev Val for Commits Report Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCommitsSortByCommitTime"}, alwaysRun = true)
	public void testPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.paginationJumper4CommitsListTable();
		
		Assert.assertEquals(repoReportPage.getPaginationFocus4CommitsTaskList(), "rgba(202, 69, 33, 1)", "Pagination Jumper for Commits List Page Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagination"}, alwaysRun = true)
	public void testFixedPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.fixedPagination4CommitsTable();
		
		Assert.assertNotEquals(repoReportPage.getTableRowNum4CommitsList(), 10, "Fixed Pagination Jumper for Commits List Page Failed!");
	}
}
