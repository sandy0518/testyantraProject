package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FBPrintColor {
	@Test

	public void printColor() {
		WebDriver driver =new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		WebElement getcolor = driver.findElement(By.name("login"));
		String color = getcolor.getCssValue("color");
		System.out.println(color);
	}
}
