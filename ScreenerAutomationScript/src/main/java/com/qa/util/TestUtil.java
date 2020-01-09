package com.qa.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class TestUtil {

	public static   WebDriver driver ;
	public static long IMPLICIT_WAIT = 50;
	public static long PAGE_LOAD_TIMEOUT = 50;
	
	public static SoftAssert softAssert = new SoftAssert();
	

	public static  void Wait() throws InterruptedException
	{
		Thread.sleep(4000);
	}
	public static void Softasset(String actual ,String expected,String message )
	{
		softAssert.assertEquals(actual, expected , message);
		softAssert.assertAll();
	}
	public static void AssertTrue(boolean verify , String Message)
	{
		softAssert.assertTrue(verify, Message);
	}
	public static void AlertPopup() {
		Alert Validate_Popup = driver.switchTo().alert();
		String Alert_text = Validate_Popup.getText();
		System.out.println("Test Daa Pass/Fail : " + Alert_text);
	}
}
