package com.pages;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends CommonUtil{

	@FindBy(how = How.ID, using = "email")
	private WebElement emailInputField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordInputField;

	@FindBy(how = How.XPATH, using = "//span[@class = 'knx-checkbox__control']")
	private WebElement acceptCheckbox;

	@FindBy(how = How.XPATH, using = "//button[@type = 'submit']")
	private WebElement submitButton;

	@FindBy(how = How.CSS, using = "div[class = 'knx-register-thankyou__welcome'] > h2")
	private WebElement successRegisterTextField;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(), 'Inloggen')]")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class= 'knx-login__error']/p")
	private WebElement loginErrorMessage;
	
	@FindBy(how = How.XPATH, using = "//div[@class= 'knx-header-img knx-dropdown-profile-img knx-dropdown-key']")
	private WebElement loginImage;
	
	@FindBy(how = How.XPATH, using = "(//div[@class= 'knx-dropdown-value'])[4]")
	private WebElement logOutButton;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class= 'knx-registration__error']")
	private WebElement registrationErrorText;
	
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void enterUsername(String text) throws Exception {
		waitUntilElementIsStable(emailInputField);
		enterTextFieldValue(emailInputField, text);
	}

	public void enterPassword() throws Exception {
		waitUntilElementIsStable(passwordInputField);
		enterTextFieldValue(passwordInputField, "Welcome1");
	}

	public void clickAccept() throws Exception {
		waitUntilElementIsStable(acceptCheckbox);
		clickAfterElementIsStable(acceptCheckbox);
	}

	public void clickSubmit() throws Exception {
		waitUntilElementIsStable(submitButton);
		clickAfterElementIsStable(submitButton);
	}

	public String getRegistrationSuccessText() throws Exception {
		waitUntilElementIsStable(successRegisterTextField);
		return successRegisterTextField.getText().toLowerCase();
	}

	public void verifySuccesfullRegistration() throws Exception {
		System.out.println(getRegistrationSuccessText());
		Assert.assertEquals(getRegistrationSuccessText(), "bedankt voor je registratie!");
	}
	
	public void clickLogin() throws Exception {
		waitUntilElementIsStable(loginButton);
		clickAfterElementIsStable(loginButton); 
	}
	
	public String getLoginErrorMessage() throws Exception {
		waitUntilElementIsStable(loginErrorMessage);
		return loginErrorMessage.getText().trim();
	}
	
	public void verifyLoginErrorMessage() throws Exception {
		waitUntilElementIsStable(loginErrorMessage);
		System.out.println(getLoginErrorMessage());
		Assert.assertEquals(getLoginErrorMessage(), "De combinatie gebruikersnaam en wachtwoord klopt niet");
	}
	
	public void isLoginImageDisplayed() throws Exception {
		waitUntilElementIsStable(loginImage);		
		Assert.assertTrue(loginImage.isDisplayed());
	}
	
	public void clickLogout() throws Exception {
		waitUntilElementIsStable(loginImage);
		clickAfterElementIsStable(loginImage);
		waitUntilElementIsStable(logOutButton);
		clickAfterElementIsStable(logOutButton);
		Thread.sleep(5000);
	}
	
	public String getRegistrationErrorText() throws Exception {
		waitUntilElementIsStable(registrationErrorText);
		return registrationErrorText.getText().trim();
	}

	public void verifyRegistrationErrorMessage() throws Exception {
		System.out.println(getRegistrationErrorText());
		Assert.assertEquals(getRegistrationErrorText(), "Dit e-mailadres is al bekend in ons systeem.");
	}

}
