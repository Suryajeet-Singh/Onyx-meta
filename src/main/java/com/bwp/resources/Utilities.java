package com.bwp.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utilities {
	private static Logger log = LogManager.getLogger(Utilities.class.getName());
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private static Utilities util;
	private Actions action;
	private Workbook workbook;
	private Properties prop;
	private Sheet sheetObj;
	private String parentWindow;
	private String childWindow;
	private String chrome = "chrome";
	private String firefox = "firefox";
	private String safari = "safari";
	private String edge = "edge";

	private Utilities() {

	}

	public static Utilities getObject() {
		if (util == null) {
			util = new Utilities();
		}
		return util;
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void launchBrowser(String browserName) {

		if (browserName == null || browserName.equalsIgnoreCase(chrome)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setAcceptInsecureCerts(true);
			driver.set(new ChromeDriver(options));
		} else if (browserName.equalsIgnoreCase(firefox)) {
			FirefoxOptions options = new FirefoxOptions();
			driver.set(new FirefoxDriver(options));
		} else if (browserName.equalsIgnoreCase(safari)) {
			SafariOptions options = new SafariOptions();
			driver.set(new SafariDriver(options));
		} else if (browserName.equalsIgnoreCase(edge)) {
			EdgeOptions options = new EdgeOptions();
			driver.set(new EdgeDriver(options));
		}

		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void launchBrowserInHeadless(String browserName) {

		if (browserName == null || browserName.equalsIgnoreCase(chrome)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--headless=new");
			options.setAcceptInsecureCerts(true);
			driver.set(new ChromeDriver(options));
		} else if (browserName.equalsIgnoreCase(firefox)) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("-headless");
			driver.set(new FirefoxDriver(options));
		} else if (browserName.equalsIgnoreCase(safari)) {
			SafariOptions options = new SafariOptions();
			driver.set(new SafariDriver(options));
		} else if (browserName.equalsIgnoreCase(edge)) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless=new");
			driver.set(new EdgeDriver(options));
		}
		driver.get().manage().window().setSize(new Dimension(1920, 1080));
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void openUrl(String url) {
		driver.get().get(url);
	}

	public void openLoginPage(Utilities util, String browserName, String url) {
		util.launchBrowser(browserName);
		util.openUrl(url);

	}

	public void openLoginPageInHeadless(Utilities util, String browserName, String url) {
		util.launchBrowserInHeadless(browserName);
		util.openUrl(url);

	}

	public void enterValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(value);
	}

	public void enterSingleValue(WebElement element, char value) {
		element.clear();
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(String.valueOf(value));
	}

	public void pressEnter() {
		action = new Actions(getDriver());
		action.keyUp(Keys.ENTER).build().perform();
		action.keyDown(Keys.ENTER).build().perform();
	}

	public void pressTab() {
		action = new Actions(getDriver());
		action.keyUp(Keys.TAB).build().perform();
		action.keyDown(Keys.TAB).build().perform();
	}

	public void pressEscape() {
		action = new Actions(getDriver());
		action.keyUp(Keys.ESCAPE).build().perform();
		action.keyDown(Keys.ESCAPE).build().perform();
	}

	public void click(WebElement element) {
		try {
			element.click();
		} catch (InvalidElementStateException e) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			jsExecutor.executeScript("arguments[0].click();", element);

		}

	}

	public void clickOnDashboard() {
		getDriver().findElement(By.xpath("//span[normalize-space()='Dashboard']")).click();
	}

	public void clickOnProductList() {
		getDriver().findElement(By.xpath("//span[normalize-space()='Product List']")).click();
	}

	public void clickOnSettings() {
		getDriver().findElement(By.xpath("//span[normalize-space()='Settings']")).click();
	}

	public void clickOnHelp() {
		getDriver().findElement(By.xpath("//span[normalize-space()='Help']")).click();
	}

	public void clickOnFAQ() {
		getDriver().findElement(By.xpath("//span[normalize-space()='FAQ']")).click();
	}

	public void clickOnGetSupport() {
		getDriver().findElement(By.xpath("//button/span[text()='Get Support']"));
	}

	public void actionClick(WebElement element) {
		action = new Actions(getDriver());
		action.click(element).build().perform();

	}

	public void scrollToBottom() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToTop() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public void jsClick(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		jsExecutor.executeAsyncScript("arguments[0].click();", element);
	}

	public String extractValueByAttributes(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	public String getTagValue(WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplyed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementVisible(WebElement element) {

		if ((getTagValue(element).length()) > 0) {
			return true;
		}
		return false;
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public void getWindoHandleByUrl(String expURLvalue) {
		Set<String> allWindowValue = getDriver().getWindowHandles();
		for (String AllValue : allWindowValue) {
			getDriver().switchTo().window(AllValue);
			String getTitleValue = getDriver().getCurrentUrl();
			if (getTitleValue.contains(expURLvalue)) {
				break;
			}
		}
	}

	public void getWindoHandleByTitle(String expTitlevalue, String msg) {
		Set<String> allWindowValue = getDriver().getWindowHandles();
		for (String AllValue : allWindowValue) {
			getDriver().switchTo().window(AllValue);
			String getTitleValue = getDriver().getTitle();
			if (getTitleValue.contains(expTitlevalue)) {
				break;
			}
		}
		log.info(msg);
	}

	public void goToChildWindow() {
		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> itr = windows.iterator();
		parentWindow = itr.next();
		childWindow = itr.next();
		getDriver().switchTo().window(childWindow);
	}

	public void goToParentWindow() {
		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> itr = windows.iterator();
		parentWindow = itr.next();
		childWindow = itr.next();
		getDriver().switchTo().window(parentWindow);
	}

	public String getPageURL() {
		return getDriver().getCurrentUrl();
	}

	public String getPageTitle() {
		return getDriver().getTitle();
	}

	public String dashBoardURL() {
		return "https://testing.cedcommerce.bwpapps.com/panel/634f7d5402a60683f40f9e48/dashboard";
	}

	public String faqPageURL() {
		return "https://testing.cedcommerce.bwpapps.com/panel/637cd7fce8364d947c0c35d7/faq";
	}

	public boolean clickOnEachElementOfList(List<WebElement> elementList, WebElement elementToBeDisplayed) {
		for (WebElement element : elementList) {
			element.click();
			return isElementDisplyed(elementToBeDisplayed);
		}
		return false;
	}

	public void failIfTimeIsExceed(List<WebElement> allQuerySugesstion, int seconds) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
				.until(ExpectedConditions.visibilityOfAllElements(allQuerySugesstion));
	}

	public void failIfTimeIsExceed(WebElement element, int seconds) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementIsVisible(WebElement element) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementIsInvisible(WebElement element) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(element));

	}

	public void hold(int seconds) {
		seconds *= 1000;
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void refreshPage() {
		getDriver().navigate().refresh();
	}

	public void copy(WebElement element) {

		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.CONTROL + "c");

	}

	public void paste(WebElement element) {
		action = new Actions(getDriver());
		element.sendKeys(Keys.CONTROL + "a");

		element.sendKeys(Keys.CONTROL + "v");

	}

	public boolean isPasswordHave8Characters(String password) {

		if (password.length() > 7) {
			return true;
		}
		return false;
	}

	public void selectFromList(List<WebElement> listOfElements, String value) {
		for (WebElement element : listOfElements) {
			if (element.getText().equals(value)) {
				element.click();
				break;
			}
		}
	}

	public boolean selectedInterest(List<WebElement> listOfElements, String interestValue) {
		for (WebElement interest : listOfElements) {
			return interest.getText().equalsIgnoreCase(interestValue);
		}
		return false;
	}

	public void selectFromListByAttribute(List<WebElement> listOfElements, String attribute, String position) {
		for (WebElement element : listOfElements) {
			if (element.getAttribute(attribute).equalsIgnoreCase(element + position)) {
				element.click();
				break;
			}
		}
	}

	public int getSize(List<WebElement> list) {
		return list.size();
	}

	public String loginPageUrl() {
		return "https://testing.cedcommerce.bwpapps.com/auth/login";
	}

	public void goBack() {
		Actions action = new Actions(getDriver());
		action.keyDown(Keys.ALT);
		action.keyDown(Keys.ARROW_LEFT);
		action.keyUp(Keys.ARROW_LEFT);
		action.keyUp(Keys.ALT);

	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(getDriver());
		action.moveToElement(element).build().perform();
	}

	public String dashboardURL() {
		return "https://testing.cedcommerce.bwpapps.com/panel/637cd7fce8364d947c0c35d7/dashboard";
	}

	public String getProperty(String key) {
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/bwp/resources/config.Properties");
		} catch (Exception e) {

		}

		try {
			prop.load(fis);
		} catch (Exception e) {

		}

		return prop.getProperty(key);
	}

	public void logout() {
		getDriver().findElement(By.xpath("//span[text() = 'Logout']")).click();
		getDriver().findElement(By.xpath("//span[text() = 'Log Out']")).click();
	}

	public String getToday() {
		Date currentDate = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");

		String todaysDate = simpleDateFormat.format(currentDate);

		simpleDateFormat = new SimpleDateFormat("MMM");

		String todaysMonthName = simpleDateFormat.format(currentDate);

		simpleDateFormat = new SimpleDateFormat("MM");

		String todaysMonth = simpleDateFormat.format(currentDate);

		simpleDateFormat = new SimpleDateFormat("YYYY");

		String todaysYear = simpleDateFormat.format(currentDate);

		simpleDateFormat = new SimpleDateFormat("dd");

		String todays2DigitDate = simpleDateFormat.format(currentDate);

		String dateInFormat = todaysMonth + "/" + todays2DigitDate + "/" + todaysYear;

		return dateInFormat;

	}

	public String getTodaysDate() {

		Date currentDate = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");

		String todaysDate = simpleDateFormat.format(currentDate);
		return todaysDate;
	}

	public String getCurrentMonth() {

		Date currentDate = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");

		String todaysMonth = simpleDateFormat.format(currentDate);

		return todaysMonth;
	}

	public String getCurrentYear() {

		Date currentDate = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");

		String todaysYear = simpleDateFormat.format(currentDate);

		return todaysYear;
	}

	public String extractWordAfterACharacter(String str, String character, int position) {
		String arr[] = str.split(character);
		return arr[position];

	}

	public void inpuData(WebElement webEle, String inputvalue) {

		try {
			webEle.clear();
			webEle.sendKeys(inputvalue);
		} catch (StaleElementReferenceException e) {
			webEle.clear();
			webEle.sendKeys(inputvalue);
		} catch (ElementNotInteractableException e) {

		}
	}

	public String[][] readCSVData() throws Exception {

		String[][] testData;

		String file = System.getProperty("user.dir") + "/src/main/java/com/bwp/resources/CreateCampaignData.csv";

		// Get the workbook
		Reader fileInputStream = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(fileInputStream);

		int numberOfRecords = 0;
		int numberOfColumns = 0;

		for (CSVRecord record : records) {
//			System.out.println("Reading record line #" + ++numberOfRecords);
			++numberOfRecords;
			numberOfColumns = record.size();
		}

		testData = new String[numberOfRecords - 1][numberOfColumns];
//		System.out.println("numberOfRecords = " + numberOfRecords);
//		System.out.println("numberOfColumns = " + numberOfColumns);

		int currentRecord = 0;

		fileInputStream = new FileReader(file);
		records = CSVFormat.EXCEL.parse(fileInputStream);

		for (CSVRecord record : records) {

//			System.out.println("Reading test data ");
			if (record.getRecordNumber() == 1) {
//				System.out.println("record = " + record);
				continue;
			}

			for (int i = 0; i < record.size(); i++) {
				testData[currentRecord][i] = record.get(i);

			}
			currentRecord++;
		}

		return testData;
	}

	public int getRowCountofTcID(Sheet sheetobj, String testcaseIdName) {
		int activateRowNum = sheetobj.getLastRowNum();
		int count = 0;
		for (int i = 1; i <= activateRowNum; i++) {
			Row rowObj = sheetobj.getRow(i);
			Cell cellObj = rowObj.getCell(1);
			String actualCellvalue = cellObj.getStringCellValue();
			if (actualCellvalue.equals(testcaseIdName)) {
				count++;
			}
		}
		return count;

	}

	public Object[][] readData(String sheetName, String expTestCaseId) {
		File file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/bwp/resources/CreateCampaignData.csv");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheetObj = workbook.getSheet(sheetName);
		Object[][] arrObj = new Object[getRowCountofTcID(sheetObj, expTestCaseId)][1];
		int dataCount = 0;
		int rowcount = sheetObj.getLastRowNum();
		for (int i = 1; i <= rowcount; i++) {
			Row rowObj = sheetObj.getRow(i);
			Cell xcellObj = rowObj.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String actualTcId = xcellObj.getStringCellValue();
			if (expTestCaseId.equalsIgnoreCase(actualTcId)) {
				Map<String, String> dataMap = new HashMap<String, String>();
				int cellCount = rowObj.getLastCellNum();

				for (int j = 2; j <= cellCount - 1; j = j + 2) {
					Cell cellDataName = rowObj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					Cell cellDataValue = rowObj.getCell(j + 1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					String dataKey = cellDataName.getStringCellValue();
					String dataValue = cellDataValue.getStringCellValue();
					dataMap.put(dataKey, dataValue);
				}
				arrObj[dataCount++][0] = dataMap;
			}
		}
		return arrObj;
	}

//	Data Reader from json file

	public List<HashMap<String, String>> getJsonDataToHashmap(String jsonFileName) throws IOException {
//		reading json to string
		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "/src/main/java/com/bwp/resources/" + jsonFileName + ".json"),
				StandardCharsets.UTF_8);

