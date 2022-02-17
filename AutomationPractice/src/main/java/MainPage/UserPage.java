package MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;
import Utilities.ActionKeyword;

public class UserPage extends BasePage{
	
	private ActionKeyword actions;
	private WebElement btnDresses, btnCasualDresses;
	
	public UserPage(WebDriver driver) {
		super(driver);
		actions = new ActionKeyword(this.driver);
		// TODO Auto-generated constructor stub
	}

	public CasualDressesPage toCasualDressesPage() {
		btnDresses = actions.waitElementVisible("xpath;//*[@id=\"block_top_menu\"]/ul/li[2]/a");
		actions.moveToElement(btnDresses);
		
		btnCasualDresses = actions.waitElementVisible("css;li[class='sfHover'] a[title='Casual Dresses']");
		actions.click(btnCasualDresses);
		
		return new CasualDressesPage(this.driver);
	}
	
}
