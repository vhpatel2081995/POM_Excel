package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {
	
	WebDriver driver;

	//elements
	//type name = value
	@FindBy(how = How.XPATH, using ="//input[@id='username']") WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using="//input[@id='password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using="//button[@name='login']") WebElement SIGNIN_BUTTON_ELEMENT;
	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Intractable methods -individual method 
	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}

	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	// combine method
	public void performLogIn(String userName,String password) {
		USERNAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_BUTTON_ELEMENT.click();
	}
}
