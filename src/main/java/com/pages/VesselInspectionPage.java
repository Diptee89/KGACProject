package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
public class VesselInspectionPage extends BaseClass {

	public VesselInspectionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickVesselInspection_SubMenu() {
		doClick(By.cssSelector("#MenuLabel_Vertical"));
		selectMenu(By.xpath("//div[@id='mainMenuItemVertical_Inspection']/a"));
		doClick(By.linkText("Vessel Inspection"));
	}
	
	public void createVessel_Inspection(String strMNFNo) {
		
		doClick(By.id("new"));
		
//		Vessel Inspection screen
		doSendKeys(By.id("txtManifestNumber"), strMNFNo); //Manifest No MRN/630/SWK22
		doSendKeys(By.id("LoadingPort"), "AEAUH"); //Port Of Destination
		doSendKeys(By.id("RegisterNo"), "REG001SWK22"); //Registration Number
		doSendKeys(By.id("RegisterPlace"), "ABU DHABI"); //Register Place
		doSendKeys(By.id("Arms"), "Arrival Passengers"); //Arrival Particulars
		doSendKeys(By.id("DeptParticulars"), "Departure Passengers"); //Departure Particulars
		doSendKeys(By.id("DeptWgt"), "100"); //Departure Weight In TONS
		
		doClick(By.id("btnSaveNew"));
		doClick(By.xpath("//input[@value='Submit']"));
//		doClick(By.id("closebutton"));
	}
	
	
}
