package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.JavaUtility;
import ObjectRepository.HomePageClass;
import ObjectRepository.NewOrgPageClass;
import ObjectRepository.OrganisationInfoPageClass;
import ObjectRepository.OrganisationsPageClass;

public class CreateOrganisationwithIndustryType extends BaseClass{
	
	@Test(retryAnalyzer = GenericLibrary.RetryAnalyserClass.class)
	public void creOrg() throws Throwable {
		
		String orgName = eFU.readDatFromExcel("Sheet1", 1, 1)+JavaUtility.generateRandomNumber();
		String indType = eFU.readDatFromExcel("Sheet1", 4, 2);
		
		
		HomePageClass hpc=new HomePageClass(driver);
		hpc.clickOrg();
//		Assert.assertEquals(false, true);
		
		OrganisationsPageClass opc=new OrganisationsPageClass(driver);
		opc.clickPlusB();
		
		NewOrgPageClass noc=new NewOrgPageClass(driver);
		noc.getOrgName().sendKeys(orgName);
		
		NewOrgPageClass nop=new NewOrgPageClass(driver);
		nop.industryDD(indType);

		Thread.sleep(3000);
		nop.saveButon();
		
		OrganisationInfoPageClass oic=new OrganisationInfoPageClass(driver);
		oic.ValidateOrgName();
	
	}

}
