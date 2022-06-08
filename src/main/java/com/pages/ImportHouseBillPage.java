package com.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

//@SuppressWarnings("unused")
public class ImportHouseBillPage extends TestBase {
	public ImportHouseBillPage(WebDriver driver) {
		this.driver = driver;
	}

	private By newBy = By.cssSelector("input#new1[title='Create New Bill Of Lading'][class='mcbutton']");
	private By houseBillNoBy = By.cssSelector("#billnumber[name='billnumber'][Attribute='HouseBillNumber']");
	private By housebilldateDatePickerBy = By.cssSelector("#housebilldateDatePicker[class='mcCalendarButton']");
	private By calenderCurrentDateBy = By.cssSelector(".Fx50CalenderCurrentDate");
	private By unregisteredConsigneeBy = By.cssSelector("#UnregisteredConsignee[Attribute='UnregisteredConsignee']");
	private By descriptionBy = By.id("description");
	private By tgWeightBy = By.id("Tgweight");
	private By tquantityManifestedBy = By.id("Tquantitymanifested");
	private By originPortBy = By.id("OriginPort");
	private By createBy = By.cssSelector("#submit10[title='Create'][class='mcbutton']");

	public void createBLForCargo() {
		clickNew();
		setHouseBill();
		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();

//		doClick(By.cssSelector("#cancel[value='Back']"));
	}

	public void createSeaBLForCargo() {
		clickNew();

		Random rand = new Random();
		int value = rand.nextInt(10000);
		String number = Integer.toString(value);
		findElement(houseBillNoBy).sendKeys("HBL/" + number + "/SWK22");

		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		doSendKeys(By.id("UserDONo"), "DO/001/SWK22");
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();

//		doClick(By.cssSelector("#cancel[value='Back']"));
	}

	public void createBLForPassenger() {
		clickNew();
		setHouseBill();
		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		doClick(By.id("IsNotCargo")); // Bill For: Cargo / Passenger /Courier /BWH
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();

	}

	public void createSeaBLForPassenger() {
		clickNew();

		Random rand = new Random();
		int value = rand.nextInt(10000);
		String number = Integer.toString(value);
		findElement(houseBillNoBy).sendKeys("HBL/" + number + "/SWK22");

		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		doSendKeys(By.id("UserDONo"), "DO/001/SWK22");

		doClick(By.id("IsNotCargo")); // Bill For: Cargo / Passenger /Courier /BWH
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();

	}

	public void createBLForCourier() {
//		Manifest can't be submitted, Courier Housebills[HBL/5769/KWI] doesn't have Split Bills
//		Can't create Consolidated house Bill as Courier Bill. 

		clickNew();
		setHouseBill();
		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		doClick(By.id("rdbCourier"));
		doClick(By.id("IsConsole"));
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();


		doClick(By.cssSelector("#cancel[value='Back']"));
	}
	public void createSeaBLForCourier() {
//		Manifest can't be submitted, Courier Housebills[HBL/5769/KWI] doesn't have Split Bills
//		Can't create Consolidated house Bill as Courier Bill. 

		clickNew();

		Random rand = new Random();
		int value = rand.nextInt(10000);
		String number = Integer.toString(value);
		findElement(houseBillNoBy).sendKeys("HBL/" + number + "/SWK22");

		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		doSendKeys(By.id("UserDONo"), "DO/001/SWK22");

		doClick(By.id("rdbCourier"));
		doClick(By.id("IsConsole"));
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();

		doClick(By.cssSelector("#cancel[value='Back']"));
	}

	public void createBLForBWH() {
		clickNew();
		setHouseBill();
		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		doClick(By.id("rdbbwh"));
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();

	}

	public void createSeaBLForBWH() {
		clickNew();

		Random rand = new Random();
		int value = rand.nextInt(10000);
		String number = Integer.toString(value);
		findElement(houseBillNoBy).sendKeys("HBL/" + number + "/SWK22");

		findElement(housebilldateDatePickerBy).click();
		findElement(calenderCurrentDateBy).click();
		doSendKeys(By.id("UserDONo"), "DO/001/SWK22");

		doClick(By.id("rdbbwh"));
//		Goods Details
		findElement(unregisteredConsigneeBy).sendKeys("Alex MD Husain");
		doSendKeys(By.id("txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(By.id("txtExporter"), "Exporter Ali");
		findElement(descriptionBy).sendKeys("Oil");
		findElement(tgWeightBy).sendKeys("100" + Keys.TAB);
		doSendKeys(By.id("txtTareWt"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("volume"), "100");
		doSendKeys(By.id("txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(By.id("txtVolUOMDesc"), "Litre");

		findElement(tquantityManifestedBy).sendKeys("100" + Keys.TAB);
		findElement(originPortBy).sendKeys("%%" + Keys.TAB);
		doSendKeys(By.id("remarks"), "Created Bill For Cargo");
		doSendKeys(By.id("Marks"), "Marks");
		findElement(createBy).click();

	}

	private void clickNew() {
		findElement(newBy).click();
	}

	private void setHouseBill() {
		Random rand = new Random();
		int value = rand.nextInt(10000);
		String number = Integer.toString(value);
		findElement(houseBillNoBy).sendKeys("AWBL/" + number + "/KWI22");
	}
}
