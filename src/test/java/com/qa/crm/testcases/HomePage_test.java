package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

import come.qa.crm.base.TestBase;

public class HomePage_test extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	
	ContactsPage contactpage;
	
	public HomePage_test()
	{
		super();
	}
	
	@BeforeMethod
	public void homepage_launch() throws Exception
	{
		initialization();
		Thread.sleep(1000);
		testutil=new TestUtil();
		contactpage=new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
				
	}
	
	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String title1=homepage.get_title();
		Assert.assertEquals(title1,"CRMPRO","title did not match");
	}
	
	@Test(priority=2)
	public void verifyUserNameValidity()
	{
		//as the user naveen k is inside a frame
	testutil.switchToFrame();
	Assert.assertTrue(homepage.verifyUsername());
	}
	
	@Test(priority=3)
	public void verifyClickContacts()
	{
		//here contact is in a frame so we create a util method for frames
		testutil.switchToFrame();
		contactpage=homepage.click_contact();
	}
	
	@AfterMethod
	public void teardown()
	{
		obj.quit();
	}

}
