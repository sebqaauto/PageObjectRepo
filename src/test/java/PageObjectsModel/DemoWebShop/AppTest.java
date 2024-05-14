package PageObjectsModel.DemoWebShop;

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
public class AppTest 
{
	WebDriver driver = new FirefoxDriver();
	String gender ="Male";
	
	HomePage hmPage = new HomePage(driver);
	JDBCHelper jdbcHelper = new JDBCHelper();
	
	RegistrationPage regPage = new RegistrationPage(driver);
	UIHelper helper = new UIHelper(driver);
	
	public void launchSite() throws IOException {
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Home Page
		for(int i=1; i<=4; i++) {
		hmPage.clickOnRegisterLink();
		//Registration Page
		regPage.selectGender("Female");
		//regPage.newUserRegistration("Fathima", "BB", "FatimaBB@test12.com", "YouKnowMe123");
		//regPage.newUserRegistrationFromDataSheet("UserDetails", i);
		//regPage.getEmailAndAddToDataSheet("Login");
		//regPage.logOut();
		String title = helper.getPageTitle();
		helper.takeSnap(title);
		}
	}
	
	public void launchDB() throws SQLException, ClassNotFoundException {
		jdbcHelper.interactWithDB();
	}
  
	public static void main(String []args) throws IOException, SQLException, ClassNotFoundException {
		AppTest test = new AppTest();
		test.launchSite();
		//test.launchDB();
	}
    
}
