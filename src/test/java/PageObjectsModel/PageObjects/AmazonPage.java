package PageObjectsModel.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	
WebDriver driver;

public AmazonPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

@FindBy(id = "twotabsearchtextbox")
WebElement searchTextBox;

@FindBy(xpath ="//div[@data-index='3']//div[contains(@class,'puis-list-col-left')][1]//a[1]/div/img")
WebElement firstSearchResult;

public void productSearch(String searchTerm) {
	
	searchTextBox.clear();
	searchTextBox.sendKeys(searchTerm);
	Actions act = new Actions(driver);
	act.moveToElement(searchTextBox)
	.keyDown(Keys.ENTER)
	.keyUp(Keys.ENTER)
	.build()
	.perform();
	firstSearchResult.click();

}
}