package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.base.TestBase;

public class ImportPage extends BaseClass {
	public ImportPage(WebDriver driver) {
		this.driver = driver;
	}

	private By editBy = By.id("edit");
	private By cancelBy = By.id("cancel");
	private By validateDecVehBy = By.id("ValidateDecVeh");
	private By cmdCancelDecBy = By.id("cmdCancelDec");
	private By ddFormBy = By.id("btnCreateIDD");
	private By saveBy = By.id("savebttn3");
	private By calculateDutyBy = By.id("makepayment");

	private By addInvoiceBy = By.id("addinvoice");

//	Declaration Documents
	private By requiredDocumentBy = By.id("viewCCPReqDocs");

	/****************** Provided Documents Count *************************/
	private By requiredDocumentsLs_0By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_0_']");
//	private By requiredDocumentsLs_0By=By.xpath("//input[@thisRowID='List_ListCCPRequiredDocumentsLs_0_']"); //@SubType='+number' and @type='text' 
	private By requiredDocumentsLs_1By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_1_']");
	private By requiredDocumentsLs_2By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_2_']");
	private By requiredDocumentsLs_3By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_3_']");
	private By requiredDocumentsLs_4By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_4_']");
	private By requiredDocumentsLs_5By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_5_']");
	private By requiredDocumentsLs_6By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_6_']");
	private By requiredDocumentsLs_7By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_7_']");
	private By requiredDocumentsLs_8By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_8_']");
	private By requiredDocumentsLs_9By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_9_']");
	private By requiredDocumentsLs_10By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_10_']");
	private By requiredDocumentsLs_11By = By
			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_11_']");
//	private By requiredDocumentsLs_12By = By
//			.xpath("//input[@name='ProvidedDocumentsCount' and @thisRowID='List_ListCCPRequiredDocumentsLs_12_']");

	/****************** Uploaded Document Count *************************/
	private By UploadedDocument_0By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_0_ScanDocumentReq']");
//	private By UploadedDocument_1By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_1_ScanDocumentReq']");
//	private By UploadedDocument_2By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_2_ScanDocumentReq']");
//	private By UploadedDocument_3By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_3_ScanDocumentReq']");
//	private By UploadedDocument_4By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_4_ScanDocumentReq']");
//	private By UploadedDocument_5By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_5_ScanDocumentReq']");
//	private By UploadedDocument_6By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_6_ScanDocumentReq']");
//	private By UploadedDocument_7By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_7_ScanDocumentReq']");
//	private By UploadedDocument_8By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_8_ScanDocumentReq']");
//	private By UploadedDocument_9By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_9_ScanDocumentReq']");
//	private By UploadedDocument_10By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_10_ScanDocumentReq']");
//	private By UploadedDocument_11By = By.xpath("//td[@id='List_ListCCPRequiredDocumentsLs_11_ScanDocumentReq']");
	
	

	private By saveDocumentsBy = By.id("Associate");

	private By digitalDocumentsBy = By.linkText("Digital Documents");

	private By closeDocumentsBy = By.id("btnClose");

//	Declaration Vehicles List
	private By declarationVehiclesListlnkBy = By.id("DeclarationVehicles");
	private By NewBtnBy = By.id("NewBtn");
	private By drpGatePassCategoryBy = By.id("drpGatePassCategory");
//	private By drpGatePassCategoryOptionBy = By.xpath("//select[@id='drpGatePassCategory']/option[2]");
	private By drpCargoTypeBy = By.id("drpCargoType");
	private By drpTruckNCarrierSizeBy = By.id("drpTruckNCarrierSize");
	private By PN_Num1By = By.id("PN_Num1");
	private By PN_LONGNBy = By.id("PN_LONGN");
	private By txtCivilIDBy = By.id("txtCivilID");
	private By txtWeigtBy = By.id("txtWeigt");
	private By createNewVehicleBy = By.id("SaveNewVehicle");
	private By saveContainersBy = By.id("SaveContainers");
	private By cancelDecVehicleDetailsBy = By.id("cancel");
	private By closeDecVehicleListBy = By.id("close");

	public void clickEdit() {
		doClick(editBy);
	}

