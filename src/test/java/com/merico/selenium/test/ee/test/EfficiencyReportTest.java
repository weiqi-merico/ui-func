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
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4IndustryMetrics(), "Acc Dev Eq Chart By Day for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByDay"}, alwaysRun = true)
	public void testAccDevEqChartStepByWeek() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByWeek4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4IndustryMetrics(), "Acc Dev Eq Chart By Week for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByWeek"}, alwaysRun = true)
	public void testAccDevEqChartStepByMonth() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByMonth4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4IndustryMetrics(), "Acc Dev Eq Chart By Month for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByMonth"}, alwaysRun = true)
	public void testAccDevEqChartStepByQuarter() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByQuarter4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4IndustryMetrics(), "Acc Dev Eq Chart By Quarter for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByQuarter"}, alwaysRun = true)
	public void testAccDevEqChartStepByYear() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqChartStepByYear4EfficiencyReport();
		
		Assert.assertTrue(repoReportPage.getAccDevEqChartDisplayed4IndustryMetrics(), "Acc Dev Eq Chart By Year for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqChartStepByYear"}, alwaysRun = true)
	public void testAccDevEqTableHeaderContributor() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqTableHeaderContributor4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getAccDevEqTableContributorHeader4EfficiencyReport(), "贡献者", "Get Acc Dev Eq Table Header Contributor for Efficiency Report Failed!");
		Assert.assertTrue(repoReportPage.getAccDevEqTableDateHeader4EfficiencyReport().contains("01-01"), "Get Acc Dev Eq Table Header Date for Efficiency Report Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccDevEqTableHeaderContributor"}, alwaysRun = true)
	public void testAccDevEqTableRowToCol() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accDevEqTableRowToCol4EfficiencyReport();
		
		Assert.assertEquals(repoReportPage.getAccDevEqTableCellsCount4EfficiencyReport(), 12, "Get Acc Dev Eq Table Row to Col for Efficiency Report Failed!");
	}
}
