package GenericLibrary;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method is for maximising the window
	 * @author saisandeep
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is for implicitwait
	 * @author saisandeep
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * This method is for explicitwait
	 * @author saisandeep
	 * @param driver
	 * @param ele
	 */
	public void waitForVisisbilityofElement(WebDriver driver, WebElement ele) {
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
		wb.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * This method is used to select by index
	 * @author saisandeep
	 * @param ele
	 * @param index
	 */
	public void selectElementByIndex(WebElement ele, int index) {
		Select select=new Select(ele);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to select by visibletext
	 * @author saisandeep
	 * @param ele
	 * @param vText
	 */
	public void selectElementByVisibletext(WebElement ele, String vText) {
		Select select=new Select(ele);
		select.selectByVisibleText(vText);
	}

	/**
	 * This method is used to select by value
	 * @author saisandeep
	 * @param ele
	 * @param value
	 */
	public void selectElementByValue(WebElement ele, String value) {
		Select select=new Select(ele);
		select.selectByVisibleText(value);
	}

	/**
	 * This method is used to give DD is mutiple or not
	 * @author saisandeep
	 * @param ele
	 * 
	 */
	public void dDisMultiple(WebElement ele) {
		Select select=new Select(ele);
		select.isMultiple();
	}

	/**
	 * This method is used to get Options from the Dropdown
	 * @author saisandeep
	 * @param ele
	 * 
	 */
	public void getDDOptions(WebElement ele) {
		Select select=new Select(ele);
		List<WebElement> list = select.getOptions();
		int listCount=0;
		for(WebElement dDList:list) {
			listCount++;
			System.out.println(dDList.getText());
		}
		System.out.println("The count of options is "+listCount);
	}
	
	
	/**
	 * This method is used to make action on administratorImage
	 * @author saisandeep
	 * @param driver
	 * @param ele
	 */
	public void mouseOverAction(WebDriver driver, WebElement ele) {
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();
	}
	
	
	public void switchWindow(WebDriver driver) {
		Set<String> childWindow = driver.getWindowHandles();
		System.out.println(childWindow);
		for(String cW:childWindow) {
			driver.switchTo().window(cW);
		}
	}
}
