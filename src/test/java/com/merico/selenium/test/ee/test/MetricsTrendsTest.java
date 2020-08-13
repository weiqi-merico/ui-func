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
		repoReportPage.coverageBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Test Coverage Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTestCoverageDisplay"}, alwaysRun = true)
	public void testVelocityDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.velocityBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Velocity Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testVelocityDisplay"}, alwaysRun = true)
	public void testReusabilityDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.reusabilityBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Reusability Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testReusabilityDisplay"}, alwaysRun = true)
	public void testModulatityDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.modulatityBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Modulatity Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testModulatityDisplay"}, alwaysRun = true)
	public void testRobustnessDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.robustnessBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Robustness Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testRobustnessDisplay"}, alwaysRun = true)
	public void testBlockerIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.blockerIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Blocker Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testBlockerIssuesDisplay"}, alwaysRun = true)
	public void testCriticalIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.criticalIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Critical Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCriticalIssuesDisplay"}, alwaysRun = true)
	public void testMajorIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.majorIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Major Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testMajorIssuesDisplay"}, alwaysRun = true)
	public void testMinorIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.minorIssuesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Minor Issues Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testMinorIssuesDisplay"}, alwaysRun = true)
	public void testInfoIssuesDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.infoIssuesBarChartDisplay4MetricsTrends();
		
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
		repoReportPage.guidesBarChartDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Guides Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGuidesDisplay"}, alwaysRun = true)
	public void testLastWeekDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.lastWeekDisplay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Last Week Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLastWeekDisplay"}, alwaysRun = true)
	public void testLastMonthWithDayDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.lastMonthDisplayByDay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Last Month With Day Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLastMonthWithDayDisplay"}, alwaysRun = true)
	public void testLastMonthWithWeekDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.lastMonthDisplayByWeek4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Last Month With Week Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLastMonthWithWeekDisplay"}, alwaysRun = true)
	public void testLastYearWithDayDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.lastYearDisplayByDay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Last Year With Day Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLastYearWithDayDisplay"}, alwaysRun = true)
	public void testLastYearWithWeekDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.lastYearDisplayByWeek4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Last Year With Week Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLastYearWithWeekDisplay"}, alwaysRun = true)
	public void testLastYearWithMonthDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.lastYearDisplayByMonth4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Last Year With Month Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLastYearWithMonthDisplay"}, alwaysRun = true)
	public void testAllTimeWithDayDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.allTimeDisplayByDay4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends All Time With Day Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAllTimeWithDayDisplay"}, alwaysRun = true)
	public void testAllTimeWithWeekDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.allTimeDisplayByWeek4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends All Time With Week Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAllTimeWithWeekDisplay"}, alwaysRun = true)
	public void testAllTimeWithMonthDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.allTimeDisplayByMonth4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends All Time With Month Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAllTimeWithMonthDisplay"}, alwaysRun = true)
	public void testAllTimeWithYearDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.allTimeDisplayByYear4MetricsTrends();
		
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends All Time With Year Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAllTimeWithYearDisplay"}, alwaysRun = true)
	public void testCustomWithDayDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.customLineChartDisplayByDay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Day Line Chart Canvas Display Failed!");
		
		repoReportPage.customBarChartDisplayByDay4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Day Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCustomWithDayDisplay"}, alwaysRun = true)
	public void testCustomWithWeekDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.customLineChartDisplayByWeek4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Week Line Chart Canvas Display Failed!");
		
		repoReportPage.customBarChartDisplayByWeek4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Week Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCustomWithWeekDisplay"}, alwaysRun = true)
	public void testCustomWithMonthDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.customLineChartDisplayByMonth4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Month Line Chart Canvas Display Failed!");
		
		repoReportPage.customBarChartDisplayByMonth4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Month Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCustomWithMonthDisplay"}, alwaysRun = true)
	public void testCustomWithYearDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.customLineChartDisplayByYear4MetricsTrends();
		Assert.assertTrue(repoReportPage.getLineChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Year Line Chart Canvas Display Failed!");
		
		repoReportPage.customBarChartDisplayByYear4MetricsTrends();
		Assert.assertTrue(repoReportPage.getBarChartCanvasDiagram4MetricTrends(), "Metrics Trends Custom With Year Bar Chart Canvas Display Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCustomWithYearDisplay"}, alwaysRun = true)
	public void testCollapseDisplay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.collapse4MetricsTrends();
		
		Assert.assertEquals(repoReportPage.getCollapseInfo4MetricTrends(), "展开条件", "Metrics Trends Collapse Display Failed!");
	}
}
