package com.qa.crm.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

import come.qa.crm.base.TestBase;

public class LoginPage_test extends TestBase {
	
	//create object of login page class
	LoginPage loginpg;
	HomePage homepage;
	
	//HERE FIRST WE WILL HAVE TO CALL THE SUPER CLASS CONSTRUCTOR AS WE NEED THE PROPERTIES TO BE LOADED FROM TEST BASE CLASS,so we create a constructor
		
		 public LoginPage_test()
		{
			super();
		}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		
		//calls the initialization method to launch chrome,firefox drivers from test base class
		initialization();
		Thread.sleep(1000);
		
		//create login page object
		 loginpg=new LoginPage();
	}

	
	@Test()
	public void validateTitle()
	{
		//calls the method where we had fetched the title and we had to create the object og LoginPage class as all the methods defined there are not static
	String title1=loginpg.getLoginTitle();
	Assert.assertEquals(title1, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		
	}
	
	@Test
	public void validateCRMLogo()
	{
	boolean img=loginpg.getCRM_LOGO_IMAGE();
	Assert.assertTrue(img);
	}
	
	@Test
	public void validatelogin() throws Exception
	{
		
		homepage=loginpg.getLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@AfterMethod()
	public void teardown()
	{
		obj.quit();
	}
	
	
}
