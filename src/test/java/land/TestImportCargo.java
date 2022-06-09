package land;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.HBItemsPage;
import com.pages.HomePage;
import com.pages.ImportHouseBillPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.VesselInspectionPage;

public class TestImportCargo extends TestBase {
	private ManifestInformationPage objMNFInfo;
	private ManifestListPage objMNFList;
	private ImportHouseBillPage objHBL;
	private HBItemsPage objHBItems;

	private String url = "http://10.138.108.44/MCKWFX5TEST/Main.aspx";
	private String strPass = "fx5test";
	private String strCarrierAgent = "csa.swk";
	private String strCManifest = "cmanifest.swk";
	private String strBayan = "broker.swk";

//	private String strPass="bam";
//	private String url="http://10.138.108.44/mckwfx5bam/Main.aspx";

	@BeforeTest
	public void setUp() {
		openIE();
		driver.get(url);
		System.out.println(driver.getTitle());
		switchToWindow();
	}

//	@Test(enabled=false)
	@Test(priority = 0)
	public void testCreateManifest() {
		HomePage objHome = new HomePage(driver);
		objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);

//		Create Manifest
		login(strCarrierAgent, strPass);
		objHome.selectPort("ABDELI");

		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createLandManifest();
	}

	@Test(priority = 1)
	public void testCreateHBLCargo() {
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);

		objHBL.createLandBLForCargo();
		objHBItems.createLandHBItems();

	}

	@Test(priority = 2)
	public void testCreateHBLPassenger() {
		objHBL.createLandBLForPassenger();
		objHBItems.createLandHBItems();

	}

	@Test(priority = 3)
	public void testCreateHBLBWH() {
		objHBL.createLandBLForBWH();
		objHBItems.createLandHBItems();

	}

	@Test(priority = 4)
	public void testSubmitAndArriveManifest() {
		objMNFInfo.setTrucksList(); // Cannot Submit & Arrive. Truck Details are missing
		objMNFInfo.submit_ArrivedLandManifest(); // Submit and Arrived
//		Issue DO
		objMNFInfo.issueDOs();

		objMNFInfo.validateTrucks();
		logOut();
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
