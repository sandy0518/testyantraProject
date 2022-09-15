package com.crm.VTiger.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.PropertyFileUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.ContactsPageClass;
import ObjectRepository.HomePageClass;
import ObjectRepository.LoginPageClass;
import ObjectRepository.NewConPageClass;

//@Listeners(GenericLibrary.ListenerImp.class)
public class CreateContactwithOrganisationTest extends BaseClass {
	@Test
	public void contactTest() throws Throwable {	
		
		
		String fName = eFU.readDatFromExcel("Sheet1", 7, 1)+JavaUtility.generateRandomNumber();
		String lName = eFU.readDatFromExcel("Sheet1", 7, 2);
		
		HomePageClass hpc=new HomePageClass(driver);
		hpc.clickContact();
		
		ContactsPageClass cpc=new ContactsPageClass(driver);
		cpc.newContactB();
		
		WebElement firstNameDD = driver.findElement(By.name("salutationtype"));
		wUtil.dDisMultiple(firstNameDD);
		wUtil.getDDOptions(firstNameDD);
//		Assert.assertEquals(false, true);
		Thread.sleep(3000);
		
		NewConPageClass npc=new NewConPageClass(driver);
		npc.fALName(fName, lName);
	}
}
