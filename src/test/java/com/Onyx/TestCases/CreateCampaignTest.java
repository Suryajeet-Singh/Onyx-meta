package com.Onyx.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bwp.pageobjects.CreateCampaignPage;
import com.bwp.pageobjects.LoginPage;
import com.bwp.pageobjects.ProductionPage;
import com.bwp.resources.BaseClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateCampaignTest extends BaseClass {
	private static final Logger log = LogManager.getLogger(CreateCampaignTest.class);

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("CreateCampaign");
		return new Object[][] { { data.get(0) } };
	}

	@DataProvider
	public Object[][] getLoginData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("LoginData");
		return new Object[][] { { data.get(0) } };
	}

	@Test(priority = 1)
	public void runOM_TC_DA_001() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_DA_001();
	}

	@Test(priority = 2)
	public void runOM_TC_DA_002() {

		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_DA_002();
	}

	@Test(priority = 4)
	public void runOM_TC_CC_001() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_001();
	}

	@Test(priority = 4)
	public void runOM_TC_CC_002() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_DA_002();
	}

	@Test(priority = 5)
	public void runOM_TC_CC_004() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_004();
	}

	@Test(priority = 6)
	public void runOM_TC_CC_005() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_005();
	}

	@Test(dataProvider = "getData", priority = 7)
	public void runOM_TC_CC_006_OM_TC_CC_010(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_006_OM_TC_CC_010(input);
	}

	@Test(priority = 8)
	public void runOM_TC_CC_007() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_007();
	}

	@Test(priority = 9)
	public void runOM_TC_CC_008() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_008();
	}

	@Test(priority = 10)
	public void runclickingOnBackButtonIconWhenAllMandatoryFieldsAreEmpty() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.clickingOnBackButtonIconWhenAllMandatoryFieldsAreEmpty();
	}

	@Test(dataProvider = "getData", priority = 11)
	public void runOM_TC_CC_012(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_012(input);
	}

	@Test(priority = 12)
	public void runOM_TC_CC_013() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_013();
	}

	@Test(priority = 12)
	public void runOM_TC_CC_014() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_014();
	}

	@Test(dataProvider = "getData", priority = 13)
	public void runOM_TC_CC_016(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_016(input);
	}

	@Test(dataProvider = "getData", priority = 14)
	public void runOM_TC_CC_017(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_017(input);
	}

	@Test(dataProvider = "getData", priority = 15)
	public void runOM_TC_CC_018(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_018(input);
	}

	@Test(dataProvider = "getData", priority = 16)
	public void runOM_TC_CC_019(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_019(input);
	}

	@Test(dataProvider = "getData", priority = 17)
	public void runOM_TC_CC_020(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_020(input);
	}

	@Test(dataProvider = "getData", priority = 18)
	public void runOM_TC_CC_021(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_021(input);
	}

	@Test(dataProvider = "getData", priority = 19)
	public void runOM_TC_CC_023(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_023(input);
	}

	@Test(dataProvider = "getData", priority = 20)
	public void runOM_TC_CC_024(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_024(input);
	}

	@Test(priority = 21)
	public void runOM_TC_CC_026() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_026();
	}

	@Test(dataProvider = "getData", priority = 21)
	public void runOM_TC_CC_034(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_034(input);
	}

	@Test(priority = 23)
	public void runOM_TC_CC_037() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_037();
	}

	@Test(priority = 24)
	public void runOM_TC_CC_038() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_038();
	}

	@Test(dataProvider = "getData", priority = 25)
	public void runOM_TC_CC_039_40_41(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_039_40_41(input);
	}

	@Test(priority = 26)
	public void runOM_TC_CC_042() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_042();
	}

	@Test(dataProvider = "getData", priority = 26)
	public void runOM_TC_CC_043(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_043(input);
	}

	@Test(dataProvider = "getData", priority = 26, groups = {"critical"})
	public void runSetMinAge(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.setMinAge(input);
	}

	@Test(dataProvider = "getData", priority = 27, groups = {"critical"})
	public void runSetMaxAge(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.setMaxAge(input);
	}

	@Test(dataProvider = "getData", priority = 28, groups = {"critical"})
	public void runSetGender(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.setGender(input);
	}

	@Test(priority = 29)
	public void runOM_TC_CC_049() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_049();
	}

	@Test(priority = 30)
	public void runOM_TC_CC_050() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_050();
	}

	@Test(priority = 31)
	public void runOM_TC_CC_055() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_055();
	}

	@Test(dataProvider = "getData", priority = 32)
	public void runOM_TC_CC_058(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_058(input);
	}

	@Test(priority = 33)
	public void runOM_TC_CC_059() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_059();
	}

	@Test(priority = 36)
	public void runOM_TC_CC_064() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_064();
	}

	@Test(priority = 34)
	public void runOM_TC_CC_063() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_063();
	}

	@Test(priority = 35)
	public void runOM_TC_CC_067_68() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_067_68();
	}

	@Test(priority = 36)
	public void OM_TC_CC_071() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_071();
	}

	@Test(priority = 38)
	public void OM_TC_CC_074() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_074(); // the redirected page url will be updated and needed to be changed.(done)
	}

	@Test(priority = 39)
	public void OM_TC_CC_076() {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.OM_TC_CC_076();
	}

	@Test(dataProvider = "getData", priority = 40, groups = {"critical"})

	public void createCampaign(HashMap<String, String> input) {
		CreateCampaignPage ccp = new CreateCampaignPage(util);
		ccp.createCampaign(input);
	}

}
