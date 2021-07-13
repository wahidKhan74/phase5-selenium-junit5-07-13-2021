package com.mcit.webapp.webelements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class RadioButtonTest {

	final String siteURL = "file:///home/wahidkhan74gmai/MCITWorkspace/phase5-selenium-junit5-07-13-2021/static/web-elements.html";
	final String driverPath = "driver/chromedriver";
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
	void testToVerifyRadioButtonOneExist() {
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
	}
	
	@Test
	void testToVerifyRadioButtonTwoExist() {
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		assertEquals(false, radio2.isSelected());
	}
	
	@Test
	void testToVerifyRadioButtonTwoSelectedExist() throws InterruptedException {
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		//before select
		assertEquals(false, radio2.isSelected());
		
		// select radio button
		radio2.click();
		Thread.sleep(3000);
		// after select
		assertEquals(true, radio2.isSelected());
	}
	
	@Test
	void testToVerifyRadioButtonThreeSelectedExist() throws InterruptedException {
		WebElement radio3 = driver.findElement(By.id("other"));
		assertEquals(true, radio3.isDisplayed());
		assertEquals(true, radio3.isEnabled());
		//before select
		assertEquals(false, radio3.isSelected());
		
		// select radio button
		radio3.click();
		Thread.sleep(3000);
		// after select
		assertEquals(true, radio3.isSelected());
	}

}
