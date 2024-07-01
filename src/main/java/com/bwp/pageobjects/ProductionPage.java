package com.bwp.pageobjects;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bwp.resources.Utilities;

public class ProductionPage extends ProductionPageOR {

	Utilities util;

	public ProductionPage(Utilities util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

	public void onboardingMarketPlace() {
		String currentPageUrl = util.getDriver().getCurrentUrl();
		util.enterValue(emailInpField, util.getProperty("market_email"));
		util.enterValue(passwordInpField, util.getProperty("market_pass"));
		util.click(submitBtn);
		util.hold(2);
		util.waitUntilElementIsVisible(setUpLaterBtn);
		util.click(setUpLaterBtn);
//		util.waitUntilElementIsVisible(headerWelcomeMsg);
		util.hold(2);
		util.click(okBtnWelcomeBanner);

		try {
			util.hold(3);
			util.click(removeAppBtn);
			util.hold(2);
			util.click(confirmRemoveAppBtn);
			util.waitUntilElementIsInvisible(appRemovedMsg);
			util.hold(2);
			util.click(installAppBtn);
			util.hold(2);
			util.goToChildWindow();
			util.waitUntilElementIsVisible(socialAdsBwpHeading);
			new WebDriverWait(util.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(authorizeBtn));
			util.click(authorizeBtn);
			util.waitUntilElementIsInvisible(modalPostAddApp);
		} catch (NoSuchElementException e) {
			util.click(installAppBtn);
			util.hold(2);
			util.goToChildWindow();
			util.hold(2);
			util.waitUntilElementIsVisible(socialAdsBwpHeading);
			util.hold(2);
			util.click(authorizeBtn);
			util.waitUntilElementIsInvisible(modalPostAddApp);
		}
	}

	public void loginMarketPlace() {
		String currentPageUrl = util.getDriver().getCurrentUrl();
		util.enterValue(emailInpField, util.getProperty("market_email"));
		util.enterValue(passwordInpField, util.getProperty("market_pass"));
		util.click(submitBtn);
		util.hold(2);
		util.waitUntilElementIsVisible(setUpLaterBtn);
		util.click(setUpLaterBtn);
		util.waitUntilElementIsVisible(headerWelcomeMsg);
		util.hold(2);
		util.click(okBtnWelcomeBanner);
		util.hold(3);
		util.click(goToCedCommerceBtn);
		util.hold(2);
		util.goToChildWindow();
		util.waitUntilElementIsVisible(bwpHeadingLoginPage);
	}
}
