package come.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.crm.util.TestUtil;
import com.qa.crm.util.WebEventListener;

public class TestBase {
	
	public static WebDriver obj;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase() 
	{
		//load the properties file
		try
		{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\Windows10\\Desktop\\atika1\\FreeCRMTest\\src\\main\\java\\com\\qa\\crm\\config\\config.properties");
		prop.load(ip);
	}catch(FileNotFoundException e)
		{
		e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initialization() throws Exception
	{
		String browsername=prop.getProperty("browser");
		
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
			obj=new ChromeDriver();
		}
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\gecko\\geckodriver.exe");
			obj=new FirefoxDriver();
		}
		
		//creating object of WebEventListener class and EventFiring web driver class 
		e_driver=new EventFiringWebDriver(obj);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		obj=e_driver;
		
		
		obj.manage().window().maximize();
		obj.manage().deleteAllCookies();
		//now i don't want to specify the time here as it can be dynamic,so i can create a util for timeouts
		
		obj.manage().timeouts().pageLoadTimeout( TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		obj.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		obj.get(prop.getProperty("url"));
		
		
		
		
		
	}

}
