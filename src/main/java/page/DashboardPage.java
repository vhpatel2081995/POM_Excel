package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;

	// WebElements
	@FindBy(how = How.XPATH, using = "//h2[text()=' Dashboard ']")
	WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Customers']")
	WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//A[text()='Add Customer']")
	WebElement ADD_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']")
	WebElement LIST_CUSTOMER_ELEMENT;

	// to passing test driver page to here
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// intractable Mehtods
	public void validateDashboardPage() {

		Assert.assertTrue(DASHBOARD_HEADER_ELEMENT.isDisplayed(), "dashboard page not displyed");
	}

	public void clickCustomerMenu() {
		CUSTOMER_MENU_ELEMENT.click();
	}

	public void clickAddCustomerMenu() {
		ADD_CUSTOMER_ELEMENT.click();
	}

	public void clickListCustomerMenu() {
		LIST_CUSTOMER_ELEMENT.click();
	}
}
