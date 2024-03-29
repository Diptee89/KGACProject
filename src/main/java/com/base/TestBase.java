package com.base;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LogOutPage;
import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	private String MainWindow;
	public WebDriver driver;
	String url="http://10.138.108.44/MCKWFX5TEST/Main.aspx";
	
//	String url="http://10.138.108.44/mckwfx5bam/Main.aspx";
	
	
	public WebDriver openIE() {
//		System.setProperty("webdriver.ie.driver", "c:\\Drivers\\IEDriverServer.exe");
		WebDriverManager.iedriver().arch32();
//		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.manage().deleteAllCookies();
		return driver;
	}

//    Login 
	public void login(String id, String pass) {
		this.switchToWindow();
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginUser(id, pass);

	}

	public void logOut() {
		LogOutPage objLogOut = new LogOutPage(driver);
		objLogOut.logOutUser();
	}

//     Element utils
	public WebElement findElement(By by) {
		waitForElementToBeVisible(by);
		WebElement elem = driver.findElement(by);
		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
		return elem;
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		findElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		findElement(locator).click();
	}

	public static void clearAndType(WebElement field, String text) {
		field.clear();
		field.sendKeys(text);
	}

	public void acceptAlert() {
		waitForAlert(10).accept();
	}

	public void switchToWindow() {
		MainWindow = driver.getWindowHandle();
//		System.out.println("Parent Winodow ID: " + MainWindow);
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();// to fetch the value iterator() will return from the collection object

		while (i1.hasNext()) { // loop if having some valu until loop will run
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
//				System.out.println("Child Winodow ID: " + ChildWindow);
				// Switching to Child window
				driver.switchTo().window(ChildWindow);

			}
		}
	}
	public void switchBackToWindow() {
		driver.switchTo().window(MainWindow);
	}
	public WebDriver launchBrowser(String browserName) {

		System.out.println("browser name is: " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			WebDriverManager.chromedriver().browserVersion("83.0.4103").setup();
//			WebDriverManager.chromedriver().arch64();
//			System.setProperty("webdriver.chrome.driver", "c:\\Drivers\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver", "c:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
//			WebDriverManager.iedriver().setup();
			WebDriverManager.iedriver().arch32();
//			System.setProperty("webdriver.ie.driver", "c:\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("please pass the correct browser: " + browserName);
		}

		return driver;
	}

	public void launchUrl() {
		if (url == null) {
			System.out.println("please pass the right url");
			return;
		}
		if (url.contains("https//:") || url.contains("http")) {
			driver.get(url);
		} else {
			driver.close();
			try {
				throw new Exception("INVALIDURLEXCEPTION - please pass the right url");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

//	public void launchUrl(URL url) {
//		driver.navigate().to(url);
//	}
	
//	JavaScript Utils
	
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 15; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();
	}

	public void refreshBrowserByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public void generateAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	public String getPageInnerText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeysUsingWithId(String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}

	public void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void drawBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
//  Wait utils	
	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0. polling time = 500 ms
	 * (default)
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementToBeVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));// sel 4.x
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebDriver waitForFrameByLocator(By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	// ************************Drop Down Utils********************//
	public void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(findElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(findElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByValue(By locator, String value) {
		Select select = new Select(findElement(locator));
		select.selectByValue(value);
	}

	public List<String> doGetDropDownOptions(By locator) {
		Select select = new Select(findElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsValList = new ArrayList<String>();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text);
		}
		return optionsValList;
	}

	public void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(findElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public void doSelectWithoutSelect(By locator, String value) {
//		driver.findElement(By.id("drpGatePassCategory")).click();
		List<WebElement> list = findElements(locator);

		for (WebElement e : list) {
			String text = e.getText();
			System.out.print(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	// *******************Actions Utils ************************//
	public void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(findElement(parentMenu)).perform();
		Thread.sleep(2000);
		findElement(childMenu).click();
	}

	public void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(findElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(findElement(childMenu)).perform();
		Thread.sleep(2000);
		findElement(subChildMenu).click();
	}

	public void selectSubMenu(By parentMenu, By childMenu1, By subChildMenu2, By subChildMenu3)
			throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(findElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(findElement(childMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(findElement(subChildMenu2)).perform();
		Thread.sleep(2000);
		findElement(subChildMenu3).click();
	}

	public void doContextClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(findElement(locator)).perform();
	}

	public int getRightClickOptionsCount(By rightClick, By rightClickOptions) {
		return getRightClickOptionsList(rightClick, rightClickOptions).size();
	}

	public List<String> getRightClickOptionsList(By rightClick, By rightClickOptions) {
		List<String> rightClickItems = new ArrayList<String>();
		doContextClick(rightClick);
		List<WebElement> itemsList = findElements(rightClickOptions);
		System.out.println(itemsList.size());

		for (WebElement e : itemsList) {
			String text = e.getText();
			// System.out.println(text);
			rightClickItems.add(text);
		}
		return rightClickItems;
	}

	public void selectRightClickMenu(By rightClick, By rightClickOptions, String value) {
		doContextClick(rightClick);
		List<WebElement> itemsList = findElements(rightClickOptions);
		System.out.println(itemsList.size());
		for (WebElement e : itemsList) {
			String text = e.getText();
			// System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}

	/**
	 * Clicks in the middle of the given element. Equivalent to:
	 * Actions.moveToElement(onElement).click()
	 * 
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(findElement(locator)).perform();
	}

	/**
	 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend).
	 * 
	 * @param locator
	 * @param value
	 */
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(findElement(locator), value).perform();
	}

}
