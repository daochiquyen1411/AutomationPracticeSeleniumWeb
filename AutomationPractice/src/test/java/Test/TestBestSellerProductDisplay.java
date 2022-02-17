package Test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainPage.CasualDressesPage;
import MainPage.LoginUserPage;
import MainPage.MainPage;
import MainPage.OrderPage;
import MainPage.PaymentPage;
import MainPage.UserPage;
import Utilities.ActionKeyword;
import Utilities.Configuration;
import Utilities.DriverFactory;

public class TestBestSellerProductDisplay extends BaseTest{
	@BeforeMethod
	public void setUp() {
		Configuration configuration = new Configuration();
		Properties prop = configuration.loadCongifPropertiesFile("src/main/resources/config.properties");
		this.driver = DriverFactory.getDriver(prop.getProperty("browser"));
		ActionKeyword actionKeyword = new ActionKeyword(this.driver);
		actionKeyword.navigate(prop.getProperty("url"));
	}
	
	@org.testng.annotations.Test
	public void Test7BestSellerProductVisible() throws Exception {
		MainPage mainPage = new MainPage(this.driver);
		mainPage.toBestSellerFrame();
		Assert.assertTrue(mainPage.checkIf7ProductIsDisplay(), "7 best selling product loading fail");	
	}
	
	
	@AfterMethod
	public void tearDown() {
		this.driver.quit();
	}
}
