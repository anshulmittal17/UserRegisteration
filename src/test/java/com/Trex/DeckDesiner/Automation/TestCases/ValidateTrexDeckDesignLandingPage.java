package com.Trex.DeckDesiner.Automation.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Trex.DeckDesiner.Automation.driverSupport.DriverFactory;
import com.Trex.DeckDesiner.Automation.driverSupport.DriverManager;

public class ValidateTrexDeckDesignLandingPage {
public static String logging_Step;
public static String AdminLandingPageHeaderXpath = "//a[contains(.,'Trex Deck Designer Admin')]";

	@Test
	public void validateTrexDeckDesignLandingPage() {
	
	DriverFactory.createDriverInstance("chrome");
	logging_Step="Navigate to Trex deck design landing page";
	String url="http://dev.trex-deck-designer.s3-website-us-east-1.amazonaws.com/";

	DriverManager.getDriver().navigate().to(url);
	String PageTitle = DriverManager.getDriver().getTitle();
	System.out.println(PageTitle);
	
	DriverManager.getDriver().findElement(By.xpath("//img[@class='logo-image']")).isDisplayed();
	DriverManager.getDriver().quit();
	}
	
	@Test
	public void validateTrexAdminLandingPageIsDisplayed() {
	
	DriverFactory.createDriverInstance("chrome");
	String url="http://trex-admin-assets.s3-website-us-east-1.amazonaws.com/";

	DriverManager.getDriver().navigate().to(url);
	String PageTitle = DriverManager.getDriver().getTitle();
	System.out.println(PageTitle);
	
	DriverManager.getDriver().quit();
	
	}
	
}
