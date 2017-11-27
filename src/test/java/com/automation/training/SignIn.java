package com.automation.training;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SignIn {

	WebDriver driver;
	@Test
	public void loginToJabong() {
		try {
			driver.get("https://www.jabong.com");
			driver.findElement(By.id("signin-model-wishlist")).click();
			driver.findElement(By.id("login-email")).sendKeys("cristianblandon13@gmail.com");
			Assert.assertTrue(driver.findElement(By.id("login-email")).isDisplayed());
			Thread.sleep(1000);
			driver.findElement(By.id("login-pwd")).sendKeys("Qwer1234");
			Assert.assertTrue(driver.findElement(By.id("login-pwd")).isDisplayed());
			Thread.sleep(1000);
			driver.findElement(By.id("btn-login")).submit();
			Thread.sleep(1000);
			//If the login was successful I expected 'Hey Cristian over login link' 
			Assert.assertEquals(driver.getTitle(), "Hey Cristian");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Proyectos\\software\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
