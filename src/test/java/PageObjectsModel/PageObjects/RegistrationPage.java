package PageObjectsModel.PageObjects;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	By locator;
	UIHelper helper;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//By locator = By.id("FirstName");
		helper = new UIHelper();
	}
	
	@FindBy(id="FirstName")
	WebElement firstNameField;
	
	@FindBy(id="LastName")
	WebElement lastNameField;
	
	@FindBy(id="Email")
	WebElement emailField;
	
	@FindBy(id="Password")
	WebElement passwordField;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordField;
	
	@FindBy(id="register-button")
	WebElement registerButton;
	
	@FindBy(css="div.header-links-wrapper a.account")
	WebElement userEmailTextElement;
	
	@FindBy(css="a.ico-logout")
	WebElement logoutLink;
	
	WebElement gender;
	
	List<String> userData = new ArrayList<>();
	
	public void selectGender(String genderType) {	
	 gender = driver.findElement(By.xpath("//label[text()='"+genderType+"']/preceding-sibling::input"));
	}
	
	public void newUserRegistration(String firstName, String lastName, String email, String password) {
		gender.click();
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		registerButton.click();
		
		WebElement firstName2 = driver.findElement(By.id("FirstName"));
		//driver.findElement(locator).click();
		
	}
	
	public void callGetUserData(String sheetName, int rowNo) throws IOException {
		helper.getuserDataForRegistration(sheetName, rowNo);
	}
	
	public void newUserRegistrationFromDataSheet(String sheetName, int rowNo ) throws IOException {
		gender.click();
		userData = helper.getuserDataForRegistration(sheetName, rowNo);
		firstNameField.sendKeys(userData.get(0));
		lastNameField.sendKeys(userData.get(1));
		emailField.sendKeys(userData.get(2));
		passwordField.sendKeys(userData.get(3));
		confirmPasswordField.sendKeys(userData.get(4));
		registerButton.click();
		
		//WebElement firstName2 = driver.findElement(By.id("FirstName"));
		//driver.findElement(locator).click();
		
	}
	
	String userEmailText;
	
	public void getEmailAndAddToDataSheet(String sheetName) throws IOException {
		userEmailText = userEmailTextElement.getText();
		helper.addRegisteredUsers(userEmailText, sheetName);
		
	}
	
	public void logOut() {
		logoutLink.click();
	}
	

}
