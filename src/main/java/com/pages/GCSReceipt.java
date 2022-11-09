package com.pages;

import org.openqa.selenium.By;

import com.base.BaseClass;

public class GCSReceipt extends BaseClass {
	public void payNOCIssuanceFee() {
		login("md.husain");
		doClick(getBy("cssSelector", "#MenuLabel_Vertical"));
		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_GCSAcs']/a"));
		doClick(getBy("linkText", "Receipts"));

		doClick(By.id("btnNew"));
		doClick(By.id("IsOthers"));
		doSendKeys(By.id("txtReceivedFrom"), "1233");
		doClick(By.id("btnCreate"));
		doClick(By.id("btnNew"));
		doSendKeys(By.id("selReceiptFor"), "NOC Issuance");
		doSendKeys(By.id("txtReferenceNo"), "NOC/1125/KWI22");
		doClick(By.id("btnCreate"));
		doClick(By.id("btnSubmit"));
		logOut();
	}
	public void payBayanIssuanceFee() {
		login("md.husain");
		doClick(getBy("cssSelector", "#MenuLabel_Vertical"));
		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_GCSAcs']/a"));
		doClick(getBy("linkText", "Receipts"));

		doClick(By.id("btnNew"));
		doClick(By.id("IsOthers"));
		doSendKeys(By.id("txtReceivedFrom"), "1233");
		doClick(By.id("btnCreate"));
		doClick(By.id("btnNew"));
		doSendKeys(By.id("txtReferenceNo"), "TIM/29804/KWI22");
		doClick(By.id("btnCreate"));
		doClick(By.id("btnSubmit"));
		logOut();
	}

}
