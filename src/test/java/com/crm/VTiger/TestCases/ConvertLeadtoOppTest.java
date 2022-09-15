package com.crm.VTiger.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.HomePageClass;
import ObjectRepository.LeadsPageClass;
import ObjectRepository.LoginPageClass;
import ObjectRepository.NewLeadsPageClass;

public class ConvertLeadtoOppTest {
	@Test

	public void conLeadtoOppTest() throws Throwable {
		WebDriver driver=new ChromeDriver();
		
		/*
		Making use of PropertyFileUtility present in GenericLibrary 
		to read Username, Password and url 
		*/
		PropertyFileUtility pFU=new PropertyFileUtility();
		String uN = pFU.readDataFromPropertyFile("username");
		String pwd = pFU.readDataFromPropertyFile("password");
		String uRL = pFU.readDataFromPropertyFile("url");
		
		/*
		 * Making Use of ExcelFileUtility present in GenericLibrary for sending data 
		 * into the text field
		 */
		ExcelFileUtility ef=new ExcelFileUtility();
		String fName = ef.readDatFromExcel("Sheet1", 7, 1)+JavaUtility.generateRandomNumber();
		String lName = ef.readDatFromExcel("Sheet1", 7, 2);
		String comName = ef.readDatFromExcel("sheet1", 10, 1);
		String fNameDDType = ef.readDatFromExcel("Sheet1", 7, 3);
		String assToDDType = ef.readDatFromExcel("Sheet1", 10, 2);
		
		/*
		 * Making Use of WebDriverUtility present in GenericLibrary for maximizing and
		 * implicitwait
		 */
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		driver.get(uRL);
		
		/*
		 * Making use of LoginPageClass present in ObjectRepositoty to perform login
		 */
		LoginPageClass lpc=new LoginPageClass(driver);
		lpc.login(uN, pwd);
		
		/*
		 * Making use of HomePageClass present in ObjectRepositoty to perform click on
		 * Leads module
		 */
		HomePageClass hpc=new HomePageClass(driver);
		hpc.getLeadLink().click();
		/*
		 * Making use of LeadsPageClass present in ObjectRepositoty to perform click on
		 * plus button in Leads page
		 */
		LeadsPageClass lepc=new LeadsPageClass(driver);
		lepc.clickPlusButton();
		
		/*
		 * Making use of NewLeadsPageClass present in ObjectRepositoty to send values into TextField
		 * 
		 */
		NewLeadsPageClass nlpc=new NewLeadsPageClass(driver);
		nlpc.fNameDD(fNameDDType);
		nlpc.sendvaluetoTf(fName, lName, comName);
		nlpc.getAssToRB().click();
		nlpc.assToDDown(assToDDType);
		nlpc.saveButon();
	}
}
