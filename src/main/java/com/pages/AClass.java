package com.pages;

import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class AClass extends BaseClass{
	
	public AClass(WebDriver driver) {
		this.driver=driver;
	}
	public void loginValidUser(String strUserName, String strPasword) {
		switchToWindow();
		doSendKeys(getBy("cssSelector", "input.FX50loginPanelTextBox"), strUserName);
		doSendKeys(getBy("cssSelector", "#sUserPassword"), strPasword);
		doClick(getBy("cssSelector", ".FX50loginPanelLoginButton"));
	}
}
