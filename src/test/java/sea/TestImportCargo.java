package sea;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.HBItemsPage;
import com.pages.HomePage;
import com.pages.ImportHouseBillPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.VesselInspectionPage;

public class TestImportCargo extends BaseClass {
	private ManifestInformationPage objMNFInfo;
	private ManifestListPage objMNFList;
	private ImportHouseBillPage objHBL;
	private HBItemsPage objHBItems;

//	private String url = "http://10.138.108.44/MCKWFX5TEST/Main.aspx";
//	private String strPass = "fx5test";
	private String strCarrierAgent = "csa.swk";
	private String strCManifest = "cmanifest.swk";
	private String strBayan = "broker.swk";

//	private String strPass="bam";
//	private String url="http://10.138.108.44/mckwfx5bam/Main.aspx";

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
	}

//	@Test(enabled=false)
	@Test(priority = 0)
	public void testCreateManifest() {
		HomePage objHome = new HomePage(driver);		
		objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);


		login(strCarrierAgent);
//		objHome.selectPort("SHUWAIKH");
//		Create Manifest
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createSeaManifest();
		objMNFInfo.setAdditionalInfo();
	}

	@Test(priority = 1)
	public void testCreateHBLCargo() {
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);
	
		objHBL.createSeaBLForCargo();
		objHBItems.createHBItems();
		
	}

	@Test(priority = 2)
	public void testCreateHBLPassenger() {
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);

		objHBL.createSeaBLForPassenger();
		objHBItems.createHBItems();

	}


//	@Test(priority = 4)
	public void testCreateHBLBWH() {
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);

		objHBL.createSeaBLForBWH();
		objHBItems.createHBItems();

	}

	@Test(priority = 5)
	public void testSubmitManifest() {
		objMNFInfo.submitSeaManifest();
//		Issue DO
		objMNFInfo.issueDOs();

	}

	@Test(priority = 6)
	public void submitVesselInspection() {
		VesselInspectionPage objVesselInspection = new VesselInspectionPage(driver);
		
		objVesselInspection.clickVesselInspection_SubMenu();//Click Sub menu
		objVesselInspection.createVessel_Inspection(objMNFInfo.seaManifestNo);//Create and Submit
	}

	@Test(priority = 7)
	public void arriveManifest() {
		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(objMNFInfo.seaManifestNo);
		
		objMNFList.clickEdit();
		
		objMNFInfo.arriveSeaManiest();//Arrive Journey
		logOut();
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
