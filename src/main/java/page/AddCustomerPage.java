package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (how = How.XPATH, using = ("//h5[text()='Add Contact']")) WebElement ADD_CUSTOMER_PAGE_HEADER_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//input[@id='account']")) WebElement FULL_NAME_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//select[@id='cid']")) WebElement COMPANY_DROPDOWN_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//input[@name='email']")) WebElement EMAIL_ID_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//input[@name='phone']")) WebElement PHONE_NUMBER_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//input[@name='address']")) WebElement ADDRESS_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//input[@name='city']")) WebElement CITY_NAME_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//input[@name='state']")) WebElement STATE_NAME_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//input[@name='zip']")) WebElement POSTAL_CODE_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//select[@name='country']")) WebElement COUNTRY_DROPDOWN_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//ul[@class='select2-selection__rendered']")) WebElement TAGS_NAME_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//li[text()='IT Training']")) WebElement TAGFILL_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//select[@id='currency']")) WebElement CURRENCY_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//select[@id='group']")) WebElement GROUP_NAME_ELEMENT ;
	@FindBy (how = How.XPATH, using = ("//button[@class='md-btn md-btn-primary waves-effect waves-light']")) WebElement SAVE_BUTTON_ELEMENT ;
	By CURRENCY_FIELD =By.xpath("//select[@id='currency']");
	By GROUP_FIELD =By.xpath("//select[@id='group']");
	By SAVE_FIELD =By.xpath("//button[@class='md-btn md-btn-primary waves-effect waves-light']");
	
	public void validateAddCustomerPageHeader() {
		Assert.assertTrue(ADD_CUSTOMER_PAGE_HEADER_ELEMENT.isDisplayed(), "Add customer page not found");
	}
	
	static String insertedName;
	public static String getInsertedName() {
		return insertedName;
	}

	public void insertFullName(String full_Name) {
		insertedName = full_Name+generateRandomNumber(9999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
		System.out.println("-----");
		System.out.println(insertedName);
	}
	
	public void selectCompanyNameFromDropDownMenu(String company) {
		selectFromDropDown(COMPANY_DROPDOWN_ELEMENT, company);
	}
	
	public void insertEmailId(String emailId) {
		EMAIL_ID_ELEMENT.sendKeys(generateRandomNumber(999) + emailId);
	}
	
	public void insertPhoneNumber(String phoneNumber) {
		PHONE_NUMBER_ELEMENT.sendKeys(generateRandomNumber(999)+phoneNumber);
	}
	
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void insertCityName(String city) {
		CITY_NAME_ELEMENT.sendKeys(city);
	}
	
	public void insertStateName(String state) {
		STATE_NAME_ELEMENT.sendKeys(state);
	}
	
	public void insertPostalCode(String postalCode) {
		POSTAL_CODE_ELEMENT.sendKeys(postalCode);
	}

	public void selectCountryNameFromDropDownMenu(String countryName) {
		selectFromDropDown(COUNTRY_DROPDOWN_ELEMENT, countryName);
	}
	
	public void selectTags() {
		TAGS_NAME_ELEMENT.click();
	    TAGFILL_ELEMENT.click();
	}
	
	public void selectCurrencyTypeFromDropDownMenu(String currencyName) {
		selectFromDropDown(CURRENCY_ELEMENT, currencyName);
	} 
	
	public void selectGroupTypeFromDropDownMenu(String GroupName) {
		selectFromDropDown(GROUP_NAME_ELEMENT, GroupName);
	} 
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
	
   
}
