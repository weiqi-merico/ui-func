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
import com.merico.selenium.test.ee.page.AddRepoPage;
import com.merico.selenium.test.ee.page.LoginPage;
import com.merico.selenium.test.ee.page.LogoutPage;
import com.merico.selenium.test.ee.utils.Crypt;

public class AddRepoDirectlyTest extends TestBase {
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
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "addRepoDirectlyProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testLogin4Admin"}, alwaysRun = true)
	public void testAddRepoDirectly(String repoUrl) throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.addRepoDirectly(repoUrl);
	
		Assert.assertTrue(addRepoPage.getAddedRepoName().contains("kubernetes"), "Add Repository Directly Failed!");
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "addRepoDirectlyProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testAddRepoDirectly"}, alwaysRun = true)
	public void testAddExistedRepoDirectly(String repoUrl) throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.addExistedRepoDirectly(repoUrl);
	
		Assert.assertEquals("代码库已存在", addRepoPage.getRepoExistedErrPromptMsg(), "Add Existed Repo Directly Failed!");
		
		addRepoPage.cancelAddRepo();
	}
	
	@Test(groups = {CasePriority.BVT}, dataProvider = "addRepoDirectlyProvider", dataProviderClass = TestDataProvider.class, dependsOnMethods = {"testAddRepoDirectly"}, alwaysRun = true)
	public void testDelRepo(String repoUrl) throws Exception {
		AddRepoPage addRepoPage = PageFactory.createPage(AddRepoPage.class, driver);
		addRepoPage.delAddedRepo(repoUrl);
		
		Assert.assertEquals("暂无数据", addRepoPage.getNoDataPromptMsg(), "Delete Repo Directly Failed!");
	}
}
