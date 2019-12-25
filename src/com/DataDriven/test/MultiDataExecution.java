package com.DataDriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MultiExecute.MultiData;

public class MultiDataExecution {
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SABARISH\\Downloads\\chromedriver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
   
		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		
	}
@DataProvider
	
	public Iterator<Object[]> GetAlldata()
	{
		ArrayList<Object[]> datatest=MultiData.getDataFromExcel();
		return datatest.iterator();
	}
	
	@Test(dataProvider="GetAlldata")

	
	public void ExecuteAll(String firstname,String lastname,String phone,String email,String country) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(email);
		WebElement element=driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(element);
		select.selectByVisibleText(country);
		driver.findElement(By.xpath("//input[@name='register']")).submit();
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void CloseBrowse()
	{
	driver.quit();
	
	}

}
