package com.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader1;

public class HandleWebtable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SABARISH\\Downloads\\chromedriver\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		
		 String BeforeXpath_Company= "//*[@id=\"customers\"]/tbody/tr[";
		 String AfterXpath_Company="]/td[1]";
		
		 
		 String BeforeXpath_Contact= "//*[@id=\"customers\"]/tbody/tr[";
		 String AfterXpath_Contact="]/td[2]";
		 
		 
		 String BeforeXpath_Country= "//*[@id=\"customers\"]/tbody/tr[";
		 String AfterXpath_Country="]/td[3]";
		 
		 Xls_Reader1 reader=new Xls_Reader1("C:\\Users\\SABARISH\\eclipse-workspace\\TestDataDriven\\src\\com\\TestData\\TestDataSheet.xlsx");
		 if(!reader.isSheetExist("WebTable"))
		 {
			 reader.addSheet("WebTable");
		 }
		 reader.addColumn("WebTable", "Company");
		 reader.addColumn("WebTable", "Contact");
		 reader.addColumn("WebTable", "Country");
		 
		 
		 for(int i=2;i<=7;i++)
		 {
			 String ActualXpath_Company=BeforeXpath_Company+i+AfterXpath_Company;
			 String Company=driver.findElement(By.xpath(ActualXpath_Company)).getText();
			 System.out.println(Company);
			 reader.setCellData("WebTable", "Company", i, Company);
			 
			 String ActualXpath_Contact=BeforeXpath_Contact+i+AfterXpath_Contact;
			 String Contact=driver.findElement(By.xpath(ActualXpath_Contact)).getText();
			 System.out.println(Contact);
			 reader.setCellData("WebTable", "Contact", i, Contact);
			 
			 String ActualXpath_Country=BeforeXpath_Country+i+AfterXpath_Country;
			 String Country=driver.findElement(By.xpath(ActualXpath_Country)).getText();
			 System.out.println(Country);
			 reader.setCellData("WebTable", "Country", i, Country);
			 
			 System.out.println("*******************************");
			 
		 }
		 
		 
	}

}
