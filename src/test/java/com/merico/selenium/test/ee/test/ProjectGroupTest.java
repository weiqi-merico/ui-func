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
import com.merico.selenium.test.ee.page.ProjectGroupPage;
import com.merico.selenium.test.ee.utils.Crypt;

public class ProjectGroupTest extends TestBase {
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
	public void testAddProjectGroup() throws Exception {
		ProjectGroupPage projectGroupPage = PageFactory.createPage(ProjectGroupPage.class, driver);
		projectGroupPage.addProjectGroup();
	//		Assert.assertEquals(projectGroupPage.getSearchResultItem(), TestDataProvider.projectGroupName.substring(17), "Add Project Group Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAddProjectGroup"}, alwaysRun = true)
	public void testAddSubProjectGroup() throws Exception {
		ProjectGroupPage projectGroupPage = PageFactory.createPage(ProjectGroupPage.class, driver);
		projectGroupPage.addSubProjectGroup();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testAddSubProjectGroup"}, alwaysRun = true)
	public void testEditSubProjectGroup() throws Exception {
		ProjectGroupPage projectGroupPage = PageFactory.createPage(ProjectGroupPage.class, driver);
		projectGroupPage.editProjectGroup();
	}
	
	@Test(groups = {CasePriority.BVT}, dependsOnMethods = {"testEditSubProjectGroup"}, alwaysRun = true)
	public void testDelProjectGroup() throws Exception {
		ProjectGroupPage projectGroupPage = PageFactory.createPage(ProjectGroupPage.class, driver);
		projectGroupPage.delProjectGroup();
	}
}
