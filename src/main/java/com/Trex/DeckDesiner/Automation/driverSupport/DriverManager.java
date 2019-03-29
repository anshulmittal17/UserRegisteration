package com.Trex.DeckDesiner.Automation.driverSupport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

public class DriverManager extends TestSetup {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}

	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);
	}

	public static void maximizeBrowser(WebDriver driver) {

		DriverManager.getDriver().manage().window().maximize();
	}

	public static void setImplicitWait(WebDriver driver) {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20,
				TimeUnit.SECONDS);
	}

}
