package com.DemoAuto;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.List;
	import java.util.NoSuchElementException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import java.util.function.Function;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.BaseClass.BaseClass;

	public class Registration extends BaseClass {
		private static final String SECONDS = null;
		Properties  pro = new Properties();
		Properties loc = new Properties();

		static  FileInputStream fl;


		@Test(priority=1)
		public void setUp() throws IOException {


			try {
				fl = new FileInputStream("C:\\Users\\mohit.jaiswal\\Desktop\\Selenium\\com.DemoAuto\\src\\test\\resources\\com.testdata\\input.properties");
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			}


			FileInputStream input = new FileInputStream("C:\\Users\\mohit.jaiswal\\Desktop\\Selenium\\com.DemoAuto\\src\\test\\resources\\locators\\locators.properties");

			loc.load(input);
			pro.load(fl);

			driver.get(loc.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		@Test(priority=2)
		public void registration()
		{
			
			
			WebElement firstName = waitAndGetElement(30, driver, loc.getProperty("fname"));
			firstName.sendKeys(pro.getProperty("firstName"));

			driver.findElement(By.xpath(loc.getProperty("lname"))).sendKeys(pro.getProperty("lastName"));

			driver.findElement(By.xpath(loc.getProperty("address"))).sendKeys(pro.getProperty("address"));

			driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys(pro.getProperty("email_address"));
			driver.findElement(By.xpath(loc.getProperty("phone"))).sendKeys(pro.getProperty("phone"));
			driver.findElement(By.xpath(loc.getProperty("gender"))).click();
			List<WebElement> checkbox=driver.findElements(By.xpath(loc.getProperty("hobbies")));
			for(int index=0;index<checkbox.size();index++)
			{
				WebElement ele=checkbox.get(index);
				String value=ele.getAttribute("value");
				if(value.equalsIgnoreCase("Cricket")) {
					ele.click();
					break;
					
				}
			}
			driver.findElement(By.xpath(loc.getProperty("country"))).click();	
			driver.findElement(By.xpath(loc.getProperty("skills"))).click();
			driver.findElement(By.xpath(loc.getProperty("year"))).click();
			driver.findElement(By.xpath(loc.getProperty("month"))).click();   
			driver.findElement(By.xpath(loc.getProperty("day"))).click();
			driver.findElement(By.xpath(loc.getProperty("firstpassword"))).sendKeys(pro.getProperty("fpassword"));
			driver.findElement(By.xpath(loc.getProperty("secondpassword"))).sendKeys(pro.getProperty("spassword"));
			driver.findElement(By.xpath(loc.getProperty("submit"))).click();

		}
		@AfterClass
	    public void TearDown()
	    {
	    	driver.quit();
	      }


		public WebElement waitAndGetElement(long seconds,WebDriver driver,final String xpath) {
			FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			
			WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver dvr) {
					return dvr.findElement(By.xpath(xpath));
				}
			});
			return element;
		}

	}

	

