package com.flipkart.setup;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	static WebDriver driver;
	@BeforeClass
	public static void launch() {
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
 driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@AfterClass
	public static void close() {
	driver.quit();
	}
	static long st;
@Before
	public void startTime() {
		st=System.currentTimeMillis();

	}
	@After
	public void endTime() {
		long g=System.currentTimeMillis();
System.out.println("Method time taken by:"+(g-st));
	}
	
	
	@Test
	public void m3() {
		try {
			WebElement w=driver.findElement(By.xpath("//button[text()='✕']"));
			w.isDisplayed();
			w.click();
		}catch(Exception e) {
			System.out.println("not required");
			
		}
			

	}
	static String sss;
	@Test
	public void m4() {
		driver.findElement(By.name("q")).sendKeys("iphone 12",Keys.ENTER);
	WebElement search=driver.findElement(By.xpath("(//div[contains(text(),'APPLE')])[2]"));
 sss=search.getText();
System.out.println("mobile name is:"+sss);
search.click();
	}
	@Test
	public void m5() {
		String parent=driver.getWindowHandle();
		
		Set<String> child=driver.getWindowHandles();
		
		for(String x:child) {
			if(!x.equals(parent)) {
				driver.switchTo().window(x);
				System.out.println("windows");
			}
		}
	}
		
		@Test
		public void m6() {
		WebElement buy=	driver.findElement(By.xpath("//button[text()='BUY NOW']"));// TODO Auto-generated method stub
buy.isDisplayed();
WebElement search=driver.findElement(By.xpath("//span[contains(text(),'APPLE')]"));
String ssss=search.getText();
System.out.println("mobile name is:"+ssss);

boolean xx=sss.equals(ssss);
System.out.println(xx);


		}
		@Test
		public void screen() throws IOException {
			TakesScreenshot tk= (TakesScreenshot)driver;
File ff=tk.getScreenshotAs(OutputType.FILE);
File sf= new File(".//target//flip.jpg");
FileUtils.copyFile(ff, sf);


		}
		
		
	
		
}
		
		
		
		
		
		
		
		

	
	
	

