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

public class EfficiencyReportTest extends TestBase {
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
	public void testAccDevEqChartStepByDay(String repoUrl) throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchRepoByNameOrGitAddr(repoUrl);
		repoReportPage.accDevEqChartStepByDay4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Acc Dev Eq Chart By Day for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByDay"}, alwaysRun = true)
	public void testAccDevEqChartStepByWeek() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByWeek4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Acc Dev Eq Chart By Week for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByWeek"}, alwaysRun = true)
	public void testAccDevEqChartStepByMonth() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByMonth4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Acc Dev Eq Chart By Month for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByMonth"}, alwaysRun = true)
	public void testAccDevEqChartStepByQuarter() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByQuarter4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Acc Dev Eq Chart By Quarter for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByQuarter"}, alwaysRun = true)
	public void testAccDevEqChartStepByYear() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByYear4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Acc Dev Eq Chart By Year for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByYear"}, alwaysRun = true)
	public void testAccDevEqTableHeaderContributorAndDate() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getAccDevEqTableContributorHeader4EfficiencyReport(), "贡献者", "Get Acc Dev Eq Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getAccDevEqTableDateHeader4EfficiencyReport().contains("01-01"), "Get Acc Dev Eq Table Header Date for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqTableHeaderContributorAndDate"}, alwaysRun = true)
	public void testAccDevEqTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 12, "Get Acc Dev Eq Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqTableRowToCol"}, alwaysRun = true)
	public void testNewDevEqTooltip() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqTooltip4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getTooltip4EfficiencyReport().contains("趋势图上下限公式"), "New Dev Eq Tooltip for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqTooltip"}, alwaysRun = true)
	public void testNewDevEqOutlier() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqOutlier4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "New Dev Eq Outlier for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqOutlier"}, alwaysRun = true)
	public void testNewDevEqChartStepByWeek() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqChartStepByWeek4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "New Dev Eq Chart Step By Week for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqChartStepByWeek"}, alwaysRun = true)
	public void testNewDevEqChartStepByMonth() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqChartStepByMonth4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "New Dev Eq Chart Step By Month for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqChartStepByMonth"}, alwaysRun = true)
	public void testNewDevEqChartStepByQuarter() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqChartStepByQuarter4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "New Dev Eq Chart Step By Quarter for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqChartStepByQuarter"}, alwaysRun = true)
	public void testNewDevEqChartStepByYear() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqChartStepByYear4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "New Dev Eq Chart Step By Year for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqChartStepByYear"}, alwaysRun = true)
	public void testNewDevEqTableHeaderContributorAndDate() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getNewDevEqTableContributorHeader4EfficiencyReport(), "贡献者", "Get New Dev Eq Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getNewDevEqTableDateHeader4EfficiencyReport().contains("01-01"), "Get New Dev Eq Table Header Date for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqTableHeaderContributorAndDate"}, alwaysRun = true)
	public void testNewDevEqTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 12, "Get New Dev Eq Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqTableRowToCol"}, alwaysRun = true)
	public void testDevEqPerRankChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqPerRankChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getDevEqPerRankChartDisplayed4EfficiencyReport(), "Dev Eq Per Rank Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqPerRankChart"}, alwaysRun = true)
	public void testDevEqPerRankTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqPerRankTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getDevEqPerRankTableContributorHeader4EfficiencyReport(), "贡献者", "Get Dev Eq Per Rank Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getDevEqPerRankTableDevEqHeader4EfficiencyReport().contains("开发当量"), "Get Dev Eq Per Rank Table Header Dev Eq for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqPerRankTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testDevEqPerRankTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqPerRankTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 12, "Get Dev Eq Ratio Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqPerRankTableRowToCol"}, alwaysRun = true)
	public void testDevEqRatioChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqRatioChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getDevEqRatioChartDisplayed4EfficiencyReport(), "Dev Eq Ratio Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqRatioChart"}, alwaysRun = true)
	public void testDevEqRatioTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqRatioTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getDevEqRatioTableContributorHeader4EfficiencyReport(), "贡献者", "Get Dev Eq Ratio Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getDevEqRatioTableDevEqHeader4EfficiencyReport().contains("开发当量"), "Get Dev Eq Ratio Table Header Dev Eq for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqRatioTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testDevEqRatioTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqRatioTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 12, "Get Dev Eq Ratio Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqRatioTableRowToCol"}, alwaysRun = true)
	public void testEfficiencyBoxPlotChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.efficiencyBoxPlotChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getEfficiencyBoxPlotChartDisplayed4EfficiencyReport(), "Efficiency BoxPlot Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEfficiencyBoxPlotChart"}, alwaysRun = true)
	public void testEfficiencyBoxPlotTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.efficiencyBoxPlotTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getEfficiencyBoxPlotTableContributorHeader4EfficiencyReport(), "贡献者", "Get Efficiency BoxPlot Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getEfficiencyBoxPlotTableMinimumHeader4EfficiencyReport().contains("最小值"), "Get Efficiency BoxPlot Table Header Minimum for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEfficiencyBoxPlotTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testEfficiencyBoxPlotTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.efficiencyBoxPlotTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 72, "Get Efficiency BoxPlot Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEfficiencyBoxPlotTableRowToCol"}, alwaysRun = true)
	public void testDevEqParetoChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqParetoChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getDevEqParetoChartDisplayed4EfficiencyReport(), "Dev Eq Pareto Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqParetoChart"}, alwaysRun = true)
	public void testDevEqParetoTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqParetoTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getDevEqParetoTableContributorHeader4EfficiencyReport(), "贡献者", "Get Dev Eq Pareto Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getDevEqParetoTableDevEqHeader4EfficiencyReport().contains("开发当量"), "Get Dev Eq Pareto Table Header Dev Eq for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevEqParetoTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testDevEqParetoTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.devEqParetoTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 12, "Get Dev Eq Pareto Table Row to Col for Efficiency Report Failed!");
	}
}
