package air;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ImportPage;
import com.pages.InspectionRequestPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

public class TestE2E extends BaseClass {
	private ManifestListPage objMNFList;
	private ManifestInformationPage objMNFInfo;
	private ImportHouseBillPage objHBL;
	private HBItemsPage objHBItems;

	private PendingDeliveryOrderListPage objPendingDOList;
	private CustomsBayanPage objBayan;
	private DeclarationListPage objDecList;
	private ImportPage objImp;
	private InspectionRequestPage objInspection;

	private String strCarrierAgent = "nas.csa";
	private String strCManifest = "cmanifest.kwi";
	private String strBayan = "broker.kwi";

	@Test(priority = 0)
	public void testCreateManifest() {
		login(strCarrierAgent);
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
	}

	@Test(priority = 1, invocationCount = 2)
//	@Test(priority = 1)
	public void testCreateHBItems() {
		objHBL.createBLForCargo();
//		objHBItems.createHBItems();
	}

	@Test(priority = 2)
	public void testSubmitManifest() {
		objMNFInfo.submitManifest();
		logOut();
	}

	@Test(priority = 3)
	public void testApproveManifest() {
		login(strCManifest);
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();
	}

	@Test(priority = 4)
	public void testIssueDO() {
		login(strCarrierAgent);
		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(objMNFInfo.manifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@Test(priority = 5)
	public void testDeclareDO() {

		login(strBayan);
		/****************** Declare DO & Create Import Bayan */
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO(objMNFInfo.doNumber);
		objPendingDOList.clickDeclare();

	}

	@Test(priority = 6)
	public void testCreateBayan() {
		objBayan.createBayan();
	}

	@Test(priority = 7)
	public void testRequiredDocument() throws InterruptedException {
		objImp.requiredDocuments();

	}

	@Test(priority = 8)
	public void testAddInvoiceItems() {
		objImp.addInvoice();
		objImp.addItems();
	}

	@Test(priority = 9)
	public void testVehicles() {
		objImp.addDeclarationVehiclesList();
	}

	@Test(priority = 10)
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
		objImp.payBayanIssuanceFee(objBayan.tempDeclarationNo);
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

		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red

		logOut();
	}

	@Test(priority = 14)
	public void testCompleteInspection() {

		login("ins.kwi");
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search(objBayan.tempDeclarationNo);
		objInspection.clickComplete();
		objInspection.clickRelease();
		objInspection.ExitGate(); // Declaration status updated "Exit Released"
//		objInspection.clickRejectInspection();
		logOut();
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

	@AfterTest
	public void close() {
		driver.quit(); // closing every associated window.
//		driver.close(); //closes the currently focused window.
	}
}
