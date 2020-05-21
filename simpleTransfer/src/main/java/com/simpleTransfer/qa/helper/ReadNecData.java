package com.simpleTransfer.qa.helper;

public class ReadNecData 
{
	String excelPath=System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
	ExcelReader excel;
	
	public String ReadNecexcelData()
	{
		excel= new ExcelReader(excelPath);
		int rCount=excel.getRowCount(1);
		System.out.println(rCount);
		
		for(int i=1;i<=rCount;i++)
		{
			String data=excel.getCellDatas(1, i, "NECBank");
			System.out.println(data);
		}
		return excelPath;
		
	}
	
	public static void main(String[] args) 
	{
		ReadNecData rr=new ReadNecData();
		rr.ReadNecexcelData();
	}

}
