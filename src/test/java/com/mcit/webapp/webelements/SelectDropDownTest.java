package com.mcit.webapp.webelements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class SelectDropDownTest {

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
	void testToVerifySelectDropDownExist() {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
	}
	
	
	@Test
	void testToVerifySelectDropDownOptionOne() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		
		// select bike as a first option select
		select.selectByVisibleText("Bike");
		
		// get selected option
		WebElement selectedOption = select.getFirstSelectedOption();
		
		assertEquals(" Bike ", selectedOption.getText());
		
		Thread.sleep(3000);
	}

	
	@Test
	void testToVerifySelectDropDownOptionTwo() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		
		// select car as selected option by index 1
		select.selectByIndex(1);
		
		// get selected option
		WebElement selectedOption = select.getFirstSelectedOption();
		
		assertEquals(" Car ", selectedOption.getText());
		
		Thread.sleep(3000);
	}
	
	
	@Test
	void testToVerifySelectDropDownOptionThree() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		
		// select train as a option by value "train".
		select.selectByValue("train");
		
		// get selected option
		WebElement selectedOption = select.getFirstSelectedOption();
		
		assertEquals(" Train ", selectedOption.getText());
		
		Thread.sleep(3000);
	}

}
