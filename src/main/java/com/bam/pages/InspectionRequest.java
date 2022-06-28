package com.bam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class InspectionRequest extends BaseClass {
	public InspectionRequest(WebDriver driver) {
		this.driver = driver;
	}

	private void subMenuInspection_and_Transfer_Request() {
		doClick(By.id("MenuLabel_Vertical"));
		selectMenu(By.xpath("//div[@id='mainMenuItemVertical_BaitAlMal']/a"));
		waitForElementPresent(By.linkText("Inspection and Transfer Request"), 10);
		doClick(By.linkText("Inspection and Transfer Request"));

	}
}
