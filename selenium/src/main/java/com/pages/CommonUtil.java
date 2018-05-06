package com.pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonUtil {
	
WebDriver driver;
	
	public CommonUtil(WebDriver driver){
		this.driver = driver;
	}

	public void enterTextFieldValue(WebElement element, String txt) throws Exception {
		clickAfterElementIsStable(element);
		element.clear();
		element.sendKeys(txt);
		element.sendKeys(Keys.RIGHT);
		element.sendKeys(Keys.TAB);
	}

	public void clickAfterElementIsStable(WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void waitUntilElementIsStable(WebElement element) throws Exception {
		try {
			element.isDisplayed();
		} catch (Exception e) {
		}
	}

	public static String getRandomString(String charSet, int length) {
		char[] text = new char[length];

		for (int i = 0; i < length; i++) {
			text[i] = charSet.charAt(new Random().nextInt(charSet.length()));
		}
		return new String(text);
	}

	public static String getUserName() {
		String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String userName = getRandomString(charSet, 7);
		return "Auto" + userName +"@gmail.com";
	}
	
	
	
	
}