	public void requiredDocuments() throws InterruptedException {
		doClick(requiredDocumentBy);
		switchToWindow();
		waitForElementToBeVisible(saveDocumentsBy, 10);

		doSendKeys(requiredDocumentsLs_0By, "1");
		doSendKeys(requiredDocumentsLs_1By, "1");
		doSendKeys(requiredDocumentsLs_2By, "1");
		doSendKeys(requiredDocumentsLs_3By, "1");
		doSendKeys(requiredDocumentsLs_4By, "1");
		doSendKeys(requiredDocumentsLs_5By, "1");
		doSendKeys(requiredDocumentsLs_6By, "1");
		doSendKeys(requiredDocumentsLs_7By, "1");
		doSendKeys(requiredDocumentsLs_8By, "1");
		doSendKeys(requiredDocumentsLs_9By, "1");
		doSendKeys(requiredDocumentsLs_10By, "1");
		doSendKeys(requiredDocumentsLs_11By, "1");
		doClick(saveDocumentsBy);
		
		upload_DigitalDocs();
		
		doClick(closeDocumentsBy);
		switchBackToWindow();

	}
	private void upload_DigitalDocs() throws InterruptedException {
		waitForElementToBeVisible(UploadedDocument_0By, 50);			
		doClick(UploadedDocument_0By);
		switchBackToWindow();
		switchToWindow();
		
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Acknowledgment and Undertaking");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Packing List");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Invoice");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Etemad Tawkie");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Releasing");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Import license");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Declaration of address");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Commercial License");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Civil ID");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Delivery Orders");
		uploadDoc();
		doSendKeys(By.id("ddlDocumentTypes"), "Housebill");
		uploadDoc();
		
		doClick(By.id("CloseBtn"));
		
		switchBackToWindow();
		switchToWindow();
	}
	private void uploadDoc() throws InterruptedException {
		Thread.sleep(2000);
		doSendKeys(By.id("MultiFiles"), "C:\\Users\\dsingh\\eclipse22-workspace\\KGAC\\KGACProject\\src\\main\\java\\com\\testData\\TestData.pdf");
		doClick(By.id("UploadBtn"));
	}
	
	
	/*
	 * cannot convert it to a Select object type as that doesn't accept datalist
	 * tags cannot click the datalist directly as it throws an ElementNotIteractable
	 * cannot use actions to moveto and click - you get
	 * "Failed to execute 'elementsFromPoint' on 'Document'" cannot use action
	 * tokeys down + keys enter - just doesn't do it cannot use a JS executor to
	 * click- does nothing
	 * 
	 * So - what's left, is to recreate what the spec says the dropdown does.
	 * 
	 * Type your partial text in the input. Get your option object (confirming the
	 * popup exists) get the value attribute clear and send keys to the input
	 */

	public void addDeclarationVehiclesList() {
		doClick(declarationVehiclesListlnkBy);
		switchToWindow();
		waitForElementPresent(NewBtnBy, 10);
		doClick(NewBtnBy);

		doSendKeys(drpGatePassCategoryBy, "General loads");
		doSendKeys(drpCargoTypeBy, "General Cargo");
		doSendKeys(drpTruckNCarrierSizeBy, "Half Lorry");

		doSendKeys(PN_Num1By, "91");
		doSendKeys(PN_LONGNBy, "202298765");

		doSendKeys(txtCivilIDBy, "321030900015");

		doSendKeys(txtWeigtBy, "100");
		doClick(createNewVehicleBy);
		waitForElementToBeVisible(saveContainersBy, 10);
		doClick(cancelDecVehicleDetailsBy);
		doClick(closeDecVehicleListBy);
		switchBackToWindow();

	}

	public void selectExitPort() throws InterruptedException {
		/*
		 * KUWAIT INTNL.AIRPORT SHUAIBA SHUWAIKH ABDELI DOHA SALMI (KUWAIT)
		 * NUWAISEEB(KUWAIT)
		 */
		doSendKeys(By.xpath("//select[@id='dldExitportName']"), "DOHA");

	}

//	Invoice Details -->Invoice Information

	public void addInvoice() {
		doClick(By.id("addinvoice"));
		doSendKeys(By.id("orderno"), "INV202201");
		doClick(By.id("orderdateDatePicker"));
		doClick(By.id("Fx50CalenderCurrentDate"));

		doSendKeys(By.id("SupplierName"), "Alex md");

		doSendKeys(By.id("currency"), "KWD");
		doSendKeys(By.id("country"), "SA");

		doClick(By.id("SaveNewCommercialInvoiceOne"));

	}

