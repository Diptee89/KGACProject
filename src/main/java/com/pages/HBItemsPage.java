package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.TestBase;

public class HBItemsPage extends TestBase {
	public HBItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	/*for Dropdown list
	 * var input = driver.findElement(By.id("input")); input.sendKeys("Auto");
	 * 
	 * String optionValue =
	 * driver.findElement(By.xpath("//option[contains(@value,'TEST')]")).
	 * getAttribute("value"); input.clear(); input.sendKeys(optionValue);
	 */
	public void createHBItems() {
		doClick(By.id("btnNew"));

		doSendKeys(By.id("txtContainerNo"), "POIU7654321");
		doSendKeys(By.xpath("//select[@id='cmbKind']"), "CONTAINER");

		doSendKeys(By.id("txtGoodsTypeId"), "12-A");
		doSendKeys(By.id("txtDescription"), "Raw material");
		doSendKeys(By.id("txtContainerTypeDesc"), "MCO");
		doSendKeys(By.id("txtContainerSizeDesc"), "20 ft");
		doSendKeys(By.id("cmbFCL"), "LCL");
		doSendKeys(By.name("ContainerOwner"), "Alex Anaya");

		doSendKeys(By.id("txtQty"), "100");	
		doSendKeys(By.id("txtVol"), "100");
		doSendKeys(By.id("txtNWt"), "100");
		doSendKeys(By.id("txtGWt"), "100");		
		doSendKeys(By.id("txtTWt"), "100");
		
		
		doSendKeys(By.xpath("//td[@id='cell_QtyUnitOfMeasurement']//input[@name='txtQtyUOMDesc']"), "pieces"); 
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");
		doSendKeys(By.id("txtNWeightUOMDesc"), "Kilograms");
		doSendKeys(By.id("txtGrossUOMDesc"), "Kilograms");		
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilograms");

		doSendKeys(By.name("txtMarkId"), "M001");
		doSendKeys(By.name("txtMarkType"), "Standared");
		doSendKeys(By.id("txtsealNo"), "S00101");
		doSendKeys(By.name("txtRemarks"), "Created By Automation Selenium");	
		
		doClick(By.id("btnCreate"));

		doClick(By.cssSelector("#cancel[value='Back']"));
	}
}
