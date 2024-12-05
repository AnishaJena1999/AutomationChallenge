package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_01 {
	WebDriver driver;

	@BeforeTest
	public void start() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		System.out.println("sleeps ends..");
	}

	@AfterTest
	public void teardown() {
		// driver.close();
	}

	@Test
	public void f() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("anishapanchu@gmail.com");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("Pandu@99");
		driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
		System.out.println("sign in successfully");

		WebElement searchInput = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchInput.sendKeys("pendrives");
		WebElement searchButton = driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
		searchButton.click();
		System.out.println("Product show Succesfully");
		driver.findElement(By.xpath(
				"//*[text()='SanDisk Ultra Dual Drive Luxe Type C, Gold, 256GB, Up to 400MB/s Transfer Speed, USB 3.2 Gen 1, 5 Y Warranty']"))
				.click();
		Set<String> s = driver.getWindowHandles();
		List<String> ar = new ArrayList(s);
		driver.switchTo().window((String) ar.get(1));
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0, 300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='add-to-cart-buuton']")).click();
		System.out.println("added");
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		driver.findElement(By.id("addressChangeLinkId")).click();
		Thread.sleep(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scroll(0,350)");
		driver.findElement(By.id("add-new-address-popover-link")).click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.id("address-ui-widgets-enterAddressFullName")));
		driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("XYZZ");
		driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("7665544900");
		driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("560099");
		driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Karatali");
		driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("side of temple");
		driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("banglore");
		driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();

		// Payment gateway
		driver.findElement(By.linkText("Enter card details")).click();
		driver.findElement(By.name("addCreditCardNumber")).sendKeys("411111111111561");
		driver.findElement(By.name("ppw-accountHolderName")).sendKeys("Anisha");

		Select EXpmonthdropdown = new Select(driver.findElement(By.xpath("//span[@id='pp-LHmzDH-22']")));
		EXpmonthdropdown.selectByVisibleText("12");
		Select EXpyeardropdown = new Select(driver.findElement(By.xpath("//span[@id='pp-LHmzDH-23']")));
		EXpyeardropdown.selectByVisibleText("2026");
		driver.findElement(By.name("ppw-widgetEvent:AddCreditCardEvent")).click();
		driver.findElement(By.linkText("Pay in Full")).click();
		driver.findElement(By.xpath("//span[@id='orderSummaryPrimaryActionBtn']")).click();
		driver.findElement(By.name("placeYourOrder1")).click();
		WebElement OTPField= driver.findElement(By.xpath("//input[@placeholder='Enter OTP:']"));
		OTPField.sendKeys("5344956");
		
		driver.findElement(By.id("c-action-submit-btn-announce")).click();

	}
}
