package com.bwp.resources;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.bwp.pageobjects.LoginPage;
import com.bwp.pageobjects.ProductionPage;

public class BaseClass {

	protected Utilities util = Utilities.getObject();

	protected Properties prop;
	private String server = "server";
	private String onboarding = "onboarding";
	private String falseVal = "false";
	private String trueVal = "true";
	private String production = "production";
	private String testing = "testing";
	private String staging = "staging";

	@DataProvider
	public Object[][] getLoginData() throws IOException {
		List<HashMap<String, String>> data = util.getJsonDataToHashmap("LoginData");
		return new Object[][] { { data.get(0) } };
	}

	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void launchingMethod(@Optional String browser) {

		if (util.getProperty("headless").equalsIgnoreCase(trueVal)) {
			launchInHeadless(browser);
			
		}
		else if ((util.getProperty(server).equalsIgnoreCase(production))
				&& (util.getProperty(onboarding).equalsIgnoreCase(falseVal))) {
			util.openLoginPage(util, browser, util.getProperty("productionUrlLogin"));
			login();

		} else if ((util.getProperty(server).equalsIgnoreCase(production))
				&& (util.getProperty(onboarding).equalsIgnoreCase(trueVal))) {

			util.openLoginPage(util, browser, util.getProperty("productionUrl"));
			addApp();

		} else if ((util.getProperty(server).equalsIgnoreCase(staging))
				&& (util.getProperty(onboarding).equalsIgnoreCase(trueVal))) {

			util.openLoginPage(util, browser, util.getProperty("stagingUrl"));
			addApp();

		} else if ((util.getProperty(server).equalsIgnoreCase(staging))
				&& (util.getProperty(onboarding).equalsIgnoreCase(falseVal))) {

			util.openLoginPage(util, browser, util.getProperty("stagingUrlLogin"));
			login();

		} else if ((util.getProperty(server).equalsIgnoreCase(testing))
				&& (util.getProperty(onboarding).equalsIgnoreCase(falseVal))) {

			util.openLoginPage(util, browser, util.getProperty("testingUrl"));
			login();

		} else if ((util.getProperty(server).equalsIgnoreCase(testing))
				&& (util.getProperty(onboarding).equalsIgnoreCase(trueVal))) {

			util.openLoginPage(util, browser, util.getProperty("BaseUrlOnborading"));
		}

	}

	public void launchInHeadless(String browser) {

		if ((util.getProperty(server).equalsIgnoreCase(production))
				&& (util.getProperty(onboarding).equalsIgnoreCase(falseVal))) {
			util.openLoginPageInHeadless(util, browser, util.getProperty("productionUrlLogin"));
			login();

		} else if ((util.getProperty(server).equalsIgnoreCase(production))
				&& (util.getProperty(onboarding).equalsIgnoreCase(trueVal))) {

			util.openLoginPageInHeadless(util, browser, util.getProperty("productionUrl"));
			addApp();

		} else if ((util.getProperty(server).equalsIgnoreCase(staging))
				&& (util.getProperty(onboarding).equalsIgnoreCase(trueVal))) {

			util.openLoginPageInHeadless(util, browser, util.getProperty("stagingUrl"));
			addApp();

		} else if ((util.getProperty(server).equalsIgnoreCase(staging))
				&& (util.getProperty(onboarding).equalsIgnoreCase(falseVal))) {

			util.openLoginPageInHeadless(util, browser, util.getProperty("stagingUrlLogin"));
			login();

		} else if ((util.getProperty(server).equalsIgnoreCase(testing))
				&& (util.getProperty(onboarding).equalsIgnoreCase(falseVal))) {

			util.openLoginPageInHeadless(util, browser, util.getProperty("testingUrl"));
			login();

		} else if ((util.getProperty(server).equalsIgnoreCase(testing))
				&& (util.getProperty(onboarding).equalsIgnoreCase(trueVal))) {

			util.openLoginPageInHeadless(util, browser, util.getProperty("BaseUrlOnborading"));
		}
	}

	public void addAppLogin() {
		ProductionPage pp = new ProductionPage(util);
		pp.loginMarketPlace();
	}

	public void login() {
		LoginPage lp = new LoginPage(util);
		lp.loginToApp();
	}

	public void addApp() {
		ProductionPage pp = new ProductionPage(util);
		pp.onboardingMarketPlace();
	}

	@AfterClass
	public void tearDown() {
		util.getDriver().quit();
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) util.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/Reports/" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
