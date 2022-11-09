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
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.LogOutPage;
import com.pages.LoginPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;

/**
 * Page Object encapsulates the Cargo Module
 */
public class CargoTest extends BaseClass {
	public WebDriver driver;
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

}