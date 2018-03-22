package com.qa.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import come.qa.crm.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Naveen K')]")
	WebElement textvalidity;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts_click;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement deals_link;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasks_link;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact_link;
	
	public HomePage()
	{
		PageFactory.initElements(obj,this);
	}
	
	
	public String get_title()
	{
		return obj.getTitle();
	}
	public boolean verifyUsername()
	{
		return textvalidity.isDisplayed();
	}
	public ContactsPage click_contact()
	{
		contacts_click.click();
		return new ContactsPage();
	}

	public DealsPage click_Deals()
	{
		deals_link.click();
		return new DealsPage();
	}
	
	public void clickonNewContacts()
	{
		//new contact link is on home page
		Actions action=new Actions(obj);
		action.moveToElement(contacts_click).build().perform();
		newContact_link.click();
		//now it will direct us to the contacts page so we have to create method in contacts page
	}
	
}
