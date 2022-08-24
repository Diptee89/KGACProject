package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/** Login as valid user
	 *
	 * @param userName
	 * @param password
	 * @return HomePage object
	 */
	public void loginUser(String strUserName, String strPasword) {
		doSendKeys(By.id("sUserId"), strUserName);
////		doSendKeys(getBy("cssSelector", "input.FX50loginPanelTextBox"), strUserName);
		doSendKeys(getBy("cssSelector", "#sUserPassword"), strPasword);
		doClick(getBy("cssSelector", ".FX50loginPanelLoginButton"));
	}

	public void logOutUser() {

		doClick(getBy("cssSelector", "#profileListDiv"));
		doClick(getBy("xpath", "//div[@id='profile_Sign_out']/a/div[2]"));

	}
}
