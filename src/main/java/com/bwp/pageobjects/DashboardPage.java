package com.bwp.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bwp.resources.Utilities;

public class DashboardPage extends DashboardPageOR {

	/*
	 * Project Name: Onyx Meta Author: Yatindra Kinker Version: 0.0 Reviewed By:
	 * Abhay Hayaran Date of Creation: October 13, 2022 Modification History: Date
	 * of change: December 15, 2022 Version: 0.0 changed function: All functions
	 * change description: Added code to get data from .json file. Modified By:
	 * Yatindra Kinker
	 */

//	Initializing Logger object that is used to print logs of steps.
	private static final Logger log = LogManager.getLogger(DashboardPage.class);

//	Local variable for initializing Utilities object.
	Utilities util;

	/**
	 * Parameterized Dashboard page constructor This constructor initializes driver
	 * And converts page factory objects into "driver.findElement()" format
	 * 
	 * @param util
	 */
	public DashboardPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

	/**
	 * Verifies that user should lands on dashboard page after login/completing
	 * onboarding
	 */
	public void OM_TC_DA_001() {
		log.info("Running OM_TC_DA_001");
		util.clickOnSettings();
		log.info("clicked on Settings");
		util.clickOnDashboard();
		log.info("clicked on dashboard");

		if (util.getPageURL().contains("/dashboard")) {
			log.info("dashboard page is visible");
			log.info("OM_TC_DA_001 is passed");
			Assert.assertTrue(false);
		} else {
			log.error("OM_TC_DA_001 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Verifies that create campaign button is displayed => it should displayed
	 */
	public void OM_TC_DA_002() {
		log.info("Running OM_TC_DA_002");
		if (util.isElementDisplyed(createCampaignButton)) {
			log.info("create campaign button is displayed");
			log.info("OM_TC_DA_002 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_002 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check if user is able to see a help doc link on blank dashboard. and this
	 * link should redirect to help section on a new tab.
	 */
	public void OM_TC_DA_003() {

		log.info("OM_TC_DA_003 is running");

		try {
			util.click(helpDocLink);
			log.info("click on help doc link");
			util.getWindoHandleByUrl(util.faqPageURL());

			if (util.getPageURL().contains("/faq")) {
				log.info("FAQ page is displayed");
				log.info("OM_TC_DA_003 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_003 is running");
				Assert.assertTrue(false);
			}
			util.getWindoHandleByUrl(util.dashboardURL());
		} catch (Exception e) {

		}

	}

	/**
	 * Check the content of tooltip on Download report button. It should be visible
	 * when mouse is hovered at it.
	 */
	public void OM_TC_DA_008() {
		log.info("OM_TC_DA_008 is running");

		util.moveToElement(downloadReportButton);
		log.info("Hovered mouse at download report button");

		if (util.isElementDisplyed(downloadReportButtonTooltipContent)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_008 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_008 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check the tooltip and content of tooltip of every column every column should
	 * have a tooltip.
	 */
	public void OM_TC_DA_019() {
		log.info("OM_TC_DA_019 is running");

		util.moveToElement(campaignHeading);
		log.info("Hovered mouse at campaign heading");
//		Hovered mouse at campaign heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}

		util.moveToElement(statusHeading);
		log.info("Hovered mouse at status heading");
//		Hovered mouse at status heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}

		util.moveToElement(placementHeading);
		log.info("Hovered mouse at placement heading");
//		Hovered mouse at placement heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}

		util.moveToElement(startDateHeading);
		log.info("Hovered mouse at start date heading");
//		Hovered mouse at start date heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}

		util.moveToElement(endDateHeading);
		log.info("Hovered mouse at end date heading");
//		Hovered mouse at end date heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}

		util.moveToElement(dailyBudgetHeading);
		log.info("Hovered mouse at daily budget heading");
//		Hovered mouse at daily budget heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}

		util.moveToElement(spendHeading);
		log.info("Hovered mouse at spend heading");
//		Hovered mouse at spend heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}

		util.moveToElement(salesHeading);
		log.info("Hovered mouse at sales heading");
//		Hovered mouse at sales heading

		if (util.isElementDisplyed(tooltipMsg)) {
			log.info("tool tip is displayed");
			log.info("OM_TC_DA_019 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_019 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check if the columns , Campaign name, placement and status is always visible
	 * and there should be no option to uncheck these columns.
	 */
	public void OM_TC_DA_022() {

	}

	/**
	 * Check if the columns,Status, Platform, Start/end date, budget, spend, and
	 * sales should be displayed.
	 */
	public void OM_TC_DA_023() {
		log.info("OM_TC_DA_023 is running");

		if (util.isElementDisplyed(campaignHeading) && util.isElementDisplyed(statusHeading)
				&& util.isElementDisplyed(placementHeading) && util.isElementDisplyed(startDateHeading)
				&& util.isElementDisplyed(endDateHeading) && util.isElementDisplyed(dailyBudgetHeading)
				&& util.isElementDisplyed(spendHeading) && util.isElementDisplyed(salesHeading)) {
			log.info("columns,Status, Platform, Start/end date, budget, spend, and  sales are reflected by default");
			log.info("OM_TC_DA_023 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_023 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check if the user is able to customize grid by using "Manage columns" button.
	 * User should be able to manage following columns (Start date, end date, daily
	 * budget, spends, sales, impressions, clicks, order and ROAS)
	 */
	public void OM_TC_DA_025() {
		log.info("OM_TC_DA_025 is running");

		util.click(manageColumnButton);
		log.info("clicked on manage Column Button");
		util.click(impressionsCheckbox);
		log.info("clicked on impression checkbox");
		util.click(clicksCheckbox);
		log.info("clicked on clicks checkbox");
		util.click(ordersCheckbox);
		log.info("clicked on orders checkbox");
		util.click(ROASCheckbox);
		log.info("clicked on ROAS checkbox");

		if (util.isElementDisplyed(campaignHeading) && util.isElementDisplyed(statusHeading)
				&& util.isElementDisplyed(placementHeading) && util.isElementDisplyed(startDateHeading)
				&& util.isElementDisplyed(endDateHeading) && util.isElementDisplyed(dailyBudgetHeading)
				&& util.isElementDisplyed(spendHeading) && util.isElementDisplyed(salesHeading)
				&& util.isElementDisplyed(impressionsHeading) && util.isElementDisplyed(clicksHeading)
				&& util.isElementDisplyed(ordersHeading) && util.isElementDisplyed(ROASHeading)) {
			log.info(
					"campaignHeading, statusHeading, placementHeading, startDateHeading, endDateHeading, dailyBudgetHeading, spendHeading, salesHeading, impressionsHeading, clicksHeading, ordersHeading, ROASHeading is displayed");
			log.info("OM_TC_DA_025 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_025 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * If the user has selected all the the columns or more than 5 column in "Manage
	 * column" button then user should be able to horizontally scroll grid.
	 * 
	 */
	public void OM_TC_DA_044() {
		log.info("OM_TC_DA_044 is running");

		if (util.isElementDisplyed(horizontalScrollGrid)) {
			log.info("horizontal Scroll Grid is visible");
			log.info("OM_TC_DA_044 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_044 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check if user is getting suggestions on typing in search bar, Suggestions
	 * should appear when the merchant starts to type after 3 strings (Contains
	 * rule)
	 */
	public void OM_TC_DA_047() {
		log.info("OM_TC_DA_047 is running");

		util.enterValue(searchCampaignInputField, "new");
		log.info("search keyword is entered in search campaign input field");
		if (util.isElementDisplyed(searchedCampaignSuggestionContainer)) {
			log.info("suggestions are displayed");
			log.info("OM_TC_DA_047 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_047 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check if user is selecting a particular campaign among the suggestions, then
	 * only that particular campaign is getting reflected on dashboard.
	 */
	public void OM_TC_DA_048() {
		log.info("OM_TC_DA_048 is running");

		for (WebElement suggestion : allSuggestionsList) {
			suggestion.click();
			log.info("clicked on suggestion");
			break;
		}

		for (WebElement campaign : allCampaignNames) {
			if (campaign.getText().equals("New diwali offer 50% off")) {
				log.info("clicked suggestion is displayed in campaign");
				log.info("OM_TC_DA_048 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_048 is failed");
				Assert.assertTrue(false);
			}
		}
	}

	/**
	 * Check if search are getting reset after user navigating to other sections
	 */
	public void OM_TC_DA_052() {
		log.info("OM_TC_DA_052 is running");

		int totalCampaignsInitial = allCampaignNames.size();

		util.clickOnFAQ();
		log.info("clicked on FAQ");
		util.clickOnDashboard();
		log.info("clicked on Dashboard");

		int totalCampaignsFinal = allCampaignNames.size();
		if (totalCampaignsInitial != totalCampaignsFinal) {
			log.info("search are getting reset after");
			log.info("OM_TC_DA_052 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_052 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * Check search campaign and then refreshing page . After refreshing page all
	 * campaign should be displayed.
	 */
	public void OM_TC_DA_054() {
		log.info("OM_TC_DA_054 is running");

		util.enterValue(searchCampaignInputField, "new");
		log.info("entered keyword to search campaigns");

		for (WebElement suggestion : allSuggestionsList) {
			suggestion.click();
			log.info("clicked on suggestion");
			break;
		}

		int totalCampaignsInitial = allCampaignNames.size();

		util.refreshPage();
		log.info("refreshed the page");
		int totalCampaignsFinal = allCampaignNames.size();

		if (totalCampaignsInitial != totalCampaignsFinal) {
			log.info("search are getting reset after");
			log.info("OM_TC_DA_054 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_054 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * Check that search rules defined for “Exact Match” with the search keyword
	 * only that campaign should be displayed in suggestion
	 */
	public void OM_TC_DA_055() {
		log.info("OM_TC_DA_055 is running");

		util.enterValue(searchCampaignInputField, "New diwali offer 50% off");
		log.info("searched campaign with exact campaign name");
		for (WebElement suggestion : allSuggestionsList) {
			suggestion.click();
			log.info("clicked on suggestion");
			break;
		}

		for (WebElement campaign : allCampaignNames) {
			if (campaign.getText().equals("New diwali offer 50% off")) {
				log.info("searched campaign is displayed");
				log.info("OM_TC_DA_055 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_055 is failed");
				Assert.assertTrue(false);
			}
		}

	}

	/**
	 * Check that search rules defined for “Contains With ” with the search key word
	 * all campaigns that contains that keyword should displayed in suggestion list.
	 */
	public void OM_TC_DA_056() {
		log.info("OM_TC_DA_056 is running");

		String keyword = "campaign";
		util.enterValue(searchCampaignInputField, keyword);
		log.info("keyword is searched");

		for (WebElement suggestion : allSuggestionsList) {
			String word = suggestion.findElement(By.xpath("(//ul[@class='inte-popover-container']/li//span)[1]"))
					.getText();
			if (word.contains(keyword)) {
				log.info("searched keyword is displayed in suggestion");
				log.info("OM_TC_DA_056 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_056 is failed");
				Assert.assertTrue(false);
			}

		}

	}

	/**
	 * Check that search rules defined for “Start With” with the search key word
	 * when user enters first three letters if any campaigns contains those words 
	 * should be visible in suggesstion list
	 */
	public void OM_TC_DA_057() {
		log.info("OM_TC_DA_057 is running");
		
		String keyword = "retargeting";
		util.enterValue(searchCampaignInputField, keyword);
		log.info("keyword is searched");
		for (WebElement suggestion : allSuggestionsList) {
			String word = suggestion.findElement(By.xpath("(//ul[@class='inte-popover-container']/li//span)[1]"))
					.getText();
			if (word.contains(keyword)) {
				log.info("searched keyword is displayed in suggestion");
				log.info("OM_TC_DA_057 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_057 is failed");
				Assert.assertTrue(false);
			}

		}

		for (WebElement suggestion : allSuggestionsList) {
			suggestion.click();
			log.info("clicked on suggestion");
			break;
		}

	}

	/**
	 * 
	 */
	public void OM_TC_DA_058() {
		log.info("OM_TC_DA_058 is running");
//	Check if search is not getting reset after user is performing any action on campaign (Pause/unpause, edit and archieve)
		int totalCampaignsInitial = allCampaignNames.size();

		util.click(actionsButton.get(0));
		util.click(editCampaignButton);
		log.info("clicked on edit campaign button");
		util.click(backButtonIcon);
		log.info("clicked on edit back button");
		int totalCampaignsFinal = allCampaignNames.size();

		if (totalCampaignsInitial == totalCampaignsFinal) {
			log.info("search is not getting reset after user is performing any action on campaign");
			log.info("OM_TC_DA_058 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_058 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_DA_059() {
		log.info("OM_TC_DA_059 is running");
//		Check if search is getting reset after user has clicked create campaign
		int totalCampaignsInitial = allCampaignNames.size();
		util.click(createCampaignButton);
		log.info("clicked on edit create button");
		util.click(backButtonIcon);
		log.info("clicked on edit back button");
		int totalCampaignsFinal = allCampaignNames.size();

		if (totalCampaignsInitial != totalCampaignsFinal) {
			log.info("search is getting reset after user has clicked create campaign");
			log.info("OM_TC_DA_059 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_059 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_DA_060() {
		log.info("OM_TC_DA_060 is running");
//		Check if filter tag is not visible before applying filter
		try {
			if (!util.isElementDisplyed(singleActiveFilter) || !util.isElementDisplyed(activeFiltersContainer)) {
				log.info("filter tag is not visible");
				log.info("OM_TC_DA_060 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_060 is failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			log.info("filter tag is not visible");
			log.info("OM_TC_DA_060 is passed");
			Assert.assertTrue(true);
		}

	}

	public void OM_TC_DA_061() {
		log.info("OM_TC_DA_061 is running");
//		Check if filter tag is visible after applying filter
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(5);
		util.click(scheduledLabel);
		log.info("clicked on schedule label");
		util.click(applyButton);
		log.info("clicked on apply button");

		if (util.isElementDisplyed(singleActiveFilter) || util.isElementDisplyed(activeFiltersContainer)) {
			log.info("filter tag is visible");
			log.info("OM_TC_DA_061 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_061 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_063() {
		log.info("OM_TC_DA_063 is running");
//		Check if all status filter options are available on status filter list
		util.refreshPage();
		util.hold(5);
		util.click(filterButton);
		System.out.println(util.isElementDisplyed(archivedLabel));
		System.out.println(util.isElementDisplyed(activeLabel));
		System.out.println(util.isElementDisplyed(disconnectedLabel));
		System.out.println(util.isElementDisplyed(endedLabel));
		System.out.println(util.isElementDisplyed(errorLabel));
		System.out.println(util.isElementDisplyed(pausedLabel));
		System.out.println(util.isElementDisplyed(pendingLabel));
		System.out.println(util.isElementDisplyed(scheduledLabel));
		if (util.isElementDisplyed(archivedLabel) && util.isElementDisplyed(activeLabel)
				&& util.isElementDisplyed(disconnectedLabel) && util.isElementDisplyed(endedLabel)
				&& util.isElementDisplyed(errorLabel) && util.isElementDisplyed(pausedLabel)
				&& util.isElementDisplyed(pendingLabel) && util.isElementDisplyed(scheduledLabel)) {
			log.info("all status filter options are available on status filter list");
			log.info("OM_TC_DA_063 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_063 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_064() {
		log.info("OM_TC_DA_064 is running");
//		Check the if the filtering of result work per option.
		String filterCheckBoxToApply = "scheduled";
		for (WebElement filter : allCheckboxList) {
			if (filter.getAttribute("id").equalsIgnoreCase(filterCheckBoxToApply)) {
				filter.click();
				log.info("clicked on scheduled checkbox");
				break;
			}
		}
		util.click(applyButton);
		log.info("clicked on apply Button");
		if (singleActiveFilter.findElement(By.tagName("span")).getText().equalsIgnoreCase(filterCheckBoxToApply)) {
			log.info("filter tag is visible");
			log.info("OM_TC_DA_064 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_064 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_067() {
		log.info("OM_TC_DA_067 is running");
//		Verify if the filter options can be removed by clicking on cross
		util.click(singleActiveFilter.findElement(By.tagName("button")));
		log.info("clicked on active filter cross button");
		try {
			if (!util.isElementDisplyed(singleActiveFilter)) {
				log.info("filter tag is not visible");
				log.info("OM_TC_DA_067 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_067 is failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			log.info("filter tag is not visible");
			log.info("OM_TC_DA_067 is passed");
			Assert.assertTrue(true);
		}

	}

	public void OM_TC_DA_065() {
		log.info("OM_TC_DA_065 is running");
//		Check applying multiple filters and then cross any one filter, the reselt should get updated accordingly.
		util.refreshPage();
		util.click(filterButton);
		log.info("clicked on filter button");
		String filterCheckBoxToApply = "active";
		String filterCheckBoxToApply1 = "scheduled";

		for (WebElement filter : allCheckboxList) {
			if (filter.getAttribute("id").equalsIgnoreCase(filterCheckBoxToApply)) {
				util.hold(5);
				util.actionClick(filter);
				log.info("clicked on active checkbox");
				break;
			}
		}

		for (WebElement filter : allCheckboxList) {
			if (filter.getAttribute("id").equalsIgnoreCase(filterCheckBoxToApply1)) {
				util.hold(5);
				filter.click();
				log.info("clicked on scheduled checkbox");
				break;
			}
		}
		util.click(applyButton);
		log.info("clicked on filter button");

		if (util.isElementDisplyed(activeFiltersContainer)) {
			log.info("filter tag container is visible");
			util.click(activeFiltersContainer);
			log.info("clicked on filter container");
			for (WebElement activeFilter : activeFiltersInsideFiltersContainer) {
				if (activeFilter.findElement(By.tagName("span")).getText().equalsIgnoreCase(filterCheckBoxToApply)
						|| activeFilter.findElement(By.tagName("span")).getText()
								.equalsIgnoreCase(filterCheckBoxToApply1)) {
					log.info("active and scheduled filter is displayed");
					log.info("OM_TC_DA_065 is passed");
					Assert.assertTrue(true);
				} else {
					log.error("OM_TC_DA_065 is passed");
					Assert.assertTrue(false);
				}
			}

		}
	}

	public void OM_TC_DA_068() {
		log.info("OM_TC_DA_068 is running");
//		Check if there is clear all/reset button to clear the filter
		util.refreshPage();
		util.click(filterButton);
		log.info("clicked on filter button");
		util.click(scheduledLabel);
		log.info("clicked on scheduled checkbox");
		util.click(applyButton);
		log.info("clicked on apply button");
		for (WebElement campaign : allCampaignsStatus) {
			if (campaign.getText().equalsIgnoreCase("Scheduled")) {
				log.info(" scheduled filter is active");
				log.info("OM_TC_DA_068 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_068 is failed");
				Assert.assertTrue(false);
			}

		}
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(5);
		util.click(resetButton);
		log.info("clicked on reset button");
		util.hold(2);
		util.click(crossButtonFiltersCard);
		log.info("clicked on cross button of filter card");
		for (WebElement campaign : allCampaignsStatus) {
			if (campaign.getText().equalsIgnoreCase("Scheduled") || campaign.getText().equalsIgnoreCase("Active")
					|| campaign.getText().equalsIgnoreCase("Paused")
					|| campaign.getText().equalsIgnoreCase("Archived")) {
				log.info("campaigns with all status are displayed");
				log.info("OM_TC_DA_068 is passed");
				Assert.assertTrue(true);
			} else {
				log.info("filters are not displayed");
				log.info("OM_TC_DA_069 is passed");
				Assert.assertTrue(false);
			}

		}
	}

	public void OM_TC_DA_069() {
		log.error("OM_TC_DA_069 is running");
//		Check if clicking on cross button closes the filter view
		util.refreshPage();
		util.click(filterButton);
		log.info("clicked on filter button");
		util.click(crossButtonFiltersCard);
		log.info("clicked on cross button");
		try {
			if (!util.isElementDisplyed(filterModal)) {
				log.info("filters are not displayed");
				log.info("OM_TC_DA_069 is passed");
				Assert.assertTrue(true);
			} else {
				log.info("filters are not displayed");
				log.error("OM_TC_DA_069 is failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			log.info("filters are not displayed");
			log.info("OM_TC_DA_069 is passed");
			Assert.assertTrue(true);
		}

	}

	public void OM_TC_DA_070() {
		log.info("OM_TC_DA_070 is running");
//		 Check if user is able to apply filter after searching campaigns 
		util.refreshPage();
		util.enterValue(searchCampaignInputField, "retarg");
		log.info("searched campaign by entering name");
		util.pressEnter();
		log.info("press enter");
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(5);
		util.click(scheduledLabel);
		log.info("clicked on schedule checkbox");
		util.click(applyButton);
		log.info("clicked on apply button");
		for (WebElement campaign : allCampaignsStatus) {
			if (campaign.getText().equalsIgnoreCase("Scheduled")) {
				log.info("all campaigns have scheduled status");
				log.info("OM_TC_DA_070 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_070 is passed");
				Assert.assertTrue(false);
			}
		}

	}

	public void OM_TC_DA_078() {
		log.info("OM_TC_DA_078 is running");
//		Check if user is able to sort Campaigns on basis of Start date---Check for hight to low and low to high
		util.refreshPage();
		util.hold(3);
		util.click(startDateHeading);
		log.info("clicked on start Date Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(startDateHeading);
		log.info("clicked on start Date Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_078 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_078 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_079() {
		log.info("OM_TC_DA_079 is running");
//		Check if user is able to sort Campaigns on basis of Start date---Check for hight to low and low to high
		util.click(campaignHeading);
		log.info("clicked on campaign Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(campaignHeading);
		log.info("clicked on campaign Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_079 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_079 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_080() {
		log.info("OM_TC_DA_080 is running");
//		Check if user is able to sort Campaigns on basis of Daily budget---Check for hight to low and low to high
		util.hold(3);
		util.click(dailyBudgetHeading);
		log.info("clicked on dailyBudget Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(dailyBudgetHeading);
		log.info("clicked on dailyBudget Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_080 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_080 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_081() {
		log.info("OM_TC_DA_080 is running");
//		Check if user is able to sort Campaigns on basis of spend---Check for hight to low and low to high
		util.hold(3);
		util.click(spendHeading);
		log.info("clicked on spending Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(spendHeading);
		log.info("clicked on spending Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_081 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_081 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_082() {
		log.info("OM_TC_DA_082 is running");
//		Check if user is able to sort Campaigns on basis of impressions------Check for hight to low and low to high 
		util.click(impressionsHeading);
		log.info("clicked on impressions Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(impressionsHeading);
		log.info("clicked on impressions Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_082 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_082 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_083() {
		log.info("OM_TC_DA_083 is running");
//		Check if user is able to sort Campaigns on basis of clicks---Check for hight to low and low to high
		util.hold(3);
		util.click(clicksHeading);
		log.info("clicked on clicks Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(clicksHeading);
		log.info("clicked on clicks Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_083 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_083 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_084() {
		log.info("OM_TC_DA_084 is running");
//		Check if user is able to sort Campaigns on basis of orders---Check for hight to low and low to high
		util.hold(3);
		util.click(ordersHeading);
		log.info("clicked on orders Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(ordersHeading);
		log.info("clicked on orders Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_084 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_084 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_085() {
		log.info("OM_TC_DA_085 is running");
//		Check if user is able to sort Campaigns on basis of sales---Check for hight to low and low to high
		util.hold(3);
		util.click(salesHeading);
		log.info("clicked on sales Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(salesHeading);
		log.info("clicked on sales Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_085 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_085 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_DA_086() {
		log.info("OM_TC_DA_086 is running");
//		Check if user is able to sort Campaigns on basis of ROAS---Check for hight to low and low to high.
		util.hold(3);
		util.click(ROASHeading);
		log.info("clicked on ROAS Heading");
		boolean isCampaignSortedInA2Z = util.isElementDisplyed(AToZSorting);
		util.click(ROASHeading);
		log.info("clicked on ROAS Heading");
		boolean isCampaignSortedInZ2A = util.isElementDisplyed(ZToASorting);
		if (isCampaignSortedInA2Z == isCampaignSortedInZ2A) {
			log.info("campaigns are sorting in ascending and descending");
			log.info("OM_TC_DA_086 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_086 is failed");
			Assert.assertTrue(false);
		}
		util.refreshPage();
	}

	public void OM_TC_DA_087() {
		log.info("OM_TC_DA_086 is running");
//		Check if sorting is getting reset after user is refreshing page.
		util.hold(3);
		util.click(campaignHeading);
		log.info("clicked on campaign Heading");
		boolean isCampaignSortedInA2ZInitial = util.isElementDisplyed(AToZSorting);
		util.refreshPage();
		log.info("page refreshed");
//		boolean isCampaignSortedInA2ZFinal = util.isElementDisplyed(AToZSorting);
		try {
			if (isCampaignSortedInA2ZInitial != util.isElementDisplyed(AToZSorting)) {
				log.info("sorting is getting reset");
				log.info("OM_TC_DA_087 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_087 is failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			log.info("sorting is getting reset");
			log.info("OM_TC_DA_087 is passed");
			Assert.assertTrue(true);
		}

		util.refreshPage();

	}

	public void OM_TC_DA_089() {
		log.info("OM_TC_DA_089 is running");
//		Check if sorting is getting reset after user is navigating between sections.
		util.hold(3);
		util.click(campaignHeading);
		log.info("clicked on campaign Heading");
		boolean isCampaignSortedInA2ZInitial = util.isElementDisplyed(AToZSorting);
		util.clickOnSettings();
		log.info("clicked on settings ");
		util.clickOnDashboard();
		log.info("clicked on dashboard");
		try {
			if (isCampaignSortedInA2ZInitial != util.isElementDisplyed(AToZSorting)) {
				log.info("sorting is getting reset");
				log.info("OM_TC_DA_089 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_089 is failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			log.info("sorting is getting reset");
			log.info("OM_TC_DA_089 is passed");
			Assert.assertTrue(true);
		}

		util.refreshPage();

	}

	public void OM_TC_DA_091() {
		log.info("OM_TC_DA_091 is running");
//		Check if sorting is getting reset if user is clicking on create campaign.
		util.hold(3);
		util.click(campaignHeading);
		log.info("clicked on campaign Heading");
		boolean isCampaignSortedInA2ZInitial = util.isElementDisplyed(AToZSorting);
		util.click(createCampaignButton);
		log.info("clicked on create campaign button");
		util.click(backButtonIcon);
		log.info("clicked on back button");
		try {
			if (isCampaignSortedInA2ZInitial != util.isElementDisplyed(AToZSorting)) {
				log.info("sorting is getting reset");
				log.info("OM_TC_DA_091 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_DA_091 is failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			log.info("sorting is getting reset");
			log.info("OM_TC_DA_091 is passed");
			Assert.assertTrue(true);
		}

		util.refreshPage();

	}

	public void OM_TC_DA_092() {
		log.info("OM_TC_DA_092 is running");
//		Check if the user has created a campaign with start date of later(later date/time) ----its status should reflect Scheduled and it should get Active on scheduled date and time  
		util.refreshPage();
		String campaignStartDate = null;
		String todaysDate = util.getToday();

		// 1 verify campaign's start date
//		2 if start date is greater than todays date it should be in scheduled
//		Todays date must be less than start date
//		Todays month must be equal or greater than current month
//		Todays year must be equal or greater than current year

//		get todays date extract day, month , year
//		get campaig's start date extract day, month , year

		int currentDay = Integer.parseInt(util.getTodaysDate());

		int currentMonth = Integer.parseInt(util.getCurrentMonth());
		int currentYear = Integer.parseInt(util.getCurrentYear());

		int indexCampaign = 0;
		for (WebElement campaign : allCampaignsStatusLabel) {
			indexCampaign += 1;
			if (campaign.findElement(By.tagName("span")).getText().equalsIgnoreCase("scheduled")) {
				log.info("campaign status is scheduled");
				int indexStartDate = 0;
				for (WebElement campStartDate : startDate) {
					indexStartDate += 1;
					if (indexStartDate == indexCampaign) {
						campaignStartDate = campStartDate.findElement(By.tagName("p")).getText();
						log.info("extracted date of that campaign");
						break;
					}
				}
				break;
			}
		}

		int getCampaignsMonth = Integer.parseInt((util.extractWordAfterACharacter(campaignStartDate, "/", 0)));
		int getCampaignsDay = Integer.parseInt(util.extractWordAfterACharacter(campaignStartDate, "/", 1));
		int getCampaignsYear = Integer.parseInt(util.extractWordAfterACharacter(campaignStartDate, "/", 2));

//		if current month and current year is same as the campaign's month and year but campaign's date is greater than today then status should be scheduled
		if ((getCampaignsMonth == currentMonth) && (getCampaignsYear == currentYear)
				&& (getCampaignsDay > currentDay)) {
			log.info("extracted date is not equals to today's date");
			log.info("OM_TC_DA_092 is passed");
			Assert.assertTrue(true);
//				if current month is less than campaign's date month and year is equal or greater than the current year
		} else if ((getCampaignsMonth > currentMonth) && (getCampaignsYear >= currentYear)) {
			log.info(
					"current month is less than campaign's date month and year is equal or greater than the current year");
			log.info("OM_TC_DA_092 is passed");
			Assert.assertTrue(true);

//				if current year is less than the campign's year
		} else if (getCampaignsYear > currentYear) {
			log.info("current year is less than the campign's year");
			log.info("OM_TC_DA_092 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_DA_092 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_DA_096_98() {
//		Check if user is able to  "Pause" a campaign, and status of that campaign should get updated to paushed.
		int indexCampaign = 0;
		for (WebElement campaignStatus : allCampaignsStatusLabel) {
			indexCampaign += 1;
			if (campaignStatus.findElement(By.tagName("span")).getText().equalsIgnoreCase("active")) {
				for (WebElement campaignName : allCampaignNames) {
					if (campaignName.getText().equals("Winter sale")) {
						int indexAction = 0;
						for (WebElement action : actionsButton) {
							indexAction += 1;
							if (indexCampaign == indexAction) {
								action.click();
								util.click(pauseCampaignButton);
								util.click(pauseCampaignButtonInModal);
								break;
							}

						}
						break;
					}

				}
				break;

			}

		}
		for (WebElement campaignName : allCampaignNames) {
			if (campaignName.getText().equals("Winter sale")) {
				int indexAction = 0;
				for (WebElement campaignStatus : allCampaignsStatusLabel) {
					indexAction += 1;
					if (indexCampaign == indexAction) {
						if (campaignStatus.findElement(By.tagName("span")).getText().equalsIgnoreCase("paused")) {
							Assert.assertTrue(true);
						} else {
							Assert.assertTrue(false);
						}
					}

				}
			}
			break;
		}
		util.hold(5);
		util.refreshPage();

	}

	public void OM_TC_DA_099() {

//		Check if user has unpasing a paused campaign---Status will be scheduled, if the start date is of later than current time. 

//		1 => find a campain with status PAUSED 
//		2 => UNPAUSED it
//		3 => check its start date if it is less than current date 
//		4 => again check its status it should be SCHEDULED
//		5 => check if start date is less than or equal to  current date and end date is greater than the current date => it should be in ACTIVE state 
		util.refreshPage();
		int indexCampaign = 0;
		for (WebElement campaignStatus : allCampaignsStatusLabel) {
			indexCampaign += 1;
			if (campaignStatus.findElement(By.tagName("span")).getText().equalsIgnoreCase("paused")) {
				int indexAction = 0;
				for (WebElement action : actionsButton) {
					indexAction += 1;
					if (indexCampaign == indexAction) {
						action.click();
//						util.click(pauseCampaignButton);
						util.click(unPauseCampaignButton);
						util.click(unPauseCampaignButtonInModal);
						break;
					}
				}
				break;
			}
		}
		System.out.println("indexCampaign = " + indexCampaign);
		String campaignStartDate = null;
		String todaysDate = util.getToday();
		int indexStartDate = 0;
		for (WebElement campStartDate : startDate) {
			indexStartDate += 1;

			System.out.println("indexStartDate = " + indexStartDate);
			if (indexStartDate == indexCampaign) {
				campaignStartDate = campStartDate.findElement(By.tagName("p")).getText();
				break;
			}
			break;
		}

		int currentDay = Integer.parseInt(util.getTodaysDate());
		int currentMonth = Integer.parseInt(util.getCurrentMonth());
		int currentYear = Integer.parseInt(util.getCurrentYear());

		int getCampaignsMonth = Integer.parseInt((util.extractWordAfterACharacter(campaignStartDate, "/", 0)));
		int getCampaignsDay = Integer.parseInt(util.extractWordAfterACharacter(campaignStartDate, "/", 1));
		int getCampaignsYear = Integer.parseInt(util.extractWordAfterACharacter(campaignStartDate, "/", 2));

//		if current month and current year is same as the campaign's month and year but campaign's date is greater than today then status should be scheduled
		if ((getCampaignsMonth == currentMonth) && (getCampaignsYear == currentYear) && (getCampaignsDay > currentDay)
				|| ((getCampaignsMonth > currentMonth) && (getCampaignsYear >= currentYear))
				|| (getCampaignsYear > currentYear)) {
			int count = 0;
			for (WebElement campaignStatus : allCampaignsStatusLabel) {
				count++;
				if (count == indexCampaign) {
					if (campaignStatus.findElement(By.tagName("span")).getText().equalsIgnoreCase("scheduled")) {
						Assert.assertTrue(true);
					} else {
						Assert.assertTrue(false);
					}
				}

			}
		}

	}

	public void OM_TC_DA_113() {
//		Check if user is getting all 3 actions in action list, (Edit, Archieve, Pause)
		for (WebElement campaign : allCampaignsStatusLabel) {
			if ((campaign.findElement(By.tagName("span")).getText().equalsIgnoreCase("scheduled"))
					|| (campaign.findElement(By.tagName("span")).getText().equalsIgnoreCase("active"))) {
				for (WebElement action : actionsButton) {
					action.click();
					if ((util.isElementDisplyed(editCampaignButton)) && (util.isElementDisplyed(pauseCampaignButton))
							&& (util.isElementDisplyed(archiveCampaignButton))) {
						Assert.assertTrue(true);
					} else {
						Assert.assertTrue(false);
					}
					action.click();
					util.scrollToBottom();
				}
			}

		}

	}

	public void OM_TC_DA_115() {
		util.refreshPage();
//		Check if user is getting unpause action only in paused campaigns
		int campaignStatusCount = 0;
		int actionCount = 0;
		for (WebElement campaign : allCampaignsStatusLabel) {
			campaignStatusCount += 1;
			System.out.println("campaignStatusCount = " + campaignStatusCount);
			if ((campaign.findElement(By.tagName("span")).getText().equalsIgnoreCase("paused"))) {

				for (WebElement action : actionsButton) {
					actionCount++;
					System.out.println("actionCount = " + actionCount);
					if (actionCount == campaignStatusCount) {
						action.click();
						if (util.isElementDisplyed(unPauseCampaignButton)) {
							Assert.assertTrue(true);
						} else {
							Assert.assertTrue(false);
						}
						action.click();
						util.scrollToBottom();
					}
					break;
				}
			}

		}

//		campaignStatusCount = 0;
//		actionCount = 0;
//		for (WebElement campaign : allCampaignsStatusLabel) {
//			campaignStatusCount += 1;
//			if (!(campaign.findElement(By.tagName("span")).getText().equalsIgnoreCase("paused"))){
//				
//				for(WebElement action : actionsButton) {
//					actionCount++;
//					if(actionCount == campaignStatusCount) {
//						action.click();
//						if(!util.isElementDisplyed(unPauseCampaignButton)) {
//							Assert.assertTrue(true);
//						}else {
//							Assert.assertTrue(false);
//						}
//						action.click();
//						util.scrollToBottom();
//					}
//					break;
//				}
//			}
//		}
	}

	public void OM_TC_DA_051() {
//		Check if user is able to apply filter after searching campaigns 
		util.click(filterButton);
		util.hold(2);
		util.click(scheduledCheckbox);
		util.click(applyButton);
		util.enterValue(searchCampaignInputField, "retarg");
		util.pressEnter();
		for (WebElement campaignStatus : allCampaignsStatus) {
			if (campaignStatus.getText().equals("Scheduled") || util.isElementDisplyed(noCampaignFound)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

	}

}
