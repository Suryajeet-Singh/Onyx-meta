package com.bwp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListOR {
	
	@FindBy(xpath = "//h1[normalize-space()='Products']")
	WebElement productListHeading;
	
	@FindBy(id="full-catalog-sync")
	WebElement catalogSync;
	
	@FindBy(xpath = "//td[@label='Title']//h3")
	List<WebElement> allCampaignTitle;
	
	@FindBy(xpath = "//thead[contains(@class,'ant-table-thead')]")
	WebElement tableHeading;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Products')]")
	WebElement searchInputField;
	
	@FindBy(xpath = "//div[@class='inte-clear']")
	WebElement clearSearchInputField;
	
	@FindBy(xpath = "//ul[contains(@class,'inte-popover-container')]/li")
	List<WebElement> allQuerySugesstion;
	
	@FindBy(xpath = "//span[@style = 'color: rgb(28, 36, 51);']")
	List<WebElement> searchKeywordList;
	
	@FindBy(id="inte-filter__btn")
	WebElement filterButton;
	
	@FindBy(xpath = "//div[@class='inte-FilterSheet']")
	WebElement allFiltersCard;
	
	@FindBy(xpath = "//div[contains(@class,'inte-FilterSheet--Header')]")
	WebElement filterCardHeading;
	
	@FindBy(xpath = "//div[contains(@class,'inte-FilterSheet--Header')]//button[contains(@class,'inte-btn--onlyIcon')]/span[@class = 'inte-btn__icon ']")
	WebElement crossButtonFiltersCard;
	
	@FindBy(xpath = "//div[@class='inte-flex__item']//h3[contains(text(),'Status')]")
	WebElement statusFilterHeading;
	
	@FindBy(id="active")
	WebElement activeCheckbox;
	
	@FindBy(xpath = "//label[normalize-space()='Active']")
	WebElement activeCheckboxLabel;
	
	@FindBy(id="error")
	WebElement errorCheckBox;
	
	@FindBy(xpath = "//label[normalize-space()='Error']")
	WebElement errorCheckBoxLabel;
	
	@FindBy(xpath = "//input[@id='warning']")
	WebElement warningCheckbox;
	
	@FindBy(xpath = "//label[normalize-space()='Warning']")
	WebElement warningCheckboxLabel;
	
	@FindBy(id="pending")
	WebElement pendingCheckBox;
	
	@FindBy(xpath = "//label[normalize-space()='Pending']")
	WebElement pendingCheckBoxLabel;
	
	@FindBy(xpath = "//div[@class = 'inte_sheetActive inte_FilterSheetWrapper']")
	WebElement filterIsActivated;
	
	@FindBy(xpath = "//h3[text()='Inventory']/parent::div/parent::div/parent::div/parent::div")
	WebElement inventoryFilterHeading;
	
	@FindBy(xpath = "//input[@id='In Stock']")
	WebElement inStockCheckbox;
	
	@FindBy(xpath = "//label[normalize-space()='In Stock']")
	WebElement inStockCheckboxLabel;
	
	@FindBy(xpath = "//input[@id='Out of Stock']")
	WebElement outOfStockCheckbox;
	
	@FindBy(xpath = "//label[normalize-space()='Out of Stock']")
	WebElement outOfStockCheckboxLabel;
	
	@FindBy(xpath = "//button//span[normalize-space()='Reset']")
	WebElement resetButton;
	
	@FindBy(xpath = "//button//span[normalize-space()='Apply']")
	WebElement applyButton;
	
	@FindBy(xpath = "//div[@class='inte--Tag__Dismissible']//button")
	List<WebElement> activeFilterCrossButton;
	
	@FindBy(xpath = "//div[@class='inte--Tag undefined false']//span")
	List<WebElement> activeFiltersName;
	
	@FindBy(xpath = "//div[@class='inte--Tag__Dismissible']")
	List<WebElement> activeFilterList;
	
	@FindBy(xpath = "//div[@class='inte--Tag__Dismissible']")
	WebElement activeFilter;
	
	@FindBy(xpath = "//div[@class='inte--Tag__Dismissible']//button")
	List<WebElement> activeFilterListCloseButton;
	
	@FindBy(xpath = "//div[contains(@class,'inte-flex__item--M100 inte-flex__item--T100 inte-flex__item--D100')]")
	WebElement activeFilterContainer;
	
	@FindBy(xpath = "//div[contains(@class,'inte-flex__item--M100 inte-flex__item--T100 inte-flex__item--D100')]/div")
	List<WebElement> activeFilterSectionItems;
	
	@FindBy(xpath = "//h3[normalize-space()='Image']")
	WebElement imageHeading;
	
	@FindBy(xpath = "//h3[normalize-space()='Title']")
	WebElement titleHeading;
	
	@FindBy(xpath = "(//h3[text()='Status'])[2]")
	WebElement statusHeading;
	
	@FindBy(xpath = "(//h3[text()='Inventory'])[2]")
	WebElement inventoryHeading;
	
	@FindBy(xpath = "//h3[normalize-space()='Actions']")
	WebElement actionsHeading;
	
	@FindBy(xpath = "//div[@class='custom-popover-btn']")
	List<WebElement> moreActionsDots;
	
	@FindBy(xpath = "//button//span[text() = 'Edit on Buy with Prime']")
	WebElement editOnBuyWithPrimeButton;
	
	@FindBy(xpath = "//button//span[text() = 'Sync']")
	WebElement syncButton;
	

	@FindBy(xpath = "//div[@class='inner']")
	WebElement loader;
	
	@FindBy(xpath = "//	div[contains(@class,'inte-toast--Wrapper')]")
	WebElement toastMsg;
	
	@FindBy(xpath = "//div[@class='inte-Pagination-perPage--Sorter']")
	WebElement itemsPerPageSelector;
	
	@FindBy(xpath = "//ul[@class='inte-select-options']/li/h3")
	List<WebElement> numberOfItems;
	
	@FindBy(xpath = "//div[@class='inte-Pagination--PageCount']/parent::div/preceding-sibling::div/button")
	WebElement	leftPaginationIcon;
	
	@FindBy(xpath = "//div[@class='inte-Pagination--PageCount']")
	WebElement pageCount;
	
	@FindBy(xpath = "//div[@class='inte-Pagination--PageCount']/parent::div/following-sibling::div/button")
	WebElement	rightPaginationIcon;
	
	@FindBy(xpath = "//h3[text() = 'No Results Found']")
	WebElement noResultFound;
	
	@FindBy(xpath = "//ul[@class = 'inte-popover-container undefined']")
	WebElement vaildSuggestionCard;
	
	@FindBy(xpath = "//li//span[@style = 'color: var(--inte-G90;']")
	List<WebElement> searchSuggestionList;
	
	@FindBy(xpath =  "//td[@label = 'Title']//h3")
	List<WebElement> titleList; 
	
	@FindBy(xpath = "//h3[normalize-space()='No Product found!']")
	WebElement noProductFoundMsg;
	
	@FindBy(xpath = "//span[@class = 'icon-ic_close']")
	WebElement closeSocialAds;

//	div[contains(@class,'inte-toast--Wrapper')]
}
