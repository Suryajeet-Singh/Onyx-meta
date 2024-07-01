package com.Onyx.TestCases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bwp.pageobjects.LoginPage;
import com.bwp.resources.BaseClass;

public class LoginToApp extends BaseClass{
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("LoginData");
		return new Object [] [] {{data.get(0)}} ;
	}

	@Test
	public void login() {
		LoginPage lp = new LoginPage(util);
		lp.loginToApp();
		
	}
}
