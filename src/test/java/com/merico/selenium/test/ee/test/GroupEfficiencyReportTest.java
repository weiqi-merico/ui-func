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
}
