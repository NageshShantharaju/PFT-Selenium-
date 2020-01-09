package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class ProdDBPage extends TestBase {
	
	
	@FindBy (id="UserName")
	WebElement DBUser;
	
	@FindBy (id="Password")
	WebElement DBPassword;
	
	@FindBy(xpath="//*[@class='login100-form-btn']")
	WebElement Submit;
	
	@FindBy(xpath="//*[@id='dbtool']")
	WebElement DBTool;
	
	@FindBy(xpath="//*[@id='TxtQuery']")
	WebElement DBTextArea;
	
	@FindBy(xpath="(//*[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]")
	WebElement DBToken;

	public ProdDBPage() {
		PageFactory.initElements(driver, this);
	}

	@Test(priority=1)
	public void DBLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",prop.getProperty("DriverPath"));
		WebDriver driv = new ChromeDriver();
		driv.get("http://10.100.30.192:8080/Account/Login?ReturnUrl=%2fDBTool%2findex");
		driv.manage().window().maximize();
		driv.findElement(By.id("UserName")).sendKeys("nagesh.shantharaju@primefocus.com");
		driv.findElement(By.id("Password")).sendKeys("Nagesh@123");
		Thread.sleep(4000);
		driv.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driv.findElement(By.xpath("//*[@id='dbtool']")).click();
		driv.findElement(By.xpath("//*[@id='TxtQuery']")).click();
		driv.findElement(By.xpath("//*[@id='TxtQuery']")).sendKeys("Select top 10  Token,* from Clear_NG.clear.MFATokens  \r\n" + 
				"where Context='LOGIN'\r\n" + 
				"order by 1 desc" , Keys.ENTER);
		driv.findElement(By.xpath("//*[@title='Execute Query']")).click();
		
		String Token_Id = DBToken.getText();
        System.out.println(Token_Id);	
		
		
	}
	@Test(priority=2)
	public void DBAction() {
		
		DBTool.click();
		DBTextArea.click();
		DBTextArea.sendKeys("Select top 10  Token,* from Clear_NG.clear.MFATokens  \r\n" + 
				"where Context='LOGIN'\r\n" + 
				"order by 1 desc" , Keys.ENTER);
		DBTool.sendKeys(Keys.F5);
	}
	@Test(priority=3)
	public void GetToken() {
		
		String Token_Id = DBToken.getText();
        System.out.println(Token_Id);	
	}
	
	
	

}
