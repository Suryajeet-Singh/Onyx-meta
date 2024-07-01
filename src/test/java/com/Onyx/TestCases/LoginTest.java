package com.Onyx.TestCases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bwp.pageobjects.LoginPage;
import com.bwp.pageobjects.ProductionPage;
import com.bwp.resources.BaseClass;

public class LoginTest extends BaseClass{
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("LoginData");
		return new Object [] [] {{data.get(0)}} ;
	}
	
//	@Test()
//	public void addAppLogin() {
//		ProductionPage pp = new ProductionPage(util);
//		pp.loginMarketPlace();
//	}
	
	@Test(dataProvider = "getData",priority = 1, groups = {"critical"})
	public void run_OM_TC_LOG_002(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_002(input);
	}
	
	@Test(dataProvider = "getData",priority = 2, groups = {"critical"})
	public void run_OM_TC_LOG_003(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_003(input);
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void run_OM_TC_LOG_004(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_004();
	}
	
	@Test(dataProvider = "getData",priority = 2, groups = {"critical"})
	public void run_OM_TC_LOG_005(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_005(input);
	}
	
	@Test(dataProvider = "getData",priority = 2, groups = {"critical"})
	public void run_OM_TC_LOG_006(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_006(input);
	}
	
	@Test(dataProvider = "getData",priority = 2, groups = {"critical"})
	public void run_OM_TC_LOG_007(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_007(input);
	}
	
	@Test(dataProvider = "getData",priority = 3)
	public void run_OM_TC_LOG_008_009(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_008_009(input);
	}
	
	@Test(priority = 3)
	public void run_OM_TC_LOG_010() {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_010();
	}
	
	@Test(priority = 3)
	public void run_OM_TC_LOG_011() {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_011();
	}

	@Test(dataProvider = "getData",priority = 3)
	public void run_OM_TC_LOG_013(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_013(input);
	}

	@Test(dataProvider = "getData",priority = 4)
	public void run_OM_TC_LOG_012(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_012(input);
	}
	
}
