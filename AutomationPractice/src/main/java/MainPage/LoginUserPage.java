package MainPage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;
import Utilities.ActionKeyword;
import Utilities.Configuration;

public class LoginUserPage extends BasePage{
	private ActionKeyword actions;
	Configuration configPropertiesHelper; 
    Properties prop;   
	private WebElement txtEmail,txtPassword,btnLoginUser;
	
	public LoginUserPage(WebDriver driver) {
		super(driver);
		actions = new ActionKeyword(this.driver);
		configPropertiesHelper = new Configuration(); 
		prop = configPropertiesHelper.loadCongifPropertiesFile("src/main/resources/config.properties");
		// TODO Auto-generated constructor stub
	}
	
	public UserPage toUserPage() {
		txtEmail = actions.waitElementVisible("xpath;//input[@id='email']");
		actions.sendText(txtEmail, prop.getProperty("email"));
		
		txtPassword = actions.waitElementVisible("xpath;//input[@id='passwd']");
		actions.sendText(txtPassword, prop.getProperty("password"));
		
		btnLoginUser = actions.waitElementVisible("xpath;//span[normalize-space()='Sign in']");
		actions.click(btnLoginUser);
		
		return new UserPage(this.driver);
	}
}
