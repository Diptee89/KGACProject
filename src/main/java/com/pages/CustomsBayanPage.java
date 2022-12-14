package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class CustomsBayanPage extends BaseClass {

	public String tempDeclarationNo;

	public CustomsBayanPage(WebDriver driver) {
		this.driver = driver;
	}

	public void createBayan() {
		setDecType();
		selectImporter();
//		doSendKeys(getBy("id", "txtReMarks"), "Created By Automation");
		doClick(getBy("id", "savebttn"));
		getTempDeclNumber();
	}
public void setDecType() {
	doSendKeys(By.id("dectype"), "Import");
}
	private void selectImporter() {
		doClick(getBy("id", "consigneebrowsebutton"));
		switchToWindow();
		waitForElementToBeVisible(getBy("id", "people"), 15);
		doClick(getBy("id", "people")); // Click on radio button
		doSendKeys(getBy("id", "FirstName"), "MOHAMMED HUSSIAN");
		doClick(By.id("okbutton"));
//		waitForElementToBeClickable(getBy("xpath", "//td[@id='List_ListPeopleDetails_0_FirstName']/a"), 15);
		scrollPageDown();
		doClick(getBy("xpath", "//td[@id='List_ListPeopleDetails_0_FirstName']/a"));
		switchBackToWindow();
	}

	private String getTempDeclNumber() {
		tempDeclarationNo = doElementGetText(getBy("xpath", "//td[@id='TempDeclNumber']/div"));
		System.out.println(tempDeclarationNo);
		return tempDeclarationNo;
	}
}
