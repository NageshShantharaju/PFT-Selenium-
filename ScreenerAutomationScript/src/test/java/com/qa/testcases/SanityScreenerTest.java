package com.qa.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LibraryPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProdDBPage;
import com.qa.pages.ScreenerInboxpage;
import com.qa.pages.ScreenerOutboxPage;
import com.qa.pages.ScreenerPublisherPage;
import com.qa.util.TestUtil;

public class SanityScreenerTest extends TestBase {
	
	LoginPage loginpage;	
	HomePage HomePage;
	LibraryPage libraryPage;
	ScreenerPublisherPage ScreenerPublisherPage;
	ScreenerInboxpage ScreenerInboxpage;
	ScreenerOutboxPage ScreenerOutboxPage;
	ProdDBPage ProdDBPage;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@BeforeSuite
	public void SanityStart()
	{
		System.out.println("================SANITY REPORT START =================");
		log.info("Automation Testing Start Running !!!");
	}	
	
	@BeforeTest
	public void Login() throws InterruptedException {
		intilization();
		loginpage = new LoginPage();	
	}
	@Test(priority = 0)
	public void VaildateUserLogin() throws InterruptedException  {	
		HomePage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
        log.info("User has entred Username and Pwd UserName:" + prop.getProperty("Username") + "Password:" + prop.getProperty("Pwd"));
	}
	
	@Test(priority = 1)
	public void NavigateToLibraryPage() throws InterruptedException {
		HomePage.ValidateLogo();
		HomePage.Navigate_handle();
		libraryPage= HomePage.ClickonLibrary();	 
	}
	
	@Test(priority=2)
	public void DragandDropTheAssets() throws InterruptedException
	{		
		libraryPage.DragandDropVideoAsset(prop.getProperty("VideoFile"));
		libraryPage.DragandDropImageAsset(prop.getProperty("ImageFile"));
		ScreenerPublisherPage = libraryPage.ClickOnScreenericon();
	}
   
