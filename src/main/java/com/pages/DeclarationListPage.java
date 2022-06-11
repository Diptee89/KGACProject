package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class DeclarationListPage extends BaseClass {
	public DeclarationListPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickDeclarationSubMenu() {

		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_Declaration']/a"));
		waitForElementToBeVisible(getBy("xpath",
				"//div[@class='subMenuWrapperDynamic_vertical' and @id='subMenuWrapperDynamicVertical_Declaration']/div[2]/div[2]/a"),
				10);
		doClick(getBy("xpath",
				"//div[@class='subMenuWrapperDynamic_vertical' and @id='subMenuWrapperDynamicVertical_Declaration']/div[2]/div[2]/a"));

	}

	public void searchByTempDec(String strTempDecNo) {
		doClick(getBy("id", "parent_frmSearchDiv_Search"));
		doSendKeys(getBy("name", "TempSADNo"), strTempDecNo + Keys.ENTER);
//		doSendKeys(getBy("name","TempSADNo"), "TIM/29636/KWI22"+Keys.ENTER);
//		doClick(getBy("xpath","//input[@title='Search']")); //Click on Search button
	}

	public void searchByDecNo(String strDecNo) {
		doClick(getBy("xpath", "//input[@title='Search']"));
		doSendKeys(getBy("name", "SADNo"), strDecNo + Keys.ENTER);
	}

	public void clickTempNo() {
		doClick(getBy("xpath", "//td[@id='List_ListDeclaration_0_TempDeclNumber' and @class='mcontent-text']/a"));
	}
}