//	Add Items -->Invoice Items
	public void addItems() {
		doClick(By.xpath("//td[@id='List_DeclarationInvoice_0_NewItem']/a"));
		doSendKeys(By.id("hscode"), "9702.00.00");
		doSendKeys(By.id("country"), "SA");
		doSendKeys(By.id("description"), "Original engravings, prints and lithographs.");
		doSendKeys(By.id("Manufacturer"), "Alex MD");
		doSendKeys(By.id("totalprice"), "100");
		doSendKeys(By.id("noofpackages"), "100");
//		Browse and Select Package Type
		doClick(By.id("btnPackageType"));
		switchToWindow();
		doSendKeys(By.name("Name"), "Piece" + Keys.ENTER);
		doClick(By.xpath("//td[@id='List_PackageTypeLsPg_0_Description']/a"));
		switchBackToWindow();

		doSendKeys(By.id("quantity"), "100");
		doSendKeys(By.id("weight"), "100");
		doSendKeys(By.id("Gross1"), "100");
		doClick(By.id("chkInfoIsCrct"));
		doClick(By.id("createnew"));

	}

	public void calculateDuty() {
		doClick(calculateDutyBy);
	}

//	Payment Information
	public void addPaymentInformation() {
		doSendKeys(By.id("paymentmethod"), "KNet POS");
		doClick(By.id("next"));

		doSendKeys(By.id("CashReceiptNumber"), "2022001");
		doClick(By.id("addtopayment"));
		doClick(By.id("payment_save"));

	}

	public void submitDeclaration() {
		doClick(By.name("submitdeclaration"));
//		Disclaimer Confirmation
		switchToWindow();
		doClick(By.id("chkSubmitDeclaration"));
		doClick(By.id("btnOk"));
		switchBackToWindow();
	}
	public void payBayanIssuanceFee(String strReferenceNo) {
		login("md.husain");
		doClick(getBy("cssSelector", "#MenuLabel_Vertical"));
		selectMenu(getBy("xpath", "//div[@id='mainMenuItemVertical_GCSAcs']/a"));
		doClick(getBy("linkText", "Receipts"));

		doClick(By.id("btnNew"));
		doClick(By.id("IsOthers"));
		doSendKeys(By.id("txtReceivedFrom"), "1233");
		doClick(By.id("btnCreate"));
		doClick(By.id("btnNew"));
		doSendKeys(By.id("txtReferenceNo"), strReferenceNo); // TIM/29804/KWI22 "TIM/29801/KWI22"
		doClick(By.id("btnCreate"));
		doClick(By.id("btnSubmit"));
		logOut();
	}
	
	public void reviewDoc() {
		doClick(requiredDocumentBy); //CLick on Required Document link
		switchToWindow();
		doClick(By.id("lnkvwuploadDoc")); //Click on View Document Gallery link from 'Declaration Documents' page
		
		switchBackToWindow();
		switchToWindow();
		doClick(By.id("img_Rev_0_0"));
		doClick(By.id("DocTypeCounts_1")); //DocTypeCounts_11
		doClick(By.id("img_Rev_1_0"));
		doClick(By.id("DocTypeCounts_2")); //DocTypeCounts_11
		doClick(By.id("img_Rev_2_0"));
		doClick(By.id("DocTypeCounts_3")); //DocTypeCounts_11
		doClick(By.id("img_Rev_3_0"));
		doClick(By.id("DocTypeCounts_4")); //DocTypeCounts_11
		doClick(By.id("img_Rev_4_0"));
		doClick(By.id("DocTypeCounts_5")); //DocTypeCounts_11
		doClick(By.id("img_Rev_5_0"));
		doClick(By.id("DocTypeCounts_6")); //DocTypeCounts_11
		doClick(By.id("img_Rev_6_0"));
		doClick(By.id("DocTypeCounts_7")); //DocTypeCounts_11
		doClick(By.id("img_Rev_7_0"));
		doClick(By.id("DocTypeCounts_8")); //DocTypeCounts_11
		doClick(By.id("img_Rev_8_0"));
		doClick(By.id("DocTypeCounts_9")); //DocTypeCounts_11
		doClick(By.id("img_Rev_9_0"));
		doClick(By.id("DocTypeCounts_10")); //DocTypeCounts_11
		doClick(By.id("img_Rev_10_0"));
		doClick(By.id("DocTypeCounts_11")); //DocTypeCounts_11
		doClick(By.id("img_Rev_11_0"));
		
//		doClick(By.xpath("//input[@vaue='Save reviews']"));
		doClick(By.id("RvwBtn"));
		
		acceptAlert(10);
		driver.close();
		switchBackToWindow();
		
		switchToWindow();
		driver.close();
		switchBackToWindow();
	}
	
	public void approveBayan() {
		doClick(By.id("approvepayment")); //CLick on Approve Bayan
		acceptAlert(10);
		acceptAlert(10); //Status updated "Audited and in Red"
	}
}
