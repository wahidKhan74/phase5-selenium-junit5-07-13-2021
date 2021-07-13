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

class AmazonLinkNavigationTest {

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
	@DisplayName("Amazon Test : Fashion Link Verification")
	void testFashionNavigationLink() {
		
		// find fashion link 
		WebElement fashionLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		// test evaluation
		assertEquals(true, fashionLink.isDisplayed());
		assertEquals(true, fashionLink.isEnabled());
		
		// perform click action
		fashionLink.click();
		String expected = "Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	// TODO : WAT for amazon nav links (minimum 3 nav links)
}
