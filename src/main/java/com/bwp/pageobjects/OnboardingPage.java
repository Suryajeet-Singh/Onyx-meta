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
 * Date of change: Jan 03 2023
 * Version: 0.0 
 * changed function: All functions
 * change description: Updated pageObjects
 * Modified By: Yatindra Kinker
 */

public class OnboardingPage extends OnboardingPageObjects {
	Utilities util;
	private static Logger log = LogManager.getLogger(OnboardingPage.class.getName());
	private String confPass = util.getProperty("confirm_password");
	private String confPass2 = util.getProperty("confirm_password_2");
	private String fbPass = util.getProperty("fb_password");

	String nameOfBrandWithHundredCharacters = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m Aenean m";

	public OnboardingPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

	public void OM_TC_REG_001(HashMap<String, String> input) {
		util.logInfo("RUNNING TEST CASE OM_TC_REG_001");
//		Check for the alphanumeric characters in the name field
		util.enterValue(brandName, input.get("brand_name"));
		util.logInfo("Entered alphanumeric characters in the brand/organization name field");

		String valueInTheBrandInputField = util.extractValueByAttributes(brandName, "value");
		if (!valueInTheBrandInputField.equals(null)) {
			Assert.assertEquals(valueInTheBrandInputField, input.get("brand_name"));
			util.logInfo("OM_TC_REG_001 passed");
			util.logInfo("alphanumeric characters are acceptable in brand/organization input field");
		}

	}

	public void OM_TC_REG_002() {
		util.logInfo("RUNNING TEST CASE OM_TC_REG_002");
//		Check the limitation of character in the Organization name.
		util.enterValue(brandName, nameOfBrandWithHundredCharacters);
		util.logInfo("Entered 100 characters in the brand/organization name field");
		util.pressTab();
		util.logInfo("press tab button");
		if (util.isElementDisplyed(maxCharacterLimitMessage) && !util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			util.logInfo("Maximum character limit is 100.---> error msg is displayed");
			util.logInfo("OM_TC_REG_002 passed");

		} else {
			Assert.assertTrue(false);
			util.logError("OM_TC_REG_002 failed");
		}
	}

	public void OM_TC_REG_003() {
		util.logInfo("RUNNING TEST CASE OM_TC_REG_003");
//		Check by entering “Spaces” in the prefix and suffix of the entered character-Trimming of space.
		util.enterValue(brandName, "  brand  ");
		util.logInfo(
				"Entered brand name that contains spaces before and after it in the brand/organization name field");
		if (util.extractValueByAttributes(brandName, "value").contains(" ")) {
			Assert.assertTrue(true);
			util.logInfo("OM_TC_REG_003 passed");
		} else {
			util.logError("OM_TC_REG_003 failed");
			Assert.assertTrue(false);

		}
	}

	public void OM_TC_REG_004() {
		util.logInfo("RUNNING TEST CASE OM_TC_REG_004");
//		Check by entering only “Spaces” in the name field
		util.enterValue(brandName, "     ");
		util.logInfo("Entering only whitespaces in brand name input field");
		if (!util.extractValueByAttributes(brandName, "value").contains(" ")) {
			Assert.assertTrue(true);
			util.logInfo("brand name input field is not accepting whitespaces.");
			util.logInfo("OM_TC_REG_004 passed");
		} else {
			util.logError("OM_TC_REG_004 failed");
			Assert.assertTrue(false);

		}
	}

	public void OM_TC_REG_005(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_005");
//		Check for the special symbol in the name field
		util.enterValue(brandName, "!@#");
		log.info("Entered only special characters in brand name input field");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, input.get("password"));
		log.info("Entered password");

		util.enterValue(confirmPasswordInputField, confPass);
		log.info("Entered confirm password");
		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			log.info("brand name input field is accepting special characters.");
			log.info("OM_TC_REG_005 passed");
		} else {
			log.error("OM_TC_REG_005 failed");
			Assert.assertTrue(false);

		}
	}

