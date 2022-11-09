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
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

public class TestE2E extends BaseClass {
	private ManifestInformationPage objMNFInfo;
	private CustomsBayanPage objBayan;

	private String strCarrierAgent = "nas.csa";
	private String strCManifest = "cmanifest.kwi";
	private String strBayan = "broker.kwi";

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
	}

//	@Test(enabled=false)
	@Test(priority = 0)
	public void testManifest() {

		ManifestListPage objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);
		ImportHouseBillPage objHBL = new ImportHouseBillPage(driver);
		HBItemsPage objHBItems = new HBItemsPage(driver);

//		Create and Submit Manifest
		login(strCarrierAgent);
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
		objHBL.createBLForCargo();
		objMNFInfo.submitManifest();
		logOut();

//		Approve Manifest
		login(strCManifest);
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();

//		Issue DO
		login(strCarrierAgent);
		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(objMNFInfo.manifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@Test(priority = 1)
	public void testBayan() throws InterruptedException {
		PendingDeliveryOrderListPage objPendingDOList = new PendingDeliveryOrderListPage(driver);
		objBayan = new CustomsBayanPage(driver);
		DeclarationListPage objDecList = new DeclarationListPage(driver);
		ImportPage objImp = new ImportPage(driver);

		login(strBayan);
		/****************** Declare DO & Create Import Bayan */
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO(objMNFInfo.doNumber);
		objPendingDOList.clickDeclare();

		objBayan.createBayan();
		objImp.requiredDocuments();
		objImp.addInvoice();
		objImp.addItems();

		objImp.addDeclarationVehiclesList();

		objImp.calculateDuty();
		objImp.addPaymentInformation();
		objImp.submitDeclaration();
		logOut();
        /***************Login as GCS user & Pay Bayan Issuance fee******************************/
		objImp.payBayanIssuanceFee(objBayan.tempDeclarationNo);
		/***************Login as Auditor & review Document and Approve Bayan******************************/

		login("customs.kwi");
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec(objBayan.tempDeclarationNo);// tempDeclarationNo TIM/29801/KWI22
		objDecList.clickTempNo();

		objImp.reviewDoc();
		objImp.approveBayan();
	}

	@AfterTest
	public void close() {
		driver.close();
	}
}
