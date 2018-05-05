package org.tq.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 * Responsible for Creating a Static Driver Object
 * Responsible for Deactivating the Driver Object
 * @author qa
 *
 */
public class DriverFactory
{
	private static WebDriver driver;
	private static WebDriver instantiateWebDriver() throws Exception
	{
		
		Properties pro = new Properties();
		pro.load(new FileInputStream(new File("config.properties")));
		
		if(pro.getProperty("browser").equals("chrome"))
		{
			System.out.println("in CH");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			 
		}
		else if(pro.getProperty("browser").equals("firefox"))
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
		return driver;
	}
	public static WebDriver getDriverInstance() throws Exception
	{
		if(driver==null)
		{
			driver = instantiateWebDriver();
			setDriver(driver);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		return driver;
		
	}
	public static void setDriver(WebDriver driver1)
	{
		 driver = driver1;
	}
	public static void deactivateDriverInstance()
	{
		driver =null;
		//driver.close();
	}
 
}
