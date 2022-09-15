package SeleniumPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtReport {
	ExtentSparkReporter reporter; //Path, look and feel report
	ExtentReports reports; //aatch reporter and env variable
	ExtentTest test; //to create entries

	@Test
	public void generateReport() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		reporter = new ExtentSparkReporter("./Reports/Facebook.html");
		reporter.config().setDocumentTitle("VTiger");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("smoke");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Browser Version", "105");
		reports.setSystemInfo("Reporter Name", "Pavan");
		reports.setSystemInfo("Build No", "5.3.1");
		reports.setSystemInfo("OS", "Windows 11");
		
		test = reports.createTest("Flipkart");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path="../Testyantra/Errorshot/eshot.png";
		File dest = new File(path);
		Files.copy(src, dest);
		
		test.addScreenCaptureFromPath(path);
		
		test.log(Status.FAIL, "Got Failed");
		reports.flush();	
		driver.close();
	}
}
