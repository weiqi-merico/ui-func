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
import com.merico.selenium.test.ee.page.SettingsPage;
import com.merico.selenium.test.ee.utils.Crypt;

public class PersonnelTest extends TestBase {
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
	public void testAddMember() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.navigateToSettings();
		settingsPage.addMember4Personnel();
		settingsPage.searchAddedMember4Personnel();
		
		Assert.assertEquals(settingsPage.getAddedMember4Personnel(), settingsPage.email.toLowerCase(), "Add Member for Personnel Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAddMember"}, alwaysRun = true)
	public void testEditMember() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.editMember4Personnel();
		
		Assert.assertEquals(settingsPage.getEditMemberPrivilege4Personnel(), "管理员", "Edit Member for Personnel Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEditMember"}, alwaysRun = true)
	public void testEnableMember() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.enableMember4Personnel();
		
		Assert.assertEquals(settingsPage.getEnableMemberStatus4Personnel(), "已启用", "Enable Member for Personnel Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEnableMember"}, alwaysRun = true)
	public void testDisableMember() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.enableMember4Personnel();
		
		Assert.assertEquals(settingsPage.getEnableMemberStatus4Personnel(), "已禁用", "Disable Member for Personnel Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDisableMember"}, alwaysRun = true)
	public void testResetMember() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.resetMember4Personnel();
		
		Assert.assertEquals(settingsPage.getResetMemberPasswordCopyTooltip4MetricsComparison(), "Copied", "Reset Member for Personnel Failed!");
		settingsPage.resetMemberOk4Personnel();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testResetMember"}, alwaysRun = true)
	public void testDeleteMember() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.deleteMember4Personnel();
		
		Assert.assertEquals(settingsPage.getMemberNoDataDesc4MetricsComparison(), "暂无数据", "Delete Member for Personnel Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDeleteMember"}, alwaysRun = true)
	public void testFixedPaging() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.fixedPagingJumper4Personnel();
		
		Assert.assertNotEquals(settingsPage.getfixedPagingRowCount4Personnel(), 20, "Fixed Paging for Personnel Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFixedPaging"}, alwaysRun = true)
	public void testPagingJumper() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.paginationJumper4Personnel();
		
		Assert.assertEquals(settingsPage.getPaginationFocus4Personnel(), "rgba(202, 69, 33, 1)", "Paging Jumper for Personnel Failed!");
	}
}
