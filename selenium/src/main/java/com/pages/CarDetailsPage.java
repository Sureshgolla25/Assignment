package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CarDetailsPage extends CommonUtil {
	public CarDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.ID, using = "licensePlate")
	private WebElement licensePlateTextField;

	@FindBy(how = How.ID, using = "claimFreeYears")
	private WebElement claimFreeYearsTextField;

	@FindBy(how = How.XPATH, using = "(//div[@class= 'knx-form-group knx-form-group--error'])[2]")
	private WebElement claimFreeYearsErrorMessage;

	@FindBy(how = How.XPATH, using = "(//div[@class= 'knx-form-group knx-form-group--error'])[1]")
	private WebElement licensePlateErrorMessage;

	@FindBy(how = How.ID, using = "birthDate")
	private WebElement birthDateField;

	@FindBy(how = How.ID, using = "postalCode")
	private WebElement postalCodeTextField;

	@FindBy(how = How.ID, using = "houseNumber")
	private WebElement houseNumberTextField;

	@FindBy(how = How.ID, using = "houseHold")
	private WebElement houseHoldTextField;

	@FindBy(how = How.XPATH, using = "//div[@class= 'knx-button knx-button--primary knx-button--3d']")
	private WebElement adviceButton;

	@FindBy(how = How.CSS, using = "div[class = 'knx-message__content']")
	private WebElement planSelectionMessage;

	public void enterLicensePlateValue(String txt) throws Exception {
		waitUntilElementIsStable(licensePlateTextField);
		enterTextFieldValue(licensePlateTextField, txt);
	}

	public void enterClaimFreeYearsValue(String txt) throws Exception {
		waitUntilElementIsStable(claimFreeYearsTextField);
		enterTextFieldValue(claimFreeYearsTextField, txt);
	}

	public void verifyLicensePlateErrorMessage() throws Exception {
		waitUntilElementIsStable(licensePlateErrorMessage);
		System.out.println(licensePlateErrorMessage.getAttribute("data-error").trim());
		Assert.assertEquals(licensePlateErrorMessage.getAttribute("data-error").trim(),
				"Het ingevulde kenteken is niet geldig");
	}

	public void verifyClaimFreeYearsErrorMessage() throws Exception {
		waitUntilElementIsStable(claimFreeYearsErrorMessage);
		System.out.println(claimFreeYearsErrorMessage.getAttribute("data-error").trim());
		Assert.assertEquals(claimFreeYearsErrorMessage.getAttribute("data-error").trim(),
				"De ingevulde waarde ligt niet tussen 0 en 50");
	}

	public void enterUserInsurancePlanSelection(String date, String postal, String houseNo) throws Exception {
		waitUntilElementIsStable(birthDateField);
		enterTextFieldValue(birthDateField, date);
		waitUntilElementIsStable(postalCodeTextField);
		enterTextFieldValue(postalCodeTextField, postal);
		waitUntilElementIsStable(houseNumberTextField);
		enterTextFieldValue(houseNumberTextField, houseNo);
		Thread.sleep(3000);
		waitUntilElementIsStable(houseHoldTextField);
		Select select = new Select(houseHoldTextField);
		select.selectByVisibleText("Alleen ikzelf");
		Thread.sleep(7000);
		waitUntilElementIsStable(adviceButton);
		clickAfterElementIsStable(adviceButton);

	}

	public void verifyPlanResultsPageIsDisplayed() throws Exception {
		Thread.sleep(7000);
		waitUntilElementIsStable(planSelectionMessage);
		Assert.assertEquals(planSelectionMessage.getText().trim(),
				"Geef hieronder aan wat voor jou van toepassing is. Zo weet je zeker dat het advies goed bij je past.");
	}

}
