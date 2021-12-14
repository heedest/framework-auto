package com.automation.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import com.automation.base.BaseClass;

public class PageObjectClass extends BaseClass {

	@FindBy(xpath = "//input[@id='searchboxinput']")
	WebElement Search;

	@FindBy(xpath = "//button[@id='searchbox-searchbutton']")
	WebElement Button;

	@FindBys({
		@FindBy(xpath = "//div[@id='omnibox']//div/descendant::div[@role='gridcell']") })
	List<WebElement> list;

	@FindBy(xpath="//span[contains(text(),'Wankhede Stadium Mumbai')]")
	WebElement StadiumText;

	@FindBy(xpath="//span[@class='aMPvhf-fI6EEc-KVuj8d']")
	WebElement ratings;

	/*
	 * @FindBy(partialLinkText = "reviews") WebElement reviews1;
	 */
	@FindBy(xpath="//span[@class='h0ySl-wcwwM-E70qVe-list']//descendant::button[1]")
	WebElement reviews12;


	@FindBy(xpath="//div[contains(text(),'mumbaicricket.com')]")
	WebElement link;

	@FindBy(xpath="//div[contains(text(),'Vinoo Mankad Rd, Churchgate, Mumbai, Maharashtra 400020')]")
	WebElement address;

	@FindBy(xpath="//span[contains(text(),' phone number')]")
	WebElement phone;

	public void searchLocation(String location) {

		Search.sendKeys(location);
	}

	public void clickSearch() {
		log.info("total Wankhede Search Result is "+list.size());
		for (int i = 0; i < list.size(); i++) {
			log.info(list.get(i).getText());
			if (list.get(i).getText().contains("Wankhede Stadium")) {

				list.get(i).click();
				break;
			}		
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

	public void print()
	{
		log.info("Rating is:\t"+ratings.getText()+"\t"+"and Review:\t"+reviews12.getText());
	}

	public boolean verifylink()
	{
		return link.isDisplayed();
	}

	public void print2()
	{
		log.info("address is:"+address.getText());
	}

	public boolean verifyPhone()
	{
		return phone.isDisplayed();
	}

}
