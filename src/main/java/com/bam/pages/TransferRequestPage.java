package com.bam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class TransferRequestPage extends BaseClass {
	public String strTRNo;
	public String strTempTRNo;
	public TransferRequestPage(WebDriver driver) {
		this.driver = driver;
	}

	public void subMenuTransfer_Request() {
		doClick(By.id("MenuLabel_Vertical"));
		selectMenu(By.xpath("//div[@id='mainMenuItemVertical_BaitAlMal']/a"));
		waitForElementPresent(By.linkText("Transfer to Bait Al Mal requests"), 15);
		doClick(By.partialLinkText("Transfer to Bait Al Mal requests"));
	}

	public void createTransferRequest() {
		doClick(By.id("btnNew"));
		doSendKeys(By.id("ddlTransferReference"), "Missing Luggage");
		doClick(By.id("cmdCreate"));
		strTempTRNo=doElementGetText(By.xpath("//td[@class='view-text']//div"));
		System.out.println("Temp. transfer request number: "+strTRNo);
	}

	public void addTransferredGoods(String srtReceivingFormNumber) {
		doClick(By.id("btnAddTRHBItems"));
		switchToWindow();

		doSendKeys(By.id("ReceivingFormNumber"), srtReceivingFormNumber); // TGML/48/KWI22
		doClick(By.xpath("//input[@value='Search']"));

		doClick(By.id("chkall0EAAAABA")); // Select All
		doClick(By.id("button0EAAAABA")); // Click on SaveSelection

		switchBackToWindow();
		
		doClick(By.id("cmdSave"));
	}
	public void submitTR() {
		doClick(By.id("cmdSubmit"));
	}
	public void approveTR() {
		doClick(By.id("cmdApprove"));
		strTRNo=doElementGetText(By.xpath("//table/tbody/tr/td[4]//div[@class='view-text']"));
		System.out.println(strTRNo);
	}
}
