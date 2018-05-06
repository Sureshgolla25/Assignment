package com.runner;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.CarDetailsPage;
import com.pages.CommonUtil;
import com.pages.HomePage;
import com.pages.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
	public static WebDriver driver=new FirefoxDriver();
	RegistrationPage regPage= new RegistrationPage(driver);
	HomePage homePage = new HomePage(driver);
	CarDetailsPage carDetailPage = new CarDetailsPage(driver);
	
	@Given("^Launch browser and Navigate to URL$")
	public void launch_Browser() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");			
		driver.get("https://mijn-verzekeren.knab.nl/car/detail");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@When("^the user click on the registration link$")
	public void user_Clicks_On_Registration_Link() throws Throwable {		
		homePage.clickRegistration();
	}

	@When("^create the new account$")
	public void create_New_Account() throws Throwable {	
		regPage.enterUsername(CommonUtil.getUserName());
		regPage.enterPassword();
		regPage.clickAccept();
		regPage.clickSubmit();
	}
	
	@When("^create account with the already registerd email address and password$")
	public void create_account_with_the_already_registerd_email_address_and_password() throws Throwable {	
		regPage.enterUsername("testuser.carinsurance@gmail.com");
		regPage.enterPassword();
		regPage.clickAccept();
		regPage.clickSubmit();
	}
	
	@Then("^new User should not be created scucessfully$")
	public void new_User_should_not_created_scucessfully() throws Throwable {
		regPage.verifyRegistrationErrorMessage();		
	}

	@Then("^new User profile should be created successfully$")
	public void new_User_profile_should_be_created_successfully() throws Throwable {
		regPage.verifySuccesfullRegistration();
	}
	
	@When("^the user click on the login link$")
	public void click_on_login() throws Throwable {	
		homePage.clickLogin();
	}
	
	@When("^enter invalid UserName and Password$")
	public void enter_Invalid_UserName_Password() throws Throwable {	
		regPage.enterUsername(CommonUtil.getUserName());
		regPage.enterPassword();
		regPage.clickLogin();
	}
	
	@Then("^user should not login to site error message should be displayed$")
	public void user_should_not_login() throws Throwable {	
		regPage.verifyLoginErrorMessage();
	}
	
	@When("^enter valid UserName and Password$")
	public void enter_valid_UserName_Password() throws Throwable {	
		regPage.enterUsername("testuser.carinsurance@gmail.com");
		regPage.enterPassword();
		regPage.clickLogin();
	}
	
	@Then("^user should login to site successfully$")
	public void user_should_login_successfully() throws Throwable {	
		regPage.isLoginImageDisplayed();
		regPage.clickLogout();
	}
	
	@When("^the user Enters invalid License plate$")
	public void the_user_Enters_invalid_License_plate() throws Throwable {	
		carDetailPage.enterLicensePlateValue("XXHGHJ");
	}
	
	@When("^enter non integer in cliam years$")
	public void enter_non_integer_in_cliam_years() throws Throwable {	
		carDetailPage.enterClaimFreeYearsValue("XXHGHJ");
	}
	
	@Then("^user should be prompted with respective error messages$")
	public void user_should_be_prompted_with_respective_error_messages() throws Throwable {	
		carDetailPage.verifyLicensePlateErrorMessage();
		carDetailPage.verifyClaimFreeYearsErrorMessage();
		regPage.clickLogout();
	}
	
	@When("^the user click enters valid license plate and years$")
	public void the_user_click_enters_valid_license_plate_and_years() throws Throwable {	
		carDetailPage.enterLicensePlateValue("47TVZH");
		carDetailPage.enterClaimFreeYearsValue("2");
	}
	
	@When("^Filling all the mandatory fields$")
	public void Filling_all_the_mandatory_fields() throws Throwable {	
		carDetailPage.enterUserInsurancePlanSelection("09/07/1985", "1315 EX", "38");
	}
	
	@Then("^User should be able to check all the advices and proceed further$")
	public void User_should_be_able_to_check_all_the_advices_and_proceed_furthers() throws Throwable {	
		carDetailPage.verifyPlanResultsPageIsDisplayed();
		regPage.clickLogout();
		driver.quit();
	}
	
	
	
	
}
