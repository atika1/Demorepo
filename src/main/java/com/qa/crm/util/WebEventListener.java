package com.qa.crm.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import come.qa.crm.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	//WebDriverEventListener is a selenium inbuilt interface available,it will automatically add unimplemented methods
	
	public void beforeNavigateTo(String url,WebDriver obj) {

		System.out.println("before navigate to:'"+url+"'");
		
	}
	
   public void afterNavigateTo(String url,WebDriver obj) {
		
		System.out.println("navigated to:'"+url+"'");
		
	}


   public void beforeClickOn(WebElement e, WebDriver obj) {
	
	   System.out.println("trying to click on:"+e.toString());
}

  public void afterClickOn(WebElement e, WebDriver obj) {
	
	  System.out.println("clicked"+e.toString());
	
}
  public void beforeNavigateBack(WebDriver obj) {

	  System.out.println("navigating back");
	  
  }	

	public void afterNavigateBack(WebDriver obj) {

		System.out.println("after navigating ");
		
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement e, WebDriver obj) {
	
		System.out.println("value of the element changed to"+e.toString());
		
	}

	public void beforeChangeValueOf(WebElement e, WebDriver obj) {

		System.out.println("new value of the element"+e.toString());
		
	}
	
 	public void onException(Throwable error, WebDriver obj) {
 		
    // throwable will throw an error as well as exception
		
 		System.out.println("Exception occured: " + error);
 			try {
 				TestUtil.getScreenshot();
 				} catch (IOException e) {
 					e.printStackTrace();
 				}
 	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}


	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}



	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

}
