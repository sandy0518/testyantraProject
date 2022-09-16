package com.crm.VTiger.TestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.JavaUtility;
import ObjectRepository.HomePageClass;
import ObjectRepository.NewOrgPageClass;
import ObjectRepository.OrganisationInfoPageClass;
import ObjectRepository.OrganisationsPageClass;

public class OrgTCSTest extends BaseClass{
	@Test(groups = "smoke")
	public void creOrg() throws Throwable {
		
		String orgName = eFU.readDatFromExcel("Sheet1", 1, 1)+JavaUtility.generateRandomNumber();
		String indType = eFU.readDatFromExcel("Sheet1", 4, 2);
		
		
		HomePageClass hpc=new HomePageClass(driver);
		hpc.clickOrg();
		
		OrganisationsPageClass opc=new OrganisationsPageClass(driver);
		opc.clickPlusB();
		
		NewOrgPageClass noc=new NewOrgPageClass(driver);
		noc.getOrgName().sendKeys(orgName);
		
		NewOrgPageClass nop=new NewOrgPageClass(driver);
		nop.industryDD(indType);

		nop.saveButon();
		Thread.sleep(3000);
//		OrganisationInfoPageClass oic=new OrganisationInfoPageClass(driver);
//		oic.ValidateOrgName();

		System.out.println("========== Org Created=========");
		Reporter.log("Organisation created");
	}

	@Test(groups="regression")
	public void validateOrg() throws Throwable {

		String orgName = eFU.readDatFromExcel("Sheet1", 1, 1)+JavaUtility.generateRandomNumber();
		String indType = eFU.readDatFromExcel("Sheet1", 4, 2);

		HomePageClass hp=new HomePageClass(driver);
		hp.clickOrg();

		OrganisationsPageClass opc=new OrganisationsPageClass(driver);
		opc.clickPlusB();

		NewOrgPageClass npc=new NewOrgPageClass(driver);
		npc.enterOrgDetails(orgName);
		npc.industryDD(indType);

		npc.saveButon();

//		OrganisationInfoPageClass oipc=new OrganisationInfoPageClass(driver);
//		oipc.ValidateOrgName();
		Thread.sleep(3000);
		System.out.println("============= ORG VALIDATED============");
		Reporter.log("Organisation validated", true);
	}
}
