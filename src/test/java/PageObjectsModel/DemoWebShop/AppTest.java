package PageObjectsModel.DemoWebShop;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjectsModel.PageObjects.HomePage;
import PageObjectsModel.PageObjects.RegistrationPage;

/**
 * Class for Demo Web Shop Test
 */
public class AppTest 
{
	WebDriver driver = new FirefoxDriver();
	String gender ="Male";
	
	HomePage hmPage = new HomePage(driver);
	
	RegistrationPage regPage = new RegistrationPage(driver);
	
	public void launchSite() throws IOException {
		driver.get("https://demowebshop.tricentis.com/");
		//Home Page
		hmPage.clickOnRegisterLink();
		//Registration Page
		regPage.selectGender("Female");
		//regPage.newUserRegistration("Fathima", "BB", "FatimaBB@test12.com", "YouKnowMe123");
		regPage.newUserRegistrationFromDataSheet("UserDetails", 4);
	}
  
	public static void main(String []args) throws IOException {
		AppTest test = new AppTest();
		test.launchSite();
	}
    
}
