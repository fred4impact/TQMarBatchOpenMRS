package org.tq.openmrs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tq.utility.BaseClass;
//PageObject class has parameterized constructor
public class ServiceTypesPage  {

	WebDriver driver;
	
	By pageListWE = By.cssSelector(BaseClass.objPro.getProperty("pageListCss"));
	
	public ServiceTypesPage(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	public boolean addServiceType(String serviceName)
	{
		return true;
	}
	public boolean updateServiceType(String serviceName)
	{
		return true;
	}
	public boolean deleteServiceType(String serviceName)
	{
		return true;
	}
	
	public  boolean verifyServiceType(String serviceName) throws InterruptedException 
	{
		Thread.sleep(10000);
		List<WebElement> pageList = driver.findElements(pageListWE );
		System.out.println("The number of the pages::" + pageList.size());
		List<WebElement> tdList = null;
		boolean result = false;
		outer:
		for(int i=1;i<=pageList.size();i=i+1)//outer
		{
			tdList= driver.findElements(By.cssSelector("#appointmentTypesTable>tbody>tr>td:nth-of-type(1)"));
			System.out.println("The number of Items in the table::: " +tdList.size());
			for(int j=0;j<tdList.size();j=j+1)//inner
			{
				System.out.println(tdList.get(j).getText());
				if(tdList.get(j).getText().equals(serviceName))
				{
					result = true;
					break outer;
				}
			}
			System.out.println("value of i :: " + i);
			//Identify the list again
			pageList = driver.findElements(By.cssSelector("#appointmentTypesTable_paginate>span>a"));
			pageList.get(i).click();
			 
		}
		return result;
		
	}
}