//	public void OM_TC_REG_006() {
//		log.info("RUNNING TEST CASE OM_TC_REG_006");
////		Register account using valid email address
//		util.enterValue(brandName, input.get("brand_name"));
//		util.enterValue(emailInputField, "yatindrakinker23@gmail.com");
//		util.enterValue(passwordInputField, input.get("password");
//		util.enterValue(confirmPasswordInputField, confPass;
//		if(!util.isElementSelected(acceptTermsConditionsCheckBox)) {
//			acceptTermsConditionsCheckBox.click();
//		}
//		util.click(createAccountButton);
//		if(util.isElementDisplyed(toastMsg)){
//			Assert.assertTrue(true);
//		} else {
//			Assert.assertTrue(false);
//		}
//	}

	public void OM_TC_REG_007(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_007");
//		Register account using invalid email address
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("invalid_email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, input.get("password"));
		log.info("Entered password");

		util.enterValue(confirmPasswordInputField, confPass);
		log.info("Entered confirm password");
		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(toastMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_REG_012(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_012");
//		check that if blank spaces are passed in password fields.
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "   ");
		log.info("Entered only whitespace in password");

		util.enterValue(confirmPasswordInputField, "   ");
		log.info("Entered only whitespace in confirm password");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if ((!util.extractValueByAttributes(passwordInputField, "value").contains(" "))
				&& (!util.extractValueByAttributes(confirmPasswordInputField, "value").contains(" "))
				&& (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("password input field and confirm password input field is not  accepting whitespaces.");
			log.info("OM_TC_REG_012 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_012 failed");
		}

	}

	public void OM_TC_REG_020(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_020");
//		check if password contains only upper case alphabet
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "AAAAAAAA");
		log.info("Entered password only in uppercase letter ");

		util.enterValue(confirmPasswordInputField, "AAAAAAAA");
		log.info("Entered confirm password only in uppercase letter ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("weak password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_020 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_020 failed.");
		}

	}

	public void OM_TC_REG_021(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_021");
//		check if password contains only lower case alphabet
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "aaaaaaaa");
		log.info("Entered password only in lowercase letter ");

		util.enterValue(confirmPasswordInputField, "aaaaaaaa");
		log.info("Entered confirm password only in lowercase letter ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("weak password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_021 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_021 failed.");
		}

	}

	public void OM_TC_REG_022(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_022");
//		check if password contains both upper and lower case alphabet
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "AAAAaaaa");
		log.info("Entered password contains only  uppercase and lowercase letter ");

		util.enterValue(confirmPasswordInputField, "AAAAaaaa");
		log.info("Entered confirm password contains only  uppercase and lowercase letter ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("weak password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_022 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_022 failed.");
		}

	}

	public void OM_TC_REG_023(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_023");
//		check if password contains only numeric values
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "12345678");
		log.info("Entered password contains only numbers ");

		util.enterValue(confirmPasswordInputField, "12345678");
		log.info("Entered confirm password contains only numbers ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("weak password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_023 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_023 failed.");
		}

	}

	public void OM_TC_REG_024(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_024");
//		check if password contains only special character values
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "@@@@@@@@");
		log.info("Entered password contains only special characters ");

		util.enterValue(confirmPasswordInputField, "@@@@@@@@");
		log.info("Entered confirm password contains only special characters ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("weak password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_024 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_024 failed.");
		}

	}

	public void OM_TC_REG_025(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_025");
//		check if password contains numeric value and lowercase alphabet
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "suryajeet123");
		log.info("Entered password contains only numbers and lowercase alphbets ");

		util.enterValue(confirmPasswordInputField, "suryajeet123");
		log.info("Entered confirm password contains only numbers and lowercase alphbets ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("medium strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_025 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_025 failed.");
		}

	}

	public void OM_TC_REG_026(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_026");
//		check if password contains numeric value and uppercase alphabet
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "SURYAJEET123");
		log.info("Entered password contains only numbers and uppercase alphbets ");

		util.enterValue(confirmPasswordInputField, "SURYAJEET123");
		log.info("Entered confirm password contains only numbers and uppercase alphbets ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("medium strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_026 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_026 failed.");
		}
	}

	public void OM_TC_REG_027(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_027");
//		check if password contains numeric value and special character
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "@#$!%123");
		log.info("Entered password contains only numbers and special characters ");

		util.enterValue(confirmPasswordInputField, "@#$!%123");
		log.info("Entered confirm password contains only numbers and special characters ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("weak strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_027 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_027 failed.");
		}

	}

	public void OM_TC_REG_028(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_028");
//		check if password contains special character and uppercase alphabet

		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "@#$!%AAA");
		log.info("Entered password contains only uppercase letters and special characters ");

		util.enterValue(confirmPasswordInputField, "@#$!%AAA");
		log.info("Entered confirm password contains only uppercase letters and special characters ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("medium strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_028 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_028 failed.");
		}

	}

	public void OM_TC_REG_029(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_029");
//		check if password contains special character and lowercase alphabet

		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "@#$!%aaa");
		log.info("Entered password contains only lowercase letters and special characters ");

		util.enterValue(confirmPasswordInputField, "@#$!%aaa");
		log.info("Entered confirm password contains only lowercase letters and special characters ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("medium strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_029 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_029 failed.");
		}

	}

	public void OM_TC_REG_031(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_031");
//		check if password contains lowercase and uppercase alphabet with numeric value 

		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "123aaaA");
		log.info("Entered password contains  lowercase , uppercase letters and numbers only ");

		util.enterValue(confirmPasswordInputField, "123aaaA");
		log.info("Entered confirm password contains  lowercase , uppercase letters and numbers only ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("medium strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_031 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_031 failed.");
		}

	}

	public void OM_TC_REG_032(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_032");
//		check if password contains lowercase and uppercase alphabet with special character
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "@#$!%Aaa");
		log.info("Entered password contains  lowercase , uppercase letters and special characters only ");

		util.enterValue(confirmPasswordInputField, "@#$!%Aaa");
		log.info("Entered confirm password contains  lowercase , uppercase letters and special characters only ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("medium strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_032 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_032 failed.");
		}

	}

	public void OM_TC_REG_033(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_033");
//		check if password contains both lower case and uppercase alphabet,numeric value and special character
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, input.get("password"));
		log.info(
				"Entered password contains  lowercase , uppercase letters and special characters and numbers and password length >=8 ");

		util.enterValue(confirmPasswordInputField, confPass);
		log.info(
				"Entered confirm password contains  lowercase , uppercase letters and special characters and numbers and password length >=8 ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(strongPasswordStrengthBar) && (util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("strong strength password bar is displayed and create account button is enabled.");
			log.info("OM_TC_REG_033 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_033 failed.");
		}

	}

	public void OM_TC_REG_034(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_034");
//		Check that weak and medium password is not accepted and display error messege
		util.enterValue(brandName, input.get("brand_name"));
		log.info("Entered  brand name ");

		util.enterValue(emailInputField, input.get("email"));
		log.info("Entered email address");

		util.enterValue(passwordInputField, "@#$!%Aaa");
		log.info("Entered password have medium strength ");

		util.enterValue(confirmPasswordInputField, "@#$!%Aaa");
		log.info("Entered confirm password have medium strength ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("clicked on accept Terms Conditions CheckBox");
		}
		if (util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("medium strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_034 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_034 failed.");
		}

		util.enterValue(passwordInputField, "Aaa");
		log.info("Entered confirm password have weak strength ");

		util.enterValue(confirmPasswordInputField, "Aaa");
		log.info("Entered confirm password have weak strength ");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is checked");
		}
		if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
			Assert.assertTrue(true);
			log.info("weak strength password bar is displayed and create account button is disabled.");
			log.info("OM_TC_REG_034 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_034 failed.");
		}
	}

	public void OM_TC_REG_035() {
		log.info("RUNNING TEST CASE OM_TC_REG_035");
//		Check when all fields are blank and click on create account button
		util.enterValue(brandName, "");
		log.info("brand name is empty");

		util.enterValue(emailInputField, "");
		log.info("email Input Field is empty");

		util.enterValue(passwordInputField, "");
		log.info("password Input Field is empty");

		util.enterValue(confirmPasswordInputField, "");
		log.info("confirm password Input Field is empty");

		if (util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is unchecked");
		}

		if (!util.isElementEnabled(createAccountButton)) {
			log.info("all fields have no value hence create account button is disabled");
			log.info("OM_TC_REG_035 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_035 failed");
		}
	}

	public void OM_TC_REG_036(HashMap<String, String> input) {
		util.refreshPage();
		log.info("RUNNING TEST CASE OM_TC_REG_036");
//		Check when Organization name/Brand name field are blank and click on create account button
		util.enterValue(brandName, "");
		log.info("brand name is empty");

		util.enterValue(emailInputField, input.get("email"));
		log.info("email is entered");

		util.enterValue(passwordInputField, input.get("password"));
		log.info("password is entered");

		util.enterValue(confirmPasswordInputField, confPass);
		log.info("confirm password is entered");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is checked");
		}

		if (!util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			log.info("brand Name have no value hence create account button is disabled");
			log.info("OM_TC_REG_036 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_036 failed");
		}
	}

	public void OM_TC_REG_037(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_037");
//		Check when email field are blank and click on create account button
		util.refreshPage();
		util.enterValue(brandName, input.get("brand_name"));
		log.info("brand name entered successfully");

		util.enterValue(emailInputField, "");
		log.info("email input field is empty");

		util.enterValue(passwordInputField, input.get("password"));
		log.info("password is entered");

		util.enterValue(confirmPasswordInputField, confPass);
		log.info("confirm password is entered");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is checked");
		}

		if (!util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			log.info("email have no value hence create account button is disabled");
			log.info("OM_TC_REG_037 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_037 failed");
		}
	}

	public void OM_TC_REG_038(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_038");
		util.refreshPage();
		util.hold(2);
//		Check when new password field are blank and click on create account button
		util.enterValue(brandName, input.get("brand_name"));
		log.info("brand name entered successfully");

		util.enterValue(emailInputField, input.get("email"));
		log.info("email entered successfully");

		util.enterValue(passwordInputField, "");
		log.info("password input field is empty");

		util.enterValue(confirmPasswordInputField, confPass);
		log.info("confirm password is entered");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is checked");
		}

		if (!util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			log.info("password have no value hence create account button is disabled");
			log.info("OM_TC_REG_038 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_038 failed");
		}
	}

	public void OM_TC_REG_039(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_039");
		util.refreshPage();
		util.hold(2);
//		Check when confirm password field are blank and click on create account button
		util.enterValue(brandName, input.get("brand_name"));
		log.info("brand name entered successfully");

		util.enterValue(emailInputField, input.get("email"));
		log.info("email entered successfully");

		util.enterValue(passwordInputField, input.get("password"));
		log.info("password is entered");

		util.enterValue(confirmPasswordInputField, "");
		log.info("confirm password is empty");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is checked");
		}

		util.hold(2);
