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
		}
	}

}
