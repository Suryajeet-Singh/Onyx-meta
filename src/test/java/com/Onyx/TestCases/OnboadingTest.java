package com.Onyx.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bwp.pageobjects.OnboardingPage;
import com.bwp.pageobjects.ProductionPage;
import com.bwp.resources.BaseClass;

public class OnboadingTest extends BaseClass {
	private static Logger log = LogManager.getLogger(OnboadingTest.class.getName());

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("Onboarding");
		return new Object[][] { { data.get(0) } };
	}

	@DataProvider
	public Object[][] getLoginData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("LoginData");
		return new Object[][] { { data.get(0) } };
	}

	@Test(dataProvider = "getData", priority = 1)
	public void run_OM_TC_REG_001(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_001(input);
	}

	@Test(priority = 2)
	public void run_OM_TC_REG_002() {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_002();
	}

	@Test(priority = 2)
	public void run_OM_TC_REG_003() {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_003();
	}

//	@Test(dataProvider = "getData",priority = 2)
//	public void run_OM_TC_REG_004(){
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_004();   //  => Whitespaces case
//	}

	@Test(dataProvider = "getData", priority = 2)
	public void run_OM_TC_REG_005(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_005(input);
	}

//	@Test(dataProvider = "getData",priority = 4)
//	public void run_OM_TC_REG_007(HashMap<String, String> input){
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_007(input);
//	}

	@Test(dataProvider = "getData", priority = 5)
	public void run_OM_TC_REG_012(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_012(input);
	}

//	@Test(dataProvider = "getData",priority = 6)
//	public void run_OM_TC_REG_019(){
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_019();
//	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_020(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_020(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_021(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_021(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_022(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_022(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_023(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_023(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_024(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_024(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_025(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_025(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_026(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_026(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_027(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_027(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_028(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_028(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_029(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_029(input);
	}

//	@Test(dataProvider = "getData",priority = 6)
//	public void run_OM_TC_REG_030(){
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_030();
//	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_031(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_031(input);
	}

	@Test(dataProvider = "getData", priority = 6)
	public void run_OM_TC_REG_032(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_032(input);
	}

	@Test(dataProvider = "getData", priority = 6, groups = {"critical"})
	public void run_OM_TC_REG_033(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_033(input);
	}

	@Test(dataProvider = "getData", priority = 7)
	public void run_OM_TC_REG_034(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_034(input);
	}

	@Test(priority = 7, groups = {"critical"})
	public void run_OM_TC_REG_035() {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_035();
	}

	@Test(dataProvider = "getData", priority = 8, groups = {"critical"})
	public void run_OM_TC_REG_036(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_036(input);
	}

	@Test(dataProvider = "getData", priority = 8, groups = {"critical"})
	public void run_OM_TC_REG_037(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_037(input);
	}

	@Test(dataProvider = "getData", priority = 8, groups = {"critical"})
	public void run_OM_TC_REG_038(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_038(input);
	}

	@Test(dataProvider = "getData", priority = 8, groups = {"critical"})
	public void run_OM_TC_REG_039(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_039(input);
	}

//	@Test(dataProvider = "getData",priority = 8)
//	public void run_OM_TC_REG_03(){
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_039();
//	}

//	@Test(dataProvider = "getData",priority = 9)
//	public void run_OM_TC_REG_040(){
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_040();
//	}

	@Test(dataProvider = "getData", priority = 8, groups = {"critical"})
	public void run_OM_TC_REG_041(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_041(input);
	}

	@Test(dataProvider = "getData", priority = 8, groups = {"critical"})
	public void run_OM_TC_REG_042(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_042(input);
	}

	@Test(dataProvider = "getData", priority = 9)
	public void run_OM_TC_REG_011(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_011(input);
	}

//	@Test(dataProvider = "getData", priority = 9)
//	public void run_OM_TC_REG_009(HashMap<String, String> input) {
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_009(input);
//	}

	@Test(dataProvider = "getData", priority = 9, groups = {"critical"})
	public void run_OM_TC_REG_013(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_013(input);
	}

	@Test(dataProvider = "getData", priority = 9, groups = {"critical"})
	public void run_OM_TC_REG_015(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_015(input);
	}

	@Test(dataProvider = "getData", priority = 10, groups = {"critical"})
	public void run_OM_TC_REG_017(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_017(input);
	}

	@Test(dataProvider = "getData", priority = 11, groups = {"critical"})
	public void run_OM_TC_REG_008(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_008(input);
	}

	@Test(dataProvider = "getData", priority = 13, groups = {"critical"})
	public void run_OM_TC_REG_010(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_010(input);
	}

	@Test(priority = 14, groups = {"critical"})
	public void run_OM_TC_REG_044() {
		OnboardingPage op = new OnboardingPage(util);
		op.OM_TC_REG_044();
	}

//	@Test(dataProvider = "getData",priority = 3)
//	public void run_OM_TC_REG_006(){
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_006();
//	} same as create user

	@Test(dataProvider = "getData",priority = 45, groups = {"critical"})
	public void runCreateUser(HashMap<String, String> input) {
		OnboardingPage op = new OnboardingPage(util);
		op.createUser(input);
	}

//	***************************THIS TEST CASE IS DONE IN RUN CREATE USER************************************
//	@Test(dataProvider = "getData",priority = 17)
//	public void run_OM_TC_REG_047() {
//		OnboardingPage op = new OnboardingPage(util);
//		op.OM_TC_REG_047();
//	}

}
