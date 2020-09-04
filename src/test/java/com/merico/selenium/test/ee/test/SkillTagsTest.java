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

public class SkillTagsTest extends TestBase {
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
	public void testSortByLanguageDesc() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.navigateToSettings();
		settingsPage.navigateToSkillTags();
		settingsPage.sortByLanguage4SkillTags();
		
		Assert.assertEquals(settingsPage.getLanguage4SkillTags(), "javascript", "Sort By Language DESC for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByLanguageDesc"}, alwaysRun = true)
	public void testSortByLanguageAsc() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.sortByLanguage4SkillTags();
		
		Assert.assertEquals(settingsPage.getLanguage4SkillTags(), "c", "Sort By Language ASC for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByLanguageAsc"}, alwaysRun = true)
	public void testSortByTagsAsc() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.sortByTags4SkillTags();
		
		Assert.assertEquals(settingsPage.getTags4SkillTags(), "增加标签", "Sort By Skill Tags ASC for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByTagsAsc"}, alwaysRun = true)
	public void testSortByTagsDesc() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.sortByTags4SkillTags();
		
		Assert.assertTrue(settingsPage.getTags4SkillTags().contains("网络相关"), "Sort By Skill Tags DESC for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testSortByTagsDesc"}, alwaysRun = true)
	public void testFilterByToolsSource() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.filterByToolsSource4SkillTags();
		
		Assert.assertTrue(settingsPage.getToolsSource4SkillTags().contains("lz"), "Filter By Tools Source for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFilterByToolsSource"}, alwaysRun = true)
	public void testFilterResetByToolsSource() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.filterResetByToolsSource4SkillTags();
		
		Assert.assertFalse(settingsPage.getToolsSource4SkillTags().contains("lz"), "Filter Reset By Tools Source for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFilterResetByToolsSource"}, alwaysRun = true)
	public void testFilterByLanguage() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.filterByLanguage4SkillTags();
		
		Assert.assertEquals(settingsPage.getLanguage4SkillTags(), "go", "Filter By Language for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFilterByLanguage"}, alwaysRun = true)
	public void testFilterResetByLanguage() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.filterResetByLanguage4SkillTags();
		
		Assert.assertEquals(settingsPage.getLanguage4SkillTags(), "java", "Filter Reset By Language for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFilterResetByLanguage"}, alwaysRun = true)
	public void testFilterByTags() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.filterByTags4SkillTags();
		
		Assert.assertTrue(settingsPage.getTags4SkillTags().contains("Web 前端"), "Filter By Tags for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFilterByTags"}, alwaysRun = true)
	public void testFilterResetByTags() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.filterResetByTags4SkillTags();
		
		Assert.assertFalse(settingsPage.getTags4SkillTags().contains("Web 前端"), "Filter Reset By Tags for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testFilterResetByTags"}, alwaysRun = true)
	public void testNewTag() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.newTags4SkillTags(settingsPage.tagName);
		
		Assert.assertEquals(settingsPage.getNewTagName4SkillTags(), settingsPage.tagName,  "New Tag for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testNewTag"}, alwaysRun = true)
	public void testEditTag() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.editTags4SkillTags(settingsPage.tagName);
		
		Assert.assertEquals(settingsPage.getNewTagName4SkillTags(), settingsPage.tagName + " Updated",  "Edit Tag for Skill Tags Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEditTag"}, alwaysRun = true)
	public void testDeleteTag() throws Exception {
		SettingsPage settingsPage = PageFactory.createPage(SettingsPage.class, driver);
		settingsPage.deleteTags4SkillTags();
	}
}
