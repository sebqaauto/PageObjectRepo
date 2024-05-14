package demoPackage;


import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import PageObjectsModel.PageObjects.AmazonPage;

public class AmzTestNGSamsung {
	
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
	
	@Parameters({"searchSamsungKeyword1"})
	@Test
	public void searchAndAddSamsungGalaxy(String searchSamsungKeyword1) {
	amz.productSearch(searchSamsungKeyword1);
	System.out.println(searchSamsungKeyword1+ " is completed at "+System.currentTimeMillis());
	}

}

//<class name="PageObjectsModel.DemoWebShop.AmzTestNGApple"/>
//<class name="PageObjectsModel.DemoWebShop.AppTestNG"/>
