package com.bwp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingPageObjects {

	@FindBy(id = "brand")
	WebElement brandName;

	@FindBy(id="email")
	WebElement emailInputField;

	@FindBy(id="createPassword")
	WebElement passwordInputField;

	@FindBy(xpath = "//span[@class='inte-form__innericSuffix']")
	WebElement showHidePassword;

	@FindBy(id="confirmPassword")
	WebElement confirmPasswordInputField;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement acceptTermsConditionsCheckBox;

	@FindBy(id="policy-link")
	WebElement readPoliciesLinkText;

	@FindBy(id="create-account")
	WebElement createAccountButton;
	
	@FindBy(id="footer-support")
	WebElement getSupport;

	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement loginLinkText;

	@FindBy(xpath = "//span[contains(text(),'Maximum character limit is 100.')]")
	WebElement maxCharacterLimitMessage;

	@FindBy(xpath = "//p[normalize-space()='Email already exists.']")
	WebElement errorMessage;

	@FindBy(xpath = "//span[contains(text(),'Invalid Email!')]")
	WebElement invalidEmailMessage;

	@FindBy(xpath = "//span[text() = 'Passwords do not match!']")
	WebElement passwordNotMatchingErrorMsg;

	@FindBy(xpath = "//div[contains(@class,'inte__PasswordStrenth--StatusPoor inte__PasswordStrenth--Status')]")
	WebElement weakPasswordStrengthBar;

	@FindBy(xpath = "//div[contains(@class,'inte__PasswordStrenth--StatusWeak inte__PasswordStrenth--Status')]")
	WebElement mediumPasswordStrengthBar;

	@FindBy(xpath = "//div[contains(@class,'inte__PasswordStrenth--StatusStrong inte__PasswordStrenth--Status')]")
	WebElement strongPasswordStrengthBar;

	@FindBy(xpath = "//div[@class = 'inte-Modal-Dialog__Modal inte-Modal-Dialog--Small']")
	WebElement otpModal;

	@FindBy(xpath = "//input[@id = 'first']")
	WebElement firstInputInOTPModal;

	@FindBy(xpath = "//input[@id = 'second']")
	WebElement secondInputInOTPModal;

	@FindBy(xpath = "//input[@id = 'third']")
	WebElement thirdInputInOTPModal;

	@FindBy(xpath = "//input[@id = 'fourth']")
	WebElement fourthInputInOTPModal;

	@FindBy(xpath = "//input[@id = 'fifth']")
	WebElement fifthInputInOTPModal;

	@FindBy(id="authorize-connect")
	WebElement authorizedAndConnectButton;

	@FindBy(xpath = "(//span[contains(text(),'Continue as')])[2]")
	WebElement contiuneAsUserNameButton;

	@FindBy(xpath = "//div[@aria-label = 'Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//span[text() = 'Log in to another account.']")
	WebElement loginToAnotherAccount;

	@FindBy(xpath = "//div[@aria-label = 'Continue']")
	WebElement continueBtnConnectToCedcommerce;

	@FindBy(xpath = "//span[text() = 'Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//form[@id = 'platformDialogForm']")
	WebElement selectYourAdAccountForm;

	@FindBy(xpath = "//div[@data-visualcompletion = 'ignore-dynamic']")
	List<WebElement> allAdAccounts;

	@FindBy(xpath = "//div[text() = 'Not eligible']")
	WebElement notEligibleAccount;

	@FindBy(xpath = "//div[@aria-label = 'Next']")
	WebElement nextButtonOnCedcommerceAllowedToPage;

	@FindBy(xpath = "//div[@aria-label = 'Back']")
	WebElement backButtonOnCedcommerceAllowedToPage;

	@FindBy(xpath = "//div[@aria-label = 'Cancel']")
	WebElement cancelButtonOnCedcommerceAllowedToPage;

	@FindBy(xpath = "//div[@aria-label = 'Done']")
	WebElement doneButtonYouAreAllSetPage;

	@FindBy(xpath = "//div[@class='inte-toast--Wrapper']")
	WebElement toastMsg;

	@FindBy(id = "email")
	WebElement fbLoginInputField;

	@FindBy(id = "pass")
	WebElement fbPasswordInputField;

	@FindBy(id = "loginbutton")
	WebElement fbLoginButton;

}
