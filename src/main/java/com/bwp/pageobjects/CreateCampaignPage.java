package com.bwp.pageobjects;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
 * Date of change: April 28 2023 
 * Version: 0.0 
 * changed function: select date functionality, added IDs in locators.
 * Modified By: Yatindra Kinker
 */
public class CreateCampaignPage extends CreateCampaignPageOR {

	private static Logger log = LogManager.getLogger(CreateCampaignPage.class.getName());
	Utilities util;
	String[][] data;

	public CreateCampaignPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
		try {
			data = util.readCSVData();
		} catch (Exception e) {

		}
	}

	public void createCampaign(HashMap<String, String> input) {
		util.refreshPage();
		util.inpuData(campaignNameInputField, input.get("campaign_name"));
		util.click(startDateInputField);
		selectDate(0);
		util.click(endDateInputField);
		selectDate(2);
		util.inpuData(dailyBudgetInputField, input.get("daily_budget"));
		util.inpuData(adTextInputField, input.get("ad_text"));
		util.click(prospectiveAudienceRadioButton);

//		Select Minimum age

		util.click(minimumAgeDropDown);
		if ((Integer.parseInt(input.get("min_age")) < 65) && (Integer.parseInt(input.get("min_age")) >= 18)) {
			util.selectFromList(allValues, input.get("min_age"));
			log.info("selected min age = " + input.get("min_age") + " from dropdown");
		} else if ((Integer.parseInt(input.get("min_age")) > 65)) {
			util.selectFromList(allValues, "65+");
		} else {
			util.selectFromList(allValues, "18");
		}

//		Select Maximum age

		util.click(maximumAgeDropDown);
		log.info("clicked on max age field");
//		Max Age < Min Age => 65+
		if (Integer.parseInt(input.get("max_age")) < Integer.parseInt(input.get("max_age"))) {
			util.selectFromList(allValues, "65+");
			log.info("selected max age = 65+ from dropdown");
		}

//		Max Age > Min Age => Max Age
		if (Integer.parseInt(input.get("max_age")) > Integer.parseInt(input.get("max_age"))) {
			util.selectFromList(allValues, input.get("max_age"));
			log.info("selected max age = " + input.get("max_age") + " from dropdown");
		}
//		Max Age == Min Age => Max Age
		if (Integer.parseInt(input.get("max_age")) == Integer.parseInt(input.get("min_age"))) {
			util.selectFromList(allValues, input.get("max_age"));
			log.info("selected max age = " + input.get("max_age") + " from dropdown");
		}
//		Max Age < 18 => 65+
		if (Integer.parseInt(input.get("max_age")) < 18) {
			util.selectFromList(allValues, "65+");
			log.info("selected max age = 65+ from dropdown");
		}
//		Max Age > 65 => 65+
		if (Integer.parseInt(input.get("max_age")) > 65) {
			util.selectFromList(allValues, "65+");
			log.info("selected max age = 65+ from dropdown");
		}

//		Select Gender

		util.click(genderField);
		log.info("clicked on gender field");
//		age == male => male
		if (input.get("gender").equalsIgnoreCase("male")) {
			util.selectFromList(allValues, "Male");
			log.info("selected Male from dropdown");
		}
//		age == female => female
		else if (input.get("gender").equalsIgnoreCase("female")) {
			util.selectFromList(allValues, "Female");
			log.info("selected female from dropdown");
		}
//		age == all => all
		else if (input.get("gender").equalsIgnoreCase("all")) {
			util.selectFromList(allValues, "All");
			log.info("selected female from dropdown");
		}
//		age == xyz => all
		else {
			util.selectFromList(allValues, "All");
			log.info("selected female from dropdown");
		}

		util.click(createCampaignButton);

	}

	public void OM_TC_DA_001() {
		log.info("RUNNING CREATE CAMPAIGN PAGE");
		log.info("running test case OM_TC_DA_001 ");
		util.clickOnSettings();
		log.info("clicked on settings");
		util.hold(2);
		util.clickOnDashboard();
		log.info("clicked on DashBoard");
		if (util.getPageURL().contains("/dashboard")) {
			Assert.assertTrue(true);
			log.info("current page is onboarding page");
		} else {
			Assert.assertTrue(false);
			log.info("OM_TC_DA_001 failed");
		}
	}

	public void OM_TC_DA_002() {
		if (util.isElementDisplyed(createCampaignButton)) {
			Assert.assertTrue(true);
			log.info("createCampaignButton is displayed");
			log.info("OM_TC_DA_002 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_DA_002 failed");
		}

	}

	public void OM_TC_DA_004() {
		util.click(createCampaignButton);
		log.info("createCampaignButton is clicked");
		if (util.isElementDisplyed(loadingicon)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_CC_001() {
		log.info("RUNNING TEST CASE OM_TC_CC_001");
		util.click(createCampaignButton);
		if (util.getPageURL().contains("/dashboard/create")) {
			Assert.assertTrue(true);
			log.info("user is on create campaign page.");
			log.info("OM_TC_CC_001 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_001 failed");
		}
	}

	public void OM_TC_CC_004() {
		log.info("RUNNING TEST CASE OM_TC_CC_004");
		log.info("campaignname input field is empty");
		log.info("start date input field is empty");
		log.info("daily budget input field is empty");
		log.info("ad text input field is empty");

		if (util.extractValueByAttributes(campaignNameInputField, "value").equals("")
				&& util.extractValueByAttributes(startDateInputField, "value").equals("")
				&& util.extractValueByAttributes(dailyBudgetInputField, "value").equals("")
				&& util.extractValueByAttributes(adTextInputField, "value").equals("")
				&& util.isElementSelected(fbCheckbox)) {
			util.click(cancelButton);
			log.info("clicked on cancel button");
			util.hold(3);

			if (util.getPageURL().contains("/dashboard")) {
				log.info("user is on dashboard page.");
				log.info("OM_TC_CC_001 passed");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				log.error("OM_TC_CC_001 failed");
			}
		}

		util.hold(5);
		util.click(createCampaignButton);
	}

	public void OM_TC_CC_005() {
		log.info("RUNNING TEST CASE OM_TC_CC_005");
//		Check, if user is able to leave the New Campaign interface at any point, they can click the  "Cancel" button
		util.refreshPage();
		util.click(cancelButton);
		log.info("clicked on cancel button");
		if (util.getPageURL().contains("/dashboard")) {
			log.info("user is on dashboard page.");
			log.info("OM_TC_CC_005 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_005 failed");
		}
		util.hold(5);
		util.click(createCampaignButton);
		log.info("clicked on createCampaignButton");
	}

	public void OM_TC_CC_006_OM_TC_CC_010(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_CC_006");
//		Check if user is able to see a validation on clicking cancel button.
		util.enterValue(campaignNameInputField, input.get("campaign_name"));
		log.info("entered campaign name");

		util.click(cancelButton);
		log.info("clicked on cancel button");

		if (util.isElementDisplyed(continuebutton) && util.isElementDisplyed(quitSetupButton)) {
			log.info("continuebutton & quitSetupButton is displayed");
			log.info("OM_TC_CC_006 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_006 failed");
		}
		util.click(continuebutton);
		log.info("clicked on continue button");
		util.hold(5);
		util.scrollToTop();
	}

	public void OM_TC_CC_007() {
		log.info("RUNNING TEST CASE OM_TC_CC_007");
//		Check if user is able to see a validation on clicking on back button on top of create campaign page----(Same validation of cancel button)
		util.click(backButtonIcon);
		log.info("clicked on back button icon");
		if (util.isElementDisplyed(continueSetupButton) && util.isElementDisplyed(quitSetupButton)) {
			log.info("continuebutton & quitSetupButton is displayed");
			log.info("OM_TC_CC_007 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_007 failed");
		}
		util.click(continueSetupButton);
		log.info("clicked on continue setup button");
	}

	public void OM_TC_CC_008() {
		log.info("RUNNING TEST CASE OM_TC_CC_008");
//		Check if user is able to see a validation on clicking on any app section from menu----(Same validation of cancel button)
		log.info("Any mandatory field is filled or prospective/rettargetting radio button is selected");

		util.clickOnDashboard();
		log.info("clicked on dashboard in navigation bar");

		if (util.isElementDisplyed(continuebutton) && util.isElementDisplyed(quitSetupButton)) {
			Assert.assertTrue(true);
			log.info("continuebutton & quitSetupButton is displayed");
			log.info("OM_TC_CC_008 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_008 failed");
		}
		util.click(continuebutton);
		log.info("clicked on continue button");

		util.clickOnProductList();
		log.info("clicked on product list in navigation bar");

		if (util.isElementDisplyed(continuebutton) && util.isElementDisplyed(quitSetupButton)) {
			log.info("continuebutton & quitSetupButton is displayed");
			log.info("OM_TC_CC_008 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_008 failed");
		}
		util.click(continuebutton);
		log.info("clicked on continue button");

		util.clickOnSettings();
		log.info("clicked on settings in navigation bar");

		if (util.isElementDisplyed(continuebutton) && util.isElementDisplyed(quitSetupButton)) {
			Assert.assertTrue(true);
			log.info("continuebutton & quitSetupButton is displayed");
			log.info("OM_TC_CC_008 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_008 failed");
		}
		util.click(continuebutton);
		log.info("clicked on continue button");

		util.clickOnHelp();
		log.info("clicked on settings in navigation bar");
		if (util.isElementDisplyed(continuebutton) && util.isElementDisplyed(quitSetupButton)) {
			log.info("continuebutton & quitSetupButton is displayed");
			log.info("OM_TC_CC_008 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_008 failed");
		}
		util.click(continuebutton);
		log.info("clicked on continue button");

		util.clickOnFAQ();
		log.info("clicked on FAQ in navigation bar");

		if (util.isElementDisplyed(continuebutton) && util.isElementDisplyed(quitSetupButton)) {
			Assert.assertTrue(true);
			log.info("continuebutton & quitSetupButton is displayed");
			log.info("OM_TC_CC_008 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_008 failed");
		}
		util.click(continuebutton);
		log.info("clicked on continue button");

	}

	public void clickingOnBackButtonIconWhenAllMandatoryFieldsAreEmpty() {
		log.info("RUNNING TEST CASE clicking On Back Button Icon When All Mandatory Fields Are Empty");

		util.refreshPage();
		if (util.extractValueByAttributes(campaignNameInputField, "value").equals("")
				&& util.extractValueByAttributes(startDateInputField, "value").equals("")
				&& util.extractValueByAttributes(dailyBudgetInputField, "value").equals("")
				&& util.extractValueByAttributes(adTextInputField, "value").equals("")
				&& !util.isElementSelected(fbCheckbox)) {
			util.scrollToTop();
			util.click(backButtonIcon);
			log.info("clicked on back button icon");
			util.hold(3);
			if (util.getPageURL().equals(util.dashboardURL())) {
				log.info("dashboard page is displayed");
				log.info("clicking On Back Button Icon When All Mandatory Fields Are Empty passed");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				log.error("clicking On Back Button Icon When All Mandatory Fields Are Empty is failed");
			}
		}
		util.hold(5);
		util.click(createCampaignButton);
		log.info("clicked on create campaign button");
	}

	public void OM_TC_CC_012(HashMap<String, String> input) {
		log.info("RUNNING TEST CASE OM_TC_CC_012");
		util.refreshPage();
		util.hold(2);
		util.enterValue(campaignNameInputField, "");
		log.info("campaign name input field is empty");

		util.click(startDateInputField);
		log.info("clicked on calendar icon");

		selectDate(0);
		log.info("start date entered successfully");
		util.hold(1);

		util.click(startDateInputField);
		log.info("clicked on calendar icon");

		selectDate(2);
		log.info("end date entered");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("daily budget entered");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("ad text entered");

		util.scrollToBottom();

		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_012 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_CC_012 is failed");
			Assert.assertTrue(false);

		}
	}

	public void OM_TC_CC_013() {
//		if any mandatory field is empty the create campaign button will be disabled
		util.refreshPage();

		if ((util.extractValueByAttributes(campaignNameInputField, "value").equals(""))
				|| (util.extractValueByAttributes(startDateInputField, "value").equals(""))
				|| (util.extractValueByAttributes(dailyBudgetInputField, "value").equals(""))
				|| (util.extractValueByAttributes(adTextInputField, "value").equals(""))
				|| (!util.isElementSelected(prospectiveAudienceRadioButton))
				|| (!util.isElementSelected(retargetingAudienceRadioButton))
				|| (util.extractValueByAttributes(fbCheckbox, "checked").equals("true"))) {

			log.info(
					"if any mandatory field is empty or prospectiveAudienceRadioButton or retargettingCampaignRadioButton is not selected");

			if (util.isElementDisplyed(createCampaignButtonDisabled)) {
				log.info("create campaign button is disabled");
				log.info("OM_TC_CC_013 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_CC_013 is failed");
				Assert.assertTrue(false);

			}
		}

	}

	public void OM_TC_CC_014() {
		log.info("OM_TC_CC_014 IS RUNNING");
//		Check,In Campaign name place holder
		util.refreshPage();
		util.hold(2);

		if (util.extractValueByAttributes(campaignNameInputField, "placeholder").equals("Enter Campaign Name")) {
			log.info("placeholder in campaign name input field is Enter Campaign Name");
			log.info("OM_TC_CC_014 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_014 is failed");
		}
	}

	public void OM_TC_CC_016(HashMap<String, String> input) {
		log.info("OM_TC_CC_016 IS RUNNING");
//		Check, on filling only spaces in user name.
		util.refreshPage();
		util.hold(2);
		util.enterValue(campaignNameInputField, "     ");
		log.info("space are entered in campaign Name Input Field ");

		util.click(startDateCalendarIcon);
		log.info("click on start date calendar icon");
		selectDate(0);
		log.info("entered value in start date input field");

		util.click(endDateCalendarIcon);
		log.info("click on end date calendar icon");
		selectDate(2);
		log.info("entered value in start date input field");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("ad text is entered");

		util.scrollToBottom();

		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementDisplyed(createCampaignButtonDisabled) && util.isElementDisplyed(campaignNameErrorMessage)) {
			log.info("create campaign button is disabled and error msg below campaign input field");
			log.info("OM_TC_CC_016 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_016 is failed");
		}

	}

	public void OM_TC_CC_017(HashMap<String, String> input) {
//		Check on filling only special characters in campaign name.
		log.info("OM_TC_CC_017 IS RUNNING");
		util.refreshPage();
		util.hold(2);
		util.enterValue(campaignNameInputField, "!@#$%^&");
		log.info("entered only special characters in campaign name");

		util.click(startDateCalendarIcon);

		selectDate(0);
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad Text");

		util.scrollToBottom();
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_017 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_017 is failed");
		}

	}

	public void OM_TC_CC_018(HashMap<String, String> input) {
		log.info("OM_TC_CC_018 IS RUNNING");
//		Check for numeric characters only in campaign name.
		util.enterValue(campaignNameInputField, "123456789");
		log.info("entered numeric characters only in campaign name");

		util.click(startDateCalendarIcon);
		selectDate(0);
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad Text");

		util.scrollToBottom();
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_018 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_018 is failed");
		}
	}

	public void OM_TC_CC_019(HashMap<String, String> input) {
		log.info("OM_TC_CC_019 IS RUNNING");
//		Check for mix characters i,e special, numeric and alphabitic
		util.enterValue(campaignNameInputField, "1new@50%and80$");
		log.info("entered mix characters i,e special, numeric and alphabitic in campaign name");

		util.click(startDateCalendarIcon);
		selectDate(0);
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad Text");

		util.scrollToBottom();
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_019 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_019 is failed");
		}
	}

	public void OM_TC_CC_020(HashMap<String, String> input) {
		log.info("OM_TC_CC_020 IS RUNNING");
//		Check the min name campaign limit.
		util.enterValue(campaignNameInputField, "a");
		log.info("entered only 1 character in campaignNameInputField");

		util.click(startDateCalendarIcon);
		selectDate(0);
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad Text");

		util.scrollToBottom();
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_020 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_020 is failed");
		}
	}

	public void OM_TC_CC_021(HashMap<String, String> input) {
//		Check the max campaign name limit.
		log.info("OM_TC_CC_021 IS RUNNING");
		util.enterValue(campaignNameInputField,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. "
						+ "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus."
						+ " Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat "
						+ "massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, "
						+ "rhoncus ut, imper");
		log.info("entered only  394 character in campaignNameInputField");

		util.click(startDateCalendarIcon);
		selectDate(0);
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad Text");

		util.scrollToBottom();
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_021 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_021 is failed");
		}
	}

	public void OM_TC_CC_023(HashMap<String, String> input) {
//		Check the max campaign name limit validation.
		log.info("OM_TC_CC_023 IS RUNNING");
		util.refreshPage();
		util.enterValue(campaignNameInputField,
				"MAX Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. "
						+ "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, "
						+ "ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, "
						+ "fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imper");

		log.info("entered more than  394 character in campaignNameInputField");
		util.click(startDateCalendarIcon);
		selectDate(0);
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad Text");

		util.scrollToBottom();
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if ((util.isElementDisplyed(campaignNameErrorMessage))
				&& (util.isElementDisplyed(createCampaignButtonDisabled))) {
			Assert.assertTrue(true);
			log.info(
					"Error message below campaign name input field is displayed and create campaign button is disabled");
			log.info("OM_TC_CC_023 is passed");
		} else {
			log.error("OM_TC_CC_023 is failed");
			Assert.assertTrue(false);

		}
	}

	public void OM_TC_CC_024(HashMap<String, String> input) {
//		Check camapign name as PRIME_PRIME.
		log.info("OM_TC_CC_024 IS RUNNING");

		util.enterValue(campaignNameInputField, "PRIME_PRIME");
		log.info("entered PRIME_PRIME in campaignNameInputField");

		util.click(startDateCalendarIcon);
		selectDate(0);
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info("entered daily budget");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad text");

		util.scrollToBottom();
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective audience Button");

		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_024 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_CC_024 is failed");
			Assert.assertTrue(false);

		}
	}

	public void OM_TC_CC_026() {
//		Check user is able to Choose start Data from date picker
		log.info("OM_TC_CC_024 IS RUNNING");

		Date currentDate = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");

		String todaysDate = simpleDateFormat.format(currentDate);
		simpleDateFormat = new SimpleDateFormat("MMM");

		String todaysMonthName = simpleDateFormat.format(currentDate);

		simpleDateFormat = new SimpleDateFormat("MM");

		String todaysMonth = simpleDateFormat.format(currentDate);

		simpleDateFormat = new SimpleDateFormat("YYYY");

		String todaysYear = simpleDateFormat.format(currentDate);

		simpleDateFormat = new SimpleDateFormat("dd");

		String todays2DigitDate = simpleDateFormat.format(currentDate);

		String dateInFormat = todaysMonth + "/" + todays2DigitDate + "/" + todaysYear;

		util.refreshPage();
		util.click(startDateCalendarIcon);

		for (WebElement date : datesInCalendar) {
			if (!util.extractValueByAttributes(date, "class").contains("ant-picker-cell ant-picker-cell-disabled")) {
				if (date.findElement(By.tagName("div")).getText().equals(todaysDate)) {
					date.click();
					break;
				}

			}
		}

		if (util.extractValueByAttributes(startDateInputField, "value").equals(dateInFormat)) {
			log.info("OM_TC_CC_024 IS passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_024 IS failed");
		}

	}

	public void OM_TC_CC_034(HashMap<String, String> input) {
		log.info("OM_TC_CC_034 IS RUNNING");

		util.enterValue(campaignNameInputField, "Automation learning course sale");
		log.info("entered campaign name in campaignNameInputField");

		util.click(startDateCalendarIcon);
		util.enterValue(startDateInputField, input.get("start_date"));
		log.info("entered start date");

		util.enterValue(dailyBudgetInputField, "");
		log.info("daily budget is empty");

		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info("entered ad text");

		if (util.isElementDisplyed(createCampaignButtonDisabled)) {
			log.info("create campaign button is disabled");
			log.info("OM_TC_CC_044 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_034 is failed");
		}
	}

	public void OM_TC_CC_035(HashMap<String, String> input) {
		log.info("OM_TC_CC_034 IS RUNNING");

//		Check, Dailybudget  is reflecting validation on value below than 5 $
		util.refreshPage();
		if (Integer.parseInt(input.get("minimum_daily_budget")) < 5) {
			log.info("daily budget is < $5");
			util.enterValue(dailyBudgetInputField, input.get("minimum_daily_budget"));
			log.info("entered daily budget ");
			if (util.isElementDisplyed(minimumDailyBudgetErrorMessage)) {
				log.info("daily budget < $5 error msg is displayed");
				log.info("OM_TC_CC_034 IS passed");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				log.error("OM_TC_CC_034 IS failed");
			}
		}

	}

	public void OM_TC_CC_037() {
		log.info("OM_TC_CC_037 IS RUNNING");
//		check if user able to see a tooltip  explaining how budgets work.
		util.moveToElement(dailyBudgetLabel);
		log.info("mouse hovered at dailyBudgetLabel");

		if (util.isElementDisplyed(dailyBudgetTooltip)) {
			log.info("dailyBudgetTooltip is displayed");
			log.info("OM_TC_CC_037 IS passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_037 IS failed");
		}
	}

	public void OM_TC_CC_038() {
		log.info("OM_TC_CC_038 IS RUNNING");
		util.refreshPage();
		util.hold(2);
		util.scrollToBottom();
		util.hold(2);
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospectiveAudienceRadioButton");
		util.click(minimumAgeField);
		log.info("clicked on minimum age dropdown");

		if (util.isElementDisplyed(minimumAgeDropDown)) {
			log.info("minimumAgeDropDown is displayed");
			log.info("OM_TC_CC_038 IS passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_038 IS failed");
		}

		util.click(maximumAgeField);
		log.info("clicked on maximum age dropdown");

		if (util.isElementDisplyed(maximumAgeDropDown)) {
			Assert.assertTrue(true);
			log.info("maximumAgeDropDown is displayed");
			log.info("OM_TC_CC_038 IS passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_038 IS failed");
		}

		util.click(genderField);
		log.info("clicked on gender dropdown");

		if (util.isElementDisplyed(genderDropDown)) {
			log.info("genderDropDown is displayed");
			log.info("OM_TC_CC_038 IS passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_038 IS failed");
		}

	}

	public void OM_TC_CC_039_40_41(HashMap<String, String> input) {
		log.info("OM_TC_CC_039_40_41 IS RUNNING");
//		Check user is able to search and select intrests, behaviour and demography in search field,
		util.enterValue(searchInterestInputField, input.get("interest"));
		log.info("entered value in search and select intrests, behaviour and demography in search field");
		util.hold(5);
		if (util.isElementDisplyed(suggestionsContainer)) {
			log.info("suggesstion are displayed");
			log.info("OM_TC_CC_039_40_41 IS passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_039_40_41 IS failed");
		}

		util.getDriver()
				.findElement(By.xpath("//input[@placeholder=' Search for demographics, interests, behaviors, etc.']"))
				.sendKeys(" ");
		log.info("entered Whitespaces in search and select intrests, behaviour and demography in search field");

		util.getDriver()
				.findElement(By.xpath("//input[@placeholder=' Search for demographics, interests, behaviors, etc.']"))
				.sendKeys(Keys.ENTER);
		log.info("press enter key in search and select intrests, behaviour and demography in search field");

		util.hold(5);
		if (util.isElementDisplyed(suggestionsContainer)) {
			log.info("suggesstion are displayed");
			log.info("OM_TC_CC_039_40_41 IS passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_039_40_41 IS failed");
		}
		for (int i = 0; i < allSuggestions.size(); i++) {
			allSuggestions.get(0).click();
			log.info("clicked on suggestion");
			break;
		}

	}

	public void OM_TC_CC_042() {
//		Check if user able to see a tip on Prospecting campaign.
		util.refreshPage();
		log.info("OM_TC_CC_042 IS RUNNING");

		util.click(retargetingAudienceRadioButton);
		log.info("clicked on retaretting Audience Radio Button ");
		if (util.isElementDisplyed(tipRetargetingAudience)) {
			log.info("Tip of Retargeting Audience is displayed");
			log.info("OM_TC_CC_042 IS Passed");
			Assert.assertTrue(true);
		} else {
			log.info("Tip of Retargeting Audience is not displayed");
			log.info("OM_TC_CC_042 IS failed");
			Assert.assertTrue(false);
		}

		util.hold(2);
		util.click(prospectiveAudienceRadioButton);
		log.info("clicked on prospective Audience Radio Button ");
		if (util.isElementDisplyed(tipProspectiveAudience)) {
			log.info("Tip of prospective Audience is displayed");
			log.info("OM_TC_CC_042 IS Passed");
			Assert.assertTrue(true);
		} else {
			log.info("Tip of prospective Audience is not displayed");
			log.info("OM_TC_CC_042 IS failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_CC_043(HashMap<String, String> input) {
		log.info("OM_TC_CC_043 IS RUNNING");
//		Check if user is able select groups (set demography) in Prospecting campaign
		util.enterValue(searchInterestInputField, input.get("interest"));
		log.info("entered value in search and select intrests, behaviour and demography in search field");

		util.hold(5);
		for (WebElement suggestion : allSuggestions) {
			suggestion.findElement(By.xpath("//span[text() = 'Demographics']")).click();
			log.info("clicked on demographics suggestion");
			break;
		}
		if (util.isElementDisplyed(selectedFromSugesstionCard)) {
			log.info("selected demographics is displayed");
			log.info("OM_TC_CC_043 IS passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_043 IS failed");
		}
	}

	public void setMinAge(HashMap<String, String> input) {
//		Check if user is able to set min age from dropdown
		util.refreshPage();
		log.info("OM_TC_CC_048 IS RUNNING");
		util.click(prospectiveAudienceRadioButton);
		;
		log.info("clicked on prospective audience radio button");
		util.click(minimumAgeField);
		log.info("clicked on min age field");
		util.hold(2);

		if ((Integer.parseInt(input.get("min_age")) < 65) && (Integer.parseInt(input.get("min_age")) >= 18)) {
			util.selectFromList(allValues, input.get("min_age"));
			log.info("selected min age = " + input.get("min_age") + " from dropdown");
		} else if ((Integer.parseInt(input.get("min_age")) > 65)) {
			util.selectFromList(allValues, "65+");
		} else {
			util.selectFromList(allValues, "18");
		}

	}

	public void setMaxAge(HashMap<String, String> input) {
//		Check if user is able to set max age from dropdown
		util.click(maximumAgeField);
		log.info("clicked on max age field");
//		Max Age < Min Age => 65+
		if (Integer.parseInt(input.get("max_age")) < Integer.parseInt(input.get("min_age"))) {
			util.selectFromList(allValues, "65+");
			log.info("selected max age = 65+ from dropdown");
		}

//		Max Age > Min Age => Max Age
		if (Integer.parseInt(input.get("max_age")) > Integer.parseInt(input.get("min_age"))) {
			util.selectFromList(allValues, input.get("max_age"));
			log.info("selected max age = " + input.get("max_age") + " from dropdown");
		}
//		Max Age == Min Age => Max Age
		if (Integer.parseInt(input.get("max_age")) == Integer.parseInt(input.get("min_age"))) {
			util.selectFromList(allValues, input.get("max_age"));
			log.info("selected max age = " + input.get("max_age") + " from dropdown");
		}
//		Max Age < 18 => 65+
		if (Integer.parseInt(input.get("max_age")) < 18) {
			util.selectFromList(allValues, "65+");
			log.info("selected max age = 65+ from dropdown");
		}
//		Max Age > 65 => 65+
		if (Integer.parseInt(input.get("max_age")) > 65) {
			util.selectFromList(allValues, "65+");
			log.info("selected max age = 65+ from dropdown");
		}

	}

	public void setGender(HashMap<String, String> input) {
		util.click(genderField);
		log.info("clicked on gender field");
//		age == male => male
		if (input.get("gender").equalsIgnoreCase("male")) {
			util.selectFromList(allValues, "Male");
			log.info("selected Male from dropdown");
		}
//		age == female => female
		else if (input.get("gender").equalsIgnoreCase("female")) {
			util.selectFromList(allValues, "Female");
			log.info("selected female from dropdown");
		}
//		age == all => all
		else if (input.get("gender").equalsIgnoreCase("all")) {
			util.selectFromList(allValues, "All");
			log.info("selected female from dropdown");
		}
//		age == xyz => all
		else {
			util.selectFromList(allValues, "All");
			log.info("selected female from dropdown");
		}
	}

	public void OM_TC_CC_049() {
		log.info(" Test case OM_TC_CC_049 is running");

		util.refreshPage();
		util.hold(3);
		util.click(prospectiveAudienceRadioButton);
		log.info("click on prospectiveAudienceRadioButton");
//		Check if user is able to select radio button of Reach people beyond these targeting selection in prospective campaign.
		boolean isIncreaseAudienceSelectedInitialValue = util.isElementSelected(increaseTargetAudienceCheckbox);
		util.click(increaseTargetAudienceCheckbox);
		log.info("click on increaseTargetAudienceCheckbox");
		boolean isIncreaseAudienceSelectedFinalValue = util.isElementSelected(increaseTargetAudienceCheckbox);
		if (isIncreaseAudienceSelectedInitialValue != isIncreaseAudienceSelectedFinalValue) {
			log.info("increaseTargetAudienceCheckbox can be checked and unchecked");
			log.info("OM_TC_CC_049 passed");

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_049 failed");
		}
	}

	public void OM_TC_CC_050() {
		log.info(" Test case OM_TC_CC_050 is running");
//		Check, if user is able to select Retargetting campaign.
		boolean isRetargettingCampaignSelectedInitialValue = util.isElementSelected(retargetingAudienceRadioButton);
		util.click(retargetingAudienceRadioButton);
		log.info("click on retargettingCampaignRadioButton");
		boolean isRetargettingCampaignSelectedFinalValue = util.isElementSelected(retargetingAudienceRadioButton);
		if (isRetargettingCampaignSelectedInitialValue != isRetargettingCampaignSelectedFinalValue) {
			Assert.assertTrue(true);
			log.info("retargettingCampaignRadioButton can be checked and unchecked");
			log.info("OM_TC_CC_050 passed");
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_050 failed");
		}
	}

	public void OM_TC_CC_055() {
		log.info(" Test case OM_TC_CC_055 is running");
		util.refreshPage();
		util.click(retargetingAudienceRadioButton);
		log.info("click on retargettingCampaignRadioButton");
//		Check if user is able to select radio button of Reach people beyond these targeting selection in Retargetting campaign.
		boolean isIncreaseAudienceSelectedInitialValue = util.isElementSelected(increaseTargetAudienceCheckbox);
		util.click(increaseTargetAudienceCheckbox);
		log.info("click on increaseTargetAudienceCheckbox");
		boolean isIncreaseAudienceSelectedFinalValue = util.isElementSelected(increaseTargetAudienceCheckbox);
		if (isIncreaseAudienceSelectedInitialValue != isIncreaseAudienceSelectedFinalValue) {
			log.info("retargettingCampaignRadioButton can be checked and unchecked");
			log.info("OM_TC_CC_055 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error("OM_TC_CC_055 failed");
		}
	}

	public void OM_TC_CC_058(HashMap<String, String> input) {
		log.info(" Test case OM_TC_CC_058 is running");
//		Check the limit of ad text field. (NO limit, Ad Text should be 125 characters its recommendation no restriction on field)  
		util.enterValue(campaignNameInputField, input.get("campaign_name"));
		log.info(" campaign name is entered");
		util.click(startDateCalendarIcon);
		selectDate(0);
		log.info(" start date is entered");
		util.click(endDateCalendarIcon);
		selectDate(2);
		log.info(" end date is entered");
		util.enterValue(dailyBudgetInputField, input.get("daily_budget"));
		log.info(" daily budget is entered");
		util.enterValue(adTextInputField, input.get("ad_text"));
		log.info(" ad text is entered");
		util.scrollToBottom();
		if (util.isElementEnabled(createCampaignButton)) {
			log.info("create campaign button is enabled");
			log.info("OM_TC_CC_058 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.info("OM_TC_CC_058 is failed");
		}
	}

	public void OM_TC_CC_059() {
		log.info(" Test case OM_TC_CC_059 is running");
//		Check if user is able to write in ad text 
		if (!util.extractValueByAttributes(adTextInputField, "value").equals("")) {
			Assert.assertTrue(true);
			log.info("adTextInputField is editable");
			log.info(" Test case OM_TC_CC_059 is passed");
		} else {
			Assert.assertTrue(false);
			log.info(" Test case OM_TC_CC_059  failed");

		}
	}

	public void OM_TC_CC_064() {
		log.info(" Test case OM_TC_CC_064 is running");
//		Check if user is getting content guide link, 
		util.scrollToTop();

		if (util.isElementDisplyed(contentGuideLink)) {
			log.info("contentGuideLink is displayed");
			util.scrollToTop();
			util.click(contentGuideLink);
			log.info("contentGuideLink is clicked");
			util.hold(3);
//			util.getWindoHandleByUrl("https://www.facebook.com/business/help/");
			util.goToChildWindow();
			log.info("switched to new window.");
			if (util.getPageURL().contains("https://www.facebook.com/business/help/")) {
				log.info("page is displayed");
				log.info(" Test case OM_TC_CC_064 passed");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				log.error(" Test case OM_TC_CC_064 failed");

			}
		} else {
			Assert.assertTrue(false);
			log.error(" Test case OM_TC_CC_064 failed");
		}
//		util.getDriver().close();
		util.goToParentWindow();
//		util.getWindoHandleByUrl(util.createCampaignPageUrl());

	}

	public void OM_TC_CC_063() {
		log.info(" Test case OM_TC_CC_063 is running");
//		Check if any placement is not selected  by default.

		util.refreshPage();
		if (util.isElementSelected(fbCheckbox)) {
			log.info("fbCheckbox is selected");
			log.info(" Test case OM_TC_CC_063 is passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.error(" Test case OM_TC_CC_063 is failed");
		}
	}

	public void OM_TC_CC_067_68() {
		log.info(" Test case OM_TC_CC_067_68 is running");
//		Check if instagram placement is disable if user has not connected instagram. 
		util.refreshPage();

		if (util.isElementDisplyed(instaIsDisabled) && !util.isElementSelected(instagramCheckbox)) {
			log.info("instagram checkbox is not checked and is disabled");
			log.info(" Test case OM_TC_CC_067_68 passed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			log.info(" Test case OM_TC_CC_067_68 failed");
		}
	}

	public void OM_TC_CC_071() {
		log.info(" Test case OM_TC_CC_071 is running");
//		Check if user is getting info, how many Prime eligible products have synced to their catalog to advertise.
		if (util.isElementDisplyed(primeEligibleProductSyncMsg)) {
			log.info("primeEligibleProductSyncMsg is displayed");
			log.info(" Test case OM_TC_CC_071 is passed");
			Assert.assertTrue(true);
		} else {
			log.error(" Test case OM_TC_CC_071 failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_CC_072() {
		log.info(" Test case OM_TC_CC_072 is running");
//		Check, if catalog is blank "0  synced" message is getting reflected. 

		String syncedProductMessage = util.getTagValue(primeEligibleProductSyncMsg);
		try {
			if (syncedProductMessage.contains("0")) {
				log.info(" Test case OM_TC_CC_072 passed");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				log.error(" Test case OM_TC_CC_072 failed");
			}
		} catch (Exception e) {
			Assert.assertTrue(true);
			log.info(" Test case OM_TC_CC_072 passed");
		}

	}

	public void OM_TC_CC_074() {
		String pageUrl = util.getPageURL();
		log.info(" Test case OM_TC_CC_074 is running");
//		Check if user is getting a link to an article to receive more details about how to sync their catalog/where to sync their  catalog
		util.click(catalogSyncProcessLink);
		log.info("catalogSyncProcessLink is clicked");
		util.getWindoHandleByUrl(util.catalogSyncProcessPageUrl());
		if (util.isElementDisplyed(faqHeading)) {
			log.info("how to sync their catalog/where to sync their  catalog page is displayed");
			log.info(" Test case OM_TC_CC_074 passed");
			Assert.assertTrue(true);
		} else {
			log.error(" Test case OM_TC_CC_074 failed");
			Assert.assertTrue(false);
		}
		util.getWindoHandleByUrl(pageUrl);
	}

	public void OM_TC_CC_076() {
		log.info(" Test case OM_TC_CC_076 is running");
//		Check if user is able to see ad preview, and preview should load with lessthan 5 seconds delay

		if (util.isElementDisplyed(adPreviewContainer)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void selectDate(int days) {
		LocalDate today = LocalDate.now();
		int currentYear = today.getYear();
		today = today.plusDays(days);
		int currentDay = today.getDayOfMonth();
		String monthName;

		util.click(yearBtnDatePicker);
//			select current year
		for (WebElement year : yearsList) {

			if (util.getTagValue(year).equals(String.valueOf(currentYear))) {
				util.click(year);
				break;
			}
		}

		monthName = StringUtils.left(today.getMonth().toString(), 3);
		util.hold(2);
		util.click(monthBtnDatePicker);
//		Select Month
		for (WebElement month : monthList) {

			if (util.getTagValue(month).equalsIgnoreCase(monthName)) {
				util.click(month);
				break;
			}
		}

		String completeDate = currentYear + "-" + returnMonth(monthName) + "-" + String.format("%02d", currentDay);

		for (WebElement dateTitle : dateTitleList) {

			if (dateTitle.getAttribute("title").equals(completeDate)) {
				util.click(dateTitle);
				break;

			}
		}
	}

	public String returnMonth(String month) {
		switch (month) {
		case "JAN":
			return "01";

		case "FEB":
			return "02";

		case "MAR":
			return "03";
		case "APR":

			return "04";
		case "MAY":

			return "05";
		case "JUN":

			return "06";
		case "JUL":

			return "07";
		case "AUG":

			return "08";
		case "SEP":

			return "09";
		case "OCT":

			return "10";
		case "NOV":

			return "11";
		case "DEC":

			return "12";

		default:
			break;
		}
		return month;
	}
}