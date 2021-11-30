package com.automation.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BaseClass;

public class PageObjectClass extends BaseClass {
	
	@FindBy(xpath = "//input[@id='searchboxinput']")
	WebElement Search;

	@FindBy(xpath = "//button[@id='searchbox-searchbutton']")
	WebElement Button;

	@FindBys({
			// @FindBy(xpath ="//div[@id='omnibox']//div/descendant::div[@class='sbqs_a']")
			@FindBy(xpath = "//div[@id='omnibox']//div/descendant::div[@role='gridcell']") })
	List<WebElement> list;

	
	
	  @FindBy(xpath="//span[contains(text(),'Wankhede Stadium Mumbai')]")
	  WebElement StadiumText;

	/*
	 * @FindBy(partialLinkText = "Stadium") WebElement StadiumText;
	 */
	
	@FindBy(xpath="//span[contains(text(),'4.5')]")
	WebElement ratings;
	/*
	 * @FindBy(xpath="//button[contains(text(),'30,268 reviews')]") WebElement
	 * reviews;
	 */
	@FindBy(partialLinkText = " reviews")
	WebElement reviews1;
	
	
	@FindBy(xpath="//div[contains(text(),'mumbaicricket.com')]")
	WebElement link;
	
	@FindBy(xpath="//div[contains(text(),'Vinoo Mankad Rd, Churchgate, Mumbai, Maharashtra 400020')]")
	WebElement address;
	
	
	/*
	 * @FindBy(partialLinkText ="Add place's phone number") WebElement phone;
	 */
	
	@FindBy(xpath="//span[contains(text(),' phone number')]")
	WebElement phone;

	
	
	/*
	 * public PageObjectClass() { PageFactory.initElements(driver,this); }
	 */
	

	public void searchLocation(String location) {
	//	Search=new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(Search));
		Search.sendKeys(location);
	}

	public void clickSearch() {
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().contains("Wankhede Stadium")) {
				list.get(i).click();
				break;

			}
			System.out.println(list.get(i).getText());
			log.info(list.get(i).getText());
		}
	}
	
	public boolean verifyText()
	{
		return StadiumText.isDisplayed();
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	//print ratings point and number of reviews in the console in main
	
	public void print()
	{
		log.info("Rating is"+ratings.getText()+"\t"+"and Review"+reviews1.getText());
	}
	
	public boolean verifylink()
	{
		return link.isDisplayed();
	}
	
	//Print the address appearing above the “mumbaicricket.com”
	public void print2()
	{
		log.info("address is:"+address.getText());
	}
	
	public boolean verifyPhone()
	{
		return phone.isDisplayed();
	}

	
}
