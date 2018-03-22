package com.qa.crm.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.TestUtil;

import come.qa.crm.base.TestBase;

public class ContactsPage_Test extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public ContactsPage_Test()
	{
		super();
	}
	
	
	@BeforeMethod
	public void ContactsPageCheck() throws Exception
	{
		initialization();
		Thread.sleep(1000);
		
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactspage=new ContactsPage();
		testutil=new TestUtil();	
		
		homepage=loginpage.getLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		testutil.switchToFrame();
		
		contactspage=homepage.click_contact();
		Thread.sleep(2000);
				
	}
	
	@Test(priority=1)
	public void verifyContactLabelTest()
	{
		Assert.assertTrue(contactspage.verifyLabel(),"label not found");
	}
	
	@Test(priority=2)
	public void verifyName()
	{	
		contactspage.selectName("Bruce Lee");
	}
	
	@DataProvider()
	public Object[][] get_NewContact_details() throws IOException
	{
		Object[][] data=TestUtil.getTestdata();
		return data;
	}
	
	@Test(dataProvider="get_NewContact_details")
	public void fill_form(String title,String fname,String lname,String comp) throws Exception
	{
		homepage.clickonNewContacts();
		obj.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		contactspage.NewContact_form(title, fname, lname, comp);
	}
	
	@AfterMethod
	public void teardown()
	{
		obj.quit();
	}

}
