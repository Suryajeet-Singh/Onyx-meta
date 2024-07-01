package com.bwp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageOR {
	
	@FindBy(id="insta-banner-link")
	WebElement connectInstaAcntBanner;
	
	@FindBy(id="payment-banner-link")
	WebElement learnToAddPaymentMethod;

	@FindBy(xpath = "//span[normalize-space()='Dashboard']")
	WebElement dashboard;

	@FindBy(xpath = "//span[normalize-space()='Product List']")
	WebElement productList;

	@FindBy(id="create-campaign")
	WebElement createCampaignButton;

	@FindBy(id="help-doc")
	WebElement helpDocLink;

	@FindBy(xpath = "//div[@class='inte-loading']")
	WebElement loadingicon;

	@FindBy(xpath = "//div[@class = 'inte__reverseNavigation']")
	WebElement backButtonIcon;

	@FindBy(id="footer-support")
	WebElement getSupportLink;

	@FindBy(xpath = "//button//span[contains(text(),'Download Report')]")
	WebElement downloadReportButton;

	@FindBy(xpath = "//div[contains(@class,'custom-tooltip--msg')]/h3[1]")
	WebElement downloadReportButtonTooltipHeading;

	@FindBy(xpath = "//div[contains(@class,'custom-tooltip--msg')]/h3[2]")
	WebElement downloadReportButtonTooltipContent;

	@FindBy(xpath = "//input[@placeholder='Search Campaign']")
	WebElement searchCampaignInputField;

	@FindBy(xpath = "//ul[@class='inte-popover-container']")
	WebElement searchedCampaignSuggestionContainer;

	@FindBy(xpath = "//ul[@class='inte-popover-container']/li")
	List<WebElement> allSuggestionsList;

	@FindBy(xpath = "//span[@style='color: rgb(28, 36, 51);']")
	WebElement searchedKeyword;

	@FindBy(xpath = "//span[@class='inte-form__innericPrefix']")
	WebElement searchCampaignIcon;

	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']/td[@label = 'Status'] //span")
	List<WebElement> allCampaignsStatus;

	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']/td[@label = 'Status']")
	List<WebElement> allCampaignsStatusLabel;

	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']/td[@label = 'Campaign'] //p")
	List<WebElement> allCampaignNames;

	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']/td[@label = 'Start Date']")
	List<WebElement> startDate;

	@FindBy(xpath = "//tr[@class='ant-table-row ant-table-row-level-0']/td[@label = 'End Date']//p")
	List<WebElement> endDate;

	@FindBy(xpath = "//div[@class='inte-Filter']")
	WebElement filterButton;

	@FindBy(xpath = "//div[@class='inte-FilterSheet']")
	WebElement allFiltersCard;

	@FindBy(xpath = "//div[@class = 'inte--Tag inte--Tag-hasPopover false']")
	WebElement activeFiltersContainer;

	@FindBy(xpath = "//div[@class = 'inte--Tag inte--Tag-hasPopover false']/parent::div//div[@class = 'inte-flex__item']")
	List<WebElement> activeFiltersInsideFiltersContainer;

	@FindBy(xpath = "//div[@class = 'inte-flex__item']//div[@class = 'inte--Tag undefined false']")
	WebElement singleActiveFilter;

	@FindBy(xpath = "//div[contains(@class,'inte-FilterSheet--Header')]")
	WebElement filterCardHeading;

	@FindBy(xpath = "//div[contains(@class,'inte-FilterSheet--Header')]//button[contains(@class,'inte-btn--onlyIcon')]/span[@class = 'inte-btn__icon ']")
	WebElement crossButtonFiltersCard;

	@FindBy(xpath = "//div[@class = 'inte_sheetActive inte_FilterSheetWrapper']")
	WebElement filterModal;

	@FindBy(xpath = "//input[@id='Archived']")
	WebElement archivedCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Archived']")
	WebElement archivedLabel;

	@FindBy(xpath = "//input[@id='Active']")
	WebElement activeCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Active']")
	WebElement activeLabel;

	@FindBy(xpath = "//input[@id='Disconnected']")
	WebElement disconnectedCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Disconnected']")
	WebElement disconnectedLabel;

	@FindBy(xpath = "//input[@id='Ended']")
	WebElement endedCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Ended']")
	WebElement endedLabel;

	@FindBy(xpath = "//input[@id='Error']")
	WebElement errorCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Error']")
	WebElement errorLabel;

	@FindBy(xpath = "//input[@id='Paused']")
	WebElement pausedCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Paused']")
	WebElement pausedLabel;

	@FindBy(xpath = "//input[@id='Pending']")
	WebElement pendingCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Pending']")
	WebElement pendingLabel;

	@FindBy(xpath = "//input[@id='Scheduled']")
	WebElement scheduledCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Scheduled']/parent::span[@class = 'inte__checkboxWrap']")
	WebElement scheduledLabel;

	@FindBy(xpath = "//div[@class = 'inte-FilterSheet--BodyAccordion-Body']//input")
	List<WebElement> allCheckboxList;

	@FindBy(xpath = "//button//span[normalize-space()='Reset']")
	WebElement resetButton;

	@FindBy(xpath = "//span[normalize-space()='Apply']/parent::button")
	WebElement applyButton;

	@FindBy(xpath = "//button//span[normalize-space()='Manage Columns']")
	WebElement manageColumnButton;

	@FindBy(xpath = "//div[@class='inte__Popover-Wrapper popover-bottom undefined']")
	WebElement manageColumnOptionsCard;

	@FindBy(xpath = "//label[normalize-space()='Start Date']/parent::span/parent::div/input")
	WebElement startDateCheckbox;

	@FindBy(xpath = "//label[normalize-space()='End Date']/parent::span/parent::div/input")
	WebElement endDateCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Daily Budget']/parent::span/parent::div/input")
	WebElement dailyBudgetCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Spend']/parent::span/parent::div/input")
	WebElement spendCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Sales']/parent::span/parent::div/input")
	WebElement salesCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Impressions']/parent::span/parent::div/input")
	WebElement impressionsCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Clicks']/parent::span/parent::div/input")
	WebElement clicksCheckbox;

	@FindBy(xpath = "//label[normalize-space()='Orders']/parent::span/parent::div/input")
	WebElement ordersCheckbox;

	@FindBy(xpath = "//label[normalize-space()='ROAS']/parent::span/parent::div/input")
	WebElement ROASCheckbox;

	@FindBy(xpath = "//span[text()='Campaign']")
	WebElement campaignHeading;

	@FindBy(xpath = "//span[@class = 'custom_tooltip_label ant-tooltip-open']")
	WebElement tooltipMsg;

	@FindBy(xpath = "//div[@class = 'ant-tooltip ant-tooltip-placement-top']")
	WebElement tooltipClass;

	@FindBy(xpath = "//div[contains(@class,'custom-tooltip--msg')]/p[1]")
	WebElement tooltipMsgHeading;

	@FindBy(xpath = "//div[contains(@class,'custom-tooltip--msg')]/p[2]")
	WebElement tooltipMsgContent;

	@FindBy(xpath = "//span[text()='Status']")
	WebElement statusHeading;

	@FindBy(xpath = "//span[contains(text(),'Placement')]")
	WebElement placementHeading;

	@FindBy(xpath = "//span[contains(text(),'Start Date')]")
	WebElement startDateHeading;

	@FindBy(xpath = "//span[contains(text(),'End Date')]")
	WebElement endDateHeading;

	@FindBy(xpath = "//span[contains(text(),'Daily Budget')]")
	WebElement dailyBudgetHeading;

	@FindBy(xpath = "//span[contains(text(),'Spend')]")
	WebElement spendHeading;

	@FindBy(xpath = "//span[contains(text(),'Sales')]")
	WebElement salesHeading;

	@FindBy(xpath = "//span[contains(text(),'Impressions')]")
	WebElement impressionsHeading;

	@FindBy(xpath = "//span[contains(text(),'Clicks')]")
	WebElement clicksHeading;

	@FindBy(xpath = "//span[contains(text(),'Orders')]")
	WebElement ordersHeading;

	@FindBy(xpath = "//span[contains(text(),'ROAS')]")
	WebElement ROASHeading;

	@FindBy(xpath = "//h3[normalize-space()='Actions']")
	WebElement actionsHeading;

	@FindBy(xpath = "//span[@class='inte-btn__icon inte-btn__icon--round']")
	List<WebElement> actionsButton;

	@FindBy(xpath = "//div[@class = 'custom_button_hover']//span[text() = 'Edit']")
	WebElement editCampaignButton;

	@FindBy(xpath = "//div[@class = 'custom_button_hover']//span[text() = 'Archive']")
	WebElement archiveCampaignButton;

	@FindBy(xpath = "//div[@class = 'custom_button_hover']//span[text() = 'Pause']")
	WebElement pauseCampaignButton;

	@FindBy(xpath = "//div[@class = 'custom_button_hover']//span[text() = 'Unpause']")
	WebElement unPauseCampaignButton;

	@FindBy(xpath = "//div[@class = 'inte-Modal-Dialog__Modal inte-Modal-Dialog--Small']")
	WebElement modalAfterClickingOnAnyActions;

	@FindBy(xpath = "//h3[text() = 'Pause Campaign']")
	WebElement pauseCampaignModalPauseHeading;

	@FindBy(xpath = "//button//span[text() = 'Cancel']")
	WebElement cancelButtonInModal;

	@FindBy(xpath = "//button//span[text() = 'Pause']")
	WebElement pauseCampaignButtonInModal;

	@FindBy(xpath = "//button//span[text() = 'Unpause']")
	WebElement unPauseCampaignButtonInModal;

	@FindBy(xpath = "//div[@class='inte-Pagination--PageCount']/parent::div/preceding-sibling::div/button")
	WebElement leftPaginationIcon;

	@FindBy(xpath = "//div[@class='inte-Pagination--PageCount']/parent::div/following-sibling::div/button")
	WebElement rightPaginationIcon;

	@FindBy(xpath = "//div[@class = 'ant-table ant-table-ping-right ant-table-fixed-column ant-table-scroll-horizontal ant-table-has-fix-left ant-table-has-fix-right']")
	WebElement horizontalScrollGrid;

	@FindBy(xpath = "//ul[@class = 'inte-popover-container']")
	List<WebElement> suggestions;

	@FindBy(xpath = "//h3[normalize-space()='No Campaigns found']")
	WebElement noCampaignFound;

	@FindBy(xpath = "//div[@class = 'anticon-caret-down active']")
	WebElement ZToASorting;

	@FindBy(xpath = "//div[@class = 'anticon-caret-up active']")
	WebElement AToZSorting;

}
