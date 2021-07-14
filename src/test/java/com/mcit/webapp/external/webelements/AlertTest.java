package com.mcit.webapp.external.webelements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AlertTest {

	final String siteURL = "file:///C:/Users/HOME/Desktop/Siimplilearn/MCIT-Workspace/phase5-selenium-junit5-07-13-2021/static/external-web-element.html";
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
	@DisplayName("Test :: JavaScript Simple Alert window test")
	void testAlertDailogWindow() throws InterruptedException {
		// open alert box
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(2) > button"));
		alertButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Are you sure !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	
	@Test
	@DisplayName("Test :: JavaScript Confirmation Alert window test")
	void testConfirmationAlertDailogWindow() throws InterruptedException {
		// open alert box
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		// click ok
		alert.accept();
	}
	
	
	@Test
	@DisplayName("Test :: JavaScript Prompt Alert window test")
	void testPromptAlertDailogWindow() throws InterruptedException {
		// open alert box
		WebElement promptButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		promptButton.click();
		
		// switch to alert window
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		Thread.sleep(3000);
		// click ok
		alert.accept();
	}

}
