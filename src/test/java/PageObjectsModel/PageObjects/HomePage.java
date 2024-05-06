package PageObjectsModel.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//Get the driver instance from the main test
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElement(By.cssSelector("a.ico-register")).click();
	
	//WebElement registerLink = driver.findElement(By.cssSelector("a.ico-register"));
	
	//Page Factory 
	@FindBy (css ="a.ico-register") 
	WebElement registerLink;

	
	public void clickOnRegisterLink() {
		registerLink.click();
	}
}
