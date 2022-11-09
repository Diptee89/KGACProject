package air;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.base.TestBase;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.ImportPage;
import com.pages.ManifestInformationPage;
import com.pages.PendingDeliveryOrderListPage;


public class DeclarationTest extends BaseClass{
	private ManifestInformationPage objMNFInfo;
	private CustomsBayanPage objBayan;


	private String strBayan = "broker.kwi";

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
	}

	
	@Test(priority = 1)
	public void testBayan() throws InterruptedException {
		PendingDeliveryOrderListPage objPendingDOList = new PendingDeliveryOrderListPage(driver);
		objBayan = new CustomsBayanPage(driver);
		DeclarationListPage objDecList = new DeclarationListPage(driver);
		ImportPage objImp = new ImportPage(driver);

		login(strBayan);
//		/**********Declare DO & Create Import Bayan*/
		objPendingDOList.clickPendingDOSubMenu();
		objPendingDOList.searchWithDO("DO/55174/KWI22"); //DO/55174/KWI22 DO/55176/KWI22 DO/55179/KWI22 DO/55180/KWI22 DO/55182/KWI22 DO/55183/KWI22
		objPendingDOList.clickDeclare();
		objBayan.createBayan();

//		/**Edit Created Bayan from Declaration list screen4';*/	
//		objDecList.clickDeclarationSubMenu();
//		objDecList.searchByTempDec("TIM/29803/KWI22");// tempDeclarationNo TIM/29801/KWI22
//		objDecList.clickTempNo();
//		objImp.clickEdit();
		objImp.requiredDocuments();
//		objImp.selectExitPort();

		objImp.addInvoice();
		objImp.addItems();

		objImp.addDeclarationVehiclesList();

		objImp.calculateDuty();
		objImp.addPaymentInformation();
		objImp.submitDeclaration(); // Status: Submitted to Auditor
		logOut();
		
		objImp.payBayanIssuanceFee(objBayan.tempDeclarationNo);

		
		login("customs.kwi");
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec(objBayan.tempDeclarationNo);// tempDeclarationNo TIM/29801/KWI22
		objDecList.clickTempNo();
		
		objImp.reviewDoc();
		objImp.approveBayan(); //Status :Audited and in Red
	}

}
