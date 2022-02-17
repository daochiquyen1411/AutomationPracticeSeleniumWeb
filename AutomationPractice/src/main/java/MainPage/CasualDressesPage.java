package MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;
import Utilities.ActionKeyword;

public class CasualDressesPage extends BasePage{
	private ActionKeyword actions;
	private WebElement imgDress,btnAddToCart,btnCheckOut;
	public CasualDressesPage(WebDriver driver) {
		super(driver);
		actions = new ActionKeyword(this.driver);
		// TODO Auto-generated constructor stub
	}

	public OrderPage toOrderPage() {
		imgDress = actions.waitElementVisible("xpath;//img[@title='Printed Dress']");
		actions.moveToElement(imgDress);
		
		btnAddToCart = actions.waitElementVisible("xpath;//span[normalize-space()='Add to cart']");
		actions.click(btnAddToCart);
		
		btnCheckOut = actions.waitElementVisible("xpath;//span[normalize-space()='Proceed to checkout']");
		actions.click(btnCheckOut);
		
		return new OrderPage(this.driver);
	}
}
