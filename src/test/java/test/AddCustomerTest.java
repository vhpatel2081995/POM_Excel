package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LogInPage;
import page.ProfilePage;
import util.BrowserFactory;
import util.ExlReader;

public class AddCustomerTest{
   
	WebDriver driver;
	
	
	ExlReader exlreader = new ExlReader("testData\\2023-02-19--TF_TestData.xlsx");
	
	String userName = exlreader.getCellData("LoginInfo", "UserName", 2);
	// String password = exlreader.getCellData("LoginInfo", "Password", 2);
	String password = "558566" ;
	String fullName = exlreader.getCellData("AddContactInfo", "FullName", 2);
	String company =  exlreader.getCellData("AddContactInfo", "CompanyName", 2);
	String emailId =  exlreader.getCellData("AddContactInfo", "Email", 2);
	String phone = exlreader.getCellData("AddContactInfo", "Phone", 2);
	String address = exlreader.getCellData("AddContactInfo", "Address", 2);
	String city = exlreader.getCellData("AddContactInfo", "City", 2);
	String state = exlreader.getCellData("AddContactInfo", "State", 2);
	String postal_Code = exlreader.getCellData("AddContactInfo", "Zip", 2);
	String countryName = exlreader.getCellData("AddContactInfo", "Country", 2);
	String currencyName = "USD";
	String groupName = "Selenium";
	
	@Test
	public void userShouldBeAbleToAddCustomer() {
		
         driver = BrowserFactory.init();
		
		LogInPage loginpage = PageFactory.initElements(driver, LogInPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickOnSignInButton();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.validateDashboardPage();
		
		dashboardpage.clickCustomerMenu();
		dashboardpage.clickAddCustomerMenu();
		
		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.validateAddCustomerPageHeader();
		addcustomerpage.insertFullName(fullName);
		addcustomerpage.selectCompanyNameFromDropDownMenu(company);
		addcustomerpage.insertEmailId(emailId);
		addcustomerpage.insertPhoneNumber(phone);
		addcustomerpage.insertAddress(address);
		addcustomerpage.insertCityName(city);
		addcustomerpage.insertStateName(state);
		addcustomerpage.insertPostalCode(postal_Code);
		addcustomerpage.selectCountryNameFromDropDownMenu(countryName);
		addcustomerpage.selectTags();
		addcustomerpage.selectCurrencyTypeFromDropDownMenu(currencyName);
		addcustomerpage.selectGroupTypeFromDropDownMenu(groupName);
		addcustomerpage.clickSaveButton();
		
		ProfilePage profilepage = PageFactory.initElements(driver, ProfilePage.class);
		profilepage.validateProfilePage();
		
		dashboardpage.clickListCustomerMenu();

		ListCustomerPage listcustomerpage = PageFactory.initElements(driver, ListCustomerPage.class);
		listcustomerpage.validateListCustomerPageElementHeader();
		
		listcustomerpage.validateInsertedNameAndDelete();
		listcustomerpage.clickOkDeleteButton();
		
		BrowserFactory.tearDown();
	}
	
}
