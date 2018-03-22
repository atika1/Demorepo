package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import come.qa.crm.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement first_name;
	
	@FindBy(id="surname")
	WebElement last_Name;
	
	@FindBy(name="client_lookup")
	WebElement Company;
	
	
	@FindBy(xpath="//input[@class='button' and @value='Save']")
	WebElement Save;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(obj, this);
	}
	
	public boolean verifyLabel()
	{
		return contactLabel.isDisplayed();
	}
	
	public void selectName(String name)
	{
		obj.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input")).click();
	}

	//create method to fill the form (new contact link form)
	
	public void NewContact_form(String title1,String fname,String lname,String Comp)
	
	{
	Select dp=new Select(title);
	dp.selectByVisibleText(title1);
	first_name.sendKeys(fname);
	last_Name.sendKeys(lname);
	Company.sendKeys(Comp);
	
	Save.click();
	
			
	}
}
