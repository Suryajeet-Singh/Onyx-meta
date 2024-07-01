package com.bwp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCampaignPageOR {
	
	@FindBy(xpath = "//div[@class='inte-Loader']")
	WebElement loadingicon;
	
	@FindBy(xpath = "//div[@class = 'inte__reverseNavigation']")
	WebElement backButtonIcon;
	
	@FindBy(xpath = "//button//span[normalize-space()='Continue Setup']")
	WebElement continueSetupButton;

	@FindBy(xpath = "//h3[normalize-space()='Campaign Name']")
	WebElement campaignNameLabel;
	
	@FindBy(id="campaignDetails-name")
	WebElement campaignNameInputField;
	
	@FindBy(xpath = "//div[@class = 'inte-formElement--Wrap   inte-formElement--Error inte--Textfield__thick   ']")
	WebElement campaignNameErrorMessage;
	
	@FindBy(xpath = "//div[text() = 'Start Date ']")
	WebElement startDateLabel;
	
	@FindBy(xpath = "//div[text() = 'Start Date '] //input")
	WebElement startDateInputField;
	
	@FindBy(xpath = "//div[text() = 'Start Date '] //input/following-sibling::span")
	WebElement startDateCalendarIcon;
	
	@FindBy(xpath = "//div[@class = 'ant-picker-date-panel']")
	WebElement datePickerPanel;
	
	@FindBy(xpath = "//div[@class = 'ant-picker-header']")
	WebElement datePickerHeader;
	
	@FindBy(xpath = "//button[@class = 'ant-picker-header-super-prev-btn']")
	WebElement prevYearsMonthButton;
	
	@FindBy(xpath = "//button[@class = 'ant-picker-header-prev-btn']")
	WebElement prevMonthButton;
	
	@FindBy(xpath = "ant-picker-header-view")
	WebElement calendarHeader;
	
	@FindBy(xpath = "//button[@class = 'ant-picker-month-btn']")
	WebElement monthName;
	
	@FindBy(xpath = "//button[@class = 'ant-picker-year-btn']")
	WebElement year;
	
	@FindBy(xpath = "//button[@class = 'ant-picker-header-next-btn']")
	WebElement nextMonthButton;
	
	@FindBy(xpath = "//button[@class = 'ant-picker-header-super-next-btn']")
	WebElement nextYearsMonthButton;
	
	@FindBy(xpath = "//div[@class = 'ant-picker-body']//tbody/tr")
	List<WebElement> weeksInMonth;
	
	@FindBy(xpath = "//div[@class = 'ant-picker-body']//tbody/tr/td")
	List<WebElement> datesInCalendar;
	
	@FindBy(xpath = "//div[@class = 'ant-picker-footer']/a")
	WebElement selectTodaysDate;
	
	@FindBy(xpath = "//td[contains(@class,'ant-picker-cell ant-picker-cell-disabled')]")
	List<WebElement> disabledDates;
	
	@FindBy(xpath = "//h3[normalize-space()='End Date']")
	WebElement endDateLabel;
	
	@FindBy(xpath = "(//input[@placeholder = 'MM/DD/YYYY'])[2]")
	WebElement endDateInputField;
	
	@FindBy(xpath = "(//input[@placeholder = 'MM/DD/YYYY'])[2]/following-sibling::span")
	WebElement endDateCalendarIcon;
	
	@FindBy(xpath = "//h3[normalize-space()='Daily Budget']")
	WebElement dailyBudgetLabel;
	
	@FindBy(xpath = "//p[@class = 'Paragraph inte__text--light none inte__font--normal inte__Paragraph--font--small']")
	WebElement dailyBudgetTooltip;
	
	@FindBy(id="campaignDetails-budget")
	WebElement dailyBudgetInputField;
	
	@FindBy(xpath = "//span[text()='Minimum daily budget is $5. You are charged only when shopper clicks on the Ad.']")
	WebElement minimumDailyBudgetErrorMessage;
	
	@FindBy(xpath = "//h3[normalize-space()='Ad Text']")
	WebElement adTextLabel;
	
	@FindBy(id="campaignDetails-adText")
	WebElement adTextInputField;
	
	@FindBy(id="campaignDetails-guide")
	WebElement contentGuideLink;
	
	@FindBy(id = "r2")
	WebElement prospectiveAudienceRadioButton;
	
	@FindBy(xpath = "//p[text() = 'Define the group of people who will see your Ads based on their demographics, interests, behavior, and more.']")
	WebElement tipProspectiveAudience;
	
	@FindBy(xpath = "//span[@class = 'inte__Select--Selected']")
	WebElement minimumAgeDropDown;
	
	@FindBy(xpath = "//h3[text() = 'Min Age']/following-sibling::div/div")
	WebElement minimumAgeField;
	
	@FindBy(xpath = "//li[@class='inte-Select__Select--Item']/h3")
	List<WebElement> allValues;
	
	@FindBy(xpath = "//div[contains(@class,'inte-select inte-select--Fixed select-')]")
	WebElement dropDown;
	
	@FindBy(xpath = "(//span[@class = 'inte__Select--Selected'])[2]")
	WebElement maximumAgeDropDown;
	
	@FindBy(xpath = "//h3[text() = 'Max Age']/following-sibling::div/div")
	WebElement maximumAgeField;
	
	@FindBy(xpath = "(//span[@class = 'inte__Select--Selected'])[3]")
	WebElement genderDropDown;
	
	@FindBy(xpath = "//h3[text() = 'Gender']/following-sibling::div/div")
	WebElement genderField;
	
	@FindBy(xpath = "//input[@placeholder=' Search for demographics, interests, behaviors, etc.']")
	WebElement searchInterestInputField;
	
	@FindBy(xpath = "//ul[contains(@class,'inte-popover-container')]")
	WebElement suggestionsContainer;
	
	@FindBy(xpath = "//ul[contains(@class,'inte-popover-container')]/li")
	List<WebElement> allSuggestions;
	
	@FindBy(xpath = "//div[@class = 'inte--Tag undefined undefined']")
	WebElement selectedFromSugesstionCard;
	
	@FindBy(xpath = "//span[text() = 'Demographics']")
	WebElement suggesstionContainsDemographics;
	
	@FindBy(xpath = "//div[@class = 'inte--Tag-content']/span")
	List<WebElement> selectedInterest;
	
	@FindBy(xpath = "//label[contains(.,'Reach people apart from your detailed targeting')]/parent::span/parent::div/input")
	WebElement increaseTargetAudienceCheckbox;
	
	@FindBy(id = "r1")
	WebElement retargetingAudienceRadioButton;
	
	@FindBy(xpath = "//p[text() = 'Target customers who either viewed your product or added it to their cart, but did not purchase.']")
	WebElement tipRetargetingAudience;
	
	@FindBy(xpath = "//span[@class='inte__Select--Selected']")
	WebElement selectedReTargettingGroups;
	
	@FindBy(xpath = "//h3[normalize-space()='Retargeting Groups']/parent::div/div")
	WebElement retargettingGroups;
	
	@FindBy(xpath = "//li[@value = 'ViewContent']")
	WebElement viewOnlyButDidNotPurchsed;
	
	@FindBy(xpath = "//li[@value = 'AddToCart']")
	WebElement addedToCartButDidNotPurchased;
	
	@FindBy(xpath = "//h3[normalize-space()='Placements']")
	WebElement placementsHeading;
	
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//div[@class = 'inte-Modal-Dialog__Modal inte-Modal-Dialog--Small']")
	WebElement cancelAlertConfirmationBox;
	
	@FindBy(xpath = "//button/span[text() = 'Continue']")
	WebElement continuebutton;
	
	@FindBy(xpath = "//button//span[normalize-space()='Quit Setup']")
	WebElement quitSetupButton;
	
	
	@FindBy(xpath = "//button//span[text() = 'Create Campaign']")
	WebElement createCampaignButton;
	
	@FindBy(xpath = "//label[text() = 'Facebook']/parent::span/preceding-sibling::input")
	WebElement fbCheckbox;
	
	@FindBy(xpath = "//label[text() = 'Instagram']/parent::span/preceding-sibling::input")
	WebElement instagramCheckbox;
	
	@FindBy(xpath = "//div[contains(@class,'inte-form__checkbox inte-form__checkbox--Disabled')]")
	WebElement instaIsDisabled;
	
	@FindBy(xpath = "//button[contains(@class,'inte-btn inte-btn-disable')]")
	WebElement createCampaignButtonDisabled;
	
	@FindBy(xpath = "//div[contains(text() , 'You have synchronized ')]")
	WebElement primeEligibleProductSyncMsg;
	
	@FindBy(id="create-advertise-link")
	WebElement catalogSyncProcessLink;
	
	@FindBy(xpath = "//div[@class = 'inte-flex__item inte-flex__item--M100 inte-flex__item--T100 inte-flex__item--D33']")
	WebElement adPreviewContainer;
	
	@FindBy(xpath = "//h1[text() = 'Frequently Asked Questions']")
	WebElement faqHeading;
	
	@FindBy(className = "ant-picker-month-btn")
	WebElement monthBtnDatePicker;
	
	@FindBy(className = "ant-picker-year-btn")
	WebElement yearBtnDatePicker;
	
	@FindBy(xpath = "//tr/td/div")
	List<WebElement> yearsList;
	
	@FindBy(xpath = "//tr/td/div")
	List<WebElement> monthList;
	
	@FindBy(xpath = "//tr/td/div")
	List<WebElement> dateList;
	
	@FindBy(xpath = "//tr/td")
	List<WebElement> dateTitleList;
	
	@FindBy(className = "ant-picker-header-prev-btn")
	WebElement prevBtnDatePicker;
	
	@FindBy(className = "ant-picker-header-next-btn")
	WebElement nextBtnDatePicker;
	
	@FindBy(className = "ant-picker-header-super-next-btn")
	WebElement nextSuperBtnDatePicker;
	
	@FindBy(className = "ant-picker-header-super-prev-btn")
	WebElement prevSuperBtnDatePicker;
	
	@FindBy(xpath = "//td[@class='ant-picker-cell ant-picker-cell-disabled ant-picker-cell-in-view']")
	WebElement disabledDate;
}
