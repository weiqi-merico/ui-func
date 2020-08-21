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

public class GroupMembersTest extends TestBase {
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
	public void testAddDevMembers() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.addDevMember4Members();
		
		Assert.assertTrue(repoReportPage.getEmailInfo4Members().contains("members@linshiyouxiang.net"), "Add Dev Member for Members Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAddDevMembers"}, alwaysRun = true)
	public void testModifyRoleToTeamLeader() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.modifyRoleToTeamLeader4Members();
		
		Assert.assertTrue(repoReportPage.getTeamLeaderInfo4Members().contains("项目负责人"), "Modify Member Role To Team Leader for Members Failed!");
		repoReportPage.delMember4Members();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testModifyRoleToTeamLeader"}, alwaysRun = true)
	public void testInviteTeamLeaderMember() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.inviteTeamLeaderMember4Members();
		
		Assert.assertTrue(repoReportPage.getInvitedTeamLeaderInfo4Members().contains("invited@autotest.com"), "Invite Team Leader for Members Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testInviteTeamLeaderMember"}, alwaysRun = true)
	public void testModifyInvitedMember() throws Exception {
		RepoReportPage repoReportPage = PageFactory.createPage(RepoReportPage.class, driver);
		repoReportPage.modifyInvitedMemberRole4Members();
		
		Assert.assertTrue(repoReportPage.getDevInfo4Members().contains("开发者"), "Modify Invited Team Member To Dev for Members Failed!");
		repoReportPage.cancelInvitedMembers4Members();
	}
}
