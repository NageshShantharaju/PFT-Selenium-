package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ScreenerPublisherPage  extends TestBase{
	
	@FindBy(id="publishTitle")
	WebElement Title;
	
	@FindBy(id ="screenerRemarks")
	WebElement Remark;
	
	@FindBy(id="screenerExpireDate_selector")
	WebElement Calander_Icon;
	
	@FindBy(id="screenerExpireDate_selector")
	WebElement Calander_dates;
	
	@FindBy(xpath="//*[@id='clearLoginId']")
	WebElement Recipient;
	
	@FindBy(xpath="//*[@class='promptBtn']")
	WebElement Submit;
	
	@FindBy(id="chkAllowShare")
	WebElement Share;
	
	@FindBy(id="chkincludeMetadata")
	WebElement metadata;
	
	@FindBy(id="chkAllowDownload")
	WebElement Download;
	
	@FindBy(id="AnYearExpiry")
	WebElement OneYearCheckbox;
	
	@FindBy(id="CMP_SecureScreenerPublishPlayer_btnCaptureFrame")
	WebElement StillCapture;
	
	@FindBy(xpath="(//*[@class='ScrThumbDiv'])[2]")
	WebElement SelectAsset;
	
	@FindBy(id="lblSetCover")
	WebElement SetasCoverArt;
	
	@FindBy(xpath="//div[@id='errorAlert' and @class='alertSuccessNG']")
	WebElement SuccessAlert;

	 public ScreenerPublisherPage()
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void EnterPublishTitle(String Title1)
	 {
		Title.sendKeys(Title1);
	 }
	 
	 public void EnterRemarks(String Remarks)
	 {
		 Remark.sendKeys(Remarks);
	 }
	 
	 public void PublishOneYear()
	 {
		 OneYearCheckbox.click();
	 }
	 
	 public void EnterRecipient(String Recipients)
	 {
		 Recipient.sendKeys(Recipients ,Keys.ENTER);
	 }
	 
	 public void CheckPermission()
	 {
		 Share.click();
		 Download.click();
	 }
	 public void ClickonSubmit() throws InterruptedException
	 {
		 TestUtil.Wait();
		 Submit.click();		 
	 }
	 
	 public void Stillcapture()
	 {
		 StillCapture.click();
	 }
	 public void SetasCoverArt()
	 {
		 SelectAsset.click();
		 try {
			TestUtil.Wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 SetasCoverArt.click();
	 }
	

}
