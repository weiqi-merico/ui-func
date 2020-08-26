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

public class GroupTalentSearchTest extends TestBase {
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
	public void testTalentSearch() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.talentSearch4TalentSearch();
		
		Assert.assertTrue(repoReportPage.talentSearchResult4TalentSearch().contains("rgb(255, 255, 0)"), "Talent Search for Talent Search Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTalentSearch"}, alwaysRun = true)
	public void testTalentSearchLonely() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.talentSearchLonely4TalentSearch();
		
//		Assert.assertTrue(repoReportPage.getHashCopyTooltip().contains("远程过程调用"), "Individual Info Tooltip for Talent Search Failed!");
		Assert.assertTrue(repoReportPage.talentSearchResult4TalentSearch().contains("rgb(255, 255, 0)"), "Talent Search Lonely for Talent Search Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTalentSearchLonely"}, alwaysRun = true)
	public void testViewIndividualDetail() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.viewIndividualDetail4TalentSearch();
		
		Assert.assertNotEquals(repoReportPage.getIndividualDetail4TalentSearch(), 0, "View Talent Individual Detail for Talent Search Failed!");
	}
}
