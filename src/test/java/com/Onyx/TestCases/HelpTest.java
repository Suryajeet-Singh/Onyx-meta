package com.Onyx.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.bwp.pageobjects.HelpPage;
import com.bwp.pageobjects.LoginPage;
import com.bwp.resources.BaseClass;

public class HelpTest extends BaseClass {

	@Test(priority = 1)
	public void run_OM_TC_HS_001() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_HS_001();
	}

	@Test(priority = 2)
	public void run_OM_TC_HS_002() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_HS_002();
	}

	@Test(priority = 3)
	public void run_OM_TC_GT_001() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_GT_001();
	}

	@Test(priority = 4)
	public void run_OM_TC_FAQ_001() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_FAQ_001();
	}

	@Test(priority = 5)
	public void run_OM_TC_FL_001AND002() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_FL_001AND002();
	}

	@Test(priority = 6)
	public void run_OM_TC_SER_001() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_SER_001();
	}

	@Test(priority = 6)
	public void run_OM_TC_SER_005() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_SER_005();
	}

	@Test(priority = 7)
	public void run_OM_TC_GS_011() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_GS_011();
	}

	@Test(priority = 8)
	public void run_OM_TC_GS_012() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_GS_012();
	}

	@Test(priority = 9)
	public void run_OM_TC_GS_013() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_GS_013();
	}

	@Test(priority = 10)
	public void run_OM_TC_GS_015() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_GS_015();
	}

	@Test(priority = 11)
	public void run_OM_TC_GS_016() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_GS_016();
	}

	@Test(priority = 12)
	public void run_OM_TC_GS_003() {
		HelpPage hp = new HelpPage(util);
		hp.OM_TC_GS_003();
	}
}
