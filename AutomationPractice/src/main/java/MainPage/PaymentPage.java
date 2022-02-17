package MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;
import Utilities.ActionKeyword;

public class PaymentPage extends BasePage{
	private ActionKeyword actions;
	WebElement btnPayByCheck,btnConfirmOrder,lblCompleteOrder;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		actions = new ActionKeyword(this.driver);
		// TODO Auto-generated constructor stub
	}
	
	public void payment() {
		btnPayByCheck = actions.waitElementVisible("css;a[title='Pay by check.'] span");
		actions.click(btnPayByCheck);
		
		btnConfirmOrder = actions.waitElementVisible("xpath;//span[normalize-space()='I confirm my order']");
		actions.click(btnConfirmOrder);
	}
	
	public boolean IsOrderComplete() {
		lblCompleteOrder = actions.waitElementVisible("xpath;//p[@class='alert alert-success']");
		if (lblCompleteOrder.isDisplayed()) {
			return true;
		}
		return false;
	}
	
}
