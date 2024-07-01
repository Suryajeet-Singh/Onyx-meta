package com.bwp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationsPageOR {
	
	@FindBy(xpath = "(//button[contains(@class,'inte-btn--onlyIcon')])[1]")
	WebElement notificationsIcon;
	
	@FindBy(className = "custom-notification-lists")
	WebElement notificationGrid;
	
	@FindBy(xpath = "//div[@class = 'custom-notification-lists']/div")
	List<WebElement> allNotifications;
	
	@FindBy(xpath = "//div[@class = 'more_notification']//span[@class = 'inte-btn__icon ']")
	WebElement moreNotificationsArrowIcon;
	
	@FindBy(xpath = "//span[text() = 'View all Notifications']")
	WebElement viewAllNotifications;
	
	@FindBy(xpath = "//h1[text() = 'Notifications']")
	WebElement notificationsPageHeading;
	
	@FindBy(xpath = "//span[text() = 'Click here to check the error and troubleshoot.']")
	WebElement errorAndTroubleshootLink;
	
	@FindBy(xpath = "//div[@class = 'inte-notification__text']//p[contains(@class,'Paragraph  inte__text--light')]")
	List<WebElement> dates;
}
