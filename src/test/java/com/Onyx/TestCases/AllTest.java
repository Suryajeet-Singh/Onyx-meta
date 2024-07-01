package com.Onyx.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.bwp.pageobjects.CreateCampaignPage;
import com.bwp.pageobjects.LoginPage;
import com.bwp.pageobjects.ProductionPage;
import com.bwp.pageobjects.SettingsPage;
import com.bwp.resources.BaseClass;

public class AllTest extends BaseClass{
	private static final Logger log = LogManager.getLogger(AllTest.class);
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("LoginData");
		return new Object [] [] {{data.get(0)}} ;
	}
	
	@Test()
	public void addAppLogin() {
		ProductionPage pp = new ProductionPage(util);
		pp.loginMarketPlace();
	}
	
	@Test(dataProvider = "getData",priority = 1, dependsOnMethods = "addAppLogin")
	public void run_OM_TC_LOG_002(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_002(input);
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void run_OM_TC_LOG_003(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_003(input);
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void run_OM_TC_LOG_004(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_004();
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void run_OM_TC_LOG_005(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_005(input);
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void run_OM_TC_LOG_006(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.OM_TC_LOG_006(input);
	}
	
	@Test(dataProvider = "getData",priority = 2)
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
	
	@Test(dataProvider = "getData",priority = 5)
	public void runLogin(HashMap<String, String> input) {
		LoginPage lp = new LoginPage(util);
		lp.loginToApp();
	}
	
	@DataProvider
	public Object[][] getSettingsData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("Settings");
		return new Object [] [] {{data.get(0)}} ;
	}

	@Test(dataProvider = "getSettingsData", priority = 5)
	public void run_OM_TC_PAS_002(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_002(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 6)
	public void run_OM_TC_PAS_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_003(input);
	}
	
	@Test(priority = 7)
	public void run_OM_TC_PAS_004() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_004();
	}
	
	@Test(priority = 8)
	public void run_OM_TC_PAS_005() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_005();
	}
	
	@Test(dataProvider = "getSettingsData", priority = 9)
	public void run_OM_TC_PAS_006(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_006(input);
	}
	
	@Test(priority = 10)
	public void run_OM_TC_PAS_007() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_007();
	}
	
	@Test(dataProvider = "getSettingsData", priority = 11)
	public void run_OM_TC_PPB_001(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_001(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 12)
	public void run_OM_TC_PPB_002(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_002(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 13)
	public void run_OM_TC_PPB_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_003(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 14)
	public void run_OM_TC_PPB_004(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperAndLowerCharOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 15)
	public void run_OM_TC_PPB_005(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsNumbersOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 16)
	public void run_OM_TC_PPB_006(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 17)
	public void run_OM_TC_PPB_007(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsLowerCaseAndNumbersCharsOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 18)
	public void run_OM_TC_PPB_008(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperCaseAndNumbersCharsOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 19)
	public void run_OM_TC_PPB_009(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsAndNumbersOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 20)
	public void run_OM_TC_PPB_010(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsAndUpperCaseCharsOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 21)
	public void run_OM_TC_PPB_011(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsAndLowerCaseCharsOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 22)
	public void run_OM_TC_PPB_013(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperCaseAndLowerCaseCharsOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 23)
	public void run_OM_TC_PPB_014(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperLowerCaseAndSpecialCharsOnly(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 24)
	public void run_OM_TC_PPB_015(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_001(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 25)
	public void run_OM_TC_PPB_016(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_016(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 26)
	public void run_OM_TC_VPAS_001(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_VPAS_001(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 27)
	public void run_OM_TC_SP_001(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_001(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 28)
	public void run_OM_TC_SP_002(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_002(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 29)
	public void run_OM_TC_SP_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_003(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 30)
	public void run_OM_TC_SP_004(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_004(input);
	}

	@Test(dataProvider = "getSettingsData", priority = 30)
	public void run_OM_TC_SP_006(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_006(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 30)
	public void run_OM_TC_SP_007(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_007(input);
	}
	
	@Test(dataProvider = "getSettingsData", priority = 31)
	public void run_OM_TC_SP_007II(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_007II(input);
	}

	@Test(priority = 32)
	public void run_OM_TC_GEN_001() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_001();
	}

	@Test(priority = 32)
	public void run_OM_TC_GEN_002() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_002();
	}
	
	@Test(dataProvider = "getSettingsData", priority = 32)
	public void run_OM_TC_GEN_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_003(input);
	}

	@Test(priority = 32)
	public void run_OM_TC_PIX_001() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_001();
	}

	@Test(priority = 32)
	public void run_OM_TC_PIX_002() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_002();
	}
	
	@Test(priority = 32)
	public void run_OM_TC_PIX_003_004() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_003_004();
	}

	@Test(priority = 32)
	public void run_OM_TC_PIX_005() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_005();
	}

	@Test(priority = 32)
	public void run_OM_TC_PIX_006_007() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_006_007();
	}


	@Test(priority = 33)
	public void run_OM_TC_GEN_011() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_011();
	}

	@Test(priority = 33)
	public void run_OM_TC_GEN_012() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_012();
	}
	
	@Test(dataProvider = "getSettingsData", priority = 33)
	public void run_OM_TC_GEN_013(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_013(input);
	}

	@Test(priority = 33)
	public void run_OM_TC_GEN_014() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_014();
	}
	

	@Test(priority = 33)
	public void run_OM_TC_GEN_015() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_015();
	}

	@Test(dataProvider = "getSettingsData", priority = 33)
	public void run_OM_TC_GEN_016_017(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_016_017(input);
	}

	@Test(priority = 34)
	public void run_OM_TC_ACS_001() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_ACS_001();
	}
	

	@DataProvider
	public Object[][] getCreateCampaignData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("CreateCampaign");
		return new Object [] [] {{data.get(0)}} ;
	}
	
	
	@Test(priority = 35)
	public void runOM_TC_DA_001() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_DA_001();
	}
	
	
	@Test(priority = 36)
	public void runOM_TC_DA_002() {
	
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_DA_002();
	}
	
