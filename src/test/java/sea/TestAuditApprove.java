package sea;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.CustomsBayanPage;
import com.pages.DeclarationListPage;
import com.pages.HBItemsPage;
import com.pages.ImportHouseBillPage;
import com.pages.ImportPage;
import com.pages.InspectionRequestPage;
import com.pages.ManifestInformationPage;
import com.pages.ManifestListPage;
import com.pages.PendingDeliveryOrderListPage;

public class TestAuditApprove extends BaseClass {
	private ManifestListPage objMNFList;
	private ManifestInformationPage objMNFInfo;
	private ImportHouseBillPage objHBL;
	private HBItemsPage objHBItems;

	private PendingDeliveryOrderListPage objPendingDOList;
	private CustomsBayanPage objBayan;
	private DeclarationListPage objDecList;
	private ImportPage objImp;
	private InspectionRequestPage objInspection;


	private String strCManifest = "Customs.SWK";
	
	String tempDec="TIM/150804/KWI22";

	
	
	@Test(priority = 2)
	public void approveAudit() {
		objImp = new ImportPage(driver);
		
		login("Customs.SWK");
		
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec("TIM/118573/SWK22");// tempDeclarationNo TIM/29801/KWI22 objBayan.tempDeclarationNo
		objDecList.clickTempNo();

//		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red
		
	
	}
	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();

		objDecList = new DeclarationListPage(driver);
		objImp = new ImportPage(driver);
		
	}
}
