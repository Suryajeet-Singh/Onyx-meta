package com.bwp.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
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
 * Date of change: Jan 03 2023
 * Version: 0.0 
 * changed function: All functions
 * change description: Updated pageObjects
 * Modified By: Yatindra Kinker
 */

public class SettingsPage extends SettingsPageOR {

//	Initializing Logger object that is used to print logs of steps.
	private static Logger log = LogManager.getLogger(SettingsPage.class.getName());

//	Local variable for initializing Utilities object.
	Utilities util = null;
	boolean isPasswordStrong = false;
	private String pass1 ="" ;
	private String pass2 ="";

	
	/**
	 * Parameterized Settings page constructor This constructor initializes driver
	 * And converts page factory objects into "driver.findElement()" format
	 * 
	 * @param util
	 */
	public SettingsPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
		pass1 = util.getProperty("password_1");
		pass2 = util.getProperty("password_2");
	}
	

	/**
	 * Check whether if 'new password' doesn't match with confirm password then
	 * verify that error message is displayed.
	 * 
	 * @param input
	 */
	public void OM_TC_PAS_002(HashMap<String, String> input) {
//		 pass2 = util.getProperty("password_2");
		log.info("Test case OM_TC_PAS_002 is running");

		util.hold(5);
		util.clickOnSettings();
		log.info("clicked on settings");
		util.click(password);
		log.info("clicked on password");
		util.enterValue(newPasswordInputField, pass2);
		log.info("entered new password");
		util.enterValue(confirmPasswordInputField, input.get("invalid_password"));
		log.info("entered confirm password that do not match with new password");

		if (util.isElementDisplyed(passwordDoesNotMatchErrorMsg)) {
			log.info("password do not match error msg is displayed");
			log.info("Test case OM_TC_PAS_002 is passed");
			Assert.assertTrue(true); /* if new and confirm password is same */
		} else {
			util.logError("Test case OM_TC_PAS_002 failed");
			Assert.assertTrue(false); /* if new and confirm password is not same */
		}
	}

	/**
	 * Check whether if 'new password' match with confirm password no error message
	 * is displayed
	 * 
	 * @param input
	 */
	public void OM_TC_PAS_003(HashMap<String, String> input) {
		log.info("Test case OM_TC_PAS_003 is running");
		util.enterValue(newPasswordInputField, pass2);
		log.info("entered new password");
		util.enterValue(confirmPasswordInputField, pass2);
		log.info("entered confirm password that match with new password");

		try {
			boolean isDisplayed = !util.isElementDisplyed(passwordDoesNotMatchErrorMsg);
		} catch (NoSuchElementException e) {
			log.info("password do not match error msg is not displayed");
			log.info("Test case OM_TC_PAS_003 is passed");
			Assert.assertTrue(true); /* "new and confirm password is not same" error msg is not displayed */
		}

	}

	/**
	 * Check whether password contain space in the beginning as well as in the end
	 * it should get trimmed and password does not contain any spaces.
	 */
	public void OM_TC_PAS_004() {
		log.info("Test case OM_TC_PAS_004 is running");
		util.enterValue(newPasswordInputField, "   Yatindr@1234   ");
		log.info("entered new password that contain space in the beginning as well as in the end");

		if (!util.extractValueByAttributes(newPasswordInputField, "value").contains(" ")) {
			log.info("password do not contains spaces");
			log.info("Test case OM_TC_PAS_004 is passed");
			Assert.assertTrue(true); /* Password input field does not accepts any whitespace */
		} else {
			util.logError("Test case OM_TC_PAS_004 is failed");
			Assert.assertTrue(false); /* Password input field accepts any whitespace */
		}
	}

	/**
	 * Check when user copy space from anywhere(like notebad,google search
	 * engine,doc etc.) and pasted in the password input field. It should not
	 * contain any whitespace
	 */
	public void OM_TC_PAS_005() {
		log.info("Test case OM_TC_PAS_005 is running");
		((JavascriptExecutor) util.getDriver()).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(util.getDriver().getWindowHandles());
		util.getDriver().switchTo().window(tabs.get(1));
		util.getDriver().get("http://google.com");
		util.enterValue(googleSearchInputfield, "  Yatindra   ");
		util.copy(googleSearchInputfield);
		util.getDriver().switchTo().window(tabs.get(0));
		util.paste(newPasswordInputField);
		log.info("copied data from antother source that contains spaced and paste into new password input field");
		if (!util.extractValueByAttributes(newPasswordInputField, "value").contains(" ")) {
			log.info("password do not contains spaces");
			log.info("Test case OM_TC_PAS_005 is passed");
			Assert.assertTrue(true); /* Password input field does not accepts any whitespace */
		} else {
			util.logError("Test case OM_TC_PAS_005  failed");
			Assert.assertTrue(false); /* Password input field accepts any whitespace */
		}

	}

	/**
	 * Check if length of the password is minimum 8 characters then reset password
	 * button should be enabled
	 * 
	 * @param input
	 */
	public void OM_TC_PAS_006(HashMap<String, String> input) {
//		pass1 = util.getProperty("password_1");
		log.info("Test case OM_TC_PAS_006 is running");

		util.enterValue(currentPasswordInputField, pass1);
		log.info("entered current password in currentPasswordInputField");

		util.enterValue(newPasswordInputField, pass2);
		log.info("entered new password in newPasswordInputField");

		util.enterValue(confirmPasswordInputField, pass2);
		log.info("entered new password in confirmPasswordInputField");

		if (util.isPasswordHave8Characters(pass2) && util.isElementEnabled(resetPasswordButton)) {
			log.info("password have valid length and reset password button is enabled");
			log.info("Test case OM_TC_PAS_006 is passed");
//			Password follows all standards && its length > 7 characters reset password button should is enabled 
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_PAS_006 is failed");
//			Password does not follows all standards || its length < 7 characters reset password button should be enabled
			Assert.assertTrue(false);

		}

	}

	/**
	 * Check if the password field allows blank spaces only. It should not accept
	 * any whitespace
	 */

	public void OM_TC_PAS_007() {
		log.info("Test case OM_TC_PAS_007 is running");
		util.refreshPage();
		util.click(password);
		log.info("clicked on password");

		util.enterValue(newPasswordInputField, "    ");
		log.info("entered only spaces in newPasswordInputField");
		if (util.extractValueByAttributes(newPasswordInputField, "value").equals("")) {
			log.info("newPasswordInputField does not contains any spaces");
			log.info("Test case OM_TC_PAS_007 is passed");
			Assert.assertTrue(true); /* Password input field does not accepts any whitespace */
		} else {
			util.logError("Test case OM_TC_PAS_007 failed");
			Assert.assertTrue(false); /* Password input field accepts any whitespace */
		}
	}

	/**
	 * Check on the basis of password entered it should display the progress bar.
	 * (Weak, Medium & Strong)
	 * 
	 * @param String input
	 */
	public void OM_TC_PPB_001(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("Test case OM_TC_PPB_001 is running");

		util.click(password);
		log.info("clicked on password");

//		User enters password that contains atleast one capital letter, small letter, number, special symbol and length > 7 characters
		util.enterValue(newPasswordInputField, pass2);
		log.info(
				"entered password that contains atleast 1 uppercase, lowercase, numbers and special characters and length is greater than 7 characters in newPasswordInputField");
		util.hold(1);

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordContainsNumbers.isDisplayed()
						&& (passwordContainsSpecialChar.isDisplayed()))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);

	}

	public void passwordContainsOnlyLowerCase(Map<String, String> input) {
		isPasswordStrong = false;
//		User enters password that contains only lower case alphabets
		util.enterValue(newPasswordInputField, input.get("password_with_only_lower_case"));
		log.info(
				"entered password that don't contains atleast 1 uppercase, lowercase, numbers and special characters and length is greater than 7 characters in newPasswordInputField");
		util.hold(1);

		if (passwordContainsEightChars.isDisplayed() && (passwordDoesNotContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordDoesNotContainsNumbers.isDisplayed()
						&& (passwordDoesNotContainsSpecialChar.isDisplayed()
								&& (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	public void passwordContainsOnlyUpperCase(Map<String, String> input) {
		isPasswordStrong = false;
		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_case"));
		log.info(
				"entered password that don't contains atleast 1 uppercase, lowercase, numbers and special characters and length is greater than 7 characters in newPasswordInputField");
		util.hold(1);

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordDoesNotContainsLowerCaseChar.isDisplayed() && (passwordDoesNotContainsNumbers.isDisplayed()
						&& (passwordDoesNotContainsSpecialChar.isDisplayed()
								&& (!resetPasswordButton.isEnabled())))))) {
			log.info("OM_TC_PPB_001 is passed");
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * User enters password that contains only upper case alphabets weak strength
	 * password bar is displayed
	 * 
	 * @param input
	 */
	public void OM_TC_PPB_002(HashMap<String, String> input) {
		log.info("OM_TC_PPB_002 is running");
		util.refreshPage();
		util.click(password);
		log.info("clicked on password");
		util.hold(1);
		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_case"));
		util.hold(2);
		log.info("entered password that contains only  upper case alphabet in newPasswordInputField");
		util.hold(2);

		if (util.isElementDisplyed(weakPasswordStrengthBar)) {
			log.info("weakPasswordStrengthBar is displayed");
			log.info("OM_TC_PPB_002 is passed");
//			Weak password bar is displayed
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_PPB_002 is failed");
//			Weak password bar is not displayed
			Assert.assertTrue(false);
		}
	}

	/**
	 * check if password contains only lower case alphabet weak strength password
	 * bar is displayed
	 * 
	 * @param input
	 */
	public void OM_TC_PPB_003(HashMap<String, String> input) {
		log.info("OM_TC_PPB_003 is running");

		util.click(password);
		util.enterValue(newPasswordInputField, input.get("password_with_only_lower_case"));
		log.info("entered password that contains only  lower case alphabet in newPasswordInputField");
		util.hold(1);

		if (util.isElementDisplyed(weakPasswordStrengthBar)) {
			log.info("weakPasswordStrengthBar is displayed");
			log.info("OM_TC_PPB_003 is passed");
//			Weak password bar is displayed
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_PPB_003 is failed");
//			Weak password bar is not displayed
			Assert.assertTrue(false);
		}
	}

	/**
	 * check if password contains only lower and upper case alphabet weak strength
	 * password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsUpperAndLowerCharOnly(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_004 is running");

		util.refreshPage();
		util.click(password);
		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_lower_case"));
		log.info("entered password that contains only  lower and upper case alphabet in newPasswordInputField");
		util.hold(1);

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordDoesNotContainsNumbers.isDisplayed()
						&& (passwordDoesNotContainsSpecialChar.isDisplayed()
								&& (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains only numeric values weak strength password bar is
	 * displayed
	 * 
	 * @param input
	 */
	public void passwordContainsNumbersOnly(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_005 is running");

		util.enterValue(newPasswordInputField, input.get("password_with_only_number"));
		log.info("entered password that contains only  numeric values in newPasswordInputField");
		util.hold(1);

		if (passwordContainsEightChars.isDisplayed() && (passwordDoesNotContainsUpperCaseChar.isDisplayed()
				&& (passwordDoesNotContainsLowerCaseChar.isDisplayed() && (passwordContainsNumbers.isDisplayed()
						&& (passwordDoesNotContainsSpecialChar.isDisplayed()
								&& (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains only special character values weak strength
	 * password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsSpecialCharsOnly(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_006 is running");

		util.enterValue(newPasswordInputField, input.get("password_with_only_special_symbols"));
		log.info("entered password that contains only special character values in newPasswordInputField");
		util.hold(1);

		if (passwordContainsEightChars.isDisplayed() && (passwordDoesNotContainsUpperCaseChar.isDisplayed()
				&& (passwordDoesNotContainsLowerCaseChar.isDisplayed() && (passwordDoesNotContainsNumbers.isDisplayed()
						&& (passwordContainsSpecialChar.isDisplayed() && (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);

	}

	/**
	 * check if password contains numeric value and lowercase alphabet medium
	 * strength password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsLowerCaseAndNumbersCharsOnly(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_007 is running");

		util.enterValue(newPasswordInputField, input.get("password_with_only_lower_case_numbers"));
		log.info(
				"entered password that contains contains numeric value and lowercase alphabet in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordDoesNotContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordContainsNumbers.isDisplayed()
						&& (passwordDoesNotContainsSpecialChar.isDisplayed()
								&& (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains numeric value and uppercase alphabet medium
	 * strength password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsUpperCaseAndNumbersCharsOnly(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_008 is running");
		util.refreshPage();
		util.click(password);
		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_case_numbers"));
		log.info(
				"entered password that contains contains numeric value and uppercase alphabet in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordDoesNotContainsLowerCaseChar.isDisplayed() && (passwordContainsNumbers.isDisplayed()
						&& (passwordDoesNotContainsSpecialChar.isDisplayed()
								&& (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains numeric value and special character weak strength
	 * password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsSpecialCharsAndNumbersOnly(HashMap<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_009 is running");

		util.enterValue(newPasswordInputField, input.get("password_with_only_number_and_special_symbol"));
		log.info(
				"entered password that contains contains numeric value and special character in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordDoesNotContainsUpperCaseChar.isDisplayed()
				&& (passwordDoesNotContainsLowerCaseChar.isDisplayed() && (passwordContainsNumbers.isDisplayed()
						&& (passwordContainsSpecialChar.isDisplayed() && (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains special character and uppercase alphabet medium
	 * strength password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsSpecialCharsAndUpperCaseCharsOnly(HashMap<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_010 is running");

		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_case_Special_symbol"));
		log.info(
				"entered password that contains contains uppercase alphabet and special character in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordDoesNotContainsLowerCaseChar.isDisplayed() && (passwordDoesNotContainsNumbers.isDisplayed()
						&& (passwordContainsSpecialChar.isDisplayed() && (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains special character and lowercase alphabet medium
	 * strength password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsSpecialCharsAndLowerCaseCharsOnly(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_011 is running");
		util.enterValue(newPasswordInputField, input.get("password_with_only_lower_case_Special_symbol"));
		log.info(
				"entered password that contains contains lowercase alphabet and special character in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordDoesNotContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordDoesNotContainsNumbers.isDisplayed()
						&& (passwordContainsSpecialChar.isDisplayed() && (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains lowercase and uppercase alphabet with numeric
	 * value medium strength password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsUpperCaseAndLowerCaseCharsOnly(HashMap<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_013 is running");

		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_lower_case_number"));
		log.info(
				"entered password that contains contains lowercase and uppercase alphabet with numeric value in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordContainsNumbers.isDisplayed()
						&& (passwordDoesNotContainsSpecialChar.isDisplayed()
								&& (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains lowercase and uppercase alphabet with special
	 * character medium strength password bar is displayed
	 * 
	 * @param input
	 */
	public void passwordContainsUpperLowerCaseAndSpecialCharsOnly(Map<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_014 is running");

		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_lower_case_special_symbol"));
		log.info(
				"entered password that contains contains lowercase and uppercase alphabet with special character in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordDoesNotContainsNumbers.isDisplayed()
						&& (passwordContainsSpecialChar.isDisplayed() && (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * check if password contains both lower case and uppercase alphabet,numeric
	 * value and special character and length is greater than 7 characters
	 * 
	 * @param input
	 */
	public void passwordContainsUpperLowerCaseAndSpecialCharsOnly(HashMap<String, String> input) {
		isPasswordStrong = false;
		log.info("OM_TC_PPB_015 is running");

		util.enterValue(newPasswordInputField, pass1);
		log.info(
				"entered password that contains atleast 1 uppercase, lowercase, numbers and special characters and length is greater than 7 characters in newPasswordInputField");

		if (passwordContainsEightChars.isDisplayed() && (passwordContainsUpperCaseChar.isDisplayed()
				&& (passwordContainsLowerCaseChar.isDisplayed() && (passwordContainsNumbers.isDisplayed()
						&& (passwordContainsSpecialChar.isDisplayed() && (!resetPasswordButton.isEnabled())))))) {
			isPasswordStrong = true;
			Assert.assertTrue(isPasswordStrong);
		}

		Assert.assertTrue(isPasswordStrong);
	}

	/**
	 * Check that if weak and medium password is entered in new and confirm password
	 * input field the reset password button should be disabled
	 * 
	 * @param input
	 */
	public void OM_TC_PPB_016(HashMap<String, String> input) {
		boolean isBtnDisabled = false;
		log.info("OM_TC_PPB_016 is running");

		util.enterValue(currentPasswordInputField, pass1);
		log.info("current password is entered");
		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_lower_case"));
		log.info("weak password is entered in new PasswordInputField");
		util.enterValue(confirmPasswordInputField, input.get("password_with_only_upper_lower_case"));
		log.info("weak password is entered in confirm PasswordInputField");

		if (!resetPasswordButton.isEnabled()) {
			isBtnDisabled = true;
			Assert.assertTrue(isBtnDisabled);
		}

		Assert.assertTrue(isBtnDisabled);

		util.enterValue(currentPasswordInputField, pass1);
		log.info("current password is entered");
		util.enterValue(newPasswordInputField, input.get("password_with_only_upper_lower_case_number"));
		log.info("medium strength password is entered in new PasswordInputField");
		util.enterValue(confirmPasswordInputField, input.get("password_with_only_upper_lower_case_number"));
		log.info("medium strength password is entered in confirm PasswordInputField");

		if (util.isElementDisplyed(resetPasswordDisabled)) {
			log.info("OM_TC_PPB_016 is passed");
//			medium strength password bar is displayed and reset button is disabled
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_PPB_016 is failed");
//			medium strength password bar is not displayed and reset button is not disabled
			Assert.assertTrue(false);
		}
	}

	/**
	 * Validating that eye button is working or not that shows/hide password
	 * 
	 * @param input
	 */
	public void OM_TC_VPAS_001(HashMap<String, String> input) {
		log.info("OM_TC_VPAS_001 is running");

		util.refreshPage();
		util.click(password);
		log.info("clicked on password");
		util.enterValue(currentPasswordInputField, pass1);
		log.info("current password is entered");
		util.enterValue(newPasswordInputField, pass1);
		log.info(" password is entered in new PasswordInputField");
		util.enterValue(confirmPasswordInputField, pass1);
		log.info(" password is entered in confirm PasswordInputField");

		if (util.extractValueByAttributes(currentPasswordInputField, "type").equals("password")) {
			util.click(showHideButton.get(0));
			log.info("clicked on EYE button");
			if (util.extractValueByAttributes(currentPasswordInputField, "type").equals("text")) {
				log.info("password in currentPasswordInputField is not encrypted");
				log.info("OM_TC_VPAS_001 is passed");
//				password is visible
				Assert.assertTrue(true);
			} else {
				util.logError("OM_TC_VPAS_001 is failed");
//				password is not visible 
				Assert.assertTrue(false);
			}
		}

		if (util.extractValueByAttributes(newPasswordInputField, "type").equals("password")) {
			util.click(showHideButton.get(1));
			log.info("clicked on EYE button");
			if (util.extractValueByAttributes(newPasswordInputField, "type").equals("text")) {
				log.info("password in newPasswordInputField is not encrypted");
				log.info("OM_TC_VPAS_001 is passed");
//				password is not visible 
				Assert.assertTrue(true);
			} else {
				util.logError("OM_TC_VPAS_001 is failed");
//				password is visible
				Assert.assertTrue(false);
			}
		}

	}

	/**
	 * if 'current password' is blank, reset password button should be disabled
	 * 
	 * @param input
	 */
	public void OM_TC_SP_001(HashMap<String, String> input) {
		log.info("OM_TC_SP_001 is running");
		util.refreshPage();
		util.click(password);
		log.info("clicked on password");

		util.enterValue(currentPasswordInputField, "");
		log.info("currentPasswordInputField is blank");
		util.enterValue(newPasswordInputField, pass2);
		log.info("entered value in newPasswordInputField");
		util.enterValue(confirmPasswordInputField, pass2);
		log.info("entered value in confirmPasswordInputField");
		if (util.isElementDisplyed(resetPasswordDisabled)) {
			log.info("resetPassword button is disabled");
			log.info("OM_TC_SP_001 is passed");
//			reset password button is disabled
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_SP_001 is failed");
//			reset password button is enabled
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check whether if 'current password' is invalid, reset password button should
	 * be disabled
	 * 
	 * @param input
	 */
	public void OM_TC_SP_002(HashMap<String, String> input) {
		log.info("OM_TC_SP_002 is running");
		util.refreshPage();
		util.click(password);
		log.info("clicked on password");

		util.enterValue(currentPasswordInputField, input.get("invalid_password"));
		log.info("currentPasswordInputField have invalid password");
		util.enterValue(newPasswordInputField, pass2);
		log.info("entered value in newPasswordInputField");
		util.enterValue(confirmPasswordInputField, "Mukul@123");
		log.info("entered value in confirmPasswordInputField");
		util.click(resetPasswordButton);
		log.info("clicked on reset password button");

		if (util.isElementDisplyed(oldPassNotMatchedErrMsg)) {
			log.info("reset Password button is Disabled");
			log.info("OM_TC_SP_002 is passed");
//			reset password button is disabled
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_SP_002 is failed");
//			reset password button is enabled
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check whether if 'new password' is blank, reset password button should be
	 * disabled
	 * 
	 * @param input
	 */
	public void OM_TC_SP_003(HashMap<String, String> input) {
		log.info("OM_TC_SP_003 is running");
		util.refreshPage();
		util.click(password);
		log.info("clicked on password");

		util.enterValue(currentPasswordInputField, pass1);
		log.info("entered current Password ");
		util.enterValue(newPasswordInputField, "");
		log.info("new Password Input Field is blank");
		util.enterValue(confirmPasswordInputField, pass2);
		log.info("entered value in confirmPasswordInputField");
		if (util.isElementDisplyed(resetPasswordDisabled)) {
			log.info("reset Password button is Disabled");
			log.info("OM_TC_SP_003 is passed");
//			reset password button is disabled
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_SP_003 is failed");
//			reset password button is enabled
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check whether if 'confirm password' is blank, reset password button should be
	 * disabled
	 * 
	 * @param input
	 */
	public void OM_TC_SP_004(HashMap<String, String> input) {
		log.info("OM_TC_SP_004 is running");
		util.refreshPage();
		util.click(password);
		log.info("clicked on password");

		util.enterValue(currentPasswordInputField, pass1);
		log.info("entered current Password ");

		util.enterValue(newPasswordInputField, pass2);
		log.info("entered value in new PasswordInputField");

		util.enterValue(confirmPasswordInputField, "");
		log.info("confirm Password Input Field is blank");

		if (util.isElementDisplyed(resetPasswordDisabled)) {
			log.info("reset Password button is Disabled");
			log.info("OM_TC_SP_004 is passed");
//			reset password button is disabled
			Assert.assertTrue(true);
		} else {
//			reset password button is enabled
			util.logError("OM_TC_SP_004 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check when current password is invalid and new password and confirm password
	 * is not matched reset password button should be disabled
	 * 
	 * @param input
	 */
	public void OM_TC_SP_006(HashMap<String, String> input) {
		log.info("OM_TC_SP_006 is running");

		util.enterValue(currentPasswordInputField, input.get("invalid_password"));
		log.info("entered invalid current Password ");

		util.enterValue(newPasswordInputField, pass1);
		log.info("entered value in new PasswordInputField");

		util.enterValue(confirmPasswordInputField, pass2);
		log.info("entered value in confirm PasswordInputField");

		if (util.isElementDisplyed(passwordDoesNotMatchErrorMsg) && util.isElementDisplyed(resetPasswordDisabled)) {
			log.info(
					"entered value in new PasswordInputField and confirm password field do not match and current password is invalid");
			log.info("password Does Not Match Error Msg is diplayed && reset Password is Disabled ");
			log.info("OM_TC_SP_006 is passed");
//			reset password button is disabled
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_SP_006 is failed");
//			reset password button is enabled
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check whether clicking on save password button {if current password is valid
	 * and new password is same as confirm password}, password should be changed
	 * 
	 * @param input
	 */
	public void OM_TC_SP_007(HashMap<String, String> input) {
		log.info("OM_TC_SP_007 is running");

		util.refreshPage();
		util.click(password);
		log.info("clicked on password");

		util.enterValue(currentPasswordInputField, pass1);
		log.info("entered current Password ");
		util.enterValue(newPasswordInputField, pass2);
		log.info("entered valid value in new PasswordInputField");
		util.enterValue(confirmPasswordInputField, pass2);
		log.info("entered valid value in confirm PasswordInputField");
		util.click(resetPasswordButton);
		log.info("clicked on reset password password");
		util.hold(5);

		if (util.isElementDisplyed(passwordUpdatedSuccessfullyMsg)) {
			log.info("password Updated Successfully toast Msg is displayed");
			log.info("OM_TC_SP_007 is passed");
//			password is changed
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_SP_007 is failed");
//			password is not changed
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check whether clicking on save password button {if current password is valid
	 * and new password is same as confirm password}, password should be changed
	 * 
	 * @param input
	 */
	public void OM_TC_SP_007II(HashMap<String, String> input) {
		util.refreshPage();
		util.click(password);
		log.info("clicked on password");
		util.enterValue(currentPasswordInputField, pass2);
		log.info("entered current Password ");
		util.enterValue(newPasswordInputField, pass1);
		log.info("entered valid value in new PasswordInputField");
		util.enterValue(confirmPasswordInputField, pass1);
		log.info("entered valid value in confirm PasswordInputField");
		util.click(resetPasswordButton);
		log.info("clicked on reset password password");
		util.hold(5);

		if (util.isElementDisplyed(passwordUpdatedSuccessfullyMsg)) {
			log.info("password Updated Successfully toast Msg is displayed");
			log.info("OM_TC_SP_007 is passed");
			Assert.assertTrue(true);
		} else {
			util.logError("OM_TC_SP_007 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check store url is visible or not
	 */
	public void OM_TC_GEN_001() {
		log.info("OM_TC_GEN_001 is running");

		util.click(general);
		log.info("clciked on general");

		if (util.isElementDisplyed(storeURLValue)) {
			log.info("storeURLValue is displayed");
			log.info("OM_TC_GEN_001 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_001 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check registered email url is visible or not
	 */
	public void OM_TC_GEN_002() {
		log.info("OM_TC_GEN_002 is running");

		if (util.isElementDisplyed(emailHeadingValue)) {
			log.info("email is displayed");
			log.info("OM_TC_GEN_002 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_002 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check registered email url is visible or not
	 * 
	 * @param input
	 */
	public void OM_TC_GEN_003(HashMap<String, String> input) {
		log.info("OM_TC_GEN_003 is running");

		if (util.getTagValue(emailHeadingValue).equals(util.getProperty("email"))) {
			log.info("OM_TC_GEN_003 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_003 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check pixel id is visible or not
	 */
	public void OM_TC_PIX_001() {
		log.info("OM_TC_PIX_001 is running");

		util.click(account);
		log.info("clicked on account");

		if (util.isElementDisplyed(pixelIDHeadingValue)) {
			log.info("pixelID is displayed");
			log.info("OM_TC_PIX_001 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_PIX_001 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check that clicking on edit icon, edit pixel will open a modal with pixel
	 * dropdown and cancel and save changes
	 */
	public void OM_TC_PIX_002() {
		log.info("OM_TC_PIX_002 is running");

		util.click(pixelIDEditButton);
		log.info("clicked on edit pixelId button");

		if (util.isElementDisplyed(EditModalHeading) && util.isElementDisplyed(EditModalCrossButton)
				&& util.isElementDisplyed(cancelButtonOfEditModal)
				&& util.isElementDisplyed(saveChangesButtonOfEditModal)) {
			log.info("Edit pixel Modal is displayed");
			log.info("OM_TC_PIX_002 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_PIX_002 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check the first loading time of pixel dropdown
	 */
	public void OM_TC_PIX_003_004() {
		log.info("OM_TC_PIX_003_004 is running");

		util.click(pixelSelector);
		log.info("clicked on  pixelId dropdown");
		util.waitUntilElementIsVisible(allPixelId.get(0));

		for (WebElement pixelId : allPixelId) {
			if (util.isElementDisplyed(pixelId)) {
				log.info("pixelId Values are displayed");
				log.info("OM_TC_PIX_003_004 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_PIX_003_004 is failed");
				Assert.assertTrue(false);
			}
		}

	}

	/**
	 * check that after clicking on cancel button user will be redirected back to
	 * the general details section
	 */
	public void OM_TC_PIX_005() {
		log.info("OM_TC_PIX_005 is running");

		util.click(EditModalCrossButton);
		log.info("clicked on cross button");
		try {
			if ((!util.isElementDisplyed(EditModalHeading) && !util.isElementDisplyed(EditModalCrossButton)
					&& !util.isElementDisplyed(cancelButtonOfEditModal)
					&& !util.isElementDisplyed(saveChangesButtonOfEditModal))) {
				log.info("edit pixel modal is closed");
				log.info("OM_TC_PIX_005 is passed");
				Assert.assertTrue(true);
			} else {
				log.info("OM_TC_PIX_005 is failed");
				Assert.assertTrue(false);
			}
		} catch (NoSuchElementException e) {
			log.info("edit pixel modal is closed");
			log.info("OM_TC_PIX_005 is passed");
			Assert.assertTrue(true);
		}
//		
	}

	/**
	 * check that "Save Changes" button is disabled until user selects pixel id
	 */
	public void OM_TC_PIX_006_007() {
		log.info("OM_TC_PIX_006_007 is running");

		String oldSelectedPixelId = util.getTagValue(pixelIDHeadingValue);
		util.click(pixelIDEditButton);
		log.info("clicked on edit button");
		util.hold(2);

		if (util.isElementDisplyed(resetPasswordDisabled)) {
			log.info("save changes button is disabled");
			log.info("OM_TC_PIX_006_007 is passed");
			Assert.assertTrue(true);
		} else {
			log.info("OM_TC_PIX_006_007 is failed");
			Assert.assertTrue(false);
		}
		util.actionClick(pixelSelector);
		log.info("clicked on pixel dropdown");

		if (!allPixelId.get(0).findElement(By.tagName("h3")).getText().contains(oldSelectedPixelId)) {
			allPixelId.get(0).click();
			log.info("clicked on pixelId ");
			util.hold(5);
		} else {
			allPixelId.get(1).click();
			log.info("clicked on pixelId ");
			util.hold(5);
		}
		util.click(saveChangesButtonOfEditModal);
		log.info("clicked on save changes button ");

		util.hold(10);
		util.refreshPage();
		util.click(account);
		log.info("clicked on account ");
		String CurrentSelectedPixelId = util.getTagValue(pixelIDHeadingValue);

		if (!oldSelectedPixelId.equals(CurrentSelectedPixelId)) {
			log.info("oldSelectedPixelId is not equal to CurrentSelectedPixelId");
			log.info("OM_TC_PIX_006_007 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_PIX_006_007 is passed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Organisation/Brand name should be visible
	 */
	public void OM_TC_GEN_011() {
		log.info("OM_TC_GEN_011 is running");

		util.refreshPage();
		util.click(general);
		log.info("clicked on general ");
		if (util.isElementDisplyed(brandNameHeadingValue)) {
			log.info("brand name is displayed ");
			log.info("OM_TC_GEN_011 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_011 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check that clicking on edit brand name will open a modal with edit name
	 * filed, cancel and save option
	 */
	public void OM_TC_GEN_012() {
		log.info("OM_TC_GEN_012 is running");

		util.click(brandNameEditButton);
		log.info("clicked on edit button ");

		if (util.isElementDisplyed(editBrandNameInputField) && util.isElementDisplyed(EditModalCrossButton)
				&& util.isElementDisplyed(cancelButtonOfEditModal)
				&& util.isElementDisplyed(saveChangesButtonOfEditModal)) {
			log.info("edit brand name modal is displayed ");
			log.info("OM_TC_GEN_012 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_012 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check Organisation/Brand name field should be editable
	 * 
	 * @param input
	 */
	public void OM_TC_GEN_013(HashMap<String, String> input) {
		log.info("OM_TC_GEN_013 is running");

		util.enterValue(editBrandNameInputField, input.get("brand_name"));
		log.info("entered brand value");
		if (util.extractValueByAttributes(editBrandNameInputField, "value").equals(input.get("brand_name"))) {
			log.info("OM_TC_GEN_013 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_013 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check when user enter the organization name above the max. limit(max. =
	 * 100charcter) error messge should displayed
	 */
	public void OM_TC_GEN_014() {
		log.info("OM_TC_GEN_014 is running");

		String maxChar = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum.";
		util.enterValue(editBrandNameInputField, maxChar);
		log.info("entered brand value");

		if (util.isElementDisplyed(brandNameWordLimitErrorMsg)) {
			log.info("error msg is displayed");
			log.info("OM_TC_GEN_014 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_014 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check that when merchant click on cancel button then modal get closed or not
	 * => it should close
	 */
	public void OM_TC_GEN_015() {
		log.info("OM_TC_GEN_015 is running");

		util.click(EditModalCrossButton);
		log.info("clicked on cross button");

		try {
			if ((!util.isElementDisplyed(editBrandNameInputField) && !util.isElementDisplyed(EditModalCrossButton)
					&& !util.isElementDisplyed(cancelButtonOfEditModal)
					&& !util.isElementDisplyed(saveChangesButtonOfEditModal))) {
				log.info("edit modal is not displayed");
				log.info("OM_TC_GEN_015 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_GEN_015 is failed");
				Assert.assertTrue(false);
			}
		} catch (NoSuchElementException e) {
			log.info("edit modal is not displayed");
			log.info("OM_TC_GEN_015 is passed");
			Assert.assertTrue(true);
		}
	}

	/**
	 * Check when user enters the Organisation/Brand name and clicks on Save button
	 * then modal closes and merchant navigates back to general details section.
	 * 
	 * @param input
	 */
	public void OM_TC_GEN_016_017(HashMap<String, String> input) {
		log.info("OM_TC_GEN_016_017 is running");

		util.click(brandNameEditButton);
		log.info("clicked on edit button");
		util.enterValue(editBrandNameInputField, input.get("new_brand_name"));
		log.info("entered brand name");
		util.click(saveChangesButtonOfEditModal);
		log.info("clicked on save button");
		util.hold(5);

		util.refreshPage();
		util.click(general);
		util.hold(5);

//		Check after editing the organisation/brand name is visible in the Account details
		if (util.getTagValue(brandNameHeadingValue).equals(input.get("new_brand_name"))) {
			log.info("brand name is updated");
			log.info("OM_TC_GEN_016_017 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GEN_016_017 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check that Active account banner is visible when fb ads account is connected
	 * => it should be active
	 */
	public void OM_TC_ACS_001() {
		log.info("OM_TC_ACS_001 is running");

		util.click(account);
		log.info("clicked on account");

		if (util.isElementDisplyed(activeAccount)) {
			log.info("Active account banner is visible");
			log.info("OM_TC_ACS_001 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_ACS_001 is failed");
			Assert.assertTrue(false);
		}

	}

}
