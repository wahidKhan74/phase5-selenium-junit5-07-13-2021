package com.mcit.webapp.amazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AmazonProductSearchTest {

	final String siteURL = "https://www.amazon.in/";
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
	@DisplayName("Test : Product search as Iphone 12 ")
	void testAmazonProductSearch1() {
		// find search bar
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		assertTrue(searchBar.isDisplayed());
		
		// enter product search data 
		searchBar.sendKeys("Iphone 12 ");
		searchBar.submit();
	}
	
	@Test
	@DisplayName("Test : Product search as Dell laptop ")
	void testAmazonProductSearch2() {
		// find search bar
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		assertTrue(searchBar.isDisplayed());
		
		// enter product search data 
		searchBar.sendKeys("Dell laptop ");
		searchBar.submit();
	}
	

}
