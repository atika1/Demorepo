package com.qa.crm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import come.qa.crm.base.TestBase;

public class LoginPage extends TestBase {
    
	
	
	// define web elements and fuctions/actions
	
	//we define object repository/page factory using @FindBy annotation-this is similar to obj.findelement...
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement CRMLogo;
	
	//initialize page factory 
	
	public LoginPage()
	{
		
		PageFactory.initElements(obj, this);
		
	}
	
	//methods
	
	public String getLoginTitle()
	{
		String title=obj.getTitle();
		System.out.println(title);
		return title;
	}
	
	public boolean getCRM_LOGO_IMAGE()
	{
		boolean flag=CRMLogo.isDisplayed();	
		System.out.println(flag);
		return flag;
	}
	
	//when we click on login it will return home page
	
	public HomePage getLogin(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
}
