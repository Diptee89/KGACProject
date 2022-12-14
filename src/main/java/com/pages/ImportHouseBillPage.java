package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

//@SuppressWarnings("unused")
public class ImportHouseBillPage extends BaseClass {
	public ImportHouseBillPage(WebDriver driver) {
		this.driver = driver;
	}

	private void clickNew() {
		doClick(getBy("cssSelector", "input#new1[title='Create New Bill Of Lading'][class='mcbutton']"));
	}

	private void setHouseBill() {

		doSendKeys(getBy("cssSelector", "#billnumber[name='billnumber'][Attribute='HouseBillNumber']"), "AWBL/" + uniqueNo() + "/KWI22");
	}
	private void setSeaHouseBill() {
		
		doSendKeys(getBy("cssSelector", "#billnumber[name='billnumber'][Attribute='HouseBillNumber']"), "HBL/" + uniqueNo() + "/SWK22");
	}

//	Carrier Type: Air >> Bill For   Cargo / Passenger/Courier /  BWH 
	public void createBLForCargo() {
		clickNew();
		setHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
//		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee"); //Optional
//		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");//Optional
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
//		doSendKeys(getBy("id", "txtTareWt"), "100");//Optional
//		doSendKeys(getBy("id", "weight"), "100");//Optional
//		doSendKeys(getBy("id", "volume"), "100");//Optional
//		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");//Optional
//		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");//Optional
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
//		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");//Optional
//		doSendKeys(getBy("id", "Marks"), "Marks");//Optional
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

		doClick(getBy("cssSelector", "#cancel[value='Back']")); //Comment if adding Items
	}

	public void createBLForPassenger() {
		clickNew();
		setHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
		doClick(getBy("id", "IsNotCargo")); // Bill For: Cargo / Passenger /Courier /BWH
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);		
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));


	}

	public void createBLForCourier() {
//		Manifest can't be submitted, Courier Housebills[HBL/5769/KWI] doesn't have Split Bills
//		Can't create Consolidated house Bill as Courier Bill. 

		clickNew();
		setHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
		doClick(getBy("id", "rdbCourier"));
		doClick(getBy("id", "IsConsole"));
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

		doClick(getBy("cssSelector", "#cancel[value='Back']"));
	}

	public void createBLForBWH() {
		clickNew();
		setHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
		doClick(getBy("id", "rdbbwh"));
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

	}

//	Carrier Type: Sea >> Bill For   Cargo / Passenger /  BWH 
	public void createSeaBLForCargo() {
		clickNew();

		setSeaHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
		doSendKeys(getBy("id", "UserDONo"), "DO/122367/SWK22");
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

//		doClick(getBy("cssSelector", "#cancel[value='Back']"));
	}
public void addRoute_Points() {
	//Route Points
	doClick(By.id("LookUpHouseBillPath"));
	switchToWindow();
	doClick(By.name("new1"));
	doSendKeys(By.id("OriginPort"), "AEAUH");	// Entry Port ABU DHABI
	doSendKeys(By.id("portname"), "KWSWK");	// Exit Port SHUWAIKH
	doClick(By.id("SaveNewHouseBillPath")); //CLick on Create button
	
//	doClick(By.name("close")); //CLick on Close button to CLose Route Points List Window
	
	switchBackToWindow();
	
}
	public void createSeaBLForPassenger() {
		clickNew();
		setSeaHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
		doSendKeys(getBy("id", "UserDONo"), "DO/001/SWK22");

		doClick(getBy("id", "IsNotCargo")); // Bill For: Cargo / Passenger /Courier /BWH
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");

		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

	}

	public void createSeaBLForBWH() {
		clickNew();
		setSeaHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
		doSendKeys(getBy("id", "UserDONo"), "DO/001/SWK22");

		doClick(getBy("id", "rdbbwh"));
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

	}

//	Carrier Type: Land >> Bill For   Cargo / Passenger /  BWH 
	public void createLandBLForCargo() {
		clickNew();

		doClick(getBy("id", "IsCargo"));
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
//		setFinalDeatination();
		doSendKeys(getBy("id", "consignmentvalue"), "100");
		doSendKeys(getBy("id", "currency"), "kwd");
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");

		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

//		doClick(getBy("cssSelector", "#cancel[value='Back']"));
	}
	public void createLandBLForPassenger() {
		clickNew();

		doClick(getBy("id", "IsNotCargo"));
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
//		setFinalDeatination();
		doSendKeys(getBy("id", "consignmentvalue"), "100");
		doSendKeys(getBy("id", "currency"), "kwd");
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");

		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

//		doClick(getBy("cssSelector", "#cancel[value='Back']"));
	}
	public void createLandBLForBWH() {
		clickNew();

		doClick(getBy("id", "rdbbwh"));
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "description"),"Oil");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		
//		setFinalDeatination();
		doSendKeys(getBy("id", "consignmentvalue"), "100");
		doSendKeys(getBy("id", "currency"), "kwd");
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");

		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));

//		doClick(getBy("cssSelector", "#cancel[value='Back']"));
	}

	
	private void setFinalDeatination() { //Mandatory only for Transit Transport
		doClick(getBy("id", "browsebutton1"));

		switchToWindow();
		doSendKeys(getBy("name", "LocationCode"), "IQABL" + Keys.ENTER);
		doClick(getBy("linkText", "ARBIL"));
		switchBackToWindow();
	}
	public void createConsolidated_ShipmentBL() {
		clickNew();
		setHouseBill();
		doClick(getBy("cssSelector", "#housebilldateDatePicker[class='mcCalendarButton']"));
		doClick(getBy("cssSelector", ".Fx50CalenderCurrentDate"));
		doClick(getBy("id", "IsConsole")); //Consolidated Shipment yes
//		Goods Details
		doSendKeys(getBy("cssSelector", "#UnregisteredConsignee[Attribute='UnregisteredConsignee']"), "Alex MD Husain");
		doSendKeys(getBy("id", "txtNotifiedConsignee"), "Notified Consignee");
		doSendKeys(getBy("id", "txtExporter"), "Exporter Ali");
		doSendKeys(getBy("id", "Tgweight"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "txtTareWt"), "100");
		doSendKeys(getBy("id", "weight"), "100");
		doSendKeys(getBy("id", "volume"), "100");
		doSendKeys(getBy("id", "txtTareWtUOMDesc"), "Kilogram");
		doSendKeys(getBy("id", "txtVolUOMDesc"), "Litre");
		doSendKeys(getBy("id", "Tquantitymanifested"),"100" + Keys.TAB);
		doSendKeys(getBy("id", "OriginPort"),"%%" + Keys.TAB);
		doSendKeys(getBy("id", "remarks"), "Created Bill For Cargo");
		doSendKeys(getBy("id", "Marks"), "Marks");
		doClick( getBy("cssSelector", "#submit10[title='Create'][class='mcbutton']"));
		doClick(getBy("cssSelector", "#CreateNOC"));
	}

}
