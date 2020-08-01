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
	public void testModularityLabel4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.modularityLabel4Radar();
		Assert.assertTrue(repoReportPage.getRadarTooltip(), "Modularity for Radar Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testModularityLabel4Radar"}, alwaysRun = true)
	public void testCodebaseGrowthLabel4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.codebaseGrowthLabel4Radar();
		Assert.assertTrue(repoReportPage.getRadarTooltip(), "Codebase Growth for Radar Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCodebaseGrowthLabel4Radar"}, alwaysRun = true)
	public void testTeamRobustnessLabel4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.teamRobustnessLabel4Radar();
		Assert.assertTrue(repoReportPage.getRadarTooltip(), "Team Robustness for Radar Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTeamRobustnessLabel4Radar"}, alwaysRun = true)
	public void testTeamRobustnessDetailPage4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.teamRobustnessDetailPage4Radar();
		
		Assert.assertEquals(repoReportPage.getFunctionPageHeader(), "团队鲁棒性", "Navigate to Team Robustness Detail Page for Radar Failed!");
		
		repoReportPage.back();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTeamRobustnessDetailPage4Radar"}, alwaysRun = true)
	public void testCodebaseDrynessLabel4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.codebaseDrynessLabel4Radar();
		Assert.assertTrue(repoReportPage.getRadarTooltip(), "Codebase Dryness for Radar Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCodebaseDrynessLabel4Radar"}, alwaysRun = true)
	public void testCodebaseDrynessDetailPage4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.codebaseDrynessDetailPage4Radar();
		
		Assert.assertEquals(repoReportPage.getFunctionPageHeader(), "代码复用", "Navigate to Codebase Dryness Detail Page for Radar Failed!");
		
		repoReportPage.back();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCodebaseDrynessDetailPage4Radar"}, alwaysRun = true)
	public void testTestCoverageLabel4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testCoverageLabel4Radar();
		Assert.assertTrue(repoReportPage.getRadarTooltip(), "Test Coverage for Radar Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTestCoverageLabel4Radar"}, alwaysRun = true)
	public void testTestCoverageDetailPage4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.testCoverageDetailPage4Radar();
		
		Assert.assertEquals(repoReportPage.getFunctionPageHeader(), "测试覆盖度", "Navigate to Test Coverage Detail Page for Radar Failed!");
		
		repoReportPage.back();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTestCoverageDetailPage4Radar"}, alwaysRun = true)
	public void testDocCoverageLabel4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.docCoverageLabel4Radar();
		Assert.assertTrue(repoReportPage.getRadarTooltip(), "Doc Coverage Label for Radar Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDocCoverageLabel4Radar"}, alwaysRun = true)
	public void testDocCoverageDetailPage4Radar() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.docCoverageDetailPage4Radar();
		
		Assert.assertEquals(repoReportPage.getFunctionPageHeader(), "注释覆盖度", "Navigate to Doc Coverage Detail Page for Radar Failed!");
		
		repoReportPage.back();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDocCoverageDetailPage4Radar"}, alwaysRun = true)
	public void testTopContributorsAllTimeTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topContributorsAllTimeTab();
		
		Assert.assertTrue(repoReportPage.getTopContributorsFirstLine().contains("#1"), "All Time Tab for Top Contributors Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopContributorsAllTimeTab"}, alwaysRun = true)
	public void testTopContributorsPastYearTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topContributorsPastYearTab();
		
		Assert.assertTrue(repoReportPage.getTopContributorsFirstLine().contains("#1"), "Past Year Tab for Top Contributors Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopContributorsPastYearTab"}, alwaysRun = true)
	public void testTopContributorsPastMonthTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topContributorsPastMonthTab();
		
		Assert.assertTrue(repoReportPage.getTopContributorsFirstLine().contains("#1"), "Past Month Tab for Top Contributors Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopContributorsPastMonthTab"}, alwaysRun = true)
	public void testTopContributorsPastWeekTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topContributorsPastWeekTab();
		
		Assert.assertTrue(repoReportPage.getTopContributorsFirstLine().contains("#1"), "Past Month Tab for Top Contributors Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopContributorsPastWeekTab"}, alwaysRun = true)
	public void testTopContributorsDetailLink() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topContributorsDetailLink();
		
		Assert.assertEquals(repoReportPage.getFunctionPageHeader(), "贡献者列表", "Navigate to Contributors Detail Page Failed!");
		
		repoReportPage.back();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopContributorsDetailLink"}, alwaysRun = true)
	public void testTopCommitsAllTimeTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topCommitsAllTimeTab();
		
		Assert.assertTrue(repoReportPage.getTopCommitsFirstLine().contains("#1"), "All Time Tab for Top Commits Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopCommitsAllTimeTab"}, alwaysRun = true)
	public void testTopCommitsPastYearTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topCommitsPastYearTab();
		
		Assert.assertTrue(repoReportPage.getTopCommitsFirstLine().contains("#1"), "Past Year Tab for Top Commits Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopCommitsPastYearTab"}, alwaysRun = true)
	public void testTopCommitsPastMonthTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topCommitsPastMonthTab();
		
		Assert.assertTrue(repoReportPage.getTopCommitsFirstLine().contains("#1"), "Past Month Tab for Top Commits Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopCommitsPastMonthTab"}, alwaysRun = true)
	public void testTopCommitsPastWeekTab() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topCommitsPastWeekTab();
		
		Assert.assertTrue(repoReportPage.getTopCommitsFirstLine().contains("#1"), "Past Month Tab for Top Commits Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testTopCommitsPastWeekTab"}, alwaysRun = true)
	public void testTopCommitsDetailLink() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.topCommitsDetailLink();
		
		Assert.assertEquals(repoReportPage.getFunctionPageHeader(), "提交列表", "Navigate to Commits Detail Page Failed!");
		
		repoReportPage.back();
	}
}
