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

//	private String strCarrierAgent = "nas.csa";
//	private String strCManifest = "cmanifest.kwi";
//	private String strBayan = "broker.kwi";
	
	String tempDec="TIM/150831/KWI22";

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();

		objDecList = new DeclarationListPage(driver);
		objImp = new ImportPage(driver);
		
	}
//	@Test(priority = 1)
	public void testBayanIssuanceFee() {
		login("md.husain");
		objImp.payBayanIssuanceFee();
		objImp.createReceipt("TIM/150831/KWI22");
		objImp.createReceipt("TIM/150832/KWI22");
		objImp.createReceipt("TIM/150833/KWI22");
		objImp.createReceipt("TIM/150834/KWI22");
		objImp.createReceipt("TIM/150835/KWI22");
		objImp.submitReceipt();
		logOut();
	}
	@Test(priority = 2)
	public void approveAudit() {
		objImp = new ImportPage(driver);
		
		login("customs.kwi");
				
			
		objDecList.clickDeclarationSubMenu_Audit();
		objDecList.searchByTempDec("TIM/150833/KWI22");// tempDeclarationNo TIM/29801/KWI22 objBayan.tempDeclarationNo
		objDecList.clickTempNo();
//		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red
		
		objDecList.clickDeclarationSubMenu_Audit();
		objDecList.searchByTempDec("TIM/150834/KWI22");// tempDeclarationNo TIM/29801/KWI22 objBayan.tempDeclarationNo
		objDecList.clickTempNo();
//		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red
		
		objDecList.clickDeclarationSubMenu_Audit();
		objDecList.searchByTempDec("TIM/150835/KWI22");// tempDeclarationNo TIM/29801/KWI22 objBayan.tempDeclarationNo
		objDecList.clickTempNo();
//		objImp.reviewDoc();
		objImp.approveBayan(); // Status :Audited and in Red
	}
	
}
