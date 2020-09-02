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
//		Assert.assertTrue(teamViewPage.getQualityDataFlag().contains("大幅"), "Quality Asc failed!");
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
		
		Assert.assertEquals(teamViewPage.getProductivityLabelVal(), "团队生产力", "Productivity Step of Year for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testProductivityStepOfYear4TDV"}, alwaysRun = true)
	public void testQualityStepOfMonth4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.qualityStepByMonth4TDV();
		
		Assert.assertEquals(teamViewPage.getQualityLabelVal(), "团队质量", "Quality Step of Month for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testQualityStepOfMonth4TDV"}, alwaysRun = true)
	public void testQualityStepOfQuarter4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.qualityStepByQuarter4TDV();
		
		Assert.assertEquals(teamViewPage.getQualityLabelVal(), "团队质量", "Quality Step of Quarter for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testQualityStepOfQuarter4TDV"}, alwaysRun = true)
	public void testQualityStepOfYear4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.qualityStepByYear4TDV();
		
		Assert.assertEquals(teamViewPage.getQualityLabelVal(), "团队质量", "Quality Step of Year for Team Detail View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testQualityStepOfYear4TDV"}, alwaysRun = true)
	public void testSearchTeamMember4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.searchTeamMember4TDV();
		
		Assert.assertEquals(teamViewPage.getTeamMember(), "wei.qi@meri.co", "Search Team Member failed!");
		
		teamViewPage.closeTeamMemberFlag4TDV();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSearchTeamMember4TDV"}, alwaysRun = true)
	public void testTeamMemberSortByEfficiencyAsc4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.teamMemberSortByEfficiencyAsc4TDV();
		
		Assert.assertEquals(teamViewPage.getEfficiencyDataFlag4TDV(), "无数据", "Team Member Sort By Efficiency ASC failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTeamMemberSortByEfficiencyAsc4TDV"}, alwaysRun = true)
	public void testTeamMemberSortByQualityDesc4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.teamMemberSortByQualityDesc4TDV();
		
		Assert.assertEquals(teamViewPage.getQualityDataFlag4TDV(), "质量", "Team Member Sort By Quality DESC failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTeamMemberSortByQualityDesc4TDV"}, alwaysRun = true)
	public void testTeamMemberSortByQualityAsc4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.teamMemberSortByQualityAsc4TDV();
		
		Assert.assertEquals(teamViewPage.getQualityNoDataFlag4TDV(), "无数据", "Team Member Sort By Quality ASC failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTeamMemberSortByQualityAsc4TDV"}, alwaysRun = true)
	public void testTeamMemberSortByAtoZ4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.teamMemberSortByAtoZ4TDV();
		
		Assert.assertEquals(teamViewPage.getTeamMember(), "4kvfbg6w@linshiyouxiang.net", "Team Member Sort By A to Z failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTeamMemberSortByAtoZ4TDV"}, alwaysRun = true)
	public void testTeamMemberSortByZtoA4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.teamMemberSortByZtoA4TDV();
		
		Assert.assertEquals(teamViewPage.getTeamMember(), "jinglei@meri.co", "Team Member Sort By Z to A failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTeamMemberSortByZtoA4TDV"}, alwaysRun = true)
	public void testPagingRightAngleBracket4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.pagingRightAngleBracket4TDV();
		
		Assert.assertFalse(teamViewPage.getTeamMember().contains("jinglei@meri.co"), "Paging Right Angle Bracket failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagingRightAngleBracket4TDV"}, alwaysRun = true)
	public void testPagingLeftAngleBracket4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.pagingLeftAngleBracket4TDV();
		
		Assert.assertTrue(teamViewPage.getTeamMember().contains("jinglei@meri.co"), "Paging Left Angle Bracket failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagingLeftAngleBracket4TDV"}, alwaysRun = true)
	public void testPagingToPageTwo4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.pagingToPageTwo4TDV();
		
		Assert.assertFalse(teamViewPage.getTeamMember().contains("jinglei@meri.co"), "Paging To Page 2 failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagingToPageTwo4TDV"}, alwaysRun = true)
	public void testPagingToPageOne4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.pagingToPageOne4TDV();
		
		Assert.assertTrue(teamViewPage.getTeamMember().contains("jinglei@meri.co"), "Paging To Page 1 failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagingToPageOne4TDV"}, alwaysRun = true)
	public void testPagingSwitchPage4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.pagingSwitchPage4TDV();
		
