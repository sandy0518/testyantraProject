package com.crm.VTiger.TestCases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.ExcelFileUtility;
import GenericLibrary.JSONFileUtility;
import GenericLibrary.JavaUtility;
import GenericLibrary.WebDriverUtility;
import ObjectRepository.ConInfoPageClass;
import ObjectRepository.HomePageClass;
import ObjectRepository.LoginPageClass;
import ObjectRepository.NewConPageClass;

public class ValidateContactNameTest extends BaseClass{
	
	@Test
	public void valContactname() throws Throwable {
		
		String fName = eFU.readDatFromExcel("Sheet1", 7, 1)+JavaUtility.generateRandomNumber();
		String lName = eFU.readDatFromExcel("Sheet1", 7, 2);
		String fNameType = eFU.readDatFromExcel("Sheet1", 7, 3);
		
		String organisationName="Severiaty Organisation";

		HomePageClass hpc=new HomePageClass(driver);
		hpc.clickContact();
		
		WebElement newContactsButton = driver.findElement(By.xpath("//img[@alt='Create Contact...']"));
		newContactsButton.click();


		NewConPageClass ncc=new NewConPageClass(driver);
		ncc.firstNameDD(fNameType);
		
		Thread.sleep(3000);
		ncc.fALName(fName, lName);

		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		ncc.getAddOrgNameButton().click();
		wUtil.switchWindow(driver);

		WebElement organisationSearchTF = driver.findElement(By.xpath("//input[@class='txtBox']"));
		organisationSearchTF.sendKeys(organisationName);
		WebElement searchButton = driver.findElement(By.xpath("//input[@name='search']"));
		searchButton.click();
		WebElement selectOrganisation = driver.findElement(By.xpath("//a[contains(text(),'Severiaty Organisation')]"));
		selectOrganisation.click();
		
		
		driver.switchTo().window(parentWindow);
		
		ncc.getSaveButton().click();
		
		ConInfoPageClass cipc=new ConInfoPageClass(driver);
		cipc.validateContact();

	}
}
