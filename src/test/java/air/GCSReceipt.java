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

public class GCSReceipt extends BaseClass{
	
	ManifestListPage objMNFList;
	ManifestInformationPage objMNFInfo;
	ImportHouseBillPage objHBL;
	HBItemsPage objHBItems;

	PendingDeliveryOrderListPage objPendingDOList;
	CustomsBayanPage objBayan;
	DeclarationListPage objDecList;
	ImportPage objImp;
	InspectionRequestPage objInspection;


	@Test(priority = 1)
	public void testBayanIssuanceFee() {
		login("md.husain");
//		login("md.salah"); //44 Server Production copy
		objImp.payBayanIssuanceFee();
		objImp.createReceipt("TIM/150831/KWI22");
		objImp.createReceipt("TIM/150832/KWI22");
		objImp.createReceipt("TIM/150833/KWI22");
		objImp.createReceipt("TIM/150834/KWI22");
		objImp.createReceipt("TIM/150835/KWI22");
		objImp.submitReceipt();
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
		objImp=new ImportPage(driver);
		objDecList = new DeclarationListPage(driver);
		objInspection = new InspectionRequestPage(driver);
	}

}