	@Test(priority=3)
	public void InternalPublish() 
	{		
		try {
			Thread.sleep(8000);
			ScreenerPublisherPage.EnterPublishTitle(prop.getProperty("ScreenerTitleInternal"));
			ScreenerPublisherPage.EnterRemarks(prop.getProperty("Remarks"));
			ScreenerPublisherPage.EnterRecipient(prop.getProperty("Internal_Recipient_Id"));
			ScreenerPublisherPage.CheckPermission();
			TestUtil.Wait();
			ScreenerPublisherPage.Stillcapture();
			TestUtil.Wait();
			ScreenerPublisherPage.ClickonSubmit();
			TestUtil.AssertTrue(true, "Internal Publish Got Passed");
			log.info("Internal Publish Got Passed");
			//TestUtil.AlertPopup();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(priority=4)
	public void ExternalPublish() 
	{
		try {
			Thread.sleep(5000);
			libraryPage.ValidateScreenerIcon();
			ScreenerPublisherPage = libraryPage.ClickOnScreenericon();
			Thread.sleep(8000);
			ScreenerPublisherPage.EnterPublishTitle(prop.getProperty("ScreenerTitleExternal"));
			ScreenerPublisherPage.EnterRemarks(prop.getProperty("Remarks"));
			ScreenerPublisherPage.PublishOneYear();
			ScreenerPublisherPage.EnterRecipient(prop.getProperty("External_Recipient_Id"));
			ScreenerPublisherPage.CheckPermission();
			TestUtil.Wait();
			ScreenerPublisherPage.SetasCoverArt();
			TestUtil.Wait();
			ScreenerPublisherPage.ClickonSubmit();
			TestUtil.Wait();
			TestUtil.AssertTrue(true, "External Publish Got Passed");
			log.info("External Publish Got Passed");
			//HomePage.Navigate_handle();
			//TestUtil.AlertPopup();
	     	HomePage.ClickonTask();
			HomePage.ClickonScreeners();
			//libraryPage.OpenNavigation();	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	@Test(priority=5)
	public void RequestExtension() throws InterruptedException
	{
		TestUtil.Wait();
		ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerInboxpage = new ScreenerInboxpage();
	    ScreenerInboxpage.ValidateScreenrTab();
	    TestUtil.Wait();
	    ScreenerInboxpage.ClcikonSearchicon();
		ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleInternal"));
		TestUtil.Wait();
		ScreenerInboxpage.RequestExtenion(prop.getProperty("RequestExternsionComment"));
	}
//    @Test(priority=6)
//    public void EditExtension() throws InterruptedException 
//    {
//			try {
//				TestUtil.Wait();
//				ScreenerInboxpage.EditRequest(prop.getProperty("EditExternsionComment"));
//			} catch (FindFailed e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//    }
	@Test(priority=7)
	public void EditTheOrder() 
	{
		try {
			TestUtil.Wait();
			ScreenerPublisherPage = new ScreenerPublisherPage();
			ScreenerOutboxPage = new ScreenerOutboxPage();
			ScreenerOutboxPage.ClickonOutboxtab();
			TestUtil.Wait();
			ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
			ScreenerOutboxPage.Editorder(prop.getProperty("EditFile"));
			ScreenerOutboxPage.EditRecipient(prop.getProperty("EditRecipientId"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @Test(priority=8)
	public void ApproveRequestOrder() throws InterruptedException
	{
    	
		TestUtil.Wait();
		ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerOutboxPage = new ScreenerOutboxPage();
		ScreenerOutboxPage.ClickonOutboxtab();
		TestUtil.Wait();
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.ApprovalOrder(prop.getProperty("ApprovalComment"));
	}
	@Test(priority=9)
	public void ManualExpiry() throws InterruptedException
	{
		TestUtil.Wait();
		ScreenerOutboxPage.ClickonOutboxtab();
		TestUtil.Wait();
		ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerOutboxPage.ManualExpiry(prop.getProperty("ManualExpiry"));
	}
	
	@Test(priority=10)
	public void RequestNewLink() throws InterruptedException
	{
		TestUtil.Wait();
		ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerInboxpage = new ScreenerInboxpage();
		ScreenerOutboxPage = new ScreenerOutboxPage();
		ScreenerInboxpage.ClickonScreenerInboxTab();
		TestUtil.Wait();
		ScreenerInboxpage.ClcikonSearchicon();
		ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleInternal"));
		ScreenerInboxpage.RequestNewLink(prop.getProperty("RequestNewLink"));	
	}
//	@Test(priority=11)
//	public void RequestAgain() 
//	{
//		try {
//			TestUtil.Wait();
//			ScreenerInboxpage.ClcikonSearchicon();
//			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleInternal"));
//			ScreenerInboxpage.RequestAgain(prop.getProperty("RequestAgainComment"));	
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	@Test(priority=12)
	public void ExtendExpiry() 
	{
		try {
			ScreenerPublisherPage = new ScreenerPublisherPage();
			ScreenerInboxpage = new ScreenerInboxpage();
			ScreenerOutboxPage = new ScreenerOutboxPage();
			TestUtil.Wait();
			ScreenerOutboxPage.ClickonOutboxtab();
			ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
			TestUtil.Wait();
			ScreenerOutboxPage.ExtendExpiry(prop.getProperty("ExtendExpiry"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test(priority=13)
	public void DeleteSingleAsset() 
	{
		try {
			ScreenerPublisherPage = new ScreenerPublisherPage();
			ScreenerInboxpage = new ScreenerInboxpage();
			ScreenerOutboxPage = new ScreenerOutboxPage();
			TestUtil.Wait();
			ScreenerOutboxPage.ClickonOutboxtab();
			ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
			TestUtil.Wait();
			ScreenerOutboxPage.DeleteSingleAsset();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=14)
	public void DeletePublishOrder() 
	{
		ScreenerPublisherPage = new ScreenerPublisherPage();
		ScreenerInboxpage = new ScreenerInboxpage();
		ScreenerOutboxPage = new ScreenerOutboxPage();
		try {
			TestUtil.Wait();
			ScreenerOutboxPage.Searchorder(prop.getProperty("ScreenerTitleInternal"));
			TestUtil.Wait();
			ScreenerOutboxPage.Deletepublish();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=15)
	public void Logout() 
	{
		try {
			TestUtil.Wait();
			ScreenerOutboxPage.Logout();
			TestUtil.Wait();
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
//	@Test(priority=13)
//	public void ExternaluserLogin() throws InterruptedException, ClassNotFoundException, SQLException {
//		System.setProperty("webdriver.chrome.driver",prop.getProperty("DriverPath"));
//		driver = new ChromeDriver();	
//		driver.manage().window().maximize();
//		driver.get(prop.getProperty("External_URL"));
//		driver.findElement(By.linkText("Click Here")).click();
//		try {
//			driver.findElement(By.xpath("//p[@class='flashCheck']/a")).click();
//			Robot robot = new Robot();
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_TAB);
//			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//		} catch (Exception e) {
//
//			// exception handling
//		}
//		loginpage = new LoginPage();
//		loginpage.login(prop.getProperty("External_Recipient_Id"), prop.getProperty("Pwd"));
//		TestUtil.Wait();
//		String ActualURL = driver.getCurrentUrl();
//		String ExpectedURL = prop.getProperty("HOME");
//		
//	    if (ActualURL == ExpectedURL)
//	    {		
//			ScreenerPublisherPage = new ScreenerPublisherPage();
//			ScreenerInboxpage = new ScreenerInboxpage();
//		    ScreenerInboxpage.ValidateScreenrTab();
//		    TestUtil.Wait();
//		    ScreenerInboxpage.ClcikonSearchicon();
//			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
//			TestUtil.Wait();
//			ScreenerInboxpage.VerifyScreenerTitle();
//	    }
//	    else
//	    {
//	    	System.out.println("MFA Is Enabled to the User!!!");
//	    }
//	    
//	}
//	@Test(priority=14)
//	public void VerifyIconDisplayed() throws InterruptedException, ClassNotFoundException, SQLException {
//		TestUtil.Wait();
//		ScreenerInboxpage = new ScreenerInboxpage();
//		ScreenerInboxpage.VerifyIconsDisplay();
//	}
//	@Test(priority=15)
//	public void VerifyMetadataPopUp()
//	{
//		ScreenerInboxpage.MetadataIcon();
//		
//	}
	
//	@Test(priority=13)
//	public void ExternaluserLogin() throws InterruptedException, ClassNotFoundException, SQLException {
//		intilization();
//		loginpage = new LoginPage();
//		HomePage = loginpage.login(prop.getProperty("External_Recipient_Id"), prop.getProperty("Pwd"));
//		
//		String MfaUrl = driver.getCurrentUrl();
//		if(MfaUrl.equalsIgnoreCase(prop.getProperty("MFA")))
//		{
//			System.out.println("MFA is Enabled to the User");
//			 String Token = DBConnection.DBConnection();
//			 driver.findElement(By.xpath("//*[@id='ctl00_pageContent_passwordEmail']")).sendKeys(Token);
//			 driver.findElement(By.xpath("//*[contains(@type,'submit')]")).click();			
//		}
//		else
//		{
//			System.out.println("MFA is not Disabled to the User");
//		}
	@Test(priority =16)
	public void ExternalUser_UseCase()
	{
		System.out.println("================EXTERNAL USER SANITY REPORT START =================");
	}	
	
	@Test(priority = 17)
	public void ExternalUser_LaunchURL() {
		intilization();
		loginpage = new LoginPage();	
	}
	@Test(priority = 18)
	public void ExternalUser_Login()   {	
		try {
			ScreenerInboxpage= loginpage.Ext_login(prop.getProperty("External_Username"), prop.getProperty("External_Pwd"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test(priority=19)
	public void CancelRequest()
	{
		try {
			TestUtil.Wait();
			ScreenerInboxpage.ClcikonSearchicon();
			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
			TestUtil.Wait();
			ScreenerInboxpage.RequestExtenion(prop.getProperty("RequestExternsionComment"));
			ScreenerInboxpage.CancelRequest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}

	}

	@Test(priority = 20)
	public void Validate_Metadata_Icon()
	{
		try {
			TestUtil.Wait();
			ScreenerInboxpage.ClcikonSearchicon();
			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
			TestUtil.Wait();
			ScreenerInboxpage.VerifyMetadataIconsDisplay();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Test(priority = 21)
	public void Validate_Download_Icon()
	{
		try {
			TestUtil.Wait();
			ScreenerInboxpage.ClcikonSearchicon();
			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
			TestUtil.Wait();
			ScreenerInboxpage.VerifyDownloadIconsDisplay();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	@Test(priority = 22)
	public void Validate_Play_Icon()
	{
		try {
			TestUtil.Wait();
			ScreenerInboxpage.ClcikonSearchicon();
			ScreenerInboxpage.SearchtheOrder(prop.getProperty("ScreenerTitleExternal"));
			TestUtil.Wait();
			ScreenerInboxpage.VerifyPlayIconsDisplay();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}
	@Test(priority=23)
	public void ShareOredr()
	{
		ScreenerInboxpage.shareorder(prop.getProperty("Share_Recipient_Id1") , prop.getProperty("Share_Recipient_Id2"));
	}
	@Test(priority=24)
	public void ValidateRefreshBtn()
	{
		ScreenerInboxpage.ValidateRefresh();
	}
	@Test(priority=25)
	public void ValidateShareCount()
	{
		ScreenerInboxpage.Validate_ShareCount();
	}
	
	@AfterSuite
	public void Endsanity() throws InterruptedException
	{
		TestUtil.Wait();
		System.out.println("================SANITY REPORT END =================");
		//driver.quit();
	}

}
