package com.pages;

import org.openqa.selenium.By;
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
		doClick(getBy("id", "optHBreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "browsereference"));
		switchToWindow();
		doClick(getBy("cssSelector", "#FixedCalendarTodayAnchor"));
		doClick(getBy("cssSelector", "#List_HouseBillsPopupForConfiscateLs_3_HouseBillNumber"));
		switchBackToWindow();
		doClick(getBy("id", "rdbCommercial"));
		doSendKeys(By.id("ddlConfiscationFor"), "People"); //Select Suspect Type People or Company
		doSendKeys(By.id("TranstypeId"), "Aircraft");//Select Transportation type Aircraft or Others		
		doSendKeys(By.id("txtDetectionMethod"), "Regular Examination"); //Select Method Of Discovery		
		
		doClick(getBy("id", "btnCreateNew"));
		}
	private void selectConfiscationReferenceType() {
		doClick(getBy("id", "optHBreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optDeclreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optPRreferenceType")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optreferenceTypeGovtPostalPackage")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		doClick(getBy("id", "optreferenceTypeOthers")); //Confiscation Reference Type radio button Housebill  Declarations  Passenger Receipt    Govt.Postal Package  Unknown reference
		
	}
}
