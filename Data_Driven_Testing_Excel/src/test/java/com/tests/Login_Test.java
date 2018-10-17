package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.Excel_Utility;

public class Login_Test {

	WebDriver driver;
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A07208trng_b4a.03.28\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.phptravels.net/admin");
		Thread.sleep(10000);
	}
	@Test
	public void loginOperation() throws InterruptedException
	{
		WebElement emailBox = null;
		WebElement pwdBox = null;
		WebElement loginButton = null;
		
		String excelPath = "C:\\Users\\A07208trng_b4a.03.28\\eclipse-workspace\\varshini\\Data_Driven_Testing_Excel\\src\\test\\resources\\credentials.xlsx";
		Excel_Utility exu = new Excel_Utility(excelPath);
		String sheetName = "admin";
		int rowCount = exu.getNumberOfRows(sheetName);
		int colCount = exu.getNumberOfColumns(sheetName);
		String email = null;
		String pwd = null;
		for(int i=1;i<rowCount;i++)
		{
			email = exu.getCellData(sheetName, i, 0);
			pwd = exu.getCellData(sheetName, i, 1);
			
			emailBox = driver.findElement(By.name("email"));
			pwdBox = driver.findElement(By.name("password"));
			loginButton = driver.findElement(By.xpath("//button[@type='submit']")); 
			
			emailBox.sendKeys(email);
			pwdBox.sendKeys(pwd);
			loginButton.click();
			
			Thread.sleep(6000);
			
			String pageTitle = driver.getTitle();
			if(pageTitle.equals("Dashboard"))
			{
				exu.setCellData(sheetName, i, 2, "PASS");
				driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
				Thread.sleep(10000);
			}
			else
			{
				exu.setCellData(sheetName, i, 2, "FAIL");
				emailBox.clear();
				pwdBox.clear();
			} 
		}
		Excel_Utility.writeAndSaveExcel(excelPath);
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
