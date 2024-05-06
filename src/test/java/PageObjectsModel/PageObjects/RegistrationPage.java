package PageObjectsModel.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
//	driver.findElement(By.xpath("//label[text()='"+gender+"']/preceding-sibling::input"));
//	driver.findElement(By.id("FirstName")).sendKeys("Michael"); //
//	driver.findElement(By.id("LastName")).sendKeys("Jordan");//
//	driver.findElement(By.id("Email")).sendKeys("MichaelJordan12@test12.com");//  
//	driver.findElement(By.id("Password")).sendKeys("YouDontKnowMe123");
//	driver.findElement(By.id("ConfirmPassword")).sendKeys("YouDontKnowMe123");
//	driver.findElement(By.id("register-button")).click();
	
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
	
	WebElement gender;
	
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
		
	}
	

}
