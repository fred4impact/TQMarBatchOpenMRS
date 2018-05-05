package org.tq.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.qameta.allure.Attachment;

public class BaseClass {
	
	protected WebDriver driver;
	public static Properties objPro ;
	
	@BeforeSuite(alwaysRun=true)
	public void beforeTestSuite() throws Exception 
	{
		Properties pro = new Properties();
		pro.load(new FileInputStream(new File("config.properties")));
		
		objPro = new Properties();
		objPro.load(new FileInputStream(new File("openmrs.properties")));
		
		driver = DriverFactory.getDriverInstance();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@AfterSuite(alwaysRun=true)
	public void afterTestSuite()
	{
		DriverFactory.deactivateDriverInstance();
	}
	@Attachment(value = "Screenshot of {0}", type = "image/png")
	public byte[] saveScreenshot(String name, WebDriver driver) {
		return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
 
	public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
		iHookCallBack.runTestMethod(iTestResult);
		if (iTestResult.getThrowable() != null) {
			this.saveScreenshot(iTestResult.getName(), driver);
		}
	}
 
}
