package com.mcit.webapp.screenshot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

class TakeBrowserWindowScreenShotTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver\\windows\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void testAmazonHomePage() throws IOException {
		this.takeScreenShot("amazon-homepage.png");
	}
	
	@Test
	void testAddressLocationPopup() throws InterruptedException, IOException {
		Thread.sleep(3000);
		// open popup window
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);
		// switch main window to new popup
		String mainWindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			String childWindow = itr.next();
			
			// switch to child window
			driver.switchTo().window(childWindow);
			// find popup windows elements
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500038");
			Thread.sleep(3000);		
			//submit apply button
			this.takeScreenShot("address-location-popup.png");
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();			
		}
		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);			
	}
	
	private void takeScreenShot(String filename) throws IOException {
		// 1. type cast driver instance to takescreenshot
		TakesScreenshot tsc = (TakesScreenshot) driver;
		
		// 2. call takescreenshot method with file type as output
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		// 3. create file with screen shot
		FileHandler.copy(src, new File("output-screenshot\\"+filename));		
	}

}
