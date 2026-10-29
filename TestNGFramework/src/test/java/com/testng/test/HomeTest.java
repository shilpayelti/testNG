package com.testng.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testng.base.BaseTest;
import com.testng.pages.HomePage;
import com.testng.pages.LoginPage;
import com.testng.utility.ScreenshotUtility;

public class HomeTest extends BaseTest{
	
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ScreenshotUtility screenshot;
	String methodName ;

	@BeforeMethod
	public void launch() {
		driver = launchapplication();
		screenshot = new ScreenshotUtility();
		loginpage=new LoginPage(driver);
		homepage = new HomePage(driver);
	}
	
	@Test
	public void homePageTestcase() {
		loginpage.enterintoUsername("admin123@gmail.com");
		loginpage.enterintopassword("admin123");
  methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
 screenshot.takescreenshot(driver,methodName);
		loginpage.clickLogin();
		homepage.clickHome();
	}
	
	@AfterMethod
	public void teardown() {
		//screenshot.takescreenshot(driver);
		closebrowser();
	}

}