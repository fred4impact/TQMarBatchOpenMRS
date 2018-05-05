package org.tq.openmrs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersEx {

	WebDriver driver;
	
	@Parameters({"browserType"})
	@BeforeClass
	public void invokeBrowser(String browserType)
	{
		if(browserType.equals("CH"))
		{
			System.out.println("in CH");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			 
		}
		else if(browserType.equals("FF"))
		{
			System.out.println("in FF");
			System.setProperty("webdriver.firefox.driver","geckodriver.exe");
			driver= new FirefoxDriver();
			 
		}
		else
		{
			System.out.println("in IE");
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			 
		}
	}
	@BeforeMethod
	public void openApp()
	{
		driver.get("http://www.indeed.co.in");
	}
	@Parameters({"jobType","location"})
	@Test
	public void validateJS(String jobType,String location)
	{
		WebElement whatWE = driver.findElement(By.id("what"));
		whatWE.clear();
		whatWE.sendKeys(jobType);

		WebElement whereWE = driver.findElement(By.id("where"));
		whereWE.clear();
		whereWE.sendKeys(location);

		//<input id="fj" class="input_submit" value="Find Jobs" type="submit">
		driver.findElement(By.id("fj")).submit();
	}
	@Test
	public void m1()
	{
		
	}
}
