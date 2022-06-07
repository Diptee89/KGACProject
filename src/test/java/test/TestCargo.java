package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;

public class TestCargo extends TestBase {
	private ManifestInformationPage objMNFInfo;
	ManifestListPage objMNFList;
	ImportHouseBillPage objHBL;
	HBItemsPage objHBItems;

	private String strPass = "fx5test";
	private String url = "http://10.138.108.44/MCKWFX5TEST/Main.aspx";

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
//	@Test(priority = 0)
	@Test(priority = 0)
	public void testCreateManifest() {

		objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);

//		Create and Submit Manifest
		login("nas.csa", strPass);
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();

	}

	@Test(priority = 1)
	public void testCreateCargoHBL() {
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);
		objHBL.createBLForCargo();
		objHBItems.createHBItems();

	}

	@Test(priority = 2)
	public void testCreatePassengerHBL() {
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);

		objHBL.createBLForPassenger();
		objHBItems.createHBItems();

	}

//	@Test(priority = 3)
	public void testCreateCourierHBL() {
		objHBL = new ImportHouseBillPage(driver);
		objHBL.createBLForCourier();
	}

	@Test(priority = 4)
	public void testCreateBWHHBL() {
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);

		objHBL.createBLForBWH();
		objHBItems.createHBItems();

	}

	@Test(priority = 5)
	public void testSubmitManifest() {
		objMNFInfo.submitManifest();
		logOut();

	}

	@Test(priority = 6)
	public void testApproveManifest() {
//		Approve Manifest
		login("cmanifest.kwi", strPass);
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();

	}

	@Test(priority = 7)
	public void testIssueDO() {
//		Issue DO
		login("nas.csa", strPass);
		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(objMNFInfo.manifestNo);
		objMNFList.clickManifestNo();
		objMNFInfo.issueDOs();
		logOut();
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
