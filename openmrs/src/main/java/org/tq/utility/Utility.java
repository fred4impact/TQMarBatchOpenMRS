package org.tq.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Utility {
 
	
	public static void unConditionalWait(long timeinMillis) throws InterruptedException
	{
		Thread.sleep(timeinMillis);
	}
	public static WebElement waitForVisiblityOfElement(WebDriver driver,long timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(null));
		return e;
	}
	public static String[][] readXLSFile( ) throws BiffException, IOException
	{
		File f = new File("InputData.xls");
		Workbook wb = Workbook.getWorkbook(f);
		
		//Fetch the sheet by passing sheet name
		//Sheet sheet = wb.getSheet("sanity");
		
		Sheet sheet[]= wb.getSheets();
		int rows = sheet[1].getRows();
		int columns = sheet[0].getColumns();
		String data[][] = new String [rows][columns];
		for(int i =0 ;i< rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				Cell cell= sheet[0].getCell(j,i);
				data[i][j]=cell.getContents();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
}
