package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends CommonUtil{
	public HomePage(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
		
	@FindBy(how = How.LINK_TEXT, using = "Registreren")
	  private WebElement registrationLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Inloggen")
	  private WebElement loginLink;

	
	
	public void clickRegistration() throws Exception {
	   Thread.sleep(7000);
	   waitUntilElementIsStable(registrationLink);
	   clickAfterElementIsStable(registrationLink);		
	}	
	
	public void clickLogin() throws Exception {
		waitUntilElementIsStable(loginLink);
	   clickAfterElementIsStable(loginLink);		
	}
	
	

}
