package com.bwp.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

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
 * change description: Added code to get data from .json file. 
 * Modified By: Yatindra Kinker
 */
public class HelpPage extends HelpPageOR {
	private static final Logger log = LogManager.getLogger(HelpPage.class);

	Utilities util;

	public HelpPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

	public void OM_TC_HS_001() {
		log.info("RUNNING HELP SECTION ONYX META");
		log.info("TEST CASE OM_TC_HS_001 IS RUNNING");

		util.clickOnHelp();
		log.info("clicked on Help in navigation bar");
//		Check whether Help page is visible or not
		if (util.isElementDisplyed(helpSectionHeading)) {
			log.info("help section is opened");
			log.info("OM_TC_HS_001 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_HS_001 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_HS_002() {
		log.info("TEST CASE OM_TC_HS_002 IS RUNNING");
//		Check that Help page consist the "Generate Ticket" card and "Email" card and FAQ
		if (util.isElementDisplyed(emailSectionCard) && util.isElementDisplyed(generateTickerSectionCard)
				&& util.isElementDisplyed(FAQSection)) {
			log.info("Generate Ticket card and Email card and FAQ is displayed");
			log.info("OM_TC_HS_002 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_HS_0012 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_GT_001() {
		log.info("TEST CASE OM_TC_GT_001 IS RUNNING");
//		Check that after clicking on Generate Ticket button user redirected to the Generate Ticket form or not
		String pageUrl = util.getPageURL();
		util.click(generateTicketButton);
		log.info("clicked on generate ticket button");
		util.getWindoHandleByUrl("https://socialsadsforbwp.freshdesk.com/support/home");
		log.info("Cedcommerce support is opened in new window");
		log.info("moved to new opened window.");
		if (util.isElementDisplyed(supportPageHeading)) {
			log.info("Support page is opened successfully.");
			log.info("OM_TC_GT_001 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GT_001 is failed");
			Assert.assertTrue(false);
		}
		util.hold(3);
		util.getWindoHandleByUrl(pageUrl);

	}

	public void OM_TC_FAQ_001() {
		log.info("TEST CASE OM_TC_FAQ_001 IS RUNNING");
//		Check by clicking all title/question whether its showing its description/answer or not
		for (WebElement faq : allFAQs) {
			faq.click();
			util.hold(1);
			log.info("clicked on FAQ");
			
			if (util.isElementDisplyed(queryBody)) {
				log.info("FAQ's Description is displayed");
				log.info("OM_TC_FAQ_001 is passed");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_FAQ_001 is failed");
				Assert.assertTrue(false);
			}
			
			faq.click();
			util.hold(1);
		}

	}

	public void OM_TC_FL_001AND002() {
		log.info("TEST CASE OM_TC_FL_001AND002 IS RUNNING");
//		Check the link direction of "View all FAQ articles"
		util.click(viewAllFAQArticlesLink);
		log.info("clicked on FAQ articles link");
		if (util.isElementDisplyed(headingOfAllFAQPage) && util.getPageURL().contains("/faq")) {
			log.info("FAQ's Description is displayed");
			log.info("OM_TC_FL_001AND002 is passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_FL_001AND002 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_SER_001() {
		log.info("TEST CASE OM_TC_SER_001 IS RUNNING");
		util.hold(1);
//		Check the search functionality by searching the title/question and description/answer
		util.enterValue(faqSearchInputField, "campaign");
		util.hold(5);
		log.info("entered searching keyword in faq search input field");
//		util.failIfTimeIsExceed(allQuerySugesstion, 5);
		for (WebElement query : allQuerySugesstion) {
			if (query.findElement(By.xpath("//span[@style = 'color: var(--inte-G800);']")).getText()
					.contains("campaign")) {
				log.info("searched results contains searched keyword");
				log.info("TEST CASE OM_TC_SER_001 IS PASSED");
				Assert.assertTrue(true);
			} else {
				log.error("OM_TC_FL_001AND002 is failed");
				Assert.assertTrue(false);
			}
		}

		util.pressEnter();
		log.info("pressed Enter");
		util.hold(2);

	}

	public void OM_TC_SER_005() {
		log.info("TEST CASE OM_TC_SER_005 IS RUNNING");
//		Check that "No results found" page is available after entering the invalid search keyword
		util.hold(2);
		util.enterValue(faqSearchInputField, "abc");
		util.hold(2);
		log.info("entered random searching keyword in faq search input field");
		if (util.isElementDisplyed(noResultFoundMsg)) {
			log.info("no searched found messaage is displayed");
			log.info("TEST CASE OM_TC_SER_005 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_SER_005 is failed");
			Assert.assertTrue(false);
		}

		util.pressEnter();
		log.info("pressed Enter");
		util.hold(3);

	}

	public void OM_TC_GS_011() {
		log.info("TEST CASE OM_TC_GS_011 IS RUNNING");
		util.hold(3);
//		Check link direction, if user click on get support link from "Dashboard" page then it redirects to the Help section in same tab.
		util.clickOnDashboard();
		log.info("clicked on Dashboard");
		util.hold(2);
		util.scrollToBottom();
		util.hold(2);
		util.actionClick(getSupportLink);
		log.info("clicked on get Support Link");
		if (util.getPageURL().contains("/help")) {
			log.info("Help page is opened");
			log.info("TEST CASE OM_TC_GS_011 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_011 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_GS_012() {
		log.info("TEST CASE OM_TC_GS_012 IS RUNNING");
		util.hold(3);
		// Check link direction, if user click on get support link from "Product List"
		// page then it redirects to the Help section in same tab.
		util.clickOnProductList();
		log.info("clicked on ProductList");
		util.hold(2);
		util.actionClick(getSupportLink);
		log.info("clicked on get support link");
		if (util.getPageURL().contains("/help")) {
			log.info("Help page is opened");
			log.info("TEST CASE OM_TC_GS_012 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_012 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_GS_013() {
		log.info("TEST CASE OM_TC_GS_013 IS RUNNING");
		util.hold(3);
//		Check link direction, if user click on get support link from "Settings" page then it redirects to the Help section in same tab.
		util.clickOnSettings();
		log.info("clicked on Settings");
		util.hold(2);
		util.actionClick(getSupportLink);
		log.info("clicked on get support link");
		if (util.getPageURL().contains("/help")) {
			log.info("Help page is opened");
			log.info("TEST CASE OM_TC_GS_013 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_013 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_GS_015() {
		log.info("TEST CASE OM_TC_GS_015 IS RUNNING");
		util.hold(3);
//		Check link direction, if user click on get support link from "Help" page then he/she stay on the same page.
		util.clickOnHelp();
		log.info("clicked on help");
		util.hold(2);
		if (util.getPageURL().contains("/help")) {
			log.info("Help page is opened");
			log.info("TEST CASE OM_TC_GS_015 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_015 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_GS_016() {
		log.info("TEST CASE OM_TC_GS_016 IS RUNNING");
		util.hold(3);
//		Check link direction, if user click on get support link from "FAQ" page then it redirects to the Help section in same tab.
		util.clickOnFAQ();
		log.info("clicked on FAQ");
		util.hold(2);
		util.actionClick(getSupportLink);
		log.info("clicked on get support link");
		if (util.getPageURL().contains("/help")) {
			log.info("Help page is opened");
			log.info("TEST CASE OM_TC_GS_016 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_016 is failed");
			Assert.assertTrue(false);
		}

	}

	public void OM_TC_GS_003() {
//		Check link direction, if user click on get support link from "Sign In" page then Help section is open in same tab or in new tab.
		log.info("TEST CASE OM_TC_GS_003 IS RUNNING");
		util.logout();
		log.info("clicked on logout");
		util.hold(2);
		util.clickOnGetSupport();
		log.info("clicked on get support link");
		util.hold(3);
		util.getWindoHandleByUrl(util.getSupportPageUrl());

		log.info("switched to help page");
		if (util.getPageURL().contains("/support/home")) {
			log.info("Help page is opened in new window");
			log.info("TEST CASE OM_TC_GS_003 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_003 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_GS_004() {
		log.info("TEST CASE OM_TC_GS_004 IS RUNNING");
//		Verify after clicking on Get support link from "Sign In" ,the page content only Help and FAQ section and no other section are visible in this page.
		if ((util.isElementDisplyed(helpInNavBar)) && (util.isElementDisplyed(FAQInNavBar))) {
			log.info("Help and FAQ is displayed");
			log.info("TEST CASE OM_TC_GS_004 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_004 is failed");
			Assert.assertTrue(false);
		}

		util.getWindoHandleByUrl("https://testing.cedcommerce.bwpapps.com/auth/login");

	}

	public void OM_TC_GS_005() {
		log.info("TEST CASE OM_TC_GS_005 IS RUNNING");
//		Check link direction, if user click on get support link from "Forgot Password" page then Help section is open in same tab or in new tab.
		util.click(forgotPasswordLink);
		log.info("clicked on forgot password link");
		util.click(getSupportLink);
		log.info("clicked on get support link");
		util.getWindoHandleByUrl(util.helpPageUrl());
		log.info("switched to help page");
		if (util.getPageURL().contains("/help")) {
			log.info("Help page is opened in new window");
			log.info("TEST CASE OM_TC_GS_005 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_005 is failed");
			Assert.assertTrue(false);
		}
	}

	public void OM_TC_GS_006() {
		log.info("TEST CASE OM_TC_GS_006 IS RUNNING");
//		Verify after clicking on Get support link from "Forgot Password" ,the page content only Help and FAQ section and no other section are visible in this page.
		if ((util.isElementDisplyed(helpInNavBar)) && (util.isElementDisplyed(FAQInNavBar))) {
			log.info("Help and FAQ is displayed");
			log.info("TEST CASE OM_TC_GS_006 IS passed");
			Assert.assertTrue(true);
		} else {
			log.error("OM_TC_GS_006 is failed");
			Assert.assertTrue(false);
		}

		util.getWindoHandleByUrl("https://testing.cedcommerce.bwpapps.com/auth/forgot");

	}

//	public void OM_TC_MU_001() {
//		Check that after clicking on Mail Us button user redirected to the Gmail 
//		util.click(mailUsButton);
//		util.getWindoHandleByUrl("");
//		if(util.getPageURL().equals("")) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
//		
//	}

}
