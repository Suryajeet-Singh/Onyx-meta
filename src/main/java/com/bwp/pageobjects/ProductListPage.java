package com.bwp.pageobjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
public class ProductListPage extends ProductListOR {
	private static final Logger log = LogManager.getLogger(ProductListPage.class);

	Utilities util;

	/**
	 * ProductList class constructor to initialize driver .
	 * 
	 * @param util
	 */
	public ProductListPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

	/**
	 * this method validates that user is redirecting to product list section after
	 * clicking on product list option in navigation menu.
	 */
	public void OM_TC_PL_01() {
		log.info("Running Product List section");
		log.info("Test case OM_TC_PL_01 is running");
//		Click on product list on the navigation tab
		util.clickOnProductList();
		log.info("clicked on Product list");

		if (util.getPageURL().contains("/product")) {
			log.info("product list page is opened");
			log.info("Test case OM_TC_PL_01 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("Test case OM_TC_PL_01 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * This method validates that search box is visible in the product list page.
	 */
	public void OM_TC_PL_02() {

		log.info("Test case OM_TC_PL_02 is running");
//		Check whether Searchbox is properly visible and in proportion with UI

		if (util.isElementDisplyed(searchInputField)) {
			log.info("search Input Field is displayed");
			log.info("Test case OM_TC_PL_02 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("Test case OM_TC_PL_02 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * This method validates that placeholder is visible in the search box input
	 * field.
	 */
	public void OM_TC_PL_07() {
		log.info("Test case OM_TC_PL_07 is running");
//		Check whether the search box gives any hint/placeholder for the user regarding what to search in the search box

		if (util.extractValueByAttributes(searchInputField, "placeholder").equals("Search Products by Title")) {
			log.info("search Input Field contains placeholder that gives user should search by title.");
			log.info("Test case OM_TC_PL_07 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("Test case OM_TC_PL_07 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * This method validates that search input field is editable.
	 * 
	 * @param input
	 */
	public void OM_TC_PL_04(HashMap<String, String> input) {
		log.info("Test case OM_TC_PL_04 is running");
//		Check whether the user is able to enter the required text in the search box
		util.enterValue(searchInputField, input.get("alpha_num"));
		log.info("entered text in search Input Field");

		if (!util.extractValueByAttributes(searchInputField, "value").equals("")) {
			log.info("search box is editable");
			log.info("Test case OM_TC_PL_04 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("Test case OM_TC_PL_04 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * 
	 */
	public void OM_TC_PL_05(HashMap<String, String> input) {
		log.info("Test case OM_TC_PL_05 is running");
//		Verify whether the search box is giving any autosuggestions for text to be searched
		util.enterValue(searchInputField, input.get("search_product"));
		util.hold(2);
		log.info("entered text in search Input Field");

		for (WebElement query : allQuerySugesstion) {

			if (query.findElement(By.xpath("//span[@style = 'color: rgb(28, 36, 51);']")).getText()
					.equalsIgnoreCase("shampoo")) {
				log.info("reflecting suggestions contains entered word");
				log.info("Test case OM_TC_PL_05 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("Test case OM_TC_PL_05 is failed");
				Assert.assertTrue(false);
			}
		}

		util.pressEnter();
		util.hold(2);
	}

	/**
	 * This method validates that user can clear data of search input field .
	 */
	public void OM_TC_PL_08_12() {
		log.info("Test case OM_TC_PL_08 is running");
//		Verify if a user can clear or delete the text written in the search box
		util.click(clearSearchInputField);
		log.info("cleared search input field");

		if (util.extractValueByAttributes(searchInputField, "value").equals("")) {
			log.info("search input field is empty");
			log.info("Test case OM_TC_PL_08 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("Test case OM_TC_PL_08 is failed");
			Assert.assertTrue(false);
		}
		util.hold(2);
	}

	/**
	 * This method validates that user can select results that appears in
	 * suggestions.
	 */
	public void OM_TC_PL_09(HashMap<String, String> input) {
		util.refreshPage();
		log.info("Test case OM_TC_PL_09 is running");
//		Verify the user is able to select any specific auto search result populated in the search box
		util.enterValue(searchInputField, input.get("search_product"));

		try {
//			if (util.isElementDisplyed(vaildSuggestionCard)) {

				for (WebElement sugesstion : searchSuggestionList) {
					sugesstion.click();
					log.info("user clicked on populated search title");
					break;
				}

				for (WebElement title : titleList) {

					if (StringUtils.containsIgnoreCase(title.getText(), input.get("search_product"))) {
						log.info("Test case OM_TC_PL_09 is passed");
						Assert.assertTrue(true);
						break;
					} else {
						log.error("Test case OM_TC_PL_09 is failed");
						Assert.assertTrue(false);

					}
				}
//			}
		} catch (NoSuchElementException e) {
			if (util.isElementDisplyed(noProductFoundMsg)) {
				log.info("No Product found msg is displayed.");
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
	}

	/**
	 * This method validates that when user enters only one character and press
	 * enter key suggestion/no product found is visible.
	 */
	public void OM_TC_PL_13(HashMap<String, String> input) {
//		Enter any one character in the search box and click on the Search button/press Enter key.
		log.info("Test case OM_TC_PL_13 is running");
		util.enterValue(searchInputField, input.get("one_char"));
		util.pressEnter();
		try {

			if ((util.isElementDisplyed(noProductFoundMsg) || (util.isElementDisplyed(titleList.get(0))))) {
				log.info("Test case OM_TC_PL_13 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("Test case OM_TC_PL_13 is failed");
				Assert.assertTrue(false);
			}

		} catch (NoSuchElementException e) {

			if (util.isElementDisplyed(noProductFoundMsg)) {
				log.info("Test case OM_TC_PL_13 is passed");
				Assert.assertTrue(true);
			} else if (util.isElementDisplyed(titleList.get(0))) {
				log.info("Test case OM_TC_PL_13 is passed");
				Assert.assertTrue(true);
			}
		}
	}

	/**
	 * This method validates when user enters only numbers in search input field
	 * results are shown accordingly.
	 */
	public void OM_TC_PL_15(HashMap<String, String> input) {
		log.info("Test case OM_TC_PL_15 is running");
//		Enter only numbers in the search filed and hit enter
		util.getDriver().navigate().refresh();
		util.hold(5);
		util.enterValue(searchInputField, input.get("only_numbers"));
		log.info("entered only numbers in search Input Field");
		util.pressEnter();
		log.info("pressed enter");
		util.hold(5);

		try {
			for (WebElement title : allCampaignTitle) {

				if ((title.getText().contains(input.get("only_numbers"))) || util.isElementDisplyed(noResultFound)) {
					log.info("Test case OM_TC_PL_15 is passed");
					Assert.assertTrue(true);
				} else {
					log.error("Test case OM_TC_PL_15 is failed");
					Assert.assertTrue(false);
				}
			}
		} catch (NoSuchElementException e) {
			if (util.isElementDisplyed(noProductFoundMsg)) {
				log.info("Test case OM_TC_PL_13 is passed");
				Assert.assertTrue(true);
			}
		}

		util.click(clearSearchInputField);
		log.info("cleared search input field");
		util.hold(2);
	}

	/**
	 * This method validates that when user enters alphanumeric characters in the
	 * search box and hit enter results are shown accordingly
	 */
	public void OM_TC_PL_16() {
		log.info("Test case OM_TC_PL_16 is running");
//		Enter alphanumeric characters in the search box and hit enter
		util.getDriver().navigate().refresh();
		util.hold(5);

		util.enterValue(searchInputField, "1110 LED");
		log.info("entered alphanumeric characters  in search Input Field");
		util.pressEnter();
		util.hold(5);

		try {
			for (WebElement title : allCampaignTitle) {
				if ((title.getText().contains("1110 LED") || util.isElementDisplyed(noResultFound))) {
					log.info("Test case OM_TC_PL_16 is passed");
					Assert.assertTrue(true);
				} else {
					log.error("Test case OM_TC_PL_16 is failed");
					Assert.assertTrue(false);
				}
			}
		} catch (NoSuchElementException e) {
			if (util.isElementDisplyed(noProductFoundMsg)) {
				log.info("Test case OM_TC_PL_13 is passed");
				Assert.assertTrue(true);
			}
		}

		util.click(clearSearchInputField);
		log.info("cleared search input field");
		util.hold(2);
	}

	/**
	 * This validates that when user enters keyword with spaces results are shown
	 * accordingly.
	 */
	public void OM_TC_PL_19(HashMap<String, String> input) {
		log.info("Test case OM_TC_PL_19 is running");
//		Enter a string in the search box with spaces (before the string, after string, and in between) and verify the results.
		util.getDriver().navigate().refresh();
		util.hold(5);
		util.enterValue(searchInputField, input.get("keyword_with_spaces"));
		log.info("entered spaces (before the string, after string, and in between)  in search Input Field");
		util.pressEnter();
		util.hold(5);

		try {
			for (WebElement title : allCampaignTitle) {
				if (title.getText().contains("Shampoo")) {
					log.info("Test case OM_TC_PL_19 is passed");
					Assert.assertTrue(true);
				} else {
					log.error("Test case OM_TC_PL_19 is failed");
					Assert.assertTrue(false);
				}
			}
		} catch (NoSuchElementException e) {
			if (util.isElementDisplyed(noProductFoundMsg)) {
				log.info("Test case OM_TC_PL_13 is passed");
				Assert.assertTrue(true);
			}
		}

		util.click(clearSearchInputField);
		util.hold(3);
	}

	/**
	 * This method validates that clicking on the filter button opens the filter
	 * view
	 */
	public void OM_TC_PL_20() {
		log.info("Test case OM_TC_PL_20 is running");
//		Check if clicking on the filter button opens the filter view
		util.refreshPage();
		util.hold(3);
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(7);

		if (util.isElementDisplyed(filterIsActivated)) {
			log.info("Test case OM_TC_PL_20 is passed");
			log.info("filter view is visible");
			Assert.assertTrue(true);
		} else {
			log.error("Test case OM_TC_PL_20 is failed");
			Assert.assertTrue(false);
		}
	}

	/**
	 * This method validates that all filter options are available.
	 */
	public void OM_TC_PL_23() {
		log.info("Test case OM_TC_PL_23 is running");
//		Check if for status filter all options are available.
		util.hold(3);
//		util.actionClick(inventoryFilterHeading);
//		log.info("clicked on inventory filter ");
//		util.actionClick(statusFilterHeading);
//		log.info("clicked on status filter heading");

		if (util.isElementDisplyed(activeCheckboxLabel) && util.isElementDisplyed(errorCheckBoxLabel)
				&& util.isElementDisplyed(pendingCheckBoxLabel)) {
			log.info("Test case OM_TC_PL_23 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("Test case OM_TC_PL_23 is failed");
			Assert.assertTrue(false);
		}

	}

	/**
	 * This method validates that "inStockCheckbox" and "outOfStockCheckbox" are
	 * available.
	 */
	public void OM_TC_PL_24() {
//		**********************REMOVED FROM APP********************
		
//		log.info("Test case OM_TC_PL_24 is running");
//		Check if inventory filter has appropriate option like instock and out of stock
//		util.hold(3);
//		util.actionClick(inventoryFilterHeading);
//		log.info("clicked on inventory filter ");
//		if (util.isElementDisplyed(inStockCheckboxLabel) && util.isElementDisplyed(outOfStockCheckboxLabel)) {
//			log.info("inStock Checkbox and outOfStockCheckbox is visible");
//			log.info("Test case OM_TC_PL_24 is passed");
//			Assert.assertTrue(true);
//		} else {
//			log.error("Test case OM_TC_PL_24 is failed");
//			Assert.assertTrue(false);
//		}

	}

//	public void OM_TC_PL_27() {
//		Verify if the filter options can be removed by clicking on cross
//		util.click(inStockCheckbox);
//		util.click(applyButton);
//		for(WebElement crossButton: activeFilterCrossButton) {
//			crossButton.click();
//			
//		}
//
//	}

	/**
	 * This method validates that there is no active filter unless user selects one.
	 */
	public void OM_TC_PL_21() {
		log.info("Test case OM_TC_PL_21 is running");
//		Check if filter tag is visible before applying filter
		util.refreshPage();

		for (WebElement activeFilter : activeFilterSectionItems) {
			try {
				if (!util.isElementDisplyed(activeFilter)) {
					log.info("filter tag is not displayed");
					log.info("Test case OM_TC_PL_21 is passed");
					Assert.assertTrue(true);
				} else {
					log.error("Test case OM_TC_PL_21 is failed");
					Assert.assertTrue(false);
				}
			} catch (NoSuchElementException e) {
				log.info("filter tag is not displayed");
				log.info("Test case OM_TC_PL_21 is passed");
				Assert.assertTrue(true);
			}
		}
	}

	/**
	 * This method validates that filters are removed when user navigates to other
	 * section.
	 */
	public void OM_TC_PL_62() {
		log.info("Test case OM_TC_PL_62 is running");
//		Apply any filter and navigate between modules => -Filter and search gets removed
		util.getDriver().navigate().refresh();
		util.hold(5);
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(2);
		util.click(activeCheckboxLabel);
		log.info("clicked on active filter");
		util.click(crossButtonFiltersCard);
		util.hold(1);
		util.clickOnDashboard();
		log.info("clicked on dashboard");
		util.clickOnProductList();
		log.info("clicked on product list");

		try {

			if (util.isElementDisplyed(activeFilter)) {
				log.info("active filter container is displayed");
				log.info("Test case OM_TC_PL_62 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("Test case OM_TC_PL_62 is failed");
				Assert.assertTrue(false);
			}

		} catch (NoSuchElementException e) {
			log.info("active filter container is displayed");
			log.info("Test case OM_TC_PL_62 is passed");
			Assert.assertTrue(true);
		}
	}

	/**
	 * This method validates that filter options can be removed by clicking on
	 * cross.
	 */
	public void OM_TC_PL_27() {
//		Verify if the filter options can be removed by clicking on cross => filter tag should get removed
		util.getDriver().navigate().refresh();
		util.hold(5);
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(2);
		util.actionClick(activeCheckboxLabel);
		log.info("clicked on activeCheckbox");
		util.click(applyButton);
		log.info("clicked on apply button");
		util.hold(1);
		activeFilterListCloseButton.get(0).click();

		try {
			if (util.isElementDisplyed(activeFilter)) {
				log.info("active filter container is displayed");
				log.info("Test case OM_TC_PL_27 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("Test case OM_TC_PL_27 is failed");
				Assert.assertTrue(false);
			}
		} catch (NoSuchElementException e) {
			log.info("active filter container is displayed");
			log.info("Test case OM_TC_PL_27 is passed");
			Assert.assertTrue(true);
		}
	}

	/**
	 * This method validates that clicking on cross button closes the filter view
	 */
	public void OM_TC_PL_29() {
		log.info("Test case OM_TC_PL_29 is running");
//		Check if clicking on cross button closes the filter view
		util.refreshPage();
		util.click(filterButton);
		log.info("clicked on filter Button");
		util.hold(2);
//		util.click(inventoryFilterHeading);
//		log.info("clicked on inventory filter heading");
		util.actionClick(crossButtonFiltersCard);
		log.info("clicked on cross button");

		try {
			if (!util.isElementDisplyed(filterIsActivated)) {
				log.info("filter is not visible");
				log.info("Test case OM_TC_PL_29 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("Test case OM_TC_PL_29 is failed");
				Assert.assertTrue(false);
			}
		} catch (NoSuchElementException e) {
			log.info("filter is not visible");
			log.info("Test case OM_TC_PL_29 is passed");
		}
	}

	/**
	 * This method validates that on clicking clear all/reset button all applied
	 * filter should get removed
	 */
	public void OM_TC_PL_28() {
		log.info("Test case OM_TC_PL_28 is running");
//		Check if there is clear all/reset button to clear the filter  => on clicking all applied filter should get removed
		util.refreshPage();
		util.hold(3);
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(2);
		util.actionClick(activeCheckboxLabel);
		log.info("clicked on active checkbox");
		util.click(applyButton);
		log.info("clicked on apply button");
		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(1);
		util.click(resetButton);
		log.info("clicked on reset button");

		try {
			if (util.isElementDisplyed(activeFilter)) {
				log.info("active filter container is displayed");
				log.info("Test case OM_TC_PL_62 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("Test case OM_TC_PL_62 is failed");
				Assert.assertTrue(false);
			}
		} catch (NoSuchElementException e) {
			log.info("active filter container is displayed");
			log.info("Test case OM_TC_PL_62 is passed");
			Assert.assertTrue(true);
		}
	}

	/**
	 * Check if any product has error then "i" icon is there or not and that product
	 * should have error status any product has error then correct and user readable
	 * text should be displayed on clicking on i icon explaining the error
	 * 
	 */
	public void OM_TC_PL_36_37() {
		log.info("Test case OM_TC_PL_36 is running");
		util.refreshPage();
		util.click(filterButton);
		log.info("clicked on filter button");
//		util.click(statusHeading);
//		log.info("clicked on status");
		util.click(pendingCheckBoxLabel);
		log.info("clicked on pending CheckBox");
		util.click(applyButton);
		log.info("clicked on apply filter button");

		try {
			for (WebElement kebabMenu : moreActionsDots) {
				util.hold(2);
				kebabMenu.click();
				log.info("clicked on kebab menu");

				if ((util.isElementDisplyed(syncButton) && (util.isElementDisplyed(editOnBuyWithPrimeButton)))) {
					log.info("syncButton and editOnBuyWithPrimeButton is displayed");
					log.info("Test case OM_TC_PL_36 is passed");
					Assert.assertTrue(true);
				} else {
					log.error("Test case OM_TC_PL_36 is failed");
					Assert.assertTrue(false);
				}
			}
		} catch (NoSuchElementException e) {
			if (util.isElementDisplyed(noProductFoundMsg)) {
				log.info("Test case OM_TC_PL_13 is passed");
				Assert.assertTrue(true);
			}
		}

		util.refreshPage();
		util.hold(3);
	}

	/**
	 * Check if on clicking on resync, activity is displayed => On clicking on sync
	 * loader in status section will be there until sync is not completed
	 */
	public void OM_TC_PL_38() {
		log.info("Test case OM_TC_PL_38 is running");
//		util.click(filterButton);
		log.info("clicked on filter button");
		util.hold(2);
		util.click(pendingCheckBoxLabel);
		log.info("clicked on pending CheckBox");
		util.click(applyButton);
		log.info("clicked on apply filter button");

		for (WebElement kebabMenu : moreActionsDots) {
			util.click(kebabMenu);
			log.info("clicked on kebabMenu");
			util.click(syncButton);
			log.info("clicked on synnc button");

			if (util.isElementDisplyed(loader)) {
				log.info("loader is displayed");
				log.info("Test case OM_TC_PL_38 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("Test case OM_TC_PL_38 is failed");
				Assert.assertTrue(false);
			}

			util.waitUntilElementIsVisible(toastMsg);

			if (util.isElementDisplyed(toastMsg)) {
				log.info("toastMsg is displayed");
				log.info("Test case OM_TC_PL_38 is passed");
				Assert.assertTrue(true);

			} else {
				log.error("toastMsg is not displayed displayed");
				log.error("Test case OM_TC_PL_38 is failed");
				Assert.assertTrue(false);
			}
		}
	}

	/**
	 * Check if on clicking on Edit with Buy on Prime is redirecting to onyx or not
	 */
	public void OM_TC_PL_40() {
		log.info("Test case OM_TC_PL_40 is running");
//		
		util.refreshPage();
		util.click(moreActionsDots.get(0));
		log.info("clicked on kebab menu");
		util.hold(2);
		util.click(editOnBuyWithPrimeButton);
		log.info("clicked on edit on Buy With Prime Button");
		util.goToChildWindow();
		util.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		System.out.println(util.getPageURL());

		if (util.getPageURL().contains("https://console.buywithprime.amazon.com/")) {
			log.info("user is redirected to onyx page");
			log.info("Test case OM_TC_PL_40 is passed");
			Assert.assertTrue(true);

		} else {
			log.error("user is not redirected to onyx page");
			log.error("Test case OM_TC_PL_40 is failed");
			Assert.assertTrue(false);
		}
		util.goToParentWindow();
	}

	public void OM_TC_PL_42() {
		log.info("Test case OM_TC_PL_42 is running");
//		Check that with only 1 page the pagination is hidden or first/previous/next/last links would be hidden/disabled

	}

}
