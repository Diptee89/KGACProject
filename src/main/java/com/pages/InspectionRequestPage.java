package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class InspectionRequestPage extends BaseClass {
	public InspectionRequestPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickIspectionRequestSubMenu() {
		doClick(By.cssSelector(".menuNavigateIcon"));
		selectMenu(By.xpath("//div[@id='mainMenuItemVertical_Inspection']/a"));
//		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_Declaration']/a"));
		waitForElementToBeVisible(getBy("linkText", "Inspection Request"), 10);
		doClick(By.linkText("Inspection Request"));
	}

	public void search(String strTempNo) {
		doSendKeys(By.id("TDECNo"), strTempNo + Keys.ENTER);
	}

	public void clickComplete() {
		doClick(By.xpath("//td[@id='List_insprequest_0_Cell1_CompleteIcon']/a"));

	}
	public void clickRelease() {
		doClick(By.id("ReleaseFromInspectionReport"));
	}
	public void clickRejectInspection() {
		doClick(By.id("btnRejInspection"));
		switchToWindow();
		doSendKeys(By.id("txtRejectionReason"), "test");
		doClick(By.id("cmdReject"));
		switchBackToWindow();
	}
	public void clickSeize() {
		doSendKeys(By.id("WareHouseCode"), "WAFIR");
		doClick(By.id("cmdFullSeize"));
		doClick(By.id("cmdApprove"));
	}
	public void ExitGate() {
		waitForElementToBeClickable(By.id("List_ListExitPassDetailsLs_0_cell_RelAndPrint"), 20);
		doClick(By.id("List_ListExitPassDetailsLs_0_cell_RelAndPrint"));
		
	}
}
