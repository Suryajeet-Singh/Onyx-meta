package com.bwp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductionPageOR {

	@FindBy(id = "form-input-email")
	WebElement emailInpField;

	@FindBy(id = "form-input-password")
	WebElement passwordInpField;

	@FindBy(id = "login-submit")
	WebElement submitBtn;

	@FindBy(className = "css-34iy07")
	WebElement keepMeSignedInCheckbox;

	@FindBy(className = "css-15x1myb")
	WebElement conditionOfUse;

	@FindBy(className = "css-y7qg26-noWrapStyle")
	WebElement privacyNotice;

	@FindBy(className = "css-jfxk2m")
	WebElement forgotPassword;

	@FindBy(className = "css-h2ov0d")
	WebElement signUpBtn;

	@FindBy(className = "css-1qorrvl")
	WebElement setUpLaterBtn;
																																																								 
	@FindBy(className = "css-6tiod0")
	WebElement okBtnWelcomeBanner;
	
	@FindBy(id = "modal-24-header")
	WebElement headerWelcomeMsg;

	@FindBy(id = "side-menu-link-14-label")
	WebElement marketPlaceNavBar;

	@FindBy(xpath = "//h2[text() = 'Social Ads for Buy with Prime']")
	WebElement cedAppBWP;
	
	@FindBy(className = "css-1lno6zt")
	WebElement goToCedCommerceBtn;
	
	@FindBy(className = "auth_page_title")
	WebElement bwpHeadingLoginPage;

	@FindBy(className = "css-1bxf732-RemoveModal")
	WebElement removeAppBtn;
	
	@FindBy(xpath = "//button[@data-testid = 'removeModal-remove-button']")
	WebElement confirmRemoveAppBtn;
	
	@FindBy(id = "toast-message-title")
	WebElement appRemovedMsg;
	
	@FindBy(xpath = "//a[@data-testid = 'install-app-button']")
	WebElement installAppBtn;
	
	@FindBy(id = "app-layout-content-1")
	WebElement socialAdsBwpHeading;
	
	@FindBy(className = "css-ndncpy")
	WebElement authorizeBtn;
	
	@FindBy(id = "modal-6-header")
	WebElement modalPostAddApp;

}
