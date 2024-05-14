package PageObjectsModel.DemoWebShop;


import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import PageObjectsModel.PageObjects.AmazonPage;

public class AmzTestNGApple {
	
	WebDriver driver;
	AmazonPage amz;
	
	
	@BeforeTest
	public void setUpDriver() {
	driver = new FirefoxDriver();
	amz = new AmazonPage(driver);
	}
	
	
	@Parameters({"urlAmz"})
	@Test
	public void launchSite(String url) {
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Parameters({"searchAppleKeyword1"})
	@Test(dependsOnMethods = "launchSite")
	public void searchAndAddiPhone(String searchText) {
	amz.productSearch(searchText);
	System.out.println(searchText+ " is completed at "+System.currentTimeMillis());
	}
	
	@Parameters({"searchAppleKeyword2"})
	@Test(dependsOnMethods = "launchSite")
	public void searchAndAddiPad(String searchText) {
	amz.productSearch(searchText);
	System.out.println(searchText+ " is completed at "+System.currentTimeMillis());
	}

}
