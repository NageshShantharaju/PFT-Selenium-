package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class LibraryPage extends TestBase{
	
	@FindBy(xpath="//*[@class='binHead']")
	WebElement Binicon;
	
	@FindBy(id="SearchController")
	WebElement Searchicon;
	
	@FindBy(id="txtCurrentSearchText")
	WebElement Serachtextbox;
	
	@FindBy(xpath="(//*[@class='thumbnailContainer'])[1]")
	WebElement VideoFile;
	
	//@FindBy(xpath="//*[@id='browseThumb_5051-246078']")
	//WebElement ImageFile;
	
	@FindBy(xpath="(//*[@class='thumbnailContainer'])[1]")
	WebElement ImageFile;
	
//	@FindBy(xpath="//*[@id='browseThumb_9001-297236']")
//	WebElement VideoFile;
//	
	
	@FindBy(xpath="//*[@class='Bin']")
	WebElement Binarea;
	
	@FindBy(xpath="(//*[@id='screenerPublish'])[2]")
	WebElement ScreenerIcon;
	
	@FindBy(xpath="//*[@id='navigiationOpenClosePanel']")
	WebElement NavigationPanel;
	
	@FindBy(id="tenantLogo")
	WebElement Tenantlogo;
	
	public LibraryPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void DragandDropVideoAsset(String File1) throws InterruptedException
	{
		Thread.sleep(5000);
		Binicon.click();
		Searchicon.click();
		Serachtextbox.click();
		Serachtextbox.sendKeys(File1 ,Keys.ENTER);
		Thread.sleep(4000);
        VideoFile.click();
		Actions a = new Actions(driver);
		a.dragAndDrop(VideoFile, Binarea).build().perform();
		
	}
	 public void DragandDropImageAsset(String File2) 
	 {
		 try {
			 Searchicon.click();
			 Serachtextbox.clear();
			 Serachtextbox.click();
			 Serachtextbox.sendKeys(File2 , Keys.ENTER);
			 TestUtil.Wait();
			 ImageFile.click();
			 Actions b = new Actions(driver);
			 b.dragAndDrop(ImageFile, Binarea).build().perform();	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 
	 public void ClickonBin()
	 {
		 Binicon.click();
	 }
	 
	 public void ValidateScreenerIcon()
	 {
		boolean BinArea = Binarea.isDisplayed();
		if (BinArea == true)
		{
			log.info("BIN area is Active");
		}
		else
		{
			 Binicon.click();
				log.info("BIN area is In-Active , Clicking on It");
		}
		
		
		
	 }
	 
	 public ScreenerPublisherPage ClickOnScreenericon()
	 {
		boolean CheckforScreenerIcon = ScreenerIcon.isDisplayed();
		 if(CheckforScreenerIcon == true)
		 {
			 try {
				TestUtil.Wait();
				 ScreenerIcon.click();
				 log.info("Clicked on Screener Icon ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else
		 {
			 log.info("Not able to Click on Screener Icon . Please check the icon is avaliable to click");
		 }
	     return new ScreenerPublisherPage();
		 
	 }
	 public void OpenNavigation()
	 {
		boolean Logo = Tenantlogo.isDisplayed();
		System.out.println("Logo is presnt" + Logo);
		if(Logo==true)
		{
			System.out.println("Panel Is Open");
		}
		else
		{
			NavigationPanel.click();
		}
	 }
 
	 
//	 public void OpenNavigation()
//	 {		 
//			 NavigationPanel.click();
//		 
//	 }
//	

}