//		Assert.assertEquals(teamViewPage.getPagingTotalItems4TDV(), 20, "Switch Page failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagingSwitchPage4TDV"}, alwaysRun = true)
	public void testPagingInputPage4TDV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.pagingInputPage4TDV();
		
		Assert.assertTrue(teamViewPage.getTeamMember().contains("jinglei@meri.co"), "Input Page Number failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testPagingInputPage4TDV"}, alwaysRun = true)
	public void testDeveloperName4TDevV() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.DeveloperName4TDevV();
		
		Assert.assertTrue(teamViewPage.getDeveloperName4TDevV().contains("Yanghui Lin"), "Get Developer Name failed!");
		Assert.assertTrue(teamViewPage.getDeveloperEmail4TDevV().contains("yanghui@meri.co"), "Get Developer Email failed!");
		Assert.assertTrue(teamViewPage.getMainCodeRepo4TDevV().contains("主要代码库"), "Get Main Code Repo failed!");
		Assert.assertTrue(teamViewPage.getTopSkills4TDevV().contains("最有价值技能"), "Get Top Skills failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDeveloperName4TDevV"}, alwaysRun = true)
	public void testTimeRange4PastWeek4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastWeek4TDevv();
		
		Assert.assertTrue(teamViewPage.getDevProductivityLabel4TDevV().contains("开发者生产力"), "Time Range of Past Week for TDev View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastWeek4TDevv"}, alwaysRun = true)
	public void testTimeRange4PastTwoWeek4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastTwoWeek4TDevv();
		
		Assert.assertTrue(teamViewPage.getDevProductivityLabel4TDevV().contains("开发者生产力"), "Time Range of Past Two Week for TDev View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastTwoWeek4TDevv"}, alwaysRun = true)
	public void testTimeRange4PastThreeMonths4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastThreeMonths4TDevv();
		
		Assert.assertTrue(teamViewPage.getQualityLabel4TDevV().contains("质量"), "Time Range of Past Three Months for TDev View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastThreeMonths4TDevv"}, alwaysRun = true)
	public void testTimeRange4PastOneYear4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.timeRange4PastOneYear4TDevv();
		
		Assert.assertTrue(teamViewPage.getIssueRateLabel4TDevV().contains("问题率"), "Time Range of Past One Year for TDev View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTimeRange4PastOneYear4TDevv"}, alwaysRun = true)
	public void testDevproductivityStepByWeek4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.devproductivityStepByWeek4TDV();
		
		Assert.assertTrue(teamViewPage.getDevProductivityLabel4TDevV().contains("开发者生产力"), "Step by Week for TDev View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevproductivityStepByWeek4TDevv"}, alwaysRun = true)
	public void testDevproductivityStepByMonth4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.devproductivityStepByMonth4TDV();
		
		Assert.assertTrue(teamViewPage.getDocCoverageLabel4TDevV().contains("注释覆盖度"), "Step by Month for TDev View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevproductivityStepByMonth4TDevv"}, alwaysRun = true)
	public void testDevproductivityStepByQuarter4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.devproductivityStepByQuarter4TDV();
		
		Assert.assertTrue(teamViewPage.getTestCoverageLabel4TDevV().contains("测试覆盖度"), "Step by Quarter for TDev View failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevproductivityStepByQuarter4TDevv"}, alwaysRun = true)
	public void testDevproductivityStepByYear4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.devproductivityStepByYear4TDV();
		
		Assert.assertTrue(teamViewPage.getModularityLabel4TDevV().contains("模块性"), "Step by Year for TDev View failed!");
	}
	

	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDevproductivityStepByYear4TDevv"}, alwaysRun = true)
	public void testCodeLineOfProductivity4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.codeLineOfProductivity4TDevv();
		
		Assert.assertTrue(teamViewPage.getDevProductivityLabel4TDevV().contains("开发者生产力"), "Code Line for TDev View failed!");
	}
	

	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCodeLineOfProductivity4TDevv"}, alwaysRun = true)
	public void testCommitNumberOfProductivity4TDevv() throws Exception {
		TeamViewPage teamViewPage = PageFactory.createPage(TeamViewPage.class, driver);
		teamViewPage.commitNumberOfProductivity4TDevv();
		
		Assert.assertTrue(teamViewPage.getDevProductivityLabel4TDevV().contains("开发者生产力"), "Commit Number for TDev View failed!");
	}
}
