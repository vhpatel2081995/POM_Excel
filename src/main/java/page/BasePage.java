package page;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
     
	
	public void selectFromDropDown(WebElement element, String visibleText) {
		Select sel = new Select(element);
	    sel.selectByVisibleText(visibleText);
	    
	    List<WebElement> allDropDownOptions = sel.getOptions();
	     
	    for(int i=0 ; i<allDropDownOptions.size() ; i++) {
	    	System.out.println(allDropDownOptions.get(i).getText());
	    }
	}   
	
	public int generateRandomNumber(int boundNum) {
		Random rnd = new Random();
		int generateNumber = rnd.nextInt(boundNum);
		return generateNumber;
	}
	
	public void waitForElement(WebDriver driver, int waitTime, WebElement visibilityOfElemnent) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(visibilityOfElemnent));
		
	}
	
	 // For dropdown validation
	/* String[] exp = {"--Title--","Mr","Mrs","Miss","Ms","Dr","Prof"};
	 WebElement dropdown = driver.findElement(By.id("ddlNights"));  
	 Select select = new Select(dropdown);  

	 List<WebElement> options = select.getOptions();  
	 for(WebElement we:options)  
	 {  
	  boolean match = false;
	  for (int i=0; i<exp.length(); i++){
	      if (we.getText().equals(exp[i]){
	        match = true;
	      }
	    }
	  Assert.assertTrue(match);
	 }  
} */
}
