package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.base.BaseClass;

public class PendingDeliveryOrderListPage extends BaseClass {
	public PendingDeliveryOrderListPage(WebDriver driver) {
		this.driver = driver;
	}

	private By menuNavigateIconBy = By.cssSelector(".menuNavigateIcon");
	private By mainMenuDeclarationBy = By.xpath("//div[@id='mainMenuItemVertical_Declaration']/a");
	private By subMenuPendingDOBy = By.linkText("Pending D.O");
	private By frmSearchDiv_SearchBy = By.className("frmSearchDiv_Search");
	private By DONoBy = By.name("DONo");
	private By securityNoBy = By.name("IDNO");
	private By searchBy = By.className("mcSearchbutton");
	private By declarBy = By.xpath("//td[@id='List_listdeliveryorder_0_ECABAAA']/a");

	public void clickPendingDOSubMenu() {
		doClick(menuNavigateIconBy);
		selectMenu(mainMenuDeclarationBy);
		doClick(subMenuPendingDOBy);
	}

	public void searchWithDO(String strDONumber) {
		doClick(frmSearchDiv_SearchBy);
		doSendKeys(DONoBy, strDONumber + Keys.ENTER);
	}

	public void searchWithSecurity(String strSecurityNumber) {

		doSendKeys(securityNoBy, strSecurityNumber);
		doClick(searchBy);
	}

	public void clickDeclare() {
		doClick(declarBy);
	}
}
