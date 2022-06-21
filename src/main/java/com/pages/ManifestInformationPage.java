package com.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

//@SuppressWarnings("unused")
public class ManifestInformationPage extends BaseClass {

	public String tempManifestNo;
	public String manifestNo;
	public String doNumber;
	public String seaManifestNo;
	public String landManifestNo;

	public ManifestInformationPage(WebDriver driver) {
		this.driver = driver;
	}

//	private By newButtonBy = By.xpath("//input[@id='new1' and @title='Create New Manifest']");
	private By originPortBy = By.cssSelector("#OriginPort");
	private By expectedArrivalDateDatePickerBy = By.cssSelector("#ExpectedArrivalDateDatePicker");
	private By calenderCurrentDateBy = By.cssSelector(".Fx50CalenderCurrentDate");
	private By arrivaldateDatePickerBy = By.cssSelector("#arrivaldateDatePicker");
	private By vesselNameBy = By.cssSelector("#vesselname");
	private By flightNoBy = By.cssSelector("#FltNo");
	private By remarksBy = By.cssSelector("#remarks");
	private By createbttnBy = By.cssSelector("#createbttn");
	private By tempJourneyNumberBy = By.xpath("//div[@id='vwr_TmpJourneyNumber' and @class='update-text-node']");
	private By okButtonBy = By.id("okbutton");

	private By manualRemakrs = By.id("ManualRemarks");
	private By submitManiestBy = By.id("btnReqForSubJourney");
	private By chkJourneySubmitBy = By.id("chkJourneySubmit");
	private By btnOkBy = By.id("btnOk");
//	private By backBy = By.id("cancel");

	private By errorBy = By.xpath("//p[@class='errorpage_header']");

//	Approve Submission Request
	private By approveBy = By.name("ArrivedSubmitJourney");
	private By manifestNoBy = By.id("vwr_JourneyNumber");

//	Issue DO
	private By chkAllBy = By.id("chkallEQ");
	private By chk1stRowBy = By.id("chk_EO_0");
	private By issueDOsBy = By.id("btnIssueDO");
	private By doNoBy = By.xpath("//td[@id='List_ViewBillsFromManifestLs_0_cell_DONO']/a");

//	Carrier Type:Air 
	public void createManifest() {
		setOriginPort();
		selectExpectedArrivalDate();
		selectArrivaldate();
		setVesselName();
		doSendKeys(By.id("CaptainName"), "Captain Alex");
		setFlightNo();
		doSendKeys(By.id("ShipName"), "Black Pearl");
		setRemarks();
		clickCreatebtn();
		confirmation();
	}

	public void submitManifest() {
		setManualRemarks();
		clickSubmitbtn();
		disclaimerConfirmation();
		confirmation();
//		clickBackbtn();
	}

	public void approveManifest() {
		clickApprovebtn();
		disclaimerConfirmation();
		approveConf();
//		clickBackbtn();
	}

	public void issueDOs() {
		waitForElementToBeVisible(chkAllBy, 10);
		doClick(chkAllBy);
//		doClick(chk1stRowBy);
		doClick(issueDOsBy);
		doNumber = doElementGetText(doNoBy);
		System.out.println("DO Number: " + doNumber);
//		doClick(doNoBy);
	}

//	 Carrier Type:Sea
	public void createSeaManifest() {
//		Manifest Information
		doSendKeys(originPortBy, "INMAA");
//		Vessel Details
		doSendKeys(vesselNameBy, "AL JAZEERA SHIPPING CO WLL");
		doSendKeys(By.id("CaptainName"), "Captain Alex");
		setVoyage();
		doSendKeys(By.id("ShipName"), "Black Pearl");
		setRemarks();
		clickCreatebtn();
		confirmation();
	}

//	The additional info. Pop up in the Manifest, does not contain the required information to Proceed further.
	public void setAdditionalInfo() {
		doClick(By.id("lnkAddInfo"));
		switchToWindow();
		waitForElementToBeVisible(By.id("txtNationality"), 10);//Overcome Stale Element Reference Exception >Refreshing the web page>Using Try Catch Block>>Using ExpectedConditions.refreshed>>Using POM
		doSendKeys(By.id("txtNationality"), "IN");
		doSendKeys(By.id("txtCallSign"), "MG 001");
		doSendKeys(By.id("txtGRT"), "100");
		doSendKeys(By.id("txtLOA"), "10");
		doSendKeys(By.id("txtNRT"), "100");
		doSendKeys(By.id("txtDraught"), "100");
		doSendKeys(By.id("txtContractorCargo"), "Contractor Cargo");
		doSendKeys(By.id("txtContractorContainer"), "LKO28368");
		doSendKeys(By.id("txtPurposeOfCall"), "Passenger");
		doClick(By.id("btnSaveNew"));
		doClick(By.id("btnCancel"));
		switchBackToWindow();
	}

	public void submitSeaManifest() {
		scrollPageDown();
		doClick(By.id("SubmitJourney"));
		disclaimerConfirmation();

		seaManifestNo = doElementGetText(By.id("vwr_JourneyNumber"));
		System.out.println("Sea Manifest Number Generated: " + seaManifestNo);
		doClick(okButtonBy);
		acceptAlert(5);

	}

