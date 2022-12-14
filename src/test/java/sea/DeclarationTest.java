package sea;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ImportPage;
import com.pages.InspectionRequestPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

public class DeclarationTest extends BaseClass {

	ManifestListPage objMNFList;
	ManifestInformationPage objMNFInfo;
	ImportHouseBillPage objHBL;
	HBItemsPage objHBItems;

	PendingDeliveryOrderListPage objPendingDOList;
	CustomsBayanPage objBayan;
	DeclarationListPage objDecList;
	ImportPage objImp;
	InspectionRequestPage objInspection;

	private String strBayan = "broker.swk";

	@Test(priority = 1)
	public void testDeclareDO() {

		login(strBayan);
		/****************** Declare DO & Create Import Bayan */
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO("DO/122528/SWK22");// objMNFInfo.doNumber
		objPendingDOList.searchWithSecurity("63140300");
		objPendingDOList.clickDeclare();

	}

	@Test(priority = 2)
	public void testCreateBayan() {
		objBayan.createBayan();
	}

	@Test(priority = 3)
	public void testVehicles() {
		objImp.addDeclarationVehiclesList();
	}

	@Test(priority = 4)
	public void testAddInvoiceItems() {
		objImp.addInvoice();
	}

	@Test(priority = 5)
	public void testAddItems() {
		objImp.addItems();
//		objImp.addItems1();
//		objImp.addItems2();
//		objImp.addItems3();
//		objImp.addItems4();
	}

	@Test(priority = 6)
	public void testRequiredDocument() throws InterruptedException {
		objImp.requiredDocuments();
//		objImp.upload_DigitalDocs();
	}

	@Test(priority = 7)
	public void testCalculateDuty_Payment() {
		objImp.calculateDuty();
		objImp.addPaymentInformation();
	}

	@Test(priority = 11)
	public void testSubmitDeclaration() {
		objImp.submitDeclaration();
		logOut();
	}

	@Test(priority = 12)
	public void testBayanIssuanceFee() {
		login("md.husain");
		objImp.payBayanIssuanceFee();
		objImp.createReceipt("TIM/118573/SWK22");
		objImp.submitReceipt();
		logOut();
	}

	@Test(priority = 13)
	public void testApproveBayan() {
		/***************
		 * Login as Auditor & review Document and Approve Bayan
		 ******************************/
		login("customs.kwi");
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec(objBayan.tempDeclarationNo);
		objDecList.clickTempNo();

//		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red

		logOut();
	}

	@Test(priority = 14)
	public void testCompleteInspection() {

		login("abd.sadoon");
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search(objBayan.tempDeclarationNo);
		objInspection.clickComplete();
		objInspection.clickSeize();
//		objInspection.clickRelease();
//		objInspection.ExitGate(); // Declaration status updated "Exit Released"
//		objInspection.clickRejectInspection();
//		logOut();
	}

	public void testBayan() throws InterruptedException {
		PendingDeliveryOrderListPage objPendingDOList = new PendingDeliveryOrderListPage(driver);
		objBayan = new CustomsBayanPage(driver);
		DeclarationListPage objDecList = new DeclarationListPage(driver);
		ImportPage objImp = new ImportPage(driver);

		login(strBayan);
//		/**********Declare DO & Create Import Bayan*/
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO("DO/55174/KWI22"); // DO/55174/KWI22 DO/55176/KWI22 DO/55179/KWI22 DO/55180/KWI22
															// DO/55182/KWI22 DO/55183/KWI22
		objPendingDOList.clickDeclare();
		objBayan.createBayan();

//		/**Edit Created Bayan from Declaration list screen4';*/	
//		objDecList.clickDeclarationSubMenu();
//		objDecList.searchByTempDec("TIM/29814/KWI22");// tempDeclarationNo TIM/29801/KWI22
//		objDecList.clickTempNo();
//		objImp.clickEdit();
//		objImp.selectExitPort();

		objImp.addInvoice();
//		objImp.addItems();

		objImp.addDeclarationVehiclesList();

		objImp.requiredDocuments();
		objImp.upload_DigitalDocs();
		objImp.calculateDuty();
		objImp.addPaymentInformation();
		objImp.submitDeclaration(); // Status: Submitted to Auditor
		logOut();

		objImp.payBayanIssuanceFee();
		objImp.createReceipt("TIM/118573/SWK22");
		objImp.submitReceipt();
		
		login("customs.kwi");
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec(objBayan.tempDeclarationNo);// tempDeclarationNo TIM/29801/KWI22
		objDecList.clickTempNo();

		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red
	}

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();

		/******** Create Object for Page class */

		objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);
		objPendingDOList = new PendingDeliveryOrderListPage(driver);
		objBayan = new CustomsBayanPage(driver);
		objDecList = new DeclarationListPage(driver);
		objImp = new ImportPage(driver);
		objInspection = new InspectionRequestPage(driver);
	}

}
