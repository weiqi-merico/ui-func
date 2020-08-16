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
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testBranchCompare"}, alwaysRun = true)
	public void testNewAnalysisBranchRefresh() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newAnalysisRefresh4ReportProblems();
		
		Assert.assertTrue(repoReportPage.getNewAnalysisBranchRefresh4ReportProblems().contains("最近一次提交"), "New Analysis Branch Refresh Failed!");
		
		repoReportPage.newAnalysisDialogCancelBtn4ReportProblems();
	}
}
