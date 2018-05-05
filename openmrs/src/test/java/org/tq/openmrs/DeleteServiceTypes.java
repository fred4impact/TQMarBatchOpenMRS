package org.tq.openmrs;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.tq.openmrs.pages.LoginPage;
import org.tq.openmrs.pages.ServiceTypesPage;
import org.tq.utility.BaseClass;
//Adding lines by TEster1
public class DeleteServiceTypes extends BaseClass {
	 
	 
	@Parameters({ "username","password"})
	@Test(description ="Validate Service Type",priority=1,groups={"sanity","ui","regression"})
	public void deleteServiceType( String username,String password) throws InterruptedException
	{
		LoginPage login = new LoginPage(driver); 
		login.login(username,password);
		
		ServiceTypesPage servicePage = new ServiceTypesPage(driver);		
		boolean result = servicePage.deleteServiceType("Urology");
		Assert.assertTrue(result);
		
		result = servicePage.verifyServiceType("Urology");
		Assert.assertFalse(result);
	}
	
	
	
	
	
	
	
	
	
	
	
}
