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

class CheckBoxTest {

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
	void testToVerifyCheckBoxVehicleOneExist() {
		WebElement checkBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkBox1.isDisplayed());
		assertEquals(true, checkBox1.isEnabled());
		assertEquals(false, checkBox1.isSelected());
	}
	
	@Test
	void testToVerifyCheckBoxVwehicelTwoExist() {
		WebElement checkBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkBox2.isDisplayed());
		assertEquals(true, checkBox2.isEnabled());
		assertEquals(true, checkBox2.isSelected());
	}
	
	@Test
	void testToVerifyCheckBoxOneSelected() throws InterruptedException {
		WebElement vehicle1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, vehicle1.isDisplayed());
		assertEquals(true, vehicle1.isEnabled());
		//before select
		assertEquals(false, vehicle1.isSelected());
		
		// select radio button
		vehicle1.click();
		Thread.sleep(3000);
		// after select
		assertEquals(true, vehicle1.isSelected());
	}
	
	
	@Test
	void testToVerifyCheckBoxTwoDeSelected() throws InterruptedException {
		WebElement vehicle2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, vehicle2.isDisplayed());
		assertEquals(true, vehicle2.isEnabled());
		//default select
		assertEquals(true, vehicle2.isSelected());
		
		// deselect radio button
		vehicle2.click();
		Thread.sleep(3000);
		// after select
		assertEquals(false, vehicle2.isSelected());
	}
	

}
