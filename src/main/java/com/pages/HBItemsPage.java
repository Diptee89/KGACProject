package com.pages;

import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class HBItemsPage extends BaseClass {
	public HBItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	/*for Dropdown list
	 * var input = driver.findElement(By.id("input")); input.sendKeys("Auto");
	 * 
	 * String optionValue =
	 * driver.findElement(getBy("id", "//option[contains(@value,'TEST')]")).
	 * getAttribute("value"); input.clear(); input.sendKeys(optionValue);
	 */
	public void createHBItems() {
		doClick(getBy("id", "btnNew"));

		doSendKeys(getBy("id", "txtContainerNo"), "POIU7654321");
		doSendKeys(getBy("id", "cmbKind"), "CONTAINER");

		doSendKeys(getBy("id", "txtGoodsTypeId"), "12-A");
		doSendKeys(getBy("id", "txtDescription"), "Raw material");
		doSendKeys(getBy("id", "txtContainerTypeDesc"), "MCO");
		doSendKeys(getBy("id", "txtContainerSizeDesc"), "20 ft");
		doSendKeys(getBy("id", "cmbFCL"), "LCL");
		doSendKeys(getBy("name", "ContainerOwner"), "Alex Anaya");

		doSendKeys(getBy("id","txtQty"), "100");
		doSendKeys(getBy("id","txtVol"), "100");
		doSendKeys(getBy("id","txtNWt"), "100");
		doSendKeys(getBy("id","txtGWt"), "100");
		doSendKeys(getBy("id","txtTWt"), "100");
		
		
		doSendKeys(getBy("xpath", "//td[@id='cell_QtyUnitOfMeasurement']//input[@name='txtQtyUOMDesc']"), "Unit"); 
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "txtNWeightUOMDesc"), "Kilograms");
		doSendKeys(getBy("id", "txtGrossUOMDesc"), "Kilograms");		
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilograms");

		doSendKeys(getBy("name", "txtMarkId"), "M001");
		doSendKeys(getBy("name", "txtMarkType"), "Standared");
		doSendKeys(getBy("id", "txtsealNo"), "S00101");
		doSendKeys(getBy("name", "txtRemarks"), "Created By Automation Selenium");	
		
		doClick(getBy("id", "btnCreate"));

		doClick(getBy("cssSelector", "#cancel[value='Back']"));
	}
	public void createLandHBItems() {
		doClick(getBy("id", "btnNew"));

		doSendKeys(getBy("id", "txtContainerNo"), "POIU7654321");
		doSendKeys(getBy("xpath", "//select[@id='cmbKind']"), "CONTAINER");

		doSendKeys(getBy("id", "txtGoodsTypeId"), "12-A");
		doSendKeys(getBy("id", "txtDescription"), "Raw material");
		doSendKeys(getBy("id", "txtContainerTypeDesc"), "MCO");
		doSendKeys(getBy("id", "txtContainerSizeDesc"), "20 ft");
		doSendKeys(getBy("id", "cmbFCL"), "LCL");
		doSendKeys(getBy("name", "ContainerOwner"), "Alex Anaya");

		doSendKeys(getBy("id","txtQty"), "100");
		doSendKeys(getBy("id","txtVol"), "100");
		doSendKeys(getBy("id","txtNWt"), "100");
		doSendKeys(getBy("id","txtGWt"), "100");
		doSendKeys(getBy("id","txtTWt"), "100");
		
		
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "txtNWeightUOMDesc"), "Kilograms");
		doSendKeys(getBy("id", "txtGrossUOMDesc"), "Kilograms");		
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilograms");

		doSendKeys(getBy("name", "txtMarkId"), "M001");
		doSendKeys(getBy("name", "txtMarkType"), "Standared");
		doSendKeys(getBy("id", "txtsealNo"), "S00101");
		doSendKeys(getBy("name", "txtRemarks"), "Created By Automation Selenium");	
		
		doClick(getBy("id", "btnCreate"));

		doClick(getBy("cssSelector", "#cancel[value='Back']"));
	}
}
