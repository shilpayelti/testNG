package com.testng.test;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.testng.base.BaseTest;
import com.testng.pages.LoginPage;

public class LoginTest extends BaseTest{
	WebDriver driver;
	LoginPage loginpage;
	
	@BeforeMethod
	public void launch()
	{
		driver =launchapplication();
		loginpage =new LoginPage(driver);		
	}
	
@Test(priority=0)
public void loginwithvalidcredentials()
{
	loginpage.enterintoUsername("admin123@gmail.com");
	loginpage.enterintopassword("admin123");
	
	loginpage.clickLogin();
}
@Test
public void loginwithinvalidcredentials()
{
	loginpage.enterintoUsername("admin123@gmail.com");
	loginpage.enterintopassword("admin1234");
	loginpage.clickLogin();
}
@AfterMethod
public void teardown()
{
	closebrowser();
}

}
