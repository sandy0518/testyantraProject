package com.crm.VTiger.TestCases;

import org.testng.annotations.Test;

import GenericLibrary.BaseClass;
import GenericLibrary.JavaUtility;
import ObjectRepository.HomePageClass;
import ObjectRepository.NewOrgPageClass;
import ObjectRepository.OrganisationInfoPageClass;
import ObjectRepository.OrganisationsPageClass;

public class ValidateOrganisationNameTest extends BaseClass{
	@Test
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

		OrganisationInfoPageClass oipc=new OrganisationInfoPageClass(driver);
		oipc.ValidateOrgName();

	}

}
