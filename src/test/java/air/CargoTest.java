package air;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ImportPage;
import com.pages.InspectionRequestPage;
import com.pages.LogOutPage;
import com.pages.LoginPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

/**
 * Page Object encapsulates the Cargo Module
 */
public class CargoTest extends BaseClass {
//	public WebDriver driver;
	ManifestListPage objMNFList;
	ManifestInformationPage objMNFInfo;
	ImportHouseBillPage objHBL;
	HBItemsPage objHBItems;

	PendingDeliveryOrderListPage objPendingDOList;
	CustomsBayanPage objBayan;
	DeclarationListPage objDecList;
	ImportPage objImp;
	InspectionRequestPage objInspection;

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

//	@Test(priority = 1, invocationCount = 10)
	@Test(priority = 1)
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
//		logOut();
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