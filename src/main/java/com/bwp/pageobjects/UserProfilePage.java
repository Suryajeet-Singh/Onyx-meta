package com.bwp.pageobjects;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bwp.resources.Utilities;

public class UserProfilePage extends UserProfilePageOR{
	Utilities util;
	private static final Logger log = LogManager.getLogger(UserProfilePage.class);
	
	public UserProfilePage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}
	
	public void logout() {
		util.click(avatarIcon);
		util.click(logoutButtonAvatarGrid);
	}
	
//	Check setting link redirection is correct or not
	public void OM_TC_SET_001() {
		log.info("RUNNING USER PROFILE");
		util.click(avatarIcon);
		util.click(settingsButtonAvatarGrid);
		if(util.getPageURL().equals("https://testing.cedcommerce.bwpapps.com/panel/634f7d5402a60683f40f9e48/config")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

	}
	
//	Check after successfull logout from one tab , User is logout from all tab and from the different browser
	public void OM_TC_LOG_001() {
		LoginPage lp = new LoginPage(util);
//		From Settings
		util.click(avatarIcon);
		util.click(logoutButtonAvatarGrid);
		if(util.getPageURL().equals(util.loginPageUrl())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		util.hold(5);
		lp.loginToApp();
		
//		From Dashboard
		util.clickOnDashboard();
		util.click(avatarIcon);
		util.click(logoutButtonAvatarGrid);
		if(util.getPageURL().equals(util.loginPageUrl())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
//		util.hold(5);
//		lp.loginToApp();
////		From ProductList
//		util.clickOnProductList();
//		util.click(avatarIcon);
//		util.click(logoutButtonAvatarGrid);
//		if(util.getPageURL().equals(util.loginPageUrl())) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
//		util.hold(5);
//		lp.loginToApp();
////		From Help
//		util.clickOnHelp();
//		util.click(avatarIcon);
//		util.click(logoutButtonAvatarGrid);
//		if(util.getPageURL().equals(util.loginPageUrl())) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
//		util.hold(5);
//		lp.loginToApp();
////		From FAQ
//		util.clickOnFAQ();
//		util.click(avatarIcon);
//		util.click(logoutButtonAvatarGrid);
//		if(util.getPageURL().equals(util.loginPageUrl())) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
		
	}
	
//	Check after successfull logout , User will not be able to browse previous page
	public void OM_TC_LOG_002() {
		util.goBack();
		if(util.getPageURL().equals(util.loginPageUrl())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	public void OM_TC_LOG_003() {
		LoginPage lp = new LoginPage(util);
		lp.loginToApp();
//		From ProductList
		util.clickOnProductList();
		util.click(avatarIcon);
		util.click(logoutButtonAvatarGrid);
		if(util.getPageURL().equals(util.loginPageUrl())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		util.hold(5);
		lp.loginToApp();
//		From Help
		util.clickOnHelp();
		util.click(avatarIcon);
		util.click(logoutButtonAvatarGrid);
		if(util.getPageURL().equals(util.loginPageUrl())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		util.hold(5);
		lp.loginToApp();
//		From FAQ
		util.clickOnFAQ();
		util.click(avatarIcon);
		util.click(logoutButtonAvatarGrid);
		if(util.getPageURL().equals(util.loginPageUrl())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
//	Check that if user copied the URL of any section and then click on Logout button on the same tab and then paste the URL in the new tab
	public void OM_TC_LOG_004() {
		LoginPage lp = new LoginPage(util);
		lp.loginToApp();
		String url =util.getPageURL();
		util.click(avatarIcon);
		util.click(logoutButtonAvatarGrid);
		((JavascriptExecutor) util.getDriver()).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(util.getDriver().getWindowHandles());
		util.getDriver().switchTo().window(tabs.get(1));
		util.getDriver().get(url);
		if(util.isElementDisplyed(sessionExpired)){
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	

}
