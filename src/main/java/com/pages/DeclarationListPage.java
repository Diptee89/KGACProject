package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;

public class DeclarationListPage extends BaseClass {
	public DeclarationListPage(WebDriver driver) {
		this.driver = driver;
	}
	private By menuNavigateIconBy = By.cssSelector(".menuNavigateIcon");
	private By mainMenuDeclarationBy = By.xpath("//div[@id='mainMenuItemVertical_Declaration']/a");
	public void clickDeclarationSubMenu() {
		doClick(menuNavigateIconBy);
		selectMenu(mainMenuDeclarationBy);
//		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_Declaration']/a"));
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
		waitForElementPresent(getBy("xpath", "//td[@id='List_ListDeclaration_0_TempDeclNumber']/a"), 20);
		doClick(getBy("xpath", "//td[@id='List_ListDeclaration_0_TempDeclNumber']/a"));
	}
}
