package air;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CustomsBayanPage;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.NOCInformationPage;

public class NOCTest extends BaseClass {
	private ManifestInformationPage objMNFInfo;
	private NOCInformationPage objNOCInfo;
	private String strCarrierAgent = "nas.csa";
	private String strCManifest = "cmanifest.kwi";
	private String strFFAgent = "universal";

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
	}

	@Test(priority = 0)
	public void testManifest() {

		ManifestListPage objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);
		ImportHouseBillPage objHBL = new ImportHouseBillPage(driver);
//		HBItemsPage objHBItems = new HBItemsPage(driver);
		objNOCInfo = new NOCInformationPage(driver);

//		Create Manifest
		login(strCarrierAgent);
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
		objHBL.createConsolidated_ShipmentBL();

		objNOCInfo.submitNOC();
		logOut();
		
//		/*********pay Issuance Fee*************/
		objNOCInfo.payIssuanceFee();
		
//		Create Split BL by FF Agent
		login(strFFAgent);
		objNOCInfo.navigateToBL();
		objNOCInfo.openNOCIssuedRecord();
		objNOCInfo.splited_BillsOfLading();
		logOut();	
		
		
//		Submit Manifest
		login(strCarrierAgent);
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);//objMNFInfo.tempManifestNo
		objMNFList.clickTempNo();
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

}
