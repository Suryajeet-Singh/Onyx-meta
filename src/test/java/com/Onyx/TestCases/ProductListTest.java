package com.Onyx.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.bwp.pageobjects.LoginPage;
import com.bwp.pageobjects.ProductListPage;
import com.bwp.resources.BaseClass;

public class ProductListTest extends BaseClass {
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("productlist");
		return new Object [] [] {{data.get(0)}} ;
	}
	
	@Test(priority = 1)
	public void login() {
		LoginPage lp = new LoginPage(util);
		lp.loginToApp();
	}
		
	@Test(priority = 2)
	public void run_OM_TC_PL_01() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_01();
	}

	@Test(priority = 3)
	public void run_OM_TC_PL_02() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_02();
	}
	
	@Test(priority = 4)
	public void run_OM_TC_PL_07() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_07();
	}

	@Test(priority = 5, dataProvider = "getData")
	public void run_OM_TC_PL_04(HashMap<String, String> input) {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_04(input);
	}

	@Test(priority = 6, dataProvider = "getData")
	public void run_OM_TC_PL_05(HashMap<String, String> input) {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_05(input);
	}

	@Test(priority = 7)
	public void run_OM_TC_PL_08_12() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_08_12();
	}
	
	@Test(priority = 8, dataProvider = "getData")
	public void run_OM_TC_PL_09(HashMap<String, String> input) {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_09(input);
	}

	@Test(priority = 9, dataProvider = "getData")
	public void run_OM_TC_PL_15(HashMap<String, String> input) {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_15(input);
	}

	@Test(priority = 10)
	public void run_OM_TC_PL_16() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_16();
	}

	@Test(priority = 11, dataProvider = "getData")
	public void run_OM_TC_PL_19(HashMap<String, String> input) {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_19(input);
	}

	@Test(priority = 12)
	public void run_OM_TC_PL_20() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_20();
	}

	@Test(priority = 13)
	public void run_OM_TC_PL_23() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_23();
	}

	@Test(priority = 14)
	public void run_OM_TC_PL_24() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_24();
	}

	@Test(priority = 15)
	public void run_OM_TC_PL_21() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_21();
	}
	
	@Test(priority = 16)
	public void run_OM_TC_PL_62() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_62();
	}

	@Test(priority = 17)
	public void run_OM_TC_PL_27() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_27();
	}

	
	@Test(priority = 18)
	public void run_OM_TC_PL_29() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_29();
	}
	
	@Test(priority = 19)
	public void run_OM_TC_PL_28() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_28();
	}

	@Test(priority = 19)
	public void run_OM_TC_PL_36_37() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_36_37();
	}
	
	@Test(priority = 20)
	public void run_OM_TC_PL_38() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_38();
	}

	@Test(priority = 21)
	public void run_OM_TC_PL_40() {
		ProductListPage pl = new ProductListPage(util);
		pl.OM_TC_PL_40();
	}
	
}
