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
	HomePage objHome;

	private String strCarrierAgent = "csa.swk";
	private String strCManifest = "cmanifest.swk";
	private String strBayan = "broker.swk";


//	@Test(enabled=false)
	@Test(priority = 0)
	public void testCreateManifest() {


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
	
		objHBL.createSeaBLForCargo();
		objHBL.addRoute_Points();
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
//		logOut();
	}


	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
		

		objHome = new HomePage(driver);		
		objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);
		objHBL = new ImportHouseBillPage(driver);
		objHBItems = new HBItemsPage(driver);

	}

	@AfterTest
	public void close() {
//		driver.close();
	}

}
