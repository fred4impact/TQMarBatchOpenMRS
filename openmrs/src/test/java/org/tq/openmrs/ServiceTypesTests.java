package org.tq.openmrs;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tq.openmrs.pages.LoginPage;
import org.tq.openmrs.pages.ServiceTypesPage;
import org.tq.utility.BaseClass;
import org.tq.utility.Utility;

import jxl.read.biff.BiffException;

public class ServiceTypesTests extends BaseClass {
	 
	@Parameters({ "username","password"})
	@Test(description ="Validate Service Type",priority=1,groups={"sanity","ui","regression"})
	public void validateServiceType( String username,String password) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver); 
		login.login(username,password);
		ServiceTypesPage servicePage = new ServiceTypesPage(driver);
		boolean result = servicePage.verifyServiceType("Urology");
		Assert.assertTrue(result);
	}
	 
	@DataProvider(name="DP")
	public String[][] feedData() throws BiffException, IOException
	{
		String data[] [] = Utility.readXLSFile();
		return data;
	}
	
 
	@Test(description ="Validate Service Type",priority=2,groups={"sanity","ui","regression"},dataProvider="DP")
	public void validateServiceType(String serviceType  ) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver); 
		login.login("Admin","Admin123");
		ServiceTypesPage servicePage = new ServiceTypesPage(driver);
		boolean result = servicePage.verifyServiceType(serviceType);
		Assert.assertTrue(result);
	}
	
	
	
	
	
	
	
	
	
}
