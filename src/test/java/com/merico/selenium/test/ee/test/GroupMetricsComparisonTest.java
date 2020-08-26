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

public class GroupMetricsComparisonTest extends TestBase {
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
	public void testIntoOverallReport() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.enterIntoOverallReport();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testIntoOverallReport"}, alwaysRun = true)
	public void testTimeTooltip() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.timeTooltip4MetricsComparison();
		
		Assert.assertTrue(repoReportPage.getDateTimeTooltip4MetricsComparison().contains("仅对这些指标有效"), "Get Date Time Tooltip for Metrics Comparison Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeTooltip"}, alwaysRun = true)
	public void testRepoComparison() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.repoComparison4MetricsComparison();
		
		Assert.assertNotEquals(repoReportPage.getComparisonCount4MetricsComparison(), 2, "Get Repo Comparison Count for Metrics Comparison Failed!");
		repoReportPage.delComparison4MetricsComparison();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testRepoComparison"}, alwaysRun = true)
	public void testProjectGroupComparison() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.projectGroupComparison4MetricsComparison();
		
		Assert.assertNotEquals(repoReportPage.getComparisonCount4MetricsComparison(), 2, "Get Project Group Comparison Count for Metrics Comparison Failed!");
		repoReportPage.delComparison4MetricsComparison();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testProjectGroupComparison"}, alwaysRun = true)
	public void testErrExportDataMsg() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.errExportData4MetricsComparison();
		
		Assert.assertTrue(repoReportPage.getErrExportDataMsg4MetricsComparison().contains("数据尚未准备好"), "Get Error Export Data Msg for Metrics Comparison Failed!");
	}
}
