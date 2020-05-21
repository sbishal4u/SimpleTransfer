package com.simpleTransfer.qa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	private static Logger log=LogManager.getLogger(TestBase.class);
	
	public static WebDriver driver;
	public FileInputStream file;
	public static Properties OR;
	public File f1;
	
	
	public void loadPropertiesFile() throws IOException
	{
		log.info("Loading Config Properties");	
		OR=new Properties();
		f1=new File(System.getProperty("user.dir")+"\\ConfigProperties\\config.properties");
		file=new FileInputStream(f1);
		OR.load(file);			
	}
	
	public void getBrowser(String browser)
	{
		
		if(System.getProperty("os.name").contains("Window"))
		{
			System.out.println(System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
				driver= new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome"))
					{
						System.out.println(System.getProperty("user.dir"));
						System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
						//ChromeOptions opt=new ChromeOptions();
						//opt.setHeadless(true);
						driver= new ChromeDriver();
					}			
		}
		
		else if(System.getProperty("os.name").contains("Mac"))
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"\\Drivers\\geckodriver");
				driver= new FirefoxDriver();
			}
			
			else if(browser.equalsIgnoreCase("Chrome"))
			{
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver");
				driver= new ChromeDriver();
			}		
			
		}	
		
		driver.manage().window().maximize();
		driver.get(OR.getProperty("url"));
			
	}
	




}
