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
import com.merico.selenium.test.ee.page.TeamViewPage;
import com.merico.selenium.test.ee.utils.Crypt;

public class TeamViewTest extends TestBase {
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
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testLogin4Admin"}, alwaysRun = true)
	public void testSearchDeveloper() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.searchDeveloper();

		Assert.assertEquals(teamViewPage.getSearchCssStatus(), "rgba(255, 255, 66, 1)", "Search Developer failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchDeveloper"}, alwaysRun = true)
	public void testEffiencyAsc() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.efficiencyAsc();

		Assert.assertEquals(teamViewPage.getEfficiencyDataFlag(), "无数据", "Efficiency Asc failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEffiencyAsc"}, alwaysRun = true)
	public void testQualityAsc() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.qualityAsc();

		Assert.assertTrue(teamViewPage.getQualityDataFlag().contains("%"), "Quality Asc failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testQualityAsc"}, alwaysRun = true)
	public void testQualityDesc() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.qualityDesc();

		Assert.assertTrue(teamViewPage.getQualityDataFlag().contains("无数据"), "Quality Desc failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testQualityDesc"}, alwaysRun = true)
	public void testAtoZSort() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.aTozSort();
		
		Assert.assertEquals(teamViewPage.getCharSortDataFlag(), "Analysis Engine", "A to Z Sort failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAtoZSort"}, alwaysRun = true)
	public void testZtoASort() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.zToaSort();
		
		Assert.assertEquals(teamViewPage.getCharSortDataFlag(), "运维部", "A to Z Sort failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testZtoASort"}, alwaysRun = true)
	public void testTimeRange4PastWeek() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastWeek();
		
		Assert.assertEquals(teamViewPage.getRootNodeDataFlag(), "Merico", "Data Range for Past Week failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastWeek"}, alwaysRun = true)
	public void testTimeRange4PastTwoWeek() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastTwoWeek();
		
		Assert.assertEquals(teamViewPage.getRootNodeDataFlag(), "Merico", "Data Range for Past Week failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastTwoWeek"}, alwaysRun = true)
	public void testTimeRange4PastThreeMonths() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastThreeMonths();
		
		Assert.assertEquals(teamViewPage.getRootNodeDataFlag(), "Merico", "Data Range for Past Week failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastThreeMonths"}, alwaysRun = true)
	public void testTimeRange4PastOneYear() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastOneYear();
		
		Assert.assertEquals(teamViewPage.getRootNodeDataFlag(), "Merico", "Data Range for Past Week failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastOneYear"}, alwaysRun = true)
	public void testMemberTooltip() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.memberTooltip();
		
		Assert.assertTrue(teamViewPage.getTooltipVal().contains("成员"), "Member Tooltip Render failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testMemberTooltip"}, alwaysRun = true)
	public void testSubGroupTooltip() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.subGroupTooltip();
		
		Assert.assertTrue(teamViewPage.getTooltipVal().contains("团队"), "Subgroup Tooltip Render failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSubGroupTooltip"}, alwaysRun = true)
	public void testTimeRageOfPastWeek4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRangeOfPastWeek4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Time Range of Past Week for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRageOfPastWeek4TDV"}, alwaysRun = true)
	public void testTimeRageOfPastTwoWeek4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRangeOfPastTwoWeek4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Time Range of Past Two Week for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRageOfPastTwoWeek4TDV"}, alwaysRun = true)
	public void testTimeRageOfPastThreeMonths4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRangeOfPastThreeMonths4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Time Range of Past Three Months for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRageOfPastThreeMonths4TDV"}, alwaysRun = true)
	public void testTimeRageOfPastOneYear4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRangeOfPastOneYear4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Time Range of Past One Year for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRageOfPastOneYear4TDV"}, alwaysRun = true)
	public void testCodeNumberOfProductivity4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.codeNumberOfProductivity4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Code Number Of Productivity for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCodeNumberOfProductivity4TDV"}, alwaysRun = true)
	public void testCommitNumberOfProductivity4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.commitNumberOfProductivity4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Commit Number Of Productivity for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCommitNumberOfProductivity4TDV"}, alwaysRun = true)
	public void testProductivityStepOfWeek4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.productivityStepByWeek4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Productivity Step of Week for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testProductivityStepOfWeek4TDV"}, alwaysRun = true)
	public void testProductivityStepOfMonth4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.productivityStepByMonth4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Productivity Step of Month for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testProductivityStepOfMonth4TDV"}, alwaysRun = true)
	public void testProductivityStepOfQuarter4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.productivityStepByQuarter4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Productivity Step of Month for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testProductivityStepOfMonth4TDV"}, alwaysRun = true)
	public void testProductivityStepOfYear4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.productivityStepByYear4TDV();
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Productivity Step of Month for Team Detail View failed!");
	}
}
