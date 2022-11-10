package air;

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

	private String strCarrierAgent = "nas.csa";
	private String strCManifest = "cmanifest.kwi";
	private String strBayan = "broker.kwi";

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();

		objDecList = new DeclarationListPage(driver);
	}

	@Test
	public void approveAudit() {
		objImp = new ImportPage(driver);
		
		login("customs.kwi");
		objDecList.clickDeclarationSubMenu();
		objDecList.searchByTempDec("TIM/29806/KWI22");// tempDeclarationNo TIM/29801/KWI22 objBayan.tempDeclarationNo
		objDecList.clickTempNo();

		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red
	}
}
