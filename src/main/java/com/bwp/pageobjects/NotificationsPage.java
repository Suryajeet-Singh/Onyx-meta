package com.bwp.pageobjects;

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
 * Date of change: December 15, 2022 
 * Version: 0.0 
 * changed function: All functions
 * change description: Added code to get data from .json file. 
 * Modified By: Yatindra Kinker
 */
public class NotificationsPage extends NotificationsPageOR {

	Utilities util;

	public NotificationsPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

//	Check whether user will able to view notification from Bell Icon.
	public void OM_TC_LPN_001() {
		util.click(notificationsIcon);
		if (util.isElementDisplyed(notificationGrid) && util.getSize(allNotifications) == 3) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

//	Check whether clicking over the notification icon on all sections
	public void OM_TC_LPN_002() {
		util.clickOnDashboard();
		util.click(notificationsIcon);
		if (util.isElementDisplyed(notificationGrid) && util.getSize(allNotifications) == 3) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		util.clickOnFAQ();
		util.click(notificationsIcon);
		if (util.isElementDisplyed(notificationGrid) && util.getSize(allNotifications) == 3) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		util.clickOnHelp();
		util.click(notificationsIcon);
		if (util.isElementDisplyed(notificationGrid) && util.getSize(allNotifications) == 3) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		util.clickOnProductList();
		util.click(notificationsIcon);
		if (util.isElementDisplyed(notificationGrid) && util.getSize(allNotifications) == 3) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		util.clickOnSettings();
		util.click(notificationsIcon);
		if (util.isElementDisplyed(notificationGrid) && util.getSize(allNotifications) == 3) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

//	Check whether clicking on "View all notification" icon is open a notification page in which recent notifications arrived as the top of the page.
//	Check notification on each page has a fix count number of notifications(max :3 notification)

	public void OM_TC_NP_002_006() {
		
		if (!util.isElementDisplyed(notificationGrid)) {
			util.click(notificationsIcon);
			util.click(viewAllNotifications);
			if (util.isElementDisplyed(notificationsPageHeading)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		util.click(viewAllNotifications);
		if (util.isElementDisplyed(notificationsPageHeading)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

//	Check whether time/date stamp on notifications.

	public void OM_TC_NP_006() {
		
		for (WebElement date : dates) {
			
			if (util.isElementDisplyed(date)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
	}

}
