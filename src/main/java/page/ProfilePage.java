package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ProfilePage extends BasePage {

WebDriver driver;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (how = How.XPATH, using = ("//a[@id=\"summary\"]")) WebElement PROFILE_PAGE_HEADER_ELEMENT ;
	
	
	public void validateProfilePage() {
		waitForElement(driver, 10, PROFILE_PAGE_HEADER_ELEMENT);
		Assert.assertTrue(PROFILE_PAGE_HEADER_ELEMENT.isDisplayed(),"Profile page not found" );
	}
}
