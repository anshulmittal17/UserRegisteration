package com.Trex.DeckDesiner.Automation.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObjects<T> {

	
	
	public void openPage( WebDriver driver,T pageObject)
	{
		PageFactory.initElements(driver, pageObject);
		//return page;
		
	}

}
