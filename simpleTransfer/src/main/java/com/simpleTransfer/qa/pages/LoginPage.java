package com.simpleTransfer.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simpleTransfer.qa.helper.DropdownHelper;
import com.simpleTransfer.qa.helper.ExcelReader;

public class LoginPage 
{
	ExcelReader excel;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='Email']")
    private WebElement userName;
	
	@FindBy(xpath = "//input[@id='Password']")
    private WebElement passWord;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary']")
    private WebElement loginButton;
	
	@FindBy(xpath = "//span[contains(text(),'Correspondents')]")
    private WebElement clickCorrespondant;
	
	@FindBy(xpath = "//a[contains(text(),'Bank Mapper')]")
    private WebElement bankMapper;
	
	@FindBy(xpath = "//div[@class='page-toolbar']")
    private WebElement clickBank;
	
	@FindBy(xpath = "//select[@id='CountryCode']")
    private WebElement dropDown;
	
	@FindBy(xpath = "//select[@id='CountryCode']/option[2]")
    private WebElement dropDownText;
	
	@FindBy(xpath = "//ul[@id='sortable1']/li")
    private WebElement transfastBankData;
	
	
	
	
	public void GetLogin(String Username, String Password) throws InterruptedException
	{
		userName.sendKeys(Username);
		passWord.sendKeys(Password);
		Thread.sleep(000);
		loginButton.click();	
		Thread.sleep(5000);
	}
	
	public void clickCorrespondant() throws InterruptedException
	{
		clickCorrespondant.click();
		bankMapper.click();
		Thread.sleep(2000);
		//driver.navigate().refresh();
	}
	
	public void clickBankMap() throws InterruptedException
	{
		clickBank.click();
		Thread.sleep(2000);
		//driver.navigate().refresh();
		
	}
	
	public void getValuefromDropDown() throws InterruptedException
	{
		String text=dropDownText.getText();
		new DropdownHelper().SelectUsingVisibleText(dropDown, text);		
		Thread.sleep(3000);
	}
	
	public void getAttributeTest()
	{
		
		
		WebElement From= driver.findElement(By.xpath("//ul[@id='sortable2']/li[@data-value=0020]"));
		
		WebElement To= driver.findElement(By.xpath("//ul[@id='sortable2']/li[2]"));
		
		 Actions act=new Actions(driver);
		 act.dragAndDrop(From, To).build().perform();
		 
		 
		
		
		
		
		
			
	}
	
	
		
	
}
