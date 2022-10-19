package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class NOCInformationPage extends BaseClass {
	public String strNOCNo;
	public String strBLNo;

	public NOCInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openCreatedNOC() {

		doClick(getBy("id", "parent_frmSearchDiv_Calendar"));
		doClick(getBy("id", "FixedCalendarTodayAnchor"));
		doClick(getBy("id", "List_noc_1_EAABAAA"));

	}

	/** NOC Information */
	public void submitNOC() {
		/*********** To Agent Name select */
		doClick(getBy("cssSelector", "#browsebutton")); // Click on To Agent Name browse button

		switchToWindow(); // Shipping Agents page
		doSendKeys(getBy("id", "searchname"), "UNIVERSAL EXPRESS CO.");
		doClick(getBy("id", "okbutton"));
		doClick(getBy("linkText", "UNIVERSAL EXPRESS CO."));
		switchBackToWindow();

		doClick(getBy("id", "submit1")); // CLick on Submit NOC
		doClick(getBy("id", "okbutton")); // Click OK button
		doClick(getBy("id", "submit2"));// Click Approve NOC > ID >submit2

		/** Confirmation */
		confirmation();

		strBLNo = doElementGetText(getBy("id", "List_NOCBills_0_HouseBillNumber"));
		System.out.println(strBLNo);
	}

	private void confirmation() {
		strNOCNo = doElementGetText(getBy("id", "vwr_NoObjectionCertificateCode"));

		System.out.println("Temporary Manifest Number Generated: " + strNOCNo);
		doClick(getBy("id", "okbutton"));
	}

	public void goToNOCList() {
		doClick(getBy("cssSelector", "#MenuLabel_Vertical"));
		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_Manifest' and @class='mainMenuItem_vertical']/a"));
		doClick(getBy("linkText", "NOC"));
	}
	public void payIssuanceFee() {
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
		doSendKeys(By.id("txtReferenceNo"), strNOCNo); // "NOC/1125/KWI22"
		doClick(By.id("btnCreate"));
		doClick(By.id("btnSubmit"));
		logOut();
	}

	private By menuNavigateIconBy = By.cssSelector("#MenuLabel_Vertical");
	private By mainMenuCargoBy = By
			.xpath("//div[@id='mainMenuItemVertical_Manifest' and @class='mainMenuItem_vertical']/a");
	private By subMenuManifestBy = By.linkText("Bills Of Lading");

	public void navigateToBL() {
		doClick(menuNavigateIconBy);
		selectMenu(mainMenuCargoBy);
		doClick(subMenuManifestBy);

	}

	public void openNOCIssuedRecord() {
		doClick(getBy("id", "parent_frmSearchDiv_Search"));
		doSendKeys(getBy("name", "BillNumber"), strBLNo);// AWBL/4764/KWI22 strBLNo
		doClick(By.cssSelector("input[value='Search']"));// Using Attribute
		
		doClick(By.id("List_bill_0_HouseBillNumber"));
		/***Bill of Lading***/
		doClick(By.id("link1")); //Create Split Bills Of Lading
	}
	public void splited_BillsOfLading() {		
//		Splited Bills Of Lading List screen
		switchToWindow();
		doClick(By.id("new1")); //Click on New button
		
		/***Split Bill Of Lading Information***/
		doSendKeys(By.id("billnumber"), "Splited"+strBLNo);//AWBL/4764/KWI22    strBLNo
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
//		Goods Details
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee"); //Notify Party
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain"); //Consignee (Free Text)
		
		doSendKeys(getBy("id", "weight"),"100" + Keys.TAB); //Net Weight
		doSendKeys(getBy("id", "Tgweight"), "100"); //Total Gross Weight
		doSendKeys(getBy("id", "gweight"), "100"); //Landed Gross Weight
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB); //Total Quantity
		doSendKeys(getBy("id", "Mgweight"), "100");  //Manifested Gross Weight
		
		doClick(By.id("submit1"));//Click on Create button
		
		doClick(By.id("Close"));//Close Splited Bills Of Lading List screen
		switchBackToWindow();
		doClick(By.id("cancel"));//Click on Back button from Bill of Lading screen.
	}
}
