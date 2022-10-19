package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

//@SuppressWarnings("unused")
public class ManifestListPage extends BaseClass {
	public ManifestListPage(WebDriver driver) {
		this.driver = driver;
	}

	private By menuNavigateIconBy = By.cssSelector("#MenuLabel_Vertical");
	private By mainMenuCargoBy = By
			.xpath("//div[@id='mainMenuItemVertical_Manifest' and @class='mainMenuItem_vertical']/a");
	private By subMenuManifestBy = By.linkText("Manifest");
	
	private By newButtonBy = By.xpath("//input[@id='new1' and @title='Create New Manifest']");
//	Search
	private By searchBy = By.id("parent_frmSearchDiv_Search");
	private By tempMNFNoBy = By.name("Temp.No");
	private By manifestNoBy = By.name("JourneyNumber");
//	private By searchbtnBy=By.className("mcSearchbutton");

//	Calender Search
	private By calenderBy = By.id("parent_frmSearchDiv_Calendar");
	private By todayDateBy = By.xpath("//span[@id='FixedCalendarTodayAnchor']/a");

	private By tempLinkBy = By.xpath("//tr[@id='List_journey_0_' and @class='DataGridItem_Row']/td[2]/a");

	public void clickCargoMenu() {
		waitForElementToBeVisible(menuNavigateIconBy, 10);
		doClick(menuNavigateIconBy);
		selectMenu(mainMenuCargoBy);
		doClick(subMenuManifestBy);

	}

	public void searchWithCalender() {
		doClick(calenderBy);
		doClick(todayDateBy);

	}

	public void searchWithTempNo(String strTempNo) {
		doClick(searchBy);
		doSendKeys(tempMNFNoBy, strTempNo + Keys.ENTER);

//		doClick(searchbtnBy);
	}

	public void seachWithManifestNo(String strManifestNo) {
		doClick(searchBy);
		doSendKeys(manifestNoBy,strManifestNo + Keys.ENTER);
	}

	public void clickTempNo() {
		doClick(tempLinkBy);
	}

	public void clickEdit() {
		doClick(By.linkText("Edit"));
	}

	public void clickManifestNo() {
		doClick(By.xpath("//td[@id='List_journey_0_JourneyNumber']/a"));
	}

	public void clickNew() {
//		Click on new button 
		doClick(newButtonBy);
	}
}
