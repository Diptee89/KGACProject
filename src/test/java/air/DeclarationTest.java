package air;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ImportPage;
import com.pages.InspectionRequestPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;


public class DeclarationTest extends BaseClass{
		
	ManifestListPage objMNFList;
	ManifestInformationPage objMNFInfo;
	ImportHouseBillPage objHBL;
	HBItemsPage objHBItems;

	PendingDeliveryOrderListPage objPendingDOList;
	CustomsBayanPage objBayan;
	DeclarationListPage objDecList;
	ImportPage objImp;
	InspectionRequestPage objInspection;


	private String strBayan = "BROKER.AIR";

	
	
	@Test(priority = 1)
	public void testDeclareDO() {

		login(strBayan);
		/****************** Declare DO & Create Import Bayan */
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO("DO/311568/KWI22");//objMNFInfo.doNumber
		objPendingDOList.searchWithSecurity("38718833");
		objPendingDOList.clickDeclare();

	}
	@Test(priority = 2)
	public void testCreateBayan() {
		objBayan.createBayan();
	}
	@Test(priority = 3)
	public void testVehicles() {
		objImp.addDeclarationVehiclesList();
	}
	@Test(priority = 4)
	public void testAddInvoiceItems() {
		objImp.addInvoice();
	}
	@Test(priority = 5)
	public void testAddItems() {
		objImp.addItems();
//		objImp.addItems1();
//		objImp.addItems2();
//		objImp.addItems3();
//		objImp.addItems4();
	}
	@Test(priority = 6)
	public void testRequiredDocument() throws InterruptedException {
		objImp.requiredDocuments();
//		objImp.upload_DigitalDocs();
	}
	@Test(priority = 7)
	public void testCalculateDuty_Payment() {
		objImp.calculateDuty();
		objImp.addPaymentInformation();
	}
		

	

	@Test(priority = 11)
	public void testSubmitDeclaration() {
		objImp.submitDeclaration();
		logOut();
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
