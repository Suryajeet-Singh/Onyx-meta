package com.bwp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePageOR {
	
	@FindBy(xpath = "(//div[@class='custom-notify']//button)[2]")
	WebElement avatarIcon;
	
	@FindBy(xpath = "//div[@class = 'inte__Popover-Wrapper popover-bottom']")
	WebElement avatarGrid;
	
	@FindBy(xpath = "//span[text() = 'Settings']/parent::button")
	WebElement settingsButtonAvatarGrid;
	
	@FindBy(xpath = "//span[text() = 'Log out']/parent::button")
	WebElement logoutButtonAvatarGrid;


	@FindBy(xpath = "//h3[text()='Session Expired']")
	WebElement sessionExpired;
}
