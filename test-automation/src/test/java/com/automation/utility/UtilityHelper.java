package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.automation.base.BaseClass;

public class UtilityHelper extends BaseClass{

	public static long IMPLICIT_TIMEOUT=10;
	public static long PAGE_LOAD_TIMEOUT=20;
	public static String URL="https://www.google.com/maps/";
	
	
	public static void takeScreenshotOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File("./ScreenShots/Wankhede_Search"+getDateTime()+".png"));
	}
	
	
	public static void takeScreenshotEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File("./ScreenShots/end_Search"+getDateTime()+".png"));
	}
	
	public static String getDateTime()
	{
		DateFormat custDateFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return custDateFormat.format(currentDate);	
	}
	
	
}
