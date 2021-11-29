package com.automation.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.page.PageObjectClass;
import com.automation.utility.UtilityHelper;

public class MainTest extends BaseClass {
	
	
	
	@Test
	public void googleSearch() throws IOException, InterruptedException {
		PageObjectClass pobject=PageFactory.initElements(driver,PageObjectClass.class);
		pobject.searchLocation("Wankhede Stadium");
		Thread.sleep(5000);
		pobject.clickSearch();
		Thread.sleep(5000);
		UtilityHelper.takeScreenshotOfTest();
	}
	
}