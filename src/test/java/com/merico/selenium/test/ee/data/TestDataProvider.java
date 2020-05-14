package com.merico.selenium.test.ee.data;

import org.testng.annotations.DataProvider;

import com.merico.selenium.test.ee.utils.Crypt;

public class TestDataProvider {

	public static String TT_Title = "EE-" + System.currentTimeMillis();

	@DataProvider(name="loginData4AdminProvider")
	public static Object[][] loginData4AdminProviderImpl() throws Exception {

		String pwd4Admin = "himerico";
		
		Crypt crypt = new Crypt();
		
		return new Object[][]{
				{"sigma@meri.co", crypt.encrypt(pwd4Admin), crypt}
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
}
