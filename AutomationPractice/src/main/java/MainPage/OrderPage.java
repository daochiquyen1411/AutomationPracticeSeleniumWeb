package MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;
import Utilities.ActionKeyword;

public class OrderPage extends BasePage{
	private ActionKeyword actions;
	private WebElement btnCheckout,checkboxTerms;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		actions = new ActionKeyword(this.driver);
		// TODO Auto-generated constructor stub
	}

	public PaymentPage Order() throws Exception {
		btnCheckout = actions.waitElementVisible("xpath;//a[@class='button btn btn-default standard-checkout button-medium']");
		actions.click(btnCheckout);
		
		btnCheckout = actions.waitElementVisible("xpath;//button[@name='processAddress']");
		actions.click(btnCheckout);
		
		actions.scrollPageUsingJs(300);
		checkboxTerms = actions.findElement("xpath;//input[@id='cgv']");	
		actions.click(checkboxTerms);
		
		btnCheckout = actions.waitElementVisible("css;button[name='processCarrier'] span");
		actions.click(btnCheckout);
		
		return new PaymentPage(this.driver);
	}
}
