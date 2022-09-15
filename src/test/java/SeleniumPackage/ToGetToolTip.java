package SeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToGetToolTip {
@Test

	public static void lenskart() {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> toolTip = driver.findElements(By.xpath("//ul[@class='display-flex']/li[@class='menuItem']/a"));
		for(int i=0;i<toolTip.size();i++) {
			String titles = toolTip.get(i).getAttribute("title");
			System.out.println(titles);
		}
		driver.close();
	}
}
