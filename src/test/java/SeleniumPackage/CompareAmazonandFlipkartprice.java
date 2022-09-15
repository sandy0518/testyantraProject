package SeleniumPackage;

import java.awt.Window;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CompareAmazonandFlipkartprice {
	@Test
	public void compareAmazonFlipkart() throws InterruptedException {

		String phone="iphone 13 pro";
		//		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		WebElement searchTF = driver.findElement(By.id("twotabsearchtextbox"));
		searchTF.sendKeys(phone);
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		WebElement iphone = driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone 13 Pro (128 GB) - Alpine Green')])[3]"));
		iphone.click();

		String parentWindow = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> allWindows = driver.getWindowHandles();
		for(String allWinH:allWindows) {
			driver.switchTo().window(allWinH);
		}
		System.out.println(driver.getTitle());
		WebElement iPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[5]"));
		String amazonPrice = iPrice.getText();
		System.out.println(amazonPrice);

		//		Flipkart Script  
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());

		WebElement closeLoginWindow = driver.findElement(By.xpath("//button[text()='✕']"));
		closeLoginWindow.click();

		WebElement searchTField = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchTField.sendKeys(phone);

		WebElement searchButon = driver.findElement(By.xpath("//button[@type='submit']"));
		searchButon.click();
		System.out.println("========All Window Handles======== \n"+allWindows);
		JavascriptExecutor js1=(JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1200)");

		WebElement phone1 = driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 Pro (Alpine Green, 128 GB)')]"));
		phone1.click();

		String parentWindow1 = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> allWindows1 = driver.getWindowHandles();
		for(String allWinH1:allWindows1) {
			driver.switchTo().window(allWinH1);
		}
		
		Thread.sleep(2000);

		WebElement flipkartIphone = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']"));
		String fKiphonePrice = flipkartIphone.getText();
		System.out.println(fKiphonePrice);
		
		String flipkartPrice = fKiphonePrice.replaceAll("[^0-9]", "");
		String AmazPrice = amazonPrice.replaceAll("[^0-9]", "");
		System.out.println("price after replacing "+flipkartPrice);
		
		if(iPrice.equals(flipkartPrice)) {
			System.out.println("Both Amazon and Flipkart prices are same ");
		}
		else {
			System.out.println("Prices are different");
		}
		driver.close();
	}
}
