package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage {

	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ("//th[contains(text(),'Email')]")) WebElement LIST_CUSTOMER_PAGE_EMAIL_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = ("//button[@class='btn btn-primary']")) WebElement DELETE_OK_BUTTON_ELEMENT;

	public void validateListCustomerPageElementHeader() {
		Assert.assertTrue(LIST_CUSTOMER_PAGE_EMAIL_HEADER_ELEMENT.isDisplayed(), "Add customer page not found");
	}
	// tbody/tr[1]/td[3] //tbody/tr[1]/td[7]/a[2} for delete
	// tbody/tr[2]/td[3] //tbody/tr[2]/td[7]/a[2] for delete

	String before_xpath = "//tbody/tr[";
	String after_xpath = "]/td[3]";
	String after_xpath_delete = "]/td[7]/a[2]";

	public void validateInsertedNameAndDelete() {

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);

			if (name.contains(AddCustomerPage.getInsertedName())) {
				driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
			}
		}

	}

	public void clickOkDeleteButton() {
		DELETE_OK_BUTTON_ELEMENT.click();
	}

}