	public void arriveSeaManiest() {
//		doClick(By.id("edit"));
		selectArrivaldate();
//	Cannot make the Manifest to Arrived as Vessel Inspection for Manifest is not yet Created.
		doClick(By.id("ArrivedJourney"));
		acceptAlert(5);
		disclaimerConfirmation();

	}

//	Carrier Type:Land
	public void createLandManifest() {
//		Manifest Information
		doSendKeys(originPortBy, "IQABD"); // Port Of Origin
		doSendKeys(By.id("ForeignManifest"), "MRN/001/ABD22"); // Foreign Manifest
		doSendKeys(By.id("country"), "IQ"); // Foreign Manifest Nationality
		doSendKeys(By.id("EntryPortName"), "KWABD");
//		Carrier Details
		doSendKeys(vesselNameBy, "TNT"); // Carrier
		doSendKeys(By.id("CaptainName"), "Driver Alex");
		setVoyage();
		doSendKeys(By.id("ShipName"), "Black Pearl");
		setRemarks();
		doSendKeys(By.id("transporttype"), "Empty Import");
		doSendKeys(By.id("CarrierOwner"), "Mitchel MD");

		clickCreatebtn();
		confirmation();
	}

	public void setTrucksList() {
		doClick(By.id("LookUpTrucks"));
		switchToWindow();
		doClick(By.id("new1"));

		doSendKeys(By.id("PN_Num1"), "101");
		doSendKeys(By.id("PN_LONGN"), "987654");
		doSendKeys(By.name("TruckNumber"), "XD626EG47J1A08097");// Chassis No
		doSendKeys(By.id("convoyno"), "TS01ER1643");
		doSendKeys(By.id("VehicleType"), "SEDAN");
		doSendKeys(By.id("VehicleModel"), "2018");
		doSendKeys(By.id("truckcountname"), "IQ");
		doSendKeys(By.id("mobilenumber"), "98765432");
		doSendKeys(By.id("DriverName"), "Irfan Moli");
		doSendKeys(By.id("country"), "SA");
		doSendKeys(By.id("Passport"), "P9878789");
		doSendKeys(By.id("CivilId"), "321030900015");
		doSendKeys(By.id("txtOwner"), "Sareef Moli");
		doSendKeys(By.id("txtColor"), "White");
		doSendKeys(By.id("txtSealCount"), "2");
		doSendKeys(By.id("txtSealNo1"), "S8475637845");
		doSendKeys(By.id("txtSealNo2"), "S000000234");

		doClick(By.id("SaveNewTrucks"));// Click on Create button
		doClick(By.id("close")); // Close Truck List screen window.
		switchBackToWindow();
	}

	public void submit_ArrivedLandManifest() {

		doClick(By.id("ArrivedSubmitJourney"));
		disclaimerConfirmation();

		landManifestNo = doElementGetText(By.id("vwr_JourneyNumber"));// MRN/84/ABD22
		System.out.println("Land Manifest Number Generated: " + landManifestNo);
		doClick(By.id("okbutton"));

	}

	public void validateTrucks() {
		doClick(By.id("ValidateDecVeh"));
		System.out.println(doElementGetText(By.className("errorpage_header")));
		doClick(By.className("errorpage_links"));
	}

	/*
	 * Confirmation: TMRN/8652/KWI22 Has been Submitted Successfully.
	 * 
	 */
	private void confirmation() {
		tempManifestNo = doElementGetText(tempJourneyNumberBy);

		System.out.println("Temporary Manifest Number Generated: " + tempManifestNo);

		doClick(okButtonBy);
	}

	/*
	 * Confirmation: MRN/7347/KWI22 Has been Approved Successfully.
	 */
	private void approveConf() {
		manifestNo = doElementGetText(manifestNoBy);

		System.out.println("Manifest Number Generated: " + manifestNo);

		doClick(okButtonBy);
	}

	private void disclaimerConfirmation() {
		switchToWindow();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(chkJourneySubmitBy));

		doClick(chkJourneySubmitBy);

		doClick(btnOkBy);
		switchBackToWindow();
	}

	private void setOriginPort() {
		doSendKeys(originPortBy, "TTA");
	}

	private void selectExpectedArrivalDate() {
		doClick(expectedArrivalDateDatePickerBy);
		doClick(calenderCurrentDateBy);
	}

	private void selectArrivaldate() {
		doClick(arrivaldateDatePickerBy);
		doClick(calenderCurrentDateBy);
	}

	private void setVesselName() {
		doSendKeys(vesselNameBy, "TNT");
	}

	private void setFlightNo() {

		doSendKeys(flightNoBy, uniqueNo());
	}

	private void setVoyage() {
		doSendKeys(By.id("Voyage"), uniqueNo());
	}

	private void setRemarks() {
		doSendKeys(remarksBy, "Created By Selenium Automation For Testing");

	}

	private void setManualRemarks() {

		doSendKeys(manualRemakrs, "Submitted");
	}

	private void clickCreatebtn() {
		doClick(createbttnBy);
	}

	private void clickSubmitbtn() {
		doClick(submitManiestBy);

	}

	private void clickApprovebtn() {

		doClick(approveBy);
	}

}
