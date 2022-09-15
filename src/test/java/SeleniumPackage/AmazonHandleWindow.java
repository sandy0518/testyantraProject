package SeleniumPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AmazonHandleWindow {
	@Test
	public void handleAmaWin() throws Exception {
		WebDriver driver =new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		WebElement mobiles = driver.findElement(By.linkText("Mobiles")); 
		WebElement todaysDeals = driver.findElement(By.linkText("Today's Deals"));
		WebElement cusService = driver.findElement(By.linkText("Customer Service"));
		WebElement books = driver.findElement(By.linkText("Books"));

		Actions action=new Actions(driver);
		action.contextClick(mobiles).perform();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		action.contextClick(todaysDeals).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);


		action.contextClick(cusService).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);


		action.contextClick(books).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		String parentWindow = driver.getWindowHandle();
		Set<String> windowId = driver.getWindowHandles();
		
		for(String id:windowId) {
			String title = driver.switchTo().window(id).getTitle();
			if(!title.contains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
				driver.close();
			}
		}
		
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow);
		driver.close();
	}
}