//		String to Hashmap

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public void logInfo(String msg) {
		log.info(msg);
	}

	public void logError(String msg) {
		log.error(msg);
	}

	public String FAQUrl() {
		return "https://testing.cedcommerce.bwpapps.com/panel/636a584330f6c03e9e09d1d8/faq";
	}

	public String helpUrl() {
		return "https://testing.cedcommerce.bwpapps.com/panel/637cd7fce8364d947c0c35d7/help";
	}

	public String settingsUrl() {
		return "https://testing.cedcommerce.bwpapps.com/panel/636a584330f6c03e9e09d1d8/config";
	}

	public String dashboardUrl() {
		return "https://testing.cedcommerce.bwpapps.com/panel/636a584330f6c03e9e09d1d8/dashboard";
	}

	public String productListUrl() {
		return "https://testing.cedcommerce.bwpapps.com/panel/636a584330f6c03e9e09d1d8/product";
	}

	public String createCampaignPageUrl() {
		return "https://testing.cedcommerce.bwpapps.com/panel/637cd7fce8364d947c0c35d7/dashboard/create";
	}

	public String catalogSyncProcessPageUrl() {
		return "https://testing.cedcommerce.bwpapps.com/info/faq?query=How%20does%20the%20Catalog%20Sync%20process%20work?";
	}

	public String helpPageUrl() {
		return "https://testing.cedcommerce.bwpapps.com/info/help";
	}

	public String getSupportPageUrl() {
		return "https://socialsadsforbwp.freshdesk.com/support/home";
	}

}