//	@Test(dataProvider = "getData",priority = 37)
//	public void runOM_TC_DA_004() {
//	
//		CreateCampaignPage ccp = new CreateCampaignPage(util);
//		ccp.OM_TC_DA_004();
//	}
	
	
	@Test(priority = 38)
	public void runOM_TC_CC_001() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_001();
	}
	
	@Test(priority = 39)
	public void runOM_TC_CC_002() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_DA_002();
	}
	
	@Test(priority = 40)
	public void runOM_TC_CC_004() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_004();
	}
	
	@Test(priority = 41)
	public void runOM_TC_CC_005() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_005();
	}

	@Test(dataProvider = "getCreateCampaignData",priority = 42)
	public void runOM_TC_CC_006_OM_TC_CC_010(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_006_OM_TC_CC_010(input);
	}

	@Test(priority = 43)
	public void runOM_TC_CC_007() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_007();
	}
	
	@Test(priority = 44)
	public void runOM_TC_CC_008() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_008();
	}

	@Test(priority = 45)
	public void runclickingOnBackButtonIconWhenAllMandatoryFieldsAreEmpty() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.clickingOnBackButtonIconWhenAllMandatoryFieldsAreEmpty();
	}

	@Test(dataProvider = "getCreateCampaignData",priority = 46)
	public void runOM_TC_CC_012(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_012(input);
	}
	
	@Test(priority = 47)
	public void runOM_TC_CC_013() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_013();
	}
	
	@Test(priority = 48)
	public void runOM_TC_CC_014() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_014();
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 49)
	public void runOM_TC_CC_016(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_016(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 50)
	public void runOM_TC_CC_017(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_017(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 51)
	public void runOM_TC_CC_018(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_018(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 52)
	public void runOM_TC_CC_019(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_019(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 53)
	public void runOM_TC_CC_020(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_020(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 54)
	public void runOM_TC_CC_021(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_021(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 55)
	public void runOM_TC_CC_023(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_023(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 56)
	public void runOM_TC_CC_024(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_024(input);
	}
	

	@Test(priority = 57)
	public void runOM_TC_CC_026(){
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_026();
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 58)
	public void runOM_TC_CC_034(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_034(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 59)
	public void runOM_TC_CC_035(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_035(input);  
	}
	
	@Test(priority = 60)
	public void runOM_TC_CC_037() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_037();
	}
	
	@Test(priority = 61)
	public void runOM_TC_CC_038() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_038();
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 62)
	public void runOM_TC_CC_039_40_41(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_039_40_41(input);
	}
	
	@Test(priority = 63)
	public void runOM_TC_CC_042() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_042();
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 64)
	public void runOM_TC_CC_043(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_043(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 65)
	public void runSetMinAge(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.setMinAge(input);
	}
	
	@Test(dataProvider = "getCreateCampaignData",priority = 66)
	public void runSetMaxAge(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.setMaxAge(input);
	}
	

	@Test(dataProvider = "getCreateCampaignData",priority = 67)
	public void runSetGender(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.setGender(input);
	}
	
//	@Test(dataProvider = "getCreateCampaignData",priority = 68)
//	public void runOM_TC_CC_046() {
//		CreateCampaignPage ccp = new CreateCampaignPage(util);
//		ccp.OM_TC_CC_046(); // need to code to check if I entered max age < min age 
//	}
//	
//	@Test(dataProvider = "getCreateCampaignData",priority = 69)
//	public void runOM_TC_CC_047() {
//		CreateCampaignPage ccp = new CreateCampaignPage(util);
//		ccp.OM_TC_CC_047();
//	}
	
	@Test(priority = 70)
	public void runOM_TC_CC_049() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_049();
	}
	
	@Test(priority = 71)
	public void runOM_TC_CC_050() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_050();
	}
	
	@Test(priority = 72)
	public void runOM_TC_CC_055() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_055();
	}
	
	
	@Test(dataProvider = "getCreateCampaignData", priority = 73)
	public void runOM_TC_CC_058(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_058(input);
	}
	
	@Test(priority = 74)
	public void runOM_TC_CC_059() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_059();
	}
	
	@Test(priority = 75)
	public void runOM_TC_CC_064() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_064();
	}
	
	@Test(priority = 76)
	public void runOM_TC_CC_063() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_063();
	}
	
	@Test(priority = 77)
	public void runOM_TC_CC_067_68() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_067_68();
	}
	
	@Test(priority = 78)
	public void OM_TC_CC_071() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_071(); 
	}
	
//	@Test(dataProvider = "getCreateCampaignData",priority = 79)
//	public void OM_TC_CC_072() {
//		CreateCampaignPage ccp = new CreateCampaignPage(util);
//		ccp.OM_TC_CC_072();
//	}
	
	@Test(priority = 80)
	public void OM_TC_CC_074() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_074(); //the redirected page url will be updated and needed to be changed.(done)
	}
	
	@Test(priority = 81)
	public void OM_TC_CC_076() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_076();
	}

	@Test(dataProvider = "getCreateCampaignData",priority = 82)
	
	public void createCampaign(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.createCampaign(input);
	}
}
