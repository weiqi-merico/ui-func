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
import com.merico.selenium.test.ee.page.AddRepoPage;
import com.merico.selenium.test.ee.page.LoginPage;
import com.merico.selenium.test.ee.page.LogoutPage;
import com.merico.selenium.test.ee.utils.Crypt;

public class AddRepoDirectlyTest extends TestBase {
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
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "loginData4AdminProvider", dataProviderClass = TestDataProvider.class, 
			alwaysRun = true)
	public void testLogin4Admin(String username, String password, Crypt crypt) throws Exception {
		LoginPage loginPage = PageFactory.createPage(LoginPage.class, driver);
		loginPage.inputUsernameAndPwd(username, crypt.decrypt(password));
		loginPage.login4Admin();
		
		Assert.assertEquals(username, loginPage.getAccountName(), "Admin login failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "addRepoDirectlyProvider", dataProviderClass = TestDataProvider.class, 
			dependsOnMethods = {"testLogin4Admin"}, alwaysRun = true)
	public void testAddRepoDirectly(String repoUrl) throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.addRepoDirectly(repoUrl);
	
		Assert.assertTrue(addRepoPage.getAddedRepoName().contains("kubernetes"), "Add Repository Directly Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "addRepoDirectlyProvider", dataProviderClass = TestDataProvider.class, 
			dependsOnMethods = {"testAddRepoDirectly"}, alwaysRun = true)
	public void testAddExistedRepoDirectly(String repoUrl) throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.addExistedRepoDirectly(repoUrl);
	
		Assert.assertEquals("代码库已存在", addRepoPage.getRepoExistedErrPromptMsg(), "Add Existed Repo Directly Failed!");
		
		addRepoPage.cancelAddRepo();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAddExistedRepoDirectly"}, alwaysRun = true)
	public void testSearchNonExistedRepoByNameOrGitAddr() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.searchNonExistedRepoByNameOrGitAddr("Does not exist");
		
		Assert.assertEquals("暂无数据", addRepoPage.getNoDataPromptMsg(), "Search Repo By Name or Git Addr Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchNonExistedRepoByNameOrGitAddr"}, alwaysRun = true)
	public void testSearchRepoByProjectGroup() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.searchRepoByProjectGroup("Merico");
		
		Assert.assertTrue(addRepoPage.getAddedRepoName().contains("kubernetes"), "Search By Project Group Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchRepoByProjectGroup"}, alwaysRun = true)
	public void testSortByDevEquivalent() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.sortByDevEquivalent();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByDevEquivalent"}, alwaysRun = true)
	public void testSortByCommits() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.sortByCommits();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByCommits"}, alwaysRun = true)
	public void testSortByContributors() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.sortByContributors();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByContributors"}, alwaysRun = true)
	public void testSortByUpdateTimestamps() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.sortByUpdateTimestamps();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByUpdateTimestamps"}, alwaysRun = true)
	public void testSortBySubscriptionTimestamps() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.sortBySubscriptionTimestamps();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortBySubscriptionTimestamps"}, alwaysRun = true)
	public void testWaitingRepoTab() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.waitingRepoTab();
		
		Assert.assertTrue(addRepoPage.getRepoStatus().contains("等待中"), "Waiting Repo Tab Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testWaitingRepoTab"}, alwaysRun = true)
	public void testUnderwayRepoTab() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.underwayRepoTab();
		
		Assert.assertTrue(addRepoPage.getRepoStatus().contains("处理中"), "Underway Repo Tab Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testUnderwayRepoTab"}, alwaysRun = true)
	public void testFinishedRepoTab() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.finishedRepoTab();
		
		Assert.assertTrue(addRepoPage.getRepoStatus().contains("已完成"), "Finished Repo Tab Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFinishedRepoTab"}, alwaysRun = true)
	public void testAbnormalRepoTab() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.abnormalRepoTab();
		
		Assert.assertTrue(addRepoPage.getRepoStatus().contains("有异常"), "Abnormal Repo Tab Failed!");
		
		addRepoPage.allRepoTab();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAbnormalRepoTab"}, alwaysRun = true)
	public void testAnalysisParameterConfig() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.analysisParameterConfig();
		
		Assert.assertEquals("分析参数配置", addRepoPage.getAnalysisParaConfigPageTitle(), "Analysis Parameter Config Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAnalysisParameterConfig"}, alwaysRun = true)
	public void testStopAnalysis() throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.stopAnalysis();
		
//		Assert.assertEquals("暂无数据", addRepoPage.getNoDataPromptMsg(), "Stop Analysis Failed!");
		
		addRepoPage.allRepoTab();
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "addRepoDirectlyProvider", dataProviderClass = TestDataProvider.class, 
			dependsOnMethods = {"testStopAnalysis"}, alwaysRun = true)
	public void testDelRepo(String repoUrl) throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.delAddedRepo(repoUrl);
		
		Assert.assertEquals("暂无数据", addRepoPage.getNoDataPromptMsg(), "Delete Repo Directly Failed!");
	}
}
