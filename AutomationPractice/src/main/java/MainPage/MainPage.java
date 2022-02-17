package MainPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;
import Utilities.ActionKeyword;


public class MainPage extends BasePage{

	private ActionKeyword actions;
	private WebElement btnBestSeller,btnDresses,btnCasualDresses,btnEveningDresses,btnSummerDresses,btnLogin;
	private List<WebElement> bestSellingProducts;

	
	public MainPage(WebDriver driver) {
		super(driver);
		actions = new ActionKeyword(this.driver);
	}
	
	public void toBestSellerFrame() {
		btnBestSeller = actions.waitElementVisible("xpath;//a[contains(text(),'Best Sellers')]");
		actions.scrollToElementUsingJs(btnBestSeller);
		actions.click(btnBestSeller);
				
	}
		
	public boolean checkIf7ProductIsDisplay() throws Exception {
		bestSellingProducts = actions.FindElements("xpath;//ul[contains(@class,'blockbestsellers')]//li");
		if (bestSellingProducts.size() == 7) {
			return true;
		}
		return false;
		
	}
	
	public LoginUserPage toLoginuserPage() throws Exception {
		btnLogin = actions.findElement("xpath;//a[normalize-space()='Sign in']");
		actions.click(btnLogin);
		return new LoginUserPage(this.driver);
	}
	
	public boolean checkIf3SubcategoriesIsDisplay() throws Exception {
//		actions.scrollPageUsingJs(-750);
		btnDresses = actions.findElement("xpath;//*[@id=\"block_top_menu\"]/ul/li[2]/a");
		actions.moveToElement(btnDresses);

		
		btnCasualDresses = actions.waitElementVisible("css;li[class='sfHover'] a[title='Casual Dresses']");
		btnEveningDresses = actions.waitElementVisible("css;li[class='sfHover'] a[title='Evening Dresses']");
		btnSummerDresses = actions.waitElementVisible("css;li[class='sfHover'] a[title='Summer Dresses']");
		
		if (btnCasualDresses.isDisplayed() && btnEveningDresses.isDisplayed() && btnSummerDresses.isDisplayed()) {
			return true;
		}
		return false;
	}
}
