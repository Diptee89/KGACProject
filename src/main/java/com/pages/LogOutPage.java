package com.pages;

import org.openqa.selenium.WebDriver;
import com.base.BaseClass;

public class LogOutPage extends BaseClass {
	
	public LogOutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void logOutUser() {

		doClick(getBy("cssSelector", "#profileListDiv"));
		doClick(getBy("xpath", "//div[@id='profile_Sign_out']/a/div[2]"));

	}

}
