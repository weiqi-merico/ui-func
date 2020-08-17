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

public class ReportProblemsTest extends TestBase {
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
		repoReportPage.branchHashCopy4ReportProblems();
		
		Assert.assertEquals(repoReportPage.getBranchHashCopyTooltip4ReportProblems(), "复制成功", "Branch Hash Copy Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testBranchHashCopy"}, alwaysRun = true)
	public void testSelectBranch() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.selectBranch4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getTotalIssuesNum4ReportProblems().contains("问题"), "Select Branch Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSelectBranch"}, alwaysRun = true)
	public void testBranchCompare() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.branchCompare4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getTotalIssuesNum4ReportProblems().contains("独有的代码质量问题"), "Branch Compare Failed!");
		
		repoReportPage.unCheckBranchCompare4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testBranchCompare"}, alwaysRun = true)
	public void testNewAnalysisBranchRefresh() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newAnalysisRefresh4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getNewAnalysisBranchRefresh4ReportProblems().contains("最近一次提交"), "New Analysis Branch Refresh Failed!");
		
		repoReportPage.newAnalysisDialogCancelBtn4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewAnalysisBranchRefresh"}, alwaysRun = true)
	public void testSearchByAuthor() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByAuthor4ReportProblems();
		
		Assert.assertFalse(repoReportPage.getSearchResultByAuthor4ReportProblems().isEmpty(), "Search By Author Failed!");
		
		repoReportPage.clearAuthor4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByAuthor"}, alwaysRun = true)
	public void testSearchByRule() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByRule4ReportProblems();
		
		Assert.assertFalse(repoReportPage.getSearchResultByRule4ReportProblems().isEmpty(), "Search By Rule Failed!");
		
		repoReportPage.clearRule4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByRule"}, alwaysRun = true)
	public void testSearchByType() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByType4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getSearchResultByType4ReportProblems().contains("漏洞"), "Search By Type Failed!");
		
		repoReportPage.clearType4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByType"}, alwaysRun = true)
	public void testSearchBySeverity() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchBySeverity4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getSearchResultBySeverity4ReportProblems().contains("阻塞"), "Search By Severity Failed!");
		
		repoReportPage.clearSeverity4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchBySeverity"}, alwaysRun = true)
	public void testSearchByFile() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchByFile4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getSearchResultByFile4ReportProblems().contains(".js"), "Search By File Failed!");
		
		repoReportPage.clearFile4ReportProblems();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchByFile"}, alwaysRun = true)
	public void testPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.paginationJumper4ReportProblems();
		
		Assert.assertEquals(repoReportPage.getPaginationFocus4ReportProblems(), "rgba(202, 69, 33, 1)", "Pagination Jumper for Report Problems Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagination"}, alwaysRun = true)
	public void testFixedPagination() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.fixedPagination4ReportProblems();
		
		Assert.assertNotEquals(repoReportPage.getTableRowNum4ReportProblems(), 10, "Fixed Pagination Jumper for Commits List Page Failed!");
	}
}
