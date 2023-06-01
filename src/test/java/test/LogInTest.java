package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LogInPage;
import util.BrowserFactory;
import util.ExlReader;

public class LogInTest {

	WebDriver driver;
	
	ExlReader exlreader = new ExlReader("testData\\2023-02-19--TF_TestData.xlsx");
	
	String userName = exlreader.getCellData("LoginInfo", "UserName", 2);
	String password = "558566" ;
	// String password = exlreader.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldAbleToLogIn() {
		
		driver = BrowserFactory.init();
		
		LogInPage loginpage = PageFactory.initElements(driver, LogInPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickOnSignInButton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validateDashboardPage();
		
		BrowserFactory.tearDown();
		
	}
	
}
