package com.simpleTransfer.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.simpleTransfer.qa.helper.ReadNecData;
import com.simpleTransfer.qa.helper.ReadTransfastBankData;

public class DragAndDrop 
{
	WebDriver driver;
	public void DragnDrop()
	{
		ReadTransfastBankData b=new ReadTransfastBankData();
		String excelData= b.ReadTransfastBank();
		
		//Element which needs to drag.    		
    	WebElement From=driver.findElement(By.xpath("//ul[@id='sortable2']//span[contains(text(), '"+excelData+"')]"));
    	
    	
    	ReadNecData dd=new ReadNecData();
    	String excelData1=dd.ReadNecexcelData();
    	
    	 //Element on which need to drop.		
        WebElement To=driver.findElement(By.xpath("//ul[@id='sortable2']//span[contains(text(), '"+excelData1+"')]"));		
        
        Actions act=new Actions(driver);					

    	//Dragged and dropped.		
         act.dragAndDrop(From, To).build().perform();	
		
	}
	
	
	

}
