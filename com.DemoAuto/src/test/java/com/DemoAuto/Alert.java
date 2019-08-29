package com.DemoAuto;

 

	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import com.BaseClass.BaseClass;

	public class Alert extends BaseClass {
		Properties loc = new Properties();

		@Test
		public void alerts()
		{
			FileInputStream input;
			try {
				input = new FileInputStream("");
				loc.load(input);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			driver.get(loc.getProperty("url"));
			driver.findElement(By.xpath(loc.getProperty("switchTo"))).click();	
			driver.findElement(By.linkText("Alerts")).click();	
			driver.findElement(By.linkText("Alert with OK")).click();
			driver.findElement(By.xpath(loc.getProperty("alertbox"))).click();
			Alert alt1=(Alert) driver.switchTo().alert();
			System.out.println(alt1.getText());
			alt1.accept();
			driver.findElement(By.linkText("Alert with OK & Cancel")).click();
			driver.findElement(By.xpath(loc.getProperty("confirmbox"))).click();
			Alert alt2=(Alert) driver.switchTo().alert();
			System.out.println(alt2.getText());
			alt2.dismiss();
			driver.findElement(By.linkText("Alert with Textbox")).click();
			driver.findElement(By.xpath(loc.getProperty("textbox"))).click();
			Alert alt3=(Alert) driver.switchTo().alert();
			System.out.println(alt3.getText());
			alt3.sendKeys("Automation Testing user");
			alt3.accept();

			
			
		}
		private void sendKeys(String string) {
			// TODO Auto-generated method stub
			
		}
		private void dismiss() {
			// TODO Auto-generated method stub
			
		}
		private void accept() {
			// TODO Auto-generated method stub
			
		}
		private char[] getText() {
			// TODO Auto-generated method stub
			return null;
		}
		@AfterMethod
	    public void TearDown()
	    {
	    	driver.quit();
	      }

	}

