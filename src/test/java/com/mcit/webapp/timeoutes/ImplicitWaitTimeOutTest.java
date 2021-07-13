package com.mcit.webapp.timeoutes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitTimeOutTest {
	
	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/chromedriver";
	WebDriver driver;
	
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		
		// implicit wait  : The implicit in selenium is used for tell the web driver to wait for 
		// a certain time before it throw a "No Such element exception" default implicit setting is 0.
		// Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}
	
	@Test
	@DisplayName("Amazon Test : Mobile Link Verification")
	void testMobileNavigationLink() {
		
		// find mobile link 
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		// test evaluation
		assertEquals(true, mobileLink.isDisplayed());
		assertEquals(true, mobileLink.isEnabled());
		
		// perform click action
		mobileLink.click();
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
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
}
