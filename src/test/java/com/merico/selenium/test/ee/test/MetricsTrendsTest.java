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

public class MetricsTrendsTest extends TestBase {
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
	public void testRepoDisplay(String repoUrl) throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchRepoByNameOrGitAddr(repoUrl);
		repoReportPage.repoLineChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends Repo Line Chart Canvas Display Failed!");
		
		repoReportPage.repoBarChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Repo Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testRepoDisplay"}, alwaysRun = true)
	public void testDevEqDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqLineChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends Dev Eq Line Chart Canvas Display Failed!");
		
		repoReportPage.devEqBarChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Dev Eq Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqDisplay"}, alwaysRun = true)
	public void testSlocDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.slocLineChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends SLOC Line Chart Canvas Display Failed!");
	
		repoReportPage.slocBarChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends SLOC Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSlocDisplay"}, alwaysRun = true)
	public void testNumOfCommitsDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.numOfCommitsLineChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends Number of Commits Line Chart Canvas Display Failed!");
	
		repoReportPage.numOfCommitsBarChartDisplay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Number of Commits Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNumOfCommitsDisplay"}, alwaysRun = true)
	public void testCycleComplexityDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.cycleComplexityBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Cycle Complexity Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCycleComplexityDisplay"}, alwaysRun = true)
	public void testDocCoverageDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.docCoverageBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Doc Coverage Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDocCoverageDisplay"}, alwaysRun = true)
	public void testTestCoverageDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testCoverageBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Test Coverage Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTestCoverageDisplay"}, alwaysRun = true)
	public void testVelocityDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testVelocityBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Velocity Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testVelocityDisplay"}, alwaysRun = true)
	public void testReusabilityDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testReusabilityBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Reusability Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testReusabilityDisplay"}, alwaysRun = true)
	public void testModulatityDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testModulatityBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Modulatity Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testModulatityDisplay"}, alwaysRun = true)
	public void testRobustnessDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testRobustnessBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Robustness Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testRobustnessDisplay"}, alwaysRun = true)
	public void testBlockerIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testBlockerIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Blocker Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testBlockerIssuesDisplay"}, alwaysRun = true)
	public void testCriticalIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testCriticalIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Critical Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCriticalIssuesDisplay"}, alwaysRun = true)
	public void testMajorIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testMajorIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Major Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testMajorIssuesDisplay"}, alwaysRun = true)
	public void testMinorIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testMinorIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Minor Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testMinorIssuesDisplay"}, alwaysRun = true)
	public void testInfoIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testInfoIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Info Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testInfoIssuesDisplay"}, alwaysRun = true)
	public void testGuidesTooltipDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.guidesQuestionMark4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getTooltip4MetricsTrends().contains("趋势图"), "Metrics Trends Guides Tooltip Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGuidesTooltipDisplay"}, alwaysRun = true)
	public void testGuidesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testGuidesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Guides  Bar Chart Canvas Display Failed!");
	}	
}
