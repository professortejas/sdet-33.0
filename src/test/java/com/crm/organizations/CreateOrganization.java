package com.crm.organizations;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_repository.BaseClass;
import generic_repository.ExcelUtility;
import generic_repository.JavaUtility;
import generic_repository.PropertiesUtility;
import generic_repository.WebDriverUtility;
import object_repository.CreateNewOrganizationPage;
import object_repository.HomePage;
import object_repository.OrganizationInformationPage;
import object_repository.OrganizationsPage;

public class CreateOrganization extends BaseClass {

	@Test
	public void createOrganizationTest() {
		hp.clickOnOrganizationsLink();
		OrganizationsPage op=new OrganizationsPage(driver);
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		int rowNo=1;
		int colNo=1;
		String organizationName = ExcelUtility.fetchSingleData(PropertiesUtility.fetchValue("organizationsSheetName"), rowNo, colNo)+JavaUtility.generateRandomNumber(1000);
		op.clickOnCreateOrganizationIcon();
		cnop.createNewOrganization(organizationName);	
		Assert.assertTrue(oip.getCreatedOrganizationTF().getText().contains(organizationName));
		Reporter.log("TC Pass", true);
	}
}
