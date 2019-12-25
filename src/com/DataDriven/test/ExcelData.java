package com.DataDriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader1;

public class ExcelData {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SABARISH\\Downloads\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
   
		driver.get("http://newtours.demoaut.com/");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		
		
		
		
		Xls_Reader1 reader=new Xls_Reader1("C:\\Users\\SABARISH\\eclipse-workspace\\TestDataDriven\\src\\com\\TestData\\TestDataSheet.xlsx");
		//Add or write a new column as Status in the datasheet
		reader.addColumn("DataSheet", "Status");
		String firstname=reader.getCellData("DataSheet", "firstname", 2);
		String lastname=reader.getCellData("DataSheet", "lastname", 2);
		String phone=reader.getCellData("DataSheet", "phone", 2);
		String email=reader.getCellData("DataSheet", "email", 2);
		String country=reader.getCellData("DataSheet", "country", 2);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(email);
		WebElement element=driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(element);
		select.selectByVisibleText(country);
		driver.findElement(By.xpath("//input[@name='register']")).click();
		//once all the actions are performed write the status as pass
		reader.setCellData("DataSheet", "Status", 2, "Pass");
	}

}
