package com.automation.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.automation.utility.UtilityHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Logger log=LogManager.getLogger(BaseClass.class);


	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilityHelper.IMPLICIT_TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilityHelper.PAGE_LOAD_TIMEOUT));

		driver.get(UtilityHelper.URL);
		log.info("Google launched");

	}

	@AfterTest	
	public void teardown() {
		driver.quit();
	}

}
