package com.bwp.pageobjects;

import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bwp.resources.Utilities;

/*
 * Project Name: Onyx Meta 
 * Author: Yatindra Kinker 
 * Version: 0.0 
 * Reviewed By: Abhay Hayaran 
 * Date of Creation: October 13, 2022 
 * Modification History: 
 * Date of change: December 15, 2022 
 * Version: 0.0 
 * changed function: All functions
 * change description: Added code to get data from .json file. 
 * Modified By: Yatindra Kinker
 */

public class LoginPage extends LoginPageOR {
//	Initializing Logger object that is used to print logs of steps.
	private static final Logger log = LogManager.getLogger(LoginPage.class);

//	Local variable for initializing Utilities object.
	Utilities util;

//	loginPage constructor to initialize driver 
	public LoginPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);

	}

	/**
	 * If user login with valid credentials he should login to the page
	 */
	public void loginToApp() {
		log.info("OM_TC_LOG_001 is running");

		util.enterValue(emailInputField, util.getProperty("email"));
		log.info("registered user email entered");

		util.enterValue(passwordInputField, util.getProperty("password"));
		log.info("registered user password entered");

		util.click(logInButton);
		log.info("clicked on sign in button");

		if (util.getPageTitle().contains("Social Ads for Buy with Prime")) {
			log.info("user logged in successfully.");
			log.info("OM_TC_LOG_001 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_001 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * When user enters invalid email but password is valid . The error message
	 * should be displayed .
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_002(HashMap<String, String> input) {
		log.info("OM_TC_LOG_002 is running");

		util.enterValue(emailInputField, input.get("invalid_email"));
		log.info("invalid email is entered successfully");
		util.enterValue(passwordInputField, input.get("password"));
		log.info("registered password is entered successfully");

		if (util.isElementDisplyed(invalidEmailErrorMessage)) {
			log.info("error message is displayed");
			log.info("OM_TC_LOG_002 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_002 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * When user enters invalid email and password . The error message should be
	 * displayed .
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_003(HashMap<String, String> input) {
		log.info("OM_TC_LOG_003 is running");

		util.enterValue(emailInputField, input.get("invalid_email"));
		log.info("invalid email is entered successfully");
		util.enterValue(passwordInputField, input.get("invalid_password"));
		log.info("invalid passworde is entered successfully");
		util.click(logInButton);
		
		if (util.isElementDisplyed(invalidEmailErrorMessage)) {
			log.info("error message is displayed");
			log.info("OM_TC_LOG_003 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_003 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * When user lefts both email and password blank. The login button should be
	 * disabled
	 */
	public void OM_TC_LOG_004() {
		log.info("OM_TC_LOG_004 is running");
//		Check response when email id and password are left blank and Sign in entered.
		util.enterValue(emailInputField, "");
		log.info("email input field is blank");
		util.enterValue(passwordInputField, "");
		log.info("password input field is blank");
		
		if (util.isElementEnabled(logInButton)) {
			log.info("signIn button is disabled");
			log.info("OM_TC_LOG_004 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_004 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * When user enters valid email but lefts password blank. The login button
	 * should be disabled
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_005(HashMap<String, String> input) {
		log.info("OM_TC_LOG_005 is running");

		util.enterValue(emailInputField, input.get("email"));
		log.info("valid email is entered");
		util.enterValue(passwordInputField, "");
		log.info("password input field is blank");
		
		if (util.isElementEnabled(logInButton)) {
			log.info("signIn button is disabled");
			log.info("OM_TC_LOG_005 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_005 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * When user enters valid password but lefts email blank. The login button
	 * should be disabled
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_006(HashMap<String, String> input) {
		log.info("OM_TC_LOG_006 is running");

		util.enterValue(emailInputField, "");
		log.info("email input field is blank");
		util.enterValue(passwordInputField, input.get("password"));
		log.info("valid password is entered");
		
		if (util.isElementEnabled(logInButton)) {
			log.info("signIn button is disabled");
			log.info("OM_TC_LOG_006 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_006 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * When user try to login with the email he did not registered with. The error
	 * message should be displayed.
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_007(HashMap<String, String> input) {
		log.info("OM_TC_LOG_007 is running");

		util.enterValue(emailInputField, input.get("unregistered_email"));
		log.info("unregistered email is entered");
		util.enterValue(passwordInputField, input.get("password"));
		log.info("valid password is entered");
		util.click(logInButton);
		log.info("signIn button is clicked");
		
		if (util.isElementDisplyed(loginErrorMessage)) {
			log.info("error message is displayed");
			log.info("OM_TC_LOG_007 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_007 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * User verifies that show/hide password button is working properly.
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_008_009(HashMap<String, String> input) {
		log.info("OM_TC_LOG_008_009 is running");

		util.refreshPage();
		util.enterValue(passwordInputField, input.get("password"));
		log.info("entered password successfully");
		if (util.extractValueByAttributes(passwordInputField, "type").equals("password")) {
			log.info("entered password is encrypted");
			log.info("OM_TC_LOG_008_009 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_008_009 is failed");
			Assert.assertTrue(false);
		}
		util.click(showHidePassword);
		log.info("clicked on EYE button");
		
		if (util.extractValueByAttributes(passwordInputField, "type").equals("text")) {
			log.info("entered password is not encrypted");
			log.info("OM_TC_LOG_008_009 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_008_009 is failed");
			Assert.assertTrue(false);
		}

		util.click(showHidePassword);
		log.info("clicked on EYE button");
		
		if (util.extractValueByAttributes(passwordInputField, "type").equals("password")) {
			log.info("entered password is encrypted");
			log.info("OM_TC_LOG_008_009 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_008_009 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * When user clicks on forget password link he should redirect to forgot
	 * password page.
	 */
	public void OM_TC_LOG_010() {
		log.info("OM_TC_LOG_010 is running");
//		Check on click of forget password link user redirected to the forget password page.
		util.click(forgotPasswordLinkText);
		log.info("clicked on forgot password link");
		
		if (util.getPageURL().contains("/forgot")) {
			log.info("user is redirected to the forgot password page");
			log.info("OM_TC_LOG_010 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_010 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * On the forgot password page email input field should be present.
	 */

	public void OM_TC_LOG_011() {
		log.info("OM_TC_LOG_011 is running");

		if (util.isElementDisplyed(emailInputFieldForgotPwdPage)) {
			log.info("email input field is displayed");
			log.info("OM_TC_LOG_011 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_011 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * On forgot password page if user enters invalid email . The reset password
	 * button should be disabled.
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_013(HashMap<String, String> input) {
		log.info("OM_TC_LOG_013 is running");
		util.enterValue(emailInputFieldForgotPwdPage, input.get("invalid_email"));
		log.info("entered invalid email id ");
		
		if (util.isElementEnabled(generateLinkButton)) {
			log.info("error msg is disabled");
			log.info("OM_TC_LOG_013 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_013 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * When user enters registered email and clicks on "Generate Password reset
	 * link" button. "Password Link Generated Successfully Message " should be
	 * displayed.
	 * 
	 * @param input
	 */
	public void OM_TC_LOG_012(HashMap<String, String> input) {
		log.info("OM_TC_LOG_012 is running");

		util.enterValue(emailInputFieldForgotPwdPage, input.get("email"));
		log.info("entered already registered email id ");
		util.click(generateLinkButton);
		log.info("clicked on generate link button");
		
		if (util.isElementDisplyed(passwordLinkGeneratedSuccessfullyMessage)) {
			log.info("Link Generated Successfully Message  is displayed");
			log.info("OM_TC_LOG_012 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_LOG_012 is failed");
			Assert.assertTrue(false);
		}
		util.click(backToLoginPageButton);
		log.info("clicked on back To Login Page Button");
	}

}
