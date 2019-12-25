package com.MultiExecute;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader1;

public class MultiData {
	
	static Xls_Reader1 reader;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		ArrayList<Object[]> MyData=new ArrayList<Object[]>();
		try {
			reader=new Xls_Reader1("C:\\Users\\SABARISH\\eclipse-workspace\\TestDataDriven\\src\\com\\TestData\\TestDataSheet.xlsx");	
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		for(int RowNum=2; RowNum<=reader.getRowCount("DataSheet");RowNum++)
		 
		{
			String firstname=reader.getCellData("DataSheet", "firstname", RowNum);
			String lastname=reader.getCellData("DataSheet", "lastname", RowNum);
			String phone=reader.getCellData("DataSheet", "phone", RowNum);
			String email=reader.getCellData("DataSheet", "email", RowNum);
			String country=reader.getCellData("DataSheet", "country", RowNum);
			Object ob[]= {firstname,lastname,phone,email,country};
			MyData.add(ob);
		}
		
		return MyData;
	}

}
