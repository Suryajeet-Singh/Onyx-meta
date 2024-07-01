package com.Onyx.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bwp.pageobjects.LoginPage;
import com.bwp.pageobjects.SettingsPage;
import com.bwp.resources.BaseClass;

public class SettingsTest extends BaseClass {
	private static final Logger log = LogManager.getLogger(CreateCampaignTest.class);

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("Settings");
		return new Object[][] { { data.get(0) } };
	}

	@Test(dataProvider = "getData", priority = 2, groups = { "critical" })
	public void run_OM_TC_PAS_002(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_002(input);
	}

	@Test(dataProvider = "getData", priority = 3, groups = { "critical" })
	public void run_OM_TC_PAS_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_003(input);
	}

	@Test(priority = 4)
	public void run_OM_TC_PAS_004() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_004();
	}

	@Test(priority = 5)
	public void run_OM_TC_PAS_005() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_005();
	}

	@Test(dataProvider = "getData", priority = 6, groups = { "critical" })
	public void run_OM_TC_PAS_006(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_006(input);
	}

	@Test(priority = 7)
	public void run_OM_TC_PAS_007() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PAS_007();
	}

	@Test(dataProvider = "getData", priority = 8)
	public void run_OM_TC_PPB_001(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_001(input);
		sp.passwordContainsOnlyLowerCase(input);
		sp.passwordContainsOnlyUpperCase(input);
	}

	@Test(dataProvider = "getData", priority = 9)
	public void run_OM_TC_PPB_002(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsOnlyUpperCase(input);

	}

	@Test(dataProvider = "getData", priority = 10)
	public void run_OM_TC_PPB_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsOnlyLowerCase(input);
	}

	@Test(dataProvider = "getData", priority = 11)
	public void run_OM_TC_PPB_004(Map<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperAndLowerCharOnly(input);
	}

	@Test(dataProvider = "getData", priority = 12)
	public void run_OM_TC_PPB_005(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsNumbersOnly(input);
	}

	@Test(dataProvider = "getData", priority = 12)
	public void run_OM_TC_PPB_006(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 12)
	public void run_OM_TC_PPB_007(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsLowerCaseAndNumbersCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 12)
	public void run_OM_TC_PPB_008(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperCaseAndNumbersCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 12)
	public void run_OM_TC_PPB_009(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsAndNumbersOnly(input);
	}

	@Test(dataProvider = "getData", priority = 13)
	public void run_OM_TC_PPB_010(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsAndUpperCaseCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 13)
	public void run_OM_TC_PPB_011(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsSpecialCharsAndLowerCaseCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 13)
	public void run_OM_TC_PPB_013(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperCaseAndLowerCaseCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 13)
	public void run_OM_TC_PPB_014(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperLowerCaseAndSpecialCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 13)
	public void run_OM_TC_PPB_015(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_001(input);
	}

	@Test(dataProvider = "getData", priority = 13)
	public void run_OM_TC_PPB_016(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PPB_016(input);
	}

	@Test(dataProvider = "getData", priority = 14)
	public void run_OM_TC_VPAS_001(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.passwordContainsUpperLowerCaseAndSpecialCharsOnly(input);
	}

	@Test(dataProvider = "getData", priority = 15)
	public void run_OM_TC_SP_001(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_001(input);
	}

	@Test(dataProvider = "getData", priority = 15)
	public void run_OM_TC_SP_002(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_002(input);
	}

	@Test(dataProvider = "getData", priority = 15)
	public void run_OM_TC_SP_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_003(input);
	}

	@Test(dataProvider = "getData", priority = 15)
	public void run_OM_TC_SP_004(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_004(input);
	}

	@Test(dataProvider = "getData", priority = 15, groups = { "critical" })
	public void run_OM_TC_SP_006(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_006(input);
	}

	@Test(dataProvider = "getData", priority = 15, groups = { "critical" })
	public void run_OM_TC_SP_007(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_007(input);
	}

	@Test(dataProvider = "getData", priority = 16, groups = { "critical" })
	public void run_OM_TC_SP_007II(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_SP_007II(input);
	}

	@Test(priority = 16)
	public void run_OM_TC_GEN_001() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_001();
	}

	@Test(priority = 16)
	public void run_OM_TC_GEN_002() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_002();
	}

	@Test(dataProvider = "getData", priority = 16)
	public void run_OM_TC_GEN_003(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_003(input);
	}

	@Test(priority = 16)
	public void run_OM_TC_PIX_001() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_001();
	}

	@Test(priority = 16)
	public void run_OM_TC_PIX_002() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_002();
	}

	@Test(priority = 16)
	public void run_OM_TC_PIX_003_004() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_003_004();
	}

	@Test(priority = 16)
	public void run_OM_TC_PIX_005() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_005();
	}

	@Test(priority = 16)
	public void run_OM_TC_PIX_006_007() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_PIX_006_007();
	}

	@Test(priority = 17)
	public void run_OM_TC_GEN_011() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_011();
	}

	@Test(priority = 17)
	public void run_OM_TC_GEN_012() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_012();
	}

	@Test(dataProvider = "getData", priority = 17)
	public void run_OM_TC_GEN_013(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_013(input);
	}

	@Test(priority = 17)
	public void run_OM_TC_GEN_014() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_014();
	}

	@Test(priority = 17)
	public void run_OM_TC_GEN_015() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_015();
	}

	@Test(dataProvider = "getData", priority = 17, groups = { "critical" })
	public void run_OM_TC_GEN_016_017(HashMap<String, String> input) {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_GEN_016_017(input);
	}

	@Test(priority = 18, groups = { "critical" })
	public void run_OM_TC_ACS_001() {
		SettingsPage sp = new SettingsPage(util);
		sp.OM_TC_ACS_001();
	}

}
