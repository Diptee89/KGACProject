package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;

public class ConfiscationBasicInformation extends BaseClass {
	public ConfiscationBasicInformation(WebDriver driver) {
		this.driver = driver;
	}
/*********Inspector Writer   - inswriter.kwi*/
	
	public void navigateToConfiscation_List() {
		doClick(getBy("cssSelector", "#MenuLabel_Vertical")); //id=MenuLabel_Vertical
		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_Inspection' and @class='mainMenuItem_vertical']/a"));
		doClick(getBy("linkText","Confiscation List"));
	}
	public void createConfiscation() {
		doClick(getBy("cssSelector", "#new"));
		
		doClick(getBy("cssSelector", "#txtConDateTimePicker"));//Select Confiscation Date And Time
		doClick(getBy("cssSelector", "#Fx50CalenderCurrentDate"));//Select current date
		doSendKeys(By.id("conHrs"), "12"); //Confiscation Time
		doClick(getBy("id", "optHBreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "browsereference"));
		switchToWindow();
		doClick(getBy("cssSelector", "#FixedCalendarTodayAnchor"));
		doClick(getBy("cssSelector", "#List_HouseBillsPopupForConfiscateLs_1_HouseBillNumber"));
		switchBackToWindow();
		doClick(getBy("id", "rdbCommercial"));
		doSendKeys(By.id("ddlConfiscationFor"), "People"); //Select Suspect Type People or Company
		doSendKeys(By.id("TranstypeId"), "Aircraft");//Select Transportation type Aircraft or Others		
		doSendKeys(By.id("txtDetectionMethod"), "Regular Examination"); //Select Method Of Discovery		
		
		doClick(getBy("id", "btnCreateNew"));
		}
	
	public void ConfiscationDetailedNotes() {
		doSendKeys(By.id("txtNotes"), "ConfiscationDetailedNotes"); //Enter Confiscation Detailed Notes
		doClick(By.id("btnSave"));
		
	}
	public void ConfiscatedItems() {
		doClick(By.id("cmdConfFindNew"));//Click on New button
		switchToWindow();
		/********Finding Details***********/
		doSendKeys(By.id("findingcat"), "ممنوعات"); // Finding Category ممنوعات
		doSendKeys(By.id("findingclass"), "ممنوعات"); //Finding Class  ممنوعات
		doSendKeys(By.id("ConfCode"), "9702.00.00"); //HS Code
		doSendKeys(By.id("txtConGoods"), "Original engravings"); //Goods Description
		doSendKeys(By.id("txtConfiscatedQuantity"), "100"); //Quantity
		doSendKeys(By.id("txtConMeasurementUnit"), "UNIT"); //Quantity UOM		
		
		/**************Detection Details***************************/
		doSendKeys(By.id("txtHidingMethod"), "Inside personal luggage"); //Hiding Method
		doSendKeys(By.id("txtDetectionMethod"), "Ordinary investigation"); //Detection Method
		doClick(By.id("cmdCreate")); //Click on Create button
		
		switchBackToWindow();
	}
	public void Confiscators() {
		doClick(By.id("cmdConfiscatorNew"));//Click on New button
		switchToWindow();
		doSendKeys(By.id("RegConFullName"), "Inspector"+Keys.TAB); //Search Confiscator Registered in System
		doClick(By.id("btnAddConfiscator")); //Click on Add button
		doClick(By.id("btnsaveconfiscator")); //Click on Save button
		switchBackToWindow();
	}
	
	public void finalConfiscation() {
		doClick(By.id("btnFinConf")); // Click on Final COnfiscation button
	}
	private void selectConfiscationReferenceType() {
		doClick(getBy("id", "optHBreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optDeclreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optPRreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optreferenceTypeGovtPostalPackage")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optreferenceTypeOthers")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		
	}
}
