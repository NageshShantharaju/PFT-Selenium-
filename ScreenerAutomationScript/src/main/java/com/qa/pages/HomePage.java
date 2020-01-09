package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//*[@role='presentation'  and contains(@title ,'Library')]")
	WebElement Libraryicon;
	
	@FindBy(xpath="//*[@role='presentation'  and contains(@title ,'Tasks')]")
	WebElement Tasktab;
	
	@FindBy(xpath="//*[contains(@id,'navigiationOpenClosePanel')]")
	WebElement LabelIcon;
	
	@FindBy(xpath="//*[@role='presentation'  and contains(@title ,'Screene')]")
	WebElement Screenertab;
	
	@FindBy(xpath="//div[@aria-expanded='true']")
	WebElement NavigationTree;
	
	@FindBy(xpath="//*[@class='usernameContainer linked']")
	WebElement Validate_UserLogo;
	
	@FindBy(id="breadCrumbOverlay")
	WebElement Validate_LibraryLogo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public void Navigate_handle()
	{
		boolean Expand = NavigationTree.isDisplayed();
			if(Expand == true)
			{
				NavigationTree.click();
				log.info("Navigation Tree has been expanded , Clicking on it.");
			}
			else 
			{
				log.info("Non of the Panel is expanded.");
			}
	}
	
	public LibraryPage ClickonLibrary() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver,20000);
		WebElement LibraryWait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='presentation'  and contains(@title ,'Library')]")));		
		LibraryWait.click();
		log.info("Clicked on the Library Panel");
		boolean Validate_Library = Validate_LibraryLogo.isDisplayed();
		if (Validate_Library == true)
		{
			TestUtil.AssertTrue(Validate_Library, "User Landed to Library Page");
			log.info("User Landed to Library Page");
		}
		else 
		{
			log.debug("Not able to click on Libary Page , Check for the Locator once");
		}
		
		return new LibraryPage();
	}
	
	public void  ClickonTask() throws InterruptedException {
		
		boolean Label = LabelIcon.isDisplayed();
		//System.out.println(Label);
		if(Label==true)
		{
			System.out.println("Navigation panel is Enable");
			Thread.sleep(3000);
			boolean Task_tab = Tasktab.isDisplayed();
			if(Task_tab == true)
			{
				Tasktab.click();
			}
			else 
			{
				Screenertab.click();
			}
			 
		}
		else
		{
			System.out.println("Navigation panel is  Disable");
			LabelIcon.click();
			Thread.sleep(3000);
			boolean Task_tab = Tasktab.isDisplayed();
			if(Task_tab == true)
			{
				Tasktab.click();
			}
			else 
			{
				Screenertab.click();
			}
		}

	}
	
	public ScreenerInboxpage ClickonScreeners() throws InterruptedException {
		Thread.sleep(3000);
		boolean Screener_Tab = Screenertab.isDisplayed();
		if (Screener_Tab == true)
		{
			Screenertab.click();

		}
		else
		{
			System.out.println("Alreday clicked");
		}
		return new ScreenerInboxpage();
		
	}
	public void ValidateLogo() {
		// TODO Auto-generated method stub
		boolean UserLog = Validate_UserLogo.isDisplayed();
		if(UserLog == true)
		{
			TestUtil.AssertTrue(UserLog, "Successfully User able to Login to the CLEAR Portal");
		}
		else 
		{
			log.error("Connection Lost !!!!!! due to internet speed user not able to login");
		}
	}
 

}
