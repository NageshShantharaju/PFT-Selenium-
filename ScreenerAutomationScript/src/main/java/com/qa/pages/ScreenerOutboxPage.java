package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class ScreenerOutboxPage extends TestBase {
	
	@FindBy(xpath="//*[@id='ScreenerOutbox']")
	WebElement Outboxtab;
	
//	@FindBy(xpath="//*[contains(text(),'Outbox')]")
//	WebElement Outboxtab;
//	
	
	@FindBy(xpath="//*[@id='UCsrchIcon']")
	WebElement OutboxSearchIcon;
	
	@FindBy(id="ScreenerInboxSearch")
	WebElement OuboxSearch;
	
	@FindBy(xpath="//*[text()='Extension Requested']")
	WebElement ExtensionApproval;
	
	@FindBy(xpath="//*[@id='requestorCommentsInbox']")
	WebElement ApprovalCommentBox;

	@FindBy(id ="dvApprove")
	WebElement Submitbutton;	
	
	@FindBy(xpath="(//*[contains(text(),'Expiry')])[1]")
	WebElement ExtendExpiry;
	
	@FindBy(xpath="//*[contains(text(),'Expire')]")
	WebElement ManualExpiry;
	
	@FindBy(id ="outBoxTextArea")
	WebElement ManualCommentBox;
	
	@FindBy(id ="btnExpire")
	WebElement ManualSubmitButton;
	
	@FindBy(xpath="//*[contains(text(),'Delete')]")
	WebElement DeletePublish;
	
	@FindBy(xpath="//li[@title='Edit Publish']")
	WebElement EditPublish;
	
	@FindBy(xpath="//*[@id='_searchBin']")
	WebElement Edit_AddAsset;
	
	@FindBy(xpath="//li[@title='Click here to Extend expiry']")
	WebElement ExtendDate;
	
	@FindBy(xpath="//*[@id='requestorCommentsInbox']")
	WebElement Exted_Cmt_Box;
	
	@FindBy(xpath="//*[@id='dvExtendExpiry']")
	WebElement Exted_Submit;
	
	
	@FindBy(xpath="//*[@id='txtCurrentSearchText']")
	WebElement Edit_Searchbox;
	
	@FindBy(xpath="(//*[@class='AssetWrapper'])[1]")
	WebElement Edit_VideoFile;
	
//	@FindBy(xpath="//*[@id='browseBinThumb_9001-306691']")
//	WebElement Edit_VideoFile;	
	
	@FindBy(id="binV2")
	WebElement Edit_Binarea;
	
	@FindBy(id="Update2")
	WebElement Edit_BtnUpdate;
	
	@FindBy(xpath="//*[@id='clearLoginId']")
	WebElement Edit_Recipient;
	
	@FindBy(id="spanSearchCount")
	WebElement No_Records_Found;
	
	@FindBy(id="Publish1")
	WebElement Edit_Publish;
	
	@FindBy(xpath="//*[@id='Yes1']")
	WebElement AlertPop;
	
	@FindBy(xpath="//div[@class='asset-actionsMain  style-scope pft-screeneroutbox'][1]")
	WebElement SelectAsset;
	
	@FindBy(xpath="//span[@class='asset-delete WhiteRounded pft-screeneroutbox'][1]")
	WebElement DeleteIcon;
		
	@FindBy(xpath="//*[@class='FL userNameRole']")
	WebElement Userlabel;
	
	@FindBy(xpath="//*[@title='Logout']")
	WebElement Logout;
		
	
	public ScreenerOutboxPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickonOutboxtab()
	{
		Outboxtab.click();
	}
	
	public void Searchorder(String Search) throws InterruptedException
	{
		TestUtil.Wait();
		OutboxSearchIcon.click();
		OuboxSearch.click();
		OuboxSearch.clear();
		OuboxSearch.sendKeys(Search , Keys.ENTER);
		TestUtil.Wait();
		
	}
	
	public void ApprovalOrder(String ApprovalComent) throws InterruptedException
	{
		TestUtil.Wait();
		ExtensionApproval.click();
		TestUtil.Wait();
		ApprovalCommentBox.click();
		ApprovalCommentBox.sendKeys(ApprovalComent,Keys.ENTER);
		Submitbutton.click();	
	}
	
	public void Editorder(String EditVideoFile) 
	{
		try {
			TestUtil.Wait();
			EditPublish.click();
			Thread.sleep(8000);
			Edit_AddAsset.click();
			Thread.sleep(10000);
			Edit_Searchbox.click();
			Edit_Searchbox.sendKeys(EditVideoFile,Keys.ENTER);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean No_Data = No_Records_Found.isDisplayed();
		if (No_Data == true) {
			
			System.out.println("Library Search is Not Working");
			Edit_BtnUpdate.click();
		}
		else
		{
			Edit_VideoFile.click();
			Actions a = new Actions(driver);
			a.dragAndDrop(Edit_VideoFile, Edit_Binarea).build().perform();
			Edit_BtnUpdate.click();	
		}
			
	}
	public void EditRecipient(String Recipient) throws InterruptedException
	{
		//wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOf(Edit_Recipient));
		Thread.sleep(8000);
		Edit_Recipient.click();
		Edit_Recipient.sendKeys(Recipient,Keys.ENTER);
		TestUtil.Wait();
		Edit_Publish.click();	
	}
	
	
//	public void ExtendExpiry(String ExtendComments)
//	{
//		ExtendExpiry.click();
//		
//	}
	public void ManualExpiry(String ManualComments) throws InterruptedException
	{
		TestUtil.Wait();
		ManualExpiry.click();
		ManualCommentBox.sendKeys(ManualComments);
		ManualSubmitButton.click();
		
	}
	
	public void ExtendExpiry(String ExtendExpiry) 
	{
		try {
			TestUtil.Wait();
			ExtendDate.click();
			Exted_Cmt_Box.sendKeys(ExtendExpiry);
			Exted_Submit.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    
	public void Deletepublish()
	{
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElements(DeletePublish));
		DeletePublish.click();
		AlertPop.click();
	}
	public void Logout()
	{
		Userlabel.click();
		Logout.click();
	}
	public void DeleteSingleAsset()
	{
		Actions d = new Actions(driver);
		d.moveToElement(SelectAsset).build().perform();
		DeleteIcon.click();
		try {
			TestUtil.Wait();
			AlertPop.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
