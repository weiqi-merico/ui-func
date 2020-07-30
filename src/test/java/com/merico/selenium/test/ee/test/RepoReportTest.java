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

public class RepoReportTest extends TestBase {
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
	public void testFocusProjectGroup(String repoUrl) throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.searchRepoByNameOrGitAddr(repoUrl);
		Assert.assertEquals(repoReportPage.getGeneralReportHeader(), "综合报告", "Get General Report Header Name Failed!");
		repoReportPage.analysisRecently();
		Assert.assertEquals(repoReportPage.getHashCopyTooltip(), "复制成功", "Get Hash Copy Tooltip Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFocusProjectGroup"}, alwaysRun = true)
	public void testAccumulationDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.accumulationDevEq();
		Assert.assertTrue(repoReportPage.getDevEqCanvas(), "Get Accumulation Dev Eq Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAccumulationDevEq"}, alwaysRun = true)
	public void testDailyDevEq() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.dailyDevEq();
		Assert.assertTrue(repoReportPage.getDevEqCanvas(), "Get Daily Dev Eq Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDailyDevEq"}, alwaysRun = true)
	public void testModularity4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.modularity4Radar();
		Assert.assertTrue(repoReportPage.getRadarTooltip(), "Modularity for Radar Failed!");
	}
}
