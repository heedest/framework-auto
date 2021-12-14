package com.automation.test;

import java.io.IOException;


/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;*/
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/*import org.testng.Reporter;*/
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*import org.testng.log4testng.Logger;*/

import com.automation.base.BaseClass;
import com.automation.page.PageObjectClass;
import com.automation.utility.UtilityHelper;

public class MainTest extends BaseClass {
	
	
	PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);
	SoftAssert softAssert = new SoftAssert();
	@Test(priority = 1)
	public void googleSearch() throws IOException, InterruptedException {
		PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);
		pobject.searchLocation("Wankhede Stadium");
		Thread.sleep(5000);
		pobject.clickSearch();
		Thread.sleep(5000);
		UtilityHelper.takeScreenshotOfTest();
		log.info("first test successfully completed");

	}

	@Test(priority = 2)
	public void verifyStadiumText() {
		PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pobject.verifyText(), "Stadium Text not matched");
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyTitle() {
		PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);
		//SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(pobject.verifyTitle(), "Wankhede Stadium Mumbai - Google Maps", "title not matched");
	}


	
	
	@Test(priority = 4)
	public void printTest()
	{
		PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);
		pobject.print();
	}
	
	@Test(priority = 5)
	public void verifyLink() {
		PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);	
		Assert.assertTrue(pobject.verifylink(), "link not matched");
		

	}

	@Test(priority = 6)
	public void printAdressTest()
	{
		PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);
		pobject.print2();
	}
	
	@Test(priority = 7)
	public void verifyPhone() throws IOException, InterruptedException {
		PageObjectClass pobject = PageFactory.initElements(driver, PageObjectClass.class);
		softAssert.assertTrue(pobject.verifyPhone(), "phone not matched");
		Thread.sleep(5000);
		UtilityHelper.takeScreenshotEndOfTest();
		;
		log.info("last successfully completed");
		

	}

}
