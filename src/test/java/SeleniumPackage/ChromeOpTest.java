package SeleniumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeOpTest {
	@Test
	public void chromeOpTest() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--incognito");
//		options.addArguments("--headless");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.facebook.com");
		driver.close();
	}
}
