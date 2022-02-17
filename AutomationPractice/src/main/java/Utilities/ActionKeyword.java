package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.management.OperationsException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionKeyword {
	public WebDriver driver;
	public Actions action;
	public WebDriverWait wait;
	
	public ActionKeyword(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigate(String url) {
		try {
			this.driver.get(url);
		}catch(WebDriverException e) {
			this.errorSnapShot();
			e.printStackTrace();
		}
	}
	
	public void errorSnapShot() {
		this.takeSnapShot("src/test/java/TestSnapshot/Error.png");
	}
	
	public void takeSnapShot(String fileWithPath) {
		try {
			TakesScreenshot scrShot =((TakesScreenshot)this.driver);
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(fileWithPath);
			FileUtils.copyFile(SrcFile, DestFile);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void click(WebElement element) {		
		action = new Actions(this.driver);	
		action.moveToElement(element).build().perform();
		element.click();
	}
	
	public void sendText(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
		}catch (WebDriverException e){
			this.errorSnapShot();
			e.printStackTrace();
		}
	}
	
	public WebElement waitElementToBeClickable(String value) {
		WebElement element = null;
		String locatorType = value.split(";")[0];
		String locatorValue = value.split(";")[1];
		
		switch (locatorType.toLowerCase()) {		
		case "xpath":
			try {
				wait = new WebDriverWait(this.driver,10);
				element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
			}catch (WebDriverException e){
				this.errorSnapShot();
				e.printStackTrace();
			}
			break;
		case "css":	
			try {
				wait = new WebDriverWait(this.driver,10);
				element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
			}catch (WebDriverException e){
				this.errorSnapShot();
				e.printStackTrace();
			}
			break;
		}
		
		return element;		
	}
	
	public WebElement waitElementVisible(String value) {
		WebElement element = null;
		String locatorType = value.split(";")[0];
		String locatorValue = value.split(";")[1];
		
		switch (locatorType.toLowerCase()) {		
		case "xpath":
			try {
				wait = new WebDriverWait(this.driver,10);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(locatorValue))));
			}catch (WebDriverException e){
				this.errorSnapShot();
				e.printStackTrace();
			}
			break;
		case "css":	
			try {
				wait = new WebDriverWait(this.driver,10);
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			}catch (WebDriverException e){
				this.errorSnapShot();
				e.printStackTrace();
			}
			break;
		}
		
		return element;
		
	}
	
	public WebElement findElement(String value) throws Exception {
		WebElement element = null;
		String locatorType = value.split(";")[0];
		String locatorValue = value.split(";")[1];
		switch (locatorType.toLowerCase()) {
		case "id":			
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case "tag":
			element = driver.findElement(By.tagName(locatorValue));
		case "link":
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case "class":
			element = driver.findElement(By.className(locatorValue));
			break;
		default:
			throw new Exception("Support FindElement with 'id' 'name' 'xpath' 'tag' 'link' 'css' 'class'");
		}
		return element;
	}
	
	public WebElement scrollToElementUsingJs(WebElement element) {
		((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", element);
		return element;
	}
	
	public List<WebElement> FindElements(String value) throws Exception
    {
        List<WebElement> elements = null;
        String locatorType = value.split(";")[0];
		String locatorValue = value.split(";")[1];
        switch (locatorType.toLowerCase())
        {
	        case "id":				
				elements = driver.findElements(By.id(locatorValue));
				break;
			case "name":
				elements = driver.findElements(By.name(locatorValue));
				break;
			case "xpath":
				elements = driver.findElements(By.xpath(locatorValue));
				break;
			case "tag":
				elements = driver.findElements(By.tagName(locatorValue));
			case "link":
				elements = driver.findElements(By.linkText(locatorValue));
				break;
			case "css":
				elements = driver.findElements(By.cssSelector(locatorValue));
				break;
			case "class":
				elements = driver.findElements(By.className(locatorValue));
				break;
            default:
                throw new Exception("Support FindElement with 'id' 'name' 'xpath' 'tag' 'link' 'css' 'class'");
        }
        return elements;
    }
	
	public void scrollPageUsingJs(int value) {
		 JavascriptExecutor js = (JavascriptExecutor) this.driver;
		 js.executeScript("window.scrollBy(0," + value + ")");
	}
	
	public void moveToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
}
