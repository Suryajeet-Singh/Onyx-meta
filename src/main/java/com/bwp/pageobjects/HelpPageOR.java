package com.bwp.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPageOR {
	
	@FindBy(xpath = "//h1[normalize-space()='Help']")
	WebElement helpSectionHeading;
	
	@FindBy(xpath = "//span[normalize-space()='Help']")
	WebElement helpInNavBar;
	
	@FindBy(xpath = "//span[normalize-space()='FAQ']")
	WebElement FAQInNavBar;
	
	@FindBy(xpath = "(//div[@class = 'inte-card inte-card--bordered custom_card_ced'])[1]")
	WebElement emailSectionCard;
	
	@FindBy(xpath = "//h3[normalize-space()='Email']")
	WebElement emailHeading;
	
	@FindBy(xpath = "//h3[contains(text(),'Send us your queries, feedback, or suggestions via')]")
	WebElement msgEmailHeading;
	
	@FindBy(id="help-card-btn")
	WebElement writeToUsButton;
	
	@FindBy(xpath = "(//div[@class = 'inte-card inte-card--bordered custom_card_ced'])[2]")
	WebElement generateTickerSectionCard;
	
	@FindBy(xpath = "//h3[normalize-space()='Generate Ticket']")
	WebElement generateHeading;
	
	@FindBy(xpath = "//h3[contains(text(),'Is something bothering you? Raise a ticket for a q')]")
	WebElement msgGenerateHeading;
	
	@FindBy(xpath = "//span[normalize-space()='Generate Ticket']")
	WebElement generateTicketButton;
	
	@FindBy(xpath = "//h3[normalize-space()='Frequently Asked Question']/ancestor::div[@class = 'inte-card inte-card--default']")
	WebElement FAQSection;
	
	@FindBy(xpath = "//div[@class = 'inte__accordion--active inte__accordionBody']")
	WebElement queryBody;
	
	@FindBy(xpath = "//h3[normalize-space()='Frequently Asked Question']")
	WebElement FAQHeading;
	
	@FindBy(xpath = "//span[normalize-space()='View all FAQ articles']")
	WebElement viewAllFAQArticlesLink;
	
	@FindBy(xpath = "//h1[normalize-space()='Frequently Asked Questions']")
	WebElement headingOfAllFAQPage;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	WebElement faqSearchInputField;
	
	@FindBy(xpath = "//h3[normalize-space()='No Results Found']")
	WebElement noResultFoundMsg;
	
	@FindBy(xpath = "//button/span[text()='Get Support']")
	WebElement getSupportLink;
	
	@FindBy(xpath = "//ul[contains(@class,'inte-popover-container')]/li")
	List<WebElement> allQuerySugesstion;
	
	@FindBy(xpath = "//span[@style = 'color: rgb(28, 36, 51);']")
	List<WebElement> searchKeywordList;
	
	@FindBy(xpath = "//div[@class='inte-card inte-card--default  '][1]")
	WebElement campaignFAQSection;
	
	@FindBy(xpath = "//h3[normalize-space()='Campaign']")
	WebElement campaignFAQSectionHeading;
	
	@FindBy(xpath = "//div[@class='inte-card inte-card--default  '][2]")
	WebElement productFAQSection;
	
	@FindBy(xpath = "//h3[normalize-space()='Product']")
	WebElement productFAQSectionHeading;
	
	@FindBy(xpath = "//div[@class='inte-card inte-card--default  '][3]")
	WebElement accountFAQSection;
	
	@FindBy(xpath = "//h3[normalize-space()='Account']")
	WebElement accountFAQSectionHeading;
	
	@FindBy(xpath = "//div[@class='inte__accordion']")
	List<WebElement> allFAQs;
	
	@FindBy(xpath = "//span[normalize-space()='Forgot Password?']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//h1[text() = 'Hi, how can we help you?']")
	WebElement supportPageHeading;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
