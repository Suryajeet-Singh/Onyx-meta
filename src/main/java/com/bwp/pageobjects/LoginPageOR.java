package com.bwp.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageOR {

	@FindBy(xpath = "//input[@placeholder='ex: abc@gmail.com']")
	WebElement emailInputField;

	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	WebElement passwordInputField;

	@FindBy(xpath = "//span[@class='inte-form__innericSuffix']")
	WebElement showHidePassword;

	@FindBy(id = "login-forgotPassword")
	WebElement forgotPasswordLinkText;

	@FindBy(id = "login-submitData")
	WebElement logInButton;

	@FindBy(id = "footer-support")
	WebElement getSupportLinkText;

	@FindBy(xpath = "//span[contains(text(),'Please enter a valid email')]")
	WebElement invalidEmailErrorMessage;

	@FindBy(xpath = "//p[normalize-space()='Invalid email or password']")
	WebElement loginErrorMessage;

	@FindBy(xpath = "//p[contains(text(),'Your ip has been banned. please contact administra')]")
	WebElement BannedIPErrorMessage;

	@FindBy(xpath = "//p[normalize-space()='No user found with this email.']")
	WebElement noUserFoundErrorMessage;

	@FindBy(xpath = "//span[normalize-space()='Generate password reset link']")
	WebElement genratePasswordLinkButton;

	@FindBy(xpath = "//div[@class='inte-Alert__text']/h3[text()='Reset password link generated!']")
	WebElement passwordLinkGeneratedSuccessfullyMessage;

	@FindBy(id = "userEmail")
	WebElement emailInputFieldForgotPwdPage;

	@FindBy(id="generate-link")
	WebElement generateLinkButton;

	@FindBy(id="back-to-login")
	WebElement backToLoginPageButton;

	@FindBy(xpath = "//h3[text() = 'Reset password link generated!']")
	WebElement resetPwdLinkGeneratedSuccesfullyText;

	@FindBy(xpath = "//div[@class='inte-Alert inte-Alert--success ']")
	WebElement passwordLinkGeneratedSucceussBox;

}
