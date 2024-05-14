package PageObjectsModel.DemoWebShop;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjectsModel.PageObjects.HomePage;
import PageObjectsModel.PageObjects.JDBCHelper;
import PageObjectsModel.PageObjects.RegistrationPage;
import PageObjectsModel.PageObjects.UIHelper;

/**
 * Class for Demo Web Shop Test
 */
public class AppTestNG 
{
	WebDriver driver;
	HomePage hmPage;
	JDBCHelper jdbcHelper;
	RegistrationPage regPage;
	UIHelper uiHelper;
	String gender ="Male";
	String title;
	
	@BeforeTest
	public void setUpDriver() {
		this.driver = new FirefoxDriver();
		this.hmPage = new HomePage(driver);
		this.jdbcHelper = new JDBCHelper();
		this.regPage = new RegistrationPage(driver);
		this.uiHelper = new UIHelper();
	} 
	
	@Parameters({"urlDemoWebShop"})
	@Test
	public void launchBrowser(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dependsOnMethods = "launchBrowser")
	public void userRegistration() throws IOException {
		//Home Page
		for(int i=1; i<=4; i++) {
		hmPage.clickOnRegisterLink();
		//Registration Page
		regPage.selectGender("Female");
		//regPage.newUserRegistration("Fathima", "BB", "FatimaBB@test12.com", "YouKnowMe123");
		regPage.newUserRegistrationFromDataSheet("UserDetails", i);
		regPage.getEmailAndAddToDataSheet("Login");
		regPage.logOut();
		}
	}
	
	@AfterTest
	public void takeSnapshoot() throws IOException {
		title = uiHelper.getPageTitle();
		uiHelper.takeSnap(title);
	}
	
	@Test
	public void launchDB() throws SQLException, ClassNotFoundException {
		jdbcHelper.interactWithDB();
	}
  
	
}
