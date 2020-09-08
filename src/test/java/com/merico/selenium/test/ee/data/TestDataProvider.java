package com.merico.selenium.test.ee.data;

import org.testng.annotations.DataProvider;

import com.merico.selenium.test.ee.utils.Crypt;

public class TestDataProvider {

	public static String projectGroupName = "AutoProjectGroup_" + System.currentTimeMillis();

	@DataProvider(name="loginData4AdminProvider")
	public static Object[][] loginData4AdminProviderImpl() throws Exception {

		String pwd4Admin = "himerico";
		
		Crypt crypt = new Crypt();
		
		return new Object[][]{
				{"autotest@test.com", crypt.encrypt(pwd4Admin), crypt}
		};
	}
	
	@DataProvider(name="loginData4LdapProvider")
	public static Object[][] loginData4LdapProviderImpl() throws Exception {

		String pwd4Ldap = "aakkkbbb123";
		
		Crypt crypt = new Crypt();
		
		return new Object[][]{
				{"billyp", crypt.encrypt(pwd4Ldap), crypt}
		};
	}

	@DataProvider(name="addRepoDirectlyProvider")
	public static Object[][] addRepoDirectlyProviderImpl() throws Exception {

		String repoUrl = "https://github.com/kubernetes/kubernetes.git";
		
		return new Object[][]{
				{ repoUrl }
		};
	}
	
	@DataProvider(name="addRepoWithSecretProvider")
	public static Object[][] addRepoWithSecretProviderImpl() throws Exception {

		String repoUrl = "https://github.com/51ias/gloudapi2.git";
		String pwd4Git = "js0205081q2w3e";
		
		Crypt crypt = new Crypt();
		
		return new Object[][]{
				{ repoUrl, "qiwei-51ias", crypt.encrypt(pwd4Git), crypt }
		};
	}
	
	@DataProvider(name="focusProjectGroupProvider")
	public static Object[][] focusProjectGroupProviderImpl() throws Exception {
		
		return new Object[][]{
				{ "Merico" }
		};
	}
	
	@DataProvider(name="searchRepoProvider")
	public static Object[][] searchRepoProviderImpl() throws Exception {
		
		String repoUrl = "git@gitlab.com:meri.co/vdev.co.git";
		
		return new Object[][]{
				{ repoUrl }
		};
	}
	
	@DataProvider(name="saveGitlabAddrInfoProvider")
	public static Object[][] saveGitlabAddrInfoProviderImpl() throws Exception {
		
		String gitlabAddr = "http://i.test.meri.co:8022";
		String appId = "fa60766f4407e7297d87b4c300ff655b32215408ab9456d9c3fa4d5b486ed132";
		String secret = "48ce03284944ac98bf1b10ba30d65c1c9ed2a3840826311a5514f7660ea2c5aa";
		
		return new Object[][]{
				{ gitlabAddr, appId, secret }
		};
	}
	
	@DataProvider(name="smtpInfoProvider")
	public static Object[][] smtpInfoProviderImpl() throws Exception {
		
		String email = "himerico@163.com";
		String password = "EPJFWNGAGZBPLZNJ";
		String smtp = "smtp.163.com:465";
		
		return new Object[][]{
				{ email, password, smtp }
		};
	}
	
	@DataProvider(name="oauthInfoProvider")
	public static Object[][] oauthInfoProviderImpl() throws Exception {
		
		String siteUrl = "http://114.116.225.29:5555";
		String appId = "auth-code-client-i-test";
		String appSecret = "secret";
		
		return new Object[][]{
				{ siteUrl, appId, appSecret }
		};
	}
}