//		onboardingPageObj.clickOnCreateAccount();
		if (!util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			log.info(" confirm password have no value hence create account button is disabled");
			log.info("OM_TC_REG_039 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_039 failed");
		}

	}


	public void OM_TC_REG_041(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_041");
//		Check when email is invalid and new password and confirm password is not matched and click on create account
		util.enterValue(brandName, input.get("brand_name"));
		log.info("brand name entered successfully");

		util.enterValue(emailInputField, "suryajeet@@gmail.com");
		log.info("invalid email entered successfully");

		util.enterValue(passwordInputField, input.get("password"));
		log.info("password is entered");

		util.enterValue(confirmPasswordInputField, "Ankit@123");
		log.info("confirm password is entered");

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is checked");
		}

		if (!util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			log.info("password and confirm password do not match hence create account button is disabled");
			log.info("OM_TC_REG_041 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_041 failed");
		}
	}

	public void OM_TC_REG_042(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_REG_042");
//		Check when email is valid and new password and confirm password is match and not accept the terms and conditions then click on create account
		util.enterValue(brandName, input.get("brand_name"));
		log.info("brand name entered successfully");

		util.enterValue(emailInputField, input.get("email"));
		log.info("invalid email entered successfully");

		util.enterValue(passwordInputField, input.get("password"));
		log.info("password is entered");

		util.enterValue(confirmPasswordInputField, confPass);
		log.info("confirm password is entered");

		if (util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is unchecked");
		}
		if (!util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
			log.info("accept Terms and Conditions CheckBox is not checked hence create account button is disabled");
			log.info("OM_TC_REG_042 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_REG_042 failed");
		}
	}

	public void OM_TC_REG_011(HashMap<String, String> input) {
//		Check the password limit when enter value less than 8 char
		util.refreshPage();
		String password = input.get("password");
		int passwordLen = password.length();
		util.enterValue(brandName, input.get("brand_name"));
		log.info("brand name entered successfully");

		util.enterValue(emailInputField, input.get("email"));
		log.info("email entered successfully");
		if (passwordLen < 8) {
			util.enterValue(passwordInputField, "Y@ti123");

			if ((util.isElementDisplyed(mediumPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton)))) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
			util.enterValue(passwordInputField, "Yatindra");

			if (util.isElementDisplyed(weakPasswordStrengthBar) && (!util.isElementEnabled(createAccountButton))) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		util.enterValue(confirmPasswordInputField, password);
		log.info("confirm password is entered");
		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			acceptTermsConditionsCheckBox.click();
			log.info("Terms and Condition checkbox is unchecked");
		}

	}

	public void OM_TC_REG_009(HashMap<String, String> input) {
		util.refreshPage();
//		Check when user is using already registered email
		util.enterValue(brandName, input.get("brand_name"));
		util.enterValue(emailInputField, input.get("already_registered_email"));
		util.enterValue(passwordInputField, input.get("password"));
		util.enterValue(confirmPasswordInputField, input.get("password"));
		util.click(createAccountButton);
		util.hold(2);
		if (util.isElementDisplyed(errorMessage)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_REG_013(HashMap<String, String> input) {

//		Check if new password is not same as confirm password
		util.enterValue(brandName, " ");
		util.enterValue(emailInputField, " ");
		util.enterValue(passwordInputField, input.get("password"));
		util.enterValue(confirmPasswordInputField, confPass2);
		if (util.isElementDisplyed(passwordNotMatchingErrorMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_REG_015(HashMap<String, String> input) {
//		Check if new password is same as confirm password
		util.enterValue(brandName, " ");
		util.enterValue(emailInputField, " ");
		util.enterValue(passwordInputField, input.get("password"));
		util.enterValue(confirmPasswordInputField, input.get("password"));

		try {
			if (!util.isElementDisplyed(passwordNotMatchingErrorMsg)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(true);
		}

	}

	public void OM_TC_REG_017(HashMap<String, String> input) {
//		Check the password view functionality so that the user can see the entered password
		util.refreshPage();
		util.enterValue(passwordInputField, input.get("password"));
		util.click(showHidePassword);
		if (util.extractValueByAttributes(passwordInputField, "type").equals("text")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		util.click(showHidePassword);
		if (util.extractValueByAttributes(passwordInputField, "type").equals("password")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_REG_008(HashMap<String, String> input) {
//		Register account using invalid email address

		util.enterValue(brandName, input.get("brand_name"));
		util.enterValue(emailInputField, input.get("invalid_email"));
		util.enterValue(passwordInputField, input.get("password"));
		util.enterValue(confirmPasswordInputField, input.get("password"));
		try {
			util.click(createAccountButton);
		} catch (Exception e) {

			if (util.isElementDisplyed(errorMessage) || !util.isElementEnabled(createAccountButton)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

	}

	public void OM_TC_REG_010(HashMap<String, String> input) {
//		Check when user is using already registered email
		util.enterValue(brandName, input.get("brand_name"));
		util.enterValue(emailInputField, input.get("email"));
		util.enterValue(passwordInputField, input.get("password"));
		util.enterValue(confirmPasswordInputField, input.get("password"));
		util.click(createAccountButton);
		if (util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_REG_044() {
//		Try to "Create Account " without entering any data on the mandatory fields
		util.refreshPage();
		util.enterValue(brandName, "");
		util.enterValue(emailInputField, "");
		util.enterValue(passwordInputField, "");
		util.enterValue(passwordInputField, "");
		util.click(createAccountButton);
		if (!util.isElementEnabled(createAccountButton)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void createUser(HashMap<String, String> input) {
		util.refreshPage();
		if (!input.get("brand_name").equals("")) {
			util.inpuData(brandName, input.get("brand_name"));
		}

		if (input.get("email").matches("[\\w]+@[\\w]+\\.[a-zA-Z]{2,3}")) {
			util.inpuData(emailInputField, input.get("email"));
		}

		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,}$";
		if (input.get("password").matches(passwordRegex)) {
			util.inpuData(passwordInputField, input.get("password"));

		}

		if (confPass.matches(passwordRegex)
				&& input.get("password").equals(confPass)) {
			util.inpuData(confirmPasswordInputField, confPass);
		}

		if (!util.isElementSelected(acceptTermsConditionsCheckBox)) {
			util.click(acceptTermsConditionsCheckBox);
		}

		util.click(createAccountButton);
		util.hold(15);
		/*
		 * if (util.isElementDisplyed(otpModal)) { Assert.assertTrue(true); } else {
		 * Assert.assertTrue(false); }
		 * 
		 * util.hold(20);
		 */
		util.click(authorizedAndConnectButton);
		util.hold(7);
//		util.getWindoHandleByTitle("Log in to Facebook | Facebook", "switched to facebook");
//		util.hold(5);
		util.enterValue(fbLoginInputField, input.get("fb_email"));
		util.enterValue(fbPasswordInputField, fbPass);
		util.click(fbLoginButton);
		util.hold(5);
		util.pressEscape();
		util.hold(10);
		util.click(contiuneAsUserNameButton);
		util.hold(5);
		util.click(continueBtnConnectToCedcommerce);
		util.hold(5);
		util.click(allAdAccounts.get(1));
		util.hold(2);
		util.click(continueBtn);
		util.hold(5);
		util.click(allAdAccounts.get(0));
		util.hold(5);
		util.click(continueBtn);
		util.hold(5);
		util.click(continueBtn);
		util.hold(5);
		util.click(nextButtonOnCedcommerceAllowedToPage);
		util.hold(20);
		util.click(doneButtonYouAreAllSetPage);
		util.hold(5);
	}
}
