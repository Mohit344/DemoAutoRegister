package com.BaseClass;



	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.BeforeTest;

	public class BaseClass {
		protected WebDriver driver;
		@BeforeTest
		public void setup() throws IOException {
			File file = new File("C:\\Users\\mohit.jaiswal\\Desktop\\Selenium\\com.DemoAuto\\src\\test\\resources\\com.testdata\\webdriver.properties");
			Properties prop = property(file);
			switch (prop.getProperty("webdrivername")) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			/*case "Ie":
				System.setProperty("webdriver.chrome.driver", "./libs/IEDriver.exe");
				webdriver = new InternetExplorerDriver();
				break;
			case "microsoftEdge":
				System.setProperty("webdriver.chrome.driver", "./libs/IEDriver.exe");
				webdriver = new InternetExplorerDriver();
				break;*/
			}
		}

		public Properties property(File file) throws IOException {
			Properties prop = new Properties();
			FileInputStream input = new FileInputStream(file);
			prop.load(input);
			return prop;
		}
	}
