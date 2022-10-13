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
////		Declare DO & Create Import Bayan
//		objPendingDOList.clickPendingDOSubMenu();
//		objPendingDOList.searchWithDO(objMNFInfo.doNumber);
//		objPendingDOList.clickDeclare();
//
//		objBayan.createBayan();

//		Edit Created Bayan from Declaration list screen4';u		
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec("TIM/29774/KWI22");// tempDeclarationNo
		objDecList.clickTempNo();
		objImp.clickEdit();
////		objImp.selectExitPort();
//
//		objImp.addInvoice();
//		objImp.addItems();

		objImp.requiredDocuments();
//		objImp.addDeclarationVehiclesList();

//		objImp.calculateDuty();
//		objImp.addPaymentInformation();
//		objImp.submitDeclaration();
//		logOut();
	}

}
