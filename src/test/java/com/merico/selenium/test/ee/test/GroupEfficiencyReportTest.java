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

public class GroupEfficiencyReportTest extends TestBase {
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
	public void testGroupAccDevEqChartStepByDay() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.enterIntoOverallReport();
		repoReportPage.groupAccDevEqChartStepByDay4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Group Acc Dev Eq Chart By Day for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupAccDevEqChartStepByDay"}, alwaysRun = true)
	public void testGroupAccDevEqChartStepByWeek() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupAccDevEqChartStepByWeek4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Group Acc Dev Eq Chart By Week for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupAccDevEqChartStepByWeek"}, alwaysRun = true)
	public void testGroupAccDevEqChartStepByMonth() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupAccDevEqChartStepByMonth4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Group Acc Dev Eq Chart By Month for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupAccDevEqChartStepByMonth"}, alwaysRun = true)
	public void testGroupAccDevEqChartStepByQuarter() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupAccDevEqChartStepByQuarter4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Group Acc Dev Eq Chart By Quarter for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupAccDevEqChartStepByQuarter"}, alwaysRun = true)
	public void testGroupAccDevEqChartStepByYear() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupAccDevEqChartStepByYear4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4EfficiencyReport(), "Group Acc Dev Eq Chart By Year for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupAccDevEqChartStepByYear"}, alwaysRun = true)
	public void testGroupAccDevEqTableHeaderContributorAndDate() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupAccDevEqTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getGroupAccDevEqTableContributorHeader4EfficiencyReport(), "项目组", "Get Group Acc Dev Eq Table Header Project Group for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getGroupAccDevEqTableDateHeader4EfficiencyReport().contains("01-01"), "Get Group Acc Dev Eq Table Header Date for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupAccDevEqTableHeaderContributorAndDate"}, alwaysRun = true)
	public void testGroupAccDevEqTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupAccDevEqTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 7, "Get Group Acc Dev Eq Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupAccDevEqTableRowToCol"}, alwaysRun = true)
	public void testGroupNewDevEqTooltip() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupNewDevEqTooltip4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getTooltip4EfficiencyReport().contains("趋势图上下限公式"), "Group New Dev Eq Tooltip for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupNewDevEqTooltip"}, alwaysRun = true)
	public void testGroupNewDevEqOutlier() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqOutlier4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "Group New Dev Eq Outlier for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupNewDevEqOutlier"}, alwaysRun = true)
	public void testGroupNewDevEqChartStepByWeek() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupNewDevEqChartStepByWeek4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "Group New Dev Eq Chart Step By Week for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupNewDevEqChartStepByWeek"}, alwaysRun = true)
	public void testNewDevEqChartStepByMonth() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqChartStepByMonth4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "Group New Dev Eq Chart Step By Month for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqChartStepByMonth"}, alwaysRun = true)
	public void testNewDevEqChartStepByQuarter() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqChartStepByQuarter4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "Group New Dev Eq Chart Step By Quarter for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqChartStepByQuarter"}, alwaysRun = true)
	public void testNewDevEqChartStepByYear() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqChartStepByYear4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getNewDevEqChartDisplayed4EfficiencyReport(), "Group New Dev Eq Chart Step By Year for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewDevEqChartStepByYear"}, alwaysRun = true)
	public void testGroupNewDevEqTableHeaderContributorAndDate() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupNewDevEqTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getNewDevEqTableContributorHeader4EfficiencyReport(), "项目组", "Get New Dev Eq Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getNewDevEqTableDateHeader4EfficiencyReport().contains("01-01"), "Get New Dev Eq Table Header Date for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupNewDevEqTableHeaderContributorAndDate"}, alwaysRun = true)
	public void testGroupNewDevEqTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.newDevEqTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 7, "Get New Dev Eq Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupNewDevEqTableRowToCol"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaTrendTooltip() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaTrendTooltip4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getTooltip4EfficiencyReport().contains("趋势图上下限公式"), "Group Dev Eq Per Capita Tooltip for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaTrendTooltip"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaOutlier() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaTrendOutlier4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqPerCapitaTrendChartDisplayed4EfficiencyReport(), "Group Dev Eq Per Capita Outlier for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaOutlier"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaChartStepByWeek() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaChartStepByWeek4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqPerCapitaTrendChartDisplayed4EfficiencyReport(), "Group Dev Eq Per Capita Chart Step By Week for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaChartStepByWeek"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaChartStepByMonth() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaChartStepByMonth4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqPerCapitaTrendChartDisplayed4EfficiencyReport(), "Group Dev Eq Per Capita Chart Step By Month for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaChartStepByMonth"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaChartStepByQuarter() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaChartStepByQuarter4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqPerCapitaTrendChartDisplayed4EfficiencyReport(), "Group Dev Eq Per Capita Chart Step By Quarter for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaChartStepByQuarter"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaChartStepByYear() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaChartStepByYear4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqPerCapitaTrendChartDisplayed4EfficiencyReport(), "Group Dev Eq Per Capita Chart Step By Year for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaChartStepByYear"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaTableHeaderContributorAndDate() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getGroupDevEqPerCapitaTableContributorHeader4EfficiencyReport(), "项目组", "Get Group Dev Eq Per Capita Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getGroupDevEqPerCapitaTableDateHeader4EfficiencyReport().contains("01-01"), "Get Group Dev Eq Per Capita Table Header Date for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaTableHeaderContributorAndDate"}, alwaysRun = true)
	public void testGroupDevEqPerCapitaTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerCapitaTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 7, "Get Group Dev Eq Per Capita Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerCapitaTableRowToCol"}, alwaysRun = true)
	public void testGroupDevEqPerRankChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerRankChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqPerRankChartDisplayed4EfficiencyReport(), "Group Dev Eq Per Rank Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerRankChart"}, alwaysRun = true)
	public void testGroupDevEqPerRankTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerRankTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getGroupDevEqPerRankTableContributorHeader4EfficiencyReport(), "项目组", "Get Group Dev Eq Per Rank Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getGroupDevEqPerRankTableDevEqHeader4EfficiencyReport().contains("开发当量"), "Get Group Dev Eq Per Rank Table Header Dev Eq for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerRankTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testGroupDevEqPerRankTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqPerRankTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 7, "Get Group Dev Eq Ratio Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqPerRankTableRowToCol"}, alwaysRun = true)
	public void testGroupDevEqRatioChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqRatioChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqRatioChartDisplayed4EfficiencyReport(), "Group Dev Eq Ratio Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqRatioChart"}, alwaysRun = true)
	public void testGroupDevEqRatioTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqRatioTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getGroupDevEqRatioTableContributorHeader4EfficiencyReport(), "项目组", "Get Group Dev Eq Ratio Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getGroupDevEqRatioTableDevEqHeader4EfficiencyReport().contains("开发当量"), "Get Group Dev Eq Ratio Table Header Dev Eq for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqRatioTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testGroupDevEqRatioTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqRatioTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 7, "Get Group Dev Eq Ratio Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqRatioTableRowToCol"}, alwaysRun = true)
	public void testGroupEfficiencyBoxPlotChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupEfficiencyBoxPlotChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupEfficiencyBoxPlotChartDisplayed4EfficiencyReport(), "Group Efficiency BoxPlot Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupEfficiencyBoxPlotChart"}, alwaysRun = true)
	public void testGroupEfficiencyBoxPlotTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupEfficiencyBoxPlotTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getGroupEfficiencyBoxPlotTableContributorHeader4EfficiencyReport(), "项目组", "Get Group Efficiency BoxPlot Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getGroupEfficiencyBoxPlotTableMinimumHeader4EfficiencyReport().contains("最小值"), "Get Group Efficiency BoxPlot Table Header Minimum for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupEfficiencyBoxPlotTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testGroupEfficiencyBoxPlotTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupEfficiencyBoxPlotTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 42, "Get Group Efficiency BoxPlot Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupEfficiencyBoxPlotTableRowToCol"}, alwaysRun = true)
	public void testGroupEfficiencyStabilityTooltip() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupEfficiencyStabilityTooltip4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getTooltip4EfficiencyReport().contains("此图用来评估开发过程中的效率稳定"), "Group Efficiency and Stability Tooltip for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupEfficiencyStabilityTooltip"}, alwaysRun = true)
	public void testGroupEfficiencyStabilityChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupEfficiencyStabilityChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupEfficiencyStabilityChartDisplayed4EfficiencyReport(), "Group Efficiency and Stability Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupEfficiencyStabilityChart"}, alwaysRun = true)
	public void testGroupEfficiencyStabilityTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupEfficiencyStabilityTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getGroupEfficiencyStabilityTableContributorHeader4EfficiencyReport(), "项目组", "Get Group Efficiency and Stability Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getGroupEfficiencyStabilityTableMinimumHeader4EfficiencyReport().contains("平均开发当量"), "Get Group Efficiency and Stability Table Header Minimum for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupEfficiencyStabilityTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testGroupEfficiencyStabilityTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupEfficiencyStabilityTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 14, "Get Group Efficiency and Stability Table Row to Col for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupEfficiencyStabilityTableRowToCol"}, alwaysRun = true)
	public void testGroupDevEqParetoChart() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqParetoChart4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getGroupDevEqParetoChartDisplayed4EfficiencyReport(), "Group Dev Eq Pareto Chart for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqParetoChart"}, alwaysRun = true)
	public void testGroupDevEqParetoTableHeaderContributorAndDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqParetoTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getGroupDevEqParetoTableContributorHeader4EfficiencyReport(), "项目组", "Get Group Dev Eq Pareto Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getGroupDevEqParetoTableDevEqHeader4EfficiencyReport().contains("开发当量"), "Get Group Dev Eq Pareto Table Header Dev Eq for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testGroupDevEqParetoTableHeaderContributorAndDevEq"}, alwaysRun = true)
	public void testGroupDevEqParetoTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.groupDevEqParetoTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getTableCellsCount4EfficiencyReport(), 7, "Get Group Group Dev Eq Pareto Table Row to Col for Efficiency Report Failed!");
	}
}
