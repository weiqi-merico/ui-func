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

public class DocCoverageTest extends TestBase {
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
		repoReportPage.branchHashCopy4DocCoverage();
		
		Assert.assertEquals(repoReportPage.getHashCopyTooltip4TestCoverage(), "复制成功", "Hash Copy for Test Coverage Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testBranchHashCopy"}, alwaysRun = true)
	public void testSelectBranchHashCopy() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.selectBranch4TestCoverage();
		
		Assert.assertTrue(repoReportPage.getCanvas4TestCoverage(), "Select Branch for Test Coverage Failed!");
		Assert.assertEquals(repoReportPage.getAllCanvas4TestCoverage(), 3, "Select Branch for Test Coverage Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSelectBranchHashCopy"}, alwaysRun = true)
	public void testUncoveredFunctionsLoadMore() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.uncoveredFunctionsLoadMore4TestCoverage();
		
		Assert.assertTrue(repoReportPage.getUncoveredFunctionsItems4TestCoverage(), "Uncovered Functions Load More for Test Coverage Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testUncoveredFunctionsLoadMore"}, alwaysRun = true)
	public void testUncoveredFunctionsFileTooltip() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.uncoveredFunctionsFileTooltip4TestCoverage();
		
		Assert.assertFalse(repoReportPage.getUncoveredFunctionsFileTooltip4TestCoverage().isEmpty(), "Uncovered Functions File Tooltip for Test Coverage Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testUncoveredFunctionsFileTooltip"}, alwaysRun = true)
	public void testSortByRepoName() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.sortByRepoName4TestCoverage();
		
		Assert.assertEquals(repoReportPage.getRepoColTooltip4TestCoverage(), "点击升序", "Sort By Repo Name for Test Coverage Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByRepoName"}, alwaysRun = true)
	public void testSortByFilePath() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.sortByFilePath4TestCoverage();
		
		Assert.assertEquals(repoReportPage.getFilePathColTooltip4TestCoverage(), "点击升序", "Sort By File Path for Test Coverage Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByFilePath"}, alwaysRun = true)
	public void testSortByFileCoverage() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.sortByFileCoverage4TestCoverage();
		
		Assert.assertEquals(repoReportPage.getFileCoverageColTooltip4TestCoverage(), "点击升序", "Sort By Coverage for Test Coverage Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByFileCoverage"}, alwaysRun = true)
	public void testFileCoverageLoadMore() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.fileCoverageLoadMore4TestCoverage();
		
		Assert.assertNotEquals(repoReportPage.getFileCoverageTableRowCount4TestCoverage(), 20, "Sort By Coverage for Test Coverage Failed!");
	}
}
