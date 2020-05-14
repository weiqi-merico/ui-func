package com.merico.selenium.test.ee.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.merico.selenium.page.PageUrlMapping;
import com.merico.selenium.page.factory.PageFactory;
import com.merico.selenium.page.support.DefaultUrlNavigator;
import com.merico.selenium.test.CasePriority;
import com.merico.selenium.test.TestBase;
import com.merico.selenium.test.ee.data.TestDataProvider;
import com.merico.selenium.test.ee.page.LoginPage;
import com.merico.selenium.test.ee.page.LogoutPage;
import com.merico.selenium.test.ee.utils.Crypt;

public class LoginPageTest extends TestBase {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	protected void initBeforeClass() {
		// TODO Auto-generated method stub
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		String targetUrl = PageUrlMapping.getAbsoluteUrl(LoginPage.class);
		new DefaultUrlNavigator().doNavigation(driver, targetUrl);
	}
	
	@AfterMethod(alwaysRun = true)
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
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "loginData4LdapProvider", dataProviderClass = TestDataProvider.class, alwaysRun = true)
	public void testLogin4Ldap(String username, String password, Crypt crypt) throws Exception {
		LoginPage loginPage = PageFactory.createPage(LoginPage.class, driver);
		loginPage.inputUsernameAndPwd(username, crypt.decrypt(password));
		loginPage.login4Ldap();

		Assert.assertTrue(loginPage.getAccountName().contains("bill"), "LDAP login failed!");
	}

//	@Test(groups = {CasePriority.BVT}, dataProvider = "createTTDataProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testLogin"}, alwaysRun = true)
//	public void testCreateTT(String serviceDir, String ccReceiver) {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.createTT(serviceDir, ccReceiver);
//
//		Assert.assertEquals(createTTPage.getTTTitleInDetail(), TestDataProvider.TT_Title, "TT创建失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCreateTT"}, alwaysRun = true)
//	public void testUpdateTTLevel() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.updateTTLevel();
//
//		Assert.assertEquals(createTTPage.getTTLevelPrompt(), TestDataProvider.TT_Level_Update_Success_Prompt, "TT等级修改失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testUpdateTTLevel"}, alwaysRun = true)
//	public void testStartProcessingTT() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.startProcessingTT();
//
//		Assert.assertEquals(createTTPage.getTTStartProcessingPrompt(), TestDataProvider.TT_Start_Processing_Prompt, "TT开始处理失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testStartProcessingTT"}, alwaysRun = true)
//	public void testProcessingCompletionTT() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.completeProcessingTT();
//
//		Assert.assertEquals(createTTPage.getTTCompleteProcessingPrompt(), TestDataProvider.TT_Processing_Complete_Prompt, "TT处理完成失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testProcessingCompletionTT"}, alwaysRun = true)
//	public void testCloseTT() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.closeTT();
//
//		Assert.assertEquals(createTTPage.getCloseTTPrompt(), TestDataProvider.TT_Close_Prompt, "TT关闭失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCloseTT"}, alwaysRun = true)
//	public void testReProcessingTT() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.reProcessingTT();
//
//		Assert.assertEquals(createTTPage.getReProcessingTTPrompt(), TestDataProvider.TT_ReProcessing_Prompt, "TT重新处理失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testReProcessingTT"}, alwaysRun = true)
//	public void testSuspendTT() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.suspendTT();
//
//		Assert.assertEquals(createTTPage.getSuspendedTTPrompt(), TestDataProvider.TT_Suspended_Prompt, "TT暂停失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dataProvider = "tranferTTDataProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testSuspendTT"}, alwaysRun = true)
//	public void testTransferTT(String serviceDir) {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.transferTT(serviceDir);
//
//		Assert.assertEquals(createTTPage.getTransferTTPrompt(), TestDataProvider.TT_Transfer_Prompt, "TT流转失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dataProvider = "addCCInTTDetailDataProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testTransferTT"}, alwaysRun = true)
//	public void testAddCCInTTDetail(String ccReceiver) {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.addCCInTTDetail(ccReceiver);
//
//		Assert.assertEquals(createTTPage.getAddCCInTTDetailPrompt(), TestDataProvider.TT_Add_CC_Prompt, "TT添加抄送人失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dataProvider = "associateTTPrefixDataProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testAddCCInTTDetail"}, alwaysRun = true)
//	public void testAssociateTT(String associateTTrefix) {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.associateTT(associateTTrefix);
//
//		Assert.assertEquals(createTTPage.getAssociateTTPrompt(), TestDataProvider.Associate_TT_Prompt, "关联TT失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAssociateTT"}, alwaysRun = true)
//	public void testDelAssociateTT() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.deleteAssociateTT();
//
//		Assert.assertEquals(createTTPage.getDelAssociateTTPrompt(), TestDataProvider.Del_Associate_TT_Prompt, "删除关联TT失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dataProvider = "associateCOEDataProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testDelAssociateTT"}, alwaysRun = true)
//	public void testAssociateCOE(String associateCOELink) {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.associateCOE(associateCOELink);
//
//		Assert.assertEquals(createTTPage.getAssociateCOEPrompt(), TestDataProvider.Associate_COE_Prompt, "关联COE失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAssociateCOE"}, alwaysRun = true)
//	public void testDelAssociateCOE() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.deleteAssociateCOE();
//
//		Assert.assertEquals(createTTPage.getAssociateCOEPrompt(), TestDataProvider.Del_Associate_COE_Prompt, "删除关联COE失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testDelAssociateCOE"}, alwaysRun = true)
//	public void testUpdateTTPermission4Private() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.updateTTPermission4Private();
//
//		Assert.assertEquals(createTTPage.getTTUpdatePermissonPrompt(), TestDataProvider.Update_TT_Permmison_Prompt, "TT修改为保密失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testUpdateTTPermission4Private"}, alwaysRun = true)
//	public void testUpdateTTPermission4Public() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.updateTTPermission4Public();
//
//		Assert.assertEquals(createTTPage.getTTUpdatePermissonPrompt(), TestDataProvider.Update_TT_Permmison_Prompt, "TT修改为公开失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testUpdateTTPermission4Public"}, alwaysRun = true)
//	public void testCreateOnesFromTT() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.createOnesFromTT();
//
//		Assert.assertEquals(createTTPage.getCreateOnesFromTTPrompt(), TestDataProvider.Ones_Create_Prompt, "一键创建Ones失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testCreateOnesFromTT"}, alwaysRun = true)
//	public void testUpdateTTType() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.updateTTType();
//
//		Assert.assertEquals(createTTPage.getUpdateTTTypePrompt(), TestDataProvider.Update_TT_Type_Prompt, "修改TT类型失败");
//	}
//
//	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testUpdateTTType"}, alwaysRun = true)
//	public void testAddComment() {
//		CreateVdevPage createTTPage = PageFactory.createPage(CreateVdevPage.class, driver);
//		createTTPage.addComment();
//
//		Assert.assertEquals(createTTPage.getDelCommentPrompt(), TestDataProvider.Add_Comment_Prompt, "添加评论失败");
//	}
}
