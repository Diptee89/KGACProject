package com.pages;



import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class HomePage extends BaseClass {
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

//	private By loginPortNameBy = getBy("cssSelector","#LoginPortNameLabel");
//	private By loggedInUserLabelBy = getBy("cssSelector",".LoggedInUserLabel");
//	private By loggedInUserIDBy = getBy("cssSelector",".LoggedInUserID");

	// Get the User name from Home Page
	public String getloggedInUserLabel() {
		return doElementGetText(getBy("cssSelector",".LoggedInUserLabel"));
	}

	public String getLoggedInUserID() {

		return doElementGetText(getBy("cssSelector",".LoggedInUserID"));

	}

	public String getLoginPortName() {

		return doElementGetText(getBy("cssSelector","#LoginPortNameLabel"));

	}

	public void selectPort(String strPortName) {
//		doSendKeys(getBy("id","LoginPortNameLabel"), "ABDELI");
		doClick(getBy("id","LoginPortNameLabel")); // Tool tip
		if (strPortName.equalsIgnoreCase("SHUWAIKH")) {
			selectMenu(getBy("id","portListScrollBarbottom"));
			doClick(getBy("linkText", strPortName));
		} else {
			doClick(getBy("linkText",strPortName));
		}
	}

}
