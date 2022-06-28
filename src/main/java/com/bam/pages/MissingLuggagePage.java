package com.bam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class MissingLuggagePage extends BaseClass {
	public String strMissingLuggageNo;
	public MissingLuggagePage(WebDriver driver) {
		this.driver = driver;
	}
	private void subMenuMissing_Luggage() {
		doClick(By.id("MenuLabel_Vertical"));
		selectMenu(By
				.xpath("//div[@id='mainMenuItemVertical_Manifest' and @class='mainMenuItem_vertical']/a"));

//		selectMenu(By.className("vSubMenuScrollButtonDynamic_vertical"));
		waitForElementPresent(By.linkText("Missing Luggage"), 10);
//		selectMenu(By.xpath("//div[@id='subMenuWrapperDynamicVertical_Manifest']/div[2]//div[@id='subMenuNavBarBottomDynamicVertical_Manifest']"));
		doClick(By.linkText("Missing Luggage"));
		
	}
public void createMissingLuggage(){
	subMenuMissing_Luggage();
//	New 
	doClick(By.id("btnNew"));
	
//	Missing Luggage Receiving form Details
	System.out.println(doElementGetText(By.id("ddlMeansOfTransportation")));
	doSendKeys(By.id("txtComments"), "Created by Custom user");
	doClick(By.id("cmdCreate"));
	strMissingLuggageNo=doElementGetText(By.xpath("//td[@class='view-text']//div"));
	System.out.println(strMissingLuggageNo);

	
}
public void addItems() {
//	Missing Luggage List
	doClick(By.id("btnNew"));

	createItems("Oil seeds and oleaginous fruits; miscellaneous grains, seeds and fruit; industrial or medicinal plants ; straw and fodder");
	createItems("Coffee, tea, mate and spices");
	createItems("Cereals");
	createItems("Products of the milling industry; malt; starches; inulin; wheat gluten.");
	createItems("Oil seeds and oleaginous fruits; miscellaneous grains, seeds and fruit; industrial or medicinal plants; straw and fodder.");
	createItems("Live animals");
	createItems("Meat and edible meat offal");
	createItems("Fish and crustaceans, molluscs and other aquatic invertebrates");
	createItems("Dairy produce; birds' eggs; natural honey; edible products of animal origin, not elsewhere specified or included");
	createItems("Products of animal origin, not elsewhere specified or included.");
	createItems("Live trees and other plants; bulbs, roots and the like; cut flowers and ornamental foliage");
	createItems("Edible vegetables and certain roots and tubers");
	createItems("Edible fruit and nuts; peel of citrus fruits or melons");
	createItems("Coffee, tea, mate and spices");
	createItems("Products of the milling industry; malt; starches; inulin; wheat gluten.");
	createItems("Vegetable plaiting materials; vegetable products not elsewhere specified or included.");
	createItems("Preparation of meat, of fish or of crustaceans, molluscs or other aquatic invertebrates");
	createItems("Sugars and sugar confectionery");
	createItems("Cocoa and cocoa preparations");
	createItems("Preparations of cereals, flour, starch or milk; pastrycooks' products");
		doClick(By.id("cmdclose")); // Create And New
		
}
private void createItems(String strDesc) {
	doSendKeys(By.id("txtLabelNumber"), "lbl"+uniqueNo());
	doSendKeys(By.id("txtPersonName"), "Alex MD Husain");
	doSendKeys(By.id("FlightNumber"), uniqueNo());
	doSendKeys(By.id("DestinationPort"), "AAB");
	doSendKeys(By.id("txtQuantity"), "1000");
	
	doSendKeys(By.id("txtTotalWeight"), "2000");
	doSendKeys(By.id("txtDescription"), strDesc);
	doSendKeys(By.id("QuantityMeasurementUnit"), "Loose Cargo");
	doSendKeys(By.id("txtWeightMeasurementNnit"), "KiloGrams");
	doSendKeys(By.id("txtComments"), "Created By Custome Officer");
//	doClick(By.id("btnCreate"));
	doClick(By.id("btnCreateAdd")); // Create And New
}
public void receivedMissing_Luggage() {
	doClick(By.id("cmdReceive"));
}
}

