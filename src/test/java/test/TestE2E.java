package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ImportPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

public class TestE2E extends TestBase {
	private ManifestInformationPage objMNFInfo;
	private CustomsBayanPage objBayan;

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
	@Test
	public void testManifest() {

		ManifestListPage objMNFList = new ManifestListPage(driver);
		objMNFInfo = new ManifestInformationPage(driver);
		ImportHouseBillPage objHBL = new ImportHouseBillPage(driver);
		HBItemsPage objHBItems = new HBItemsPage(driver);

//		Create and Submit Manifest
		login("nas.csa", strPass);
		objMNFList.clickCargoMenu();
		objMNFList.clickNew();
		objMNFInfo.createManifest();
		objHBL.createBLForCargo();
		objHBItems.createHBItems();
		objMNFInfo.submitManifest();
		logOut();

//		Approve Manifest
		login("cmanifest.kwi", strPass);
		objMNFList.clickCargoMenu();
		objMNFList.searchWithTempNo(objMNFInfo.tempManifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.approveManifest();
		logOut();

//		Issue DO
		login("nas.csa", strPass);
		objMNFList.clickCargoMenu();
		objMNFList.seachWithManifestNo(objMNFInfo.manifestNo);
		objMNFList.clickTempNo();
		objMNFInfo.issueDOs();
		logOut();
	}

//	@Test(priority = 1)
	public void testBayan() throws InterruptedException {
		PendingDeliveryOrderListPage objPendingDOList = new PendingDeliveryOrderListPage(driver);
		objBayan = new CustomsBayanPage(driver);
		DeclarationListPage objDecList = new DeclarationListPage(driver);
		ImportPage objImp = new ImportPage(driver);

		login("broker.kwi", strPass);
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
