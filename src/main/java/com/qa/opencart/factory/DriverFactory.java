package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	Properties prop;
	
	/**
	 * This method will initialize the web driver
	 * @param browserName
	 * @return this will return the driver
	 */
	
	public WebDriver init_driver(Properties prop ) {
		
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");
		System.out.println("Browser name is :"+ browserName);
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else  if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else {
			System.out.println("please pass the correct browser :" + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		
		return driver;
		
	}
	/**
	 * This method is used to initialize the properties
	 * @return this will return properties prop reference
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			}
			return prop;
		
	}

}
