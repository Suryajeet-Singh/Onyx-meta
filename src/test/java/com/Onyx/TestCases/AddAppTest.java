package com.Onyx.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bwp.pageobjects.ProductionPage;
import com.bwp.resources.BaseClass;

public class AddAppTest extends BaseClass {

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("LoginData");
		return new Object[][] { { data.get(0) } };
	}

	@Test()
	public void addApp() {
		ProductionPage pp = new ProductionPage(util);
		pp.onboardingMarketPlace();
	}
	
	@Test()
	public void addAppLogin() {
		ProductionPage pp = new ProductionPage(util);
		pp.loginMarketPlace();
	}

}
