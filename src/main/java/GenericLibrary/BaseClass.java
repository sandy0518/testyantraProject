package GenericLibrary;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import ObjectRepository.HomePageClass;
import ObjectRepository.LoginPageClass;

public class BaseClass {
	public PropertyFileUtility pFU=new PropertyFileUtility();
	public WebDriver driver;
	public WebDriverUtility wUtil=new WebDriverUtility();
	public ExcelFileUtility eFU=new ExcelFileUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void creConnWithDB() {
		System.out.println("========== Create Connection with DataBase===========");
	}
//	@org.testng.annotations.Parameters("browser")
	
	@BeforeClass(groups= {"smoke","regression"})
	public void openBrowser() throws Throwable {
		System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
		System.out.println("========== Openning Browser===========");
		String Browser = pFU.readDataFromPropertyFile("browser");
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			driver=new EdgeDriver();
		}
		
//		driver=new FirefoxDriver();
//		driver=new ChromeDriver();
//		driver=new EdgeDriver();
		wUtil.maximizeWindow(driver);
		sdriver = driver;
		wUtil.waitForPageLoad(driver);
	}
	
	@BeforeMethod(groups= {"smoke","regression"})
	public void login() throws Throwable{
		System.out.println("========== Logging into the Application ============");
		driver.get(pFU.readDataFromPropertyFile("url"));
		LoginPageClass lpc=new LoginPageClass(driver);
		lpc.login(pFU.readDataFromPropertyFile("username"), pFU.readDataFromPropertyFile("password"));
	}
	
	@AfterMethod(groups= {"smoke","regression"})
	public void logout() throws InterruptedException {
		System.out.println("=========Logging out from the Application===========");
		HomePageClass hpc=new HomePageClass(driver);
		hpc.logOut(driver);
	}
	
	@AfterClass(groups= {"smoke","regression"})
	public void closeBrowser() {
		System.out.println("============Closing Browser============");
		driver.close();
	}

	@AfterSuite(groups= {"smoke","regression"})
	public void closeConnWithDB() {
		System.out.println("=========== Closing connection with DataBase ===========");
	}
}
