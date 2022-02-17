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

public class TestMenuSubcategoriesDisplay extends BaseTest{
	@BeforeMethod
	public void setUp() {
		Configuration configuration = new Configuration();
		Properties prop = configuration.loadCongifPropertiesFile("src/main/resources/config.properties");
		this.driver = DriverFactory.getDriver(prop.getProperty("browser"));
		ActionKeyword actionKeyword = new ActionKeyword(this.driver);
		actionKeyword.navigate(prop.getProperty("url"));
	}
	
	
	@Test
	public void Test3MenuSubcategories() throws Exception {
		MainPage mainPage = new MainPage(this.driver);
		Assert.assertTrue(mainPage.checkIf3SubcategoriesIsDisplay(), "3 Subcategories dont display");
	}
	

	
	@AfterMethod
	public void tearDown() {
		this.driver.quit();
	}
}
