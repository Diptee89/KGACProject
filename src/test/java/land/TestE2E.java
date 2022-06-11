package land;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.HomePage;
import com.pages.ImportHouseBillPage;
import com.pages.ImportPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;
import com.pages.VesselInspectionPage;

public class TestE2E extends BaseClass {
	private ManifestInformationPage objMNFInfo;
	private CustomsBayanPage objBayan;
	private ManifestListPage objMNFList;

	private String strCarrierAgent = "csa.swk";
	private String strCManifest = "cmanifest.swk";
	private String strBayan = "broker.swk";

	private String url = "http://10.138.108.44/MCKWFX5TEST/Main.aspx";
	private String strPass = "fx5test";

//	private String strPass = "bam";
//	private String url = "http://10.138.108.44/mckwfx5bam/Main.aspx";

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
	}

//	@Test(enabled=false)
	@Test(priority = 0)
	public void testManifest() {

		HomePage objHome = new HomePage(driver);
		objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);
		ImportHouseBillPage objHBL = new ImportHouseBillPage(driver);
		HBItemsPage objHBItems = new HBItemsPage(driver);

//		Create and Submit Manifest
		login(strCarrierAgent);
		objHome.selectPort("ABDELI");
		
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createLandManifest();
		objHBL.createLandBLForCargo();
		objHBItems.createHBItems();
		objMNFInfo.submitSeaManifest();
		objMNFInfo.issueDOs();

	}

	@Test(priority = 1)
	public void submitVesselInspection() {
//		login(strCarrierAgent, strPass);
		VesselInspectionPage objVesselInspection = new VesselInspectionPage(driver);
		objVesselInspection.clickVesselInspection_SubMenu();
		objVesselInspection.createVessel_Inspection(objMNFInfo.seaManifestNo);
//		objVesselInspection.createVessel_Inspection("MRN/631/SWK22");
	}

	@Test(priority = 2)
	public void arriveManifest() {
//		objMNFList = new ManifestListPage(driver);
//		objMNFInfo = new ManifestInformationPage(driver);

//		login(strCarrierAgent, strPass);

		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(objMNFInfo.seaManifestNo);
		objMNFList.clickEdit();
		objMNFInfo.arriveSeaManiest();
	}

//	@Test(priority = 2)
	public void testBayan() throws InterruptedException {
		PendingDeliveryOrderListPage objPendingDOList = new PendingDeliveryOrderListPage(driver);
		objBayan = new CustomsBayanPage(driver);
		DeclarationListPage objDecList = new DeclarationListPage(driver);
		ImportPage objImp = new ImportPage(driver);

		login(strBayan);
//		Declare DO & Create Import Bayan
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO(objMNFInfo.doNumber);
		objPendingDOList.clickDeclare();

		objBayan.createBayan();

//		Edit Created Bayan from Declaration list screen4';u		
//		objDecList.clickDeclarationSubMenu();
//		objDecList.searchByTempDec("TIM/29661/KWI22");// tempDeclarationNo
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

//	@AfterTest
	public void close() {
		driver.close();
	}
}
