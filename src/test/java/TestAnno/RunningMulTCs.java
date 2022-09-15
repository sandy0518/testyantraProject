package TestAnno;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunningMulTCs {
	@BeforeSuite
	public void dBConnectionStarted() {
		System.out.println("Started DatBase Connection");
	}
	@BeforeTest
	public void crossBrowserTest() {
		System.out.println("crossBrowserTesting Started");
	}
	@BeforeClass
	public void openBrowser() {
		System.out.println("open the Browser");
	}
	@BeforeMethod
	public void login() {
		System.out.println("Log into the application");
	}
	@Test(priority=1)
	public void createOrgTest() {
		System.out.println("Organisation created");
	}
	@Test(priority=2)
	public void createContact() {
		System.out.println("Contact created");
	}
	@AfterMethod
	public void logOut() {
		System.out.println("LogOut from the application");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close the Browser");
	}
	@AfterTest
	public void crossBrowserTestClose() {
		System.out.println("crossBrowserTesting closed");
	}
	@AfterSuite
	public void dBConnectionClosed() {
		System.out.println("DatBase Connection closed");
	}
}
