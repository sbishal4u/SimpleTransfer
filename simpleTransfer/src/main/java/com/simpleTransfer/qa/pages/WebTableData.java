package com.simpleTransfer.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebTableData 
{
	WebDriver driver;
	public WebTableData(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void getTableData()
	{
		
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@id='sortable1']/li"));
		System.out.println("Number of elements:" +ele.size());
		
		System.out.println("************************************************************************************");
		
		System.out.println("Transfast Bank are");
		for(int i=0; i<ele.size(); i++)
		{
			String transfast=ele.get(i).getAttribute("title");
		    System.out.println(transfast);
		}
		
		System.out.println("************************************************************************************");
		
		
		List<WebElement> ele1=driver.findElements(By.xpath("//ul[@id='sortable2']/li"));
		System.out.println("Number of elements:" +ele1.size());
		System.out.println("************************************************************************************");
		
		System.out.println("Nec Money Bank are");
		for(int i=0; i<ele1.size(); i++)
		{
			String nec=ele1.get(i).getAttribute("title");
		    System.out.println(nec);
			
		}
		
		System.out.println("************************************************************************************");		
		
	}

}
