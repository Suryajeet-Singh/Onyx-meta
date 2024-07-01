package com.bwp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPageOR {

	@FindBy(xpath = "//span[normalize-space()='Settings']")
	WebElement settings;

	@FindBy(xpath = "//h1[normalize-space()='Settings']")
	WebElement settingsPageHeading;

	@FindBy(xpath = "//li[@id='Account']")
	WebElement account;

	@FindBy(xpath = "//h3[normalize-space()='Accounts']")
	WebElement accountHeading;

	@FindBy(xpath = "//div[@class = 'inte-card inte-card--bordered  ']")
	WebElement accountsCard;

	@FindBy(xpath = "//p[text()= 'Facebook / Instagram Accounts']")
	WebElement fbInstaAccountHeading;

	@FindBy(id = "account-update-btn")
	WebElement updateButton;

	@FindBy(xpath = "//span[normalize-space()='Active Account']")
	WebElement activeAccount;

	@FindBy(id = "account-connect-new")
	WebElement connectNewAccount;

	@FindBy(xpath = "//li[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//h3[normalize-space()='Current Password']")
	WebElement currentPassword;

	@FindBy(id = "reset-oldPassword")
	WebElement currentPasswordInputField;

	@FindBy(xpath = "//span[contains(@class,'inte-form__innericSuffix')]")
	List<WebElement> showHideButton;

	@FindBy(id = "reset-newPassword")
	WebElement newPasswordInputField;

	@FindBy(id = "reset-confirmPassword")
	WebElement confirmPasswordInputField;

	@FindBy(xpath = "//span[contains(text(),'Passwords do not match!')]")
	WebElement passwordDoesNotMatchErrorMsg;

	@FindBy(id = "reset-btn")
	WebElement resetPasswordButton;

	@FindBy(id = "General")
	WebElement general;

	@FindBy(xpath = "//h3[normalize-space()='General Details']")
	WebElement generalDetailsHeading;

	@FindBy(xpath = "//p[normalize-space()='Store URL']")
	WebElement storeURL;

	@FindBy(xpath = "//p[normalize-space()='Store URL']/parent::div/following-sibling::div/p")
	WebElement storeURLValue;

	@FindBy(xpath = "//p[normalize-space()='Email']")
	WebElement emailHeading;

	@FindBy(xpath = "//p[normalize-space()='Email']/parent::div/following-sibling::div/p")
	WebElement emailHeadingValue;

	@FindBy(xpath = "//p[text() = 'Pixel ID']")
	WebElement pixelIDHeading;

	@FindBy(xpath = "//p[normalize-space()='Pixel ID']/parent::div/following-sibling::div/div/h3")
	WebElement pixelIDHeadingValue;

	@FindBy(xpath = "//span[@class='inte__Select--Selected']")
	WebElement pixelSelector;

	@FindBy(xpath = "//ul[@aria-label='inte-select-options']")
	WebElement allPixelsContainer;

	@FindBy(xpath = "//ul[@class = 'inte-select-options']/li")
	List<WebElement> allPixelId;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement cancelButtonOfEditModal;

	@FindBy(xpath = "//span[normalize-space()='Save Changes']")
	WebElement saveChangesButtonOfEditModal;

	@FindBy(id = "account-edit-btn")
	WebElement pixelIDEditButton;

	@FindBy(xpath = "//h3[normalize-space()='Edit Pixel']")
	WebElement EditModalHeading;

	@FindBy(xpath = "//h3/parent::div/following-sibling::button")
	WebElement EditModalCrossButton;

	@FindBy(xpath = "//p[normalize-space()='Organization / Brand Name']")
	WebElement brandNameHeading;

	@FindBy(xpath = "//p[normalize-space()='Store / Brand Name']/parent::div/following-sibling::div/div/p")
	WebElement brandNameHeadingValue;

	@FindBy(xpath = "//span[contains(text(),'Edit')]/parent::button")
	WebElement brandNameEditButton;

	@FindBy(id="add-new-store")
	WebElement editBrandNameInputField;

	@FindBy(xpath = "//span[contains(text(),'Maximum character limit is 100.')]")
	WebElement brandNameWordLimitErrorMsg;

	@FindBy(xpath = "//span[text() = 'Passwords do not match!']")
	WebElement oldPassNotMatchedErrMsg;

	@FindBy(xpath = "//button[@class = 'inte-btn inte-btn-disable inte-btn--Primary  inte-btn--distributionCenter  inte-btnNarrow  ']")
	WebElement resetPasswordDisabled;

	@FindBy(xpath = "//div[@class = 'inte__PasswordStrenth--StatusPoor inte__PasswordStrenth--Status']")
	WebElement weakPasswordStrengthBar;

	@FindBy(xpath = "//div[contains(@class,'inte__PasswordStrenth--StatusWeak inte__PasswordStrenth--Status')]")
	WebElement mediumPasswordStrengthBar;

	@FindBy(xpath = "//div[contains(@class,'inte__PasswordStrenth--StatusStrong inte__PasswordStrenth--Status')]")
	WebElement strongPasswordStrengthBar;

	@FindBy(xpath = "//div[@class='inte-toast--Wrapper']//p[normalize-space()='Old Password not matched']")
	WebElement oldPasswordNotMatchedErrorMsg;

	@FindBy(xpath = "//p[normalize-space()='Password updated successfully']")
	WebElement passwordUpdatedSuccessfullyMsg;
	
	@FindBy(xpath = "//h3[normalize-space()='A minimum of 8 characters']/ancestor::div[@class = 'checkIconAlign active']")
	WebElement passwordContainsEightChars;
	
	@FindBy(xpath = "//h3[normalize-space()='A minimum of 8 characters']/ancestor::div[@class = 'checkIconAlign false']")
	WebElement passwordDoesNotContainsEightChars;
	
	@FindBy(xpath = "//h3[normalize-space()='An uppercase']/ancestor::div[@class = 'checkIconAlign false']")
	WebElement passwordDoesNotContainsUpperCaseChar;
	
	@FindBy(xpath = "//h3[normalize-space()='An uppercase']/ancestor::div[@class = 'checkIconAlign active']")
	WebElement passwordContainsUpperCaseChar;
	
	@FindBy(xpath = "//h3[normalize-space()='A lowercase letter']/ancestor::div[@class = 'checkIconAlign active']")
	WebElement passwordContainsLowerCaseChar;
	
	@FindBy(xpath = "//h3[normalize-space()='A lowercase letter']/ancestor::div[@class = 'checkIconAlign false']")
	WebElement passwordDoesNotContainsLowerCaseChar;
	
	@FindBy(xpath = "//h3[normalize-space()='One special character']/ancestor::div[@class = 'checkIconAlign active']")
	WebElement passwordContainsSpecialChar;
	
	@FindBy(xpath = "//h3[normalize-space()='One special character']/ancestor::div[@class = 'checkIconAlign false']")
	WebElement passwordDoesNotContainsSpecialChar;
	
	@FindBy(xpath = "//h3[normalize-space()='A number']/ancestor::div[@class = 'checkIconAlign active']")
	WebElement passwordContainsNumbers;
	
	@FindBy(xpath = "//h3[normalize-space()='A number']/ancestor::div[@class = 'checkIconAlign false']")
	WebElement passwordDoesNotContainsNumbers;

	@FindBy(name = "q")
	WebElement googleSearchInputfield;

}
