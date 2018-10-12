package com.elal.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;



public class TestBase {
	 protected static WebDriver driver;
	String URL = "https://www.elal.com/en/Israel/Pages/default.aspx";
	 

	public static WebDriver startBrowser(String browserName,String url){
		Reporter.log("====Start browser====",true);
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Slava/Desktop/Webdriver/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		driver= new  ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
		
	}

	
	public static void tearDown(){
		driver.quit();
		Reporter.log("======Stop browser======",true);
		
		
	}

}
