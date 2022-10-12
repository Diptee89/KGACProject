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

public class TestE2E extends BaseClass
{
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
//	@Test(priority = 0)
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
		objHBItems.createHBItems();
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
		/******************Declare DO & Create Import Bayan*/
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO(objMNFInfo.doNumber);
		objPendingDOList.clickDeclare();

		objBayan.createBayan();

		/*****Edit Created Bayan from Declaration list screen4';u****/		
//		objDecList.clickDeclarationSubMenu();
//		objDecList.searchByTempDec("TIM/29772/KWI22");// tempDeclarationNo
//		objDecList.clickTempNo();
//		objImp.clickEdit();
//		objImp.selectExitPort();

		objImp.addInvoice();
		objImp.addItems();

		objImp.requiredDocuments();
		objImp.addDeclarationVehiclesList();

		objImp.calculateDuty();
		objImp.addPaymentInformation();
		objImp.submitDeclaration();
		logOut();
	}

	@AfterTest
	public void close() {
		driver.close();
	}
}
