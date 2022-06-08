package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.base.TestBase;

public class HomePage extends TestBase {
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By loginPortNameBy = By.cssSelector("#LoginPortNameLabel");
	private By loggedInUserLabelBy = By.cssSelector(".LoggedInUserLabel");
	private By loggedInUserIDBy = By.cssSelector(".LoggedInUserID");

	// Get the User name from Home Page
	public String getloggedInUserLabel() {

		return driver.findElement(loggedInUserLabelBy).getText();

	}

	public String getLoggedInUserID() {

		return driver.findElement(loggedInUserIDBy).getText();

	}

	public String getLoginPortName() {

		return driver.findElement(loginPortNameBy).getText();

	}

	public void selectPort(String strPortName) {
//		doSendKeys(By.id("LoginPortNameLabel"), "ABDELI");
		doClick(By.id("LoginPortNameLabel")); // Tool tip
		if (strPortName.equalsIgnoreCase("SHUWAIKH")) {
			Actions act = new Actions(driver);
			act.moveToElement(findElement(By.id("portListScrollBarbottom"))).perform();
			doClick(By.linkText(strPortName));
		} else {
			doClick(By.linkText(strPortName));
		}
	}

}
