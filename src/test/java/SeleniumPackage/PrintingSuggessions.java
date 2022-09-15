package SeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintingSuggessions {
	@Test

	public void suggFromSearchBar() {
		WebDriver driver =new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		WebElement SearchTF = driver.findElement(By.xpath("//input[@type='text']"));
		SearchTF.sendKeys("samsung");
//		WebElement SearchButton = driver.findElement(By.xpath("//*[name()='svg' and @width='20']"));
//		SearchButton.click();
		List<WebElement> searchSugg = driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']/li"));
		for(int i=0;i<searchSugg.size();i++) {
			String printSugg = searchSugg.get(i).getText();
			System.out.println(printSugg);
		}
		driver.close();
	}
}
