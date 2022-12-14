package sea;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.InspectionRequestPage;

public class TestInspection extends BaseClass{
	String tempDec="TIM/150780/KWI22";
	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
	}

	
	@Test(priority = 1)
	public void completeInspection() {
		InspectionRequestPage objInspection=new InspectionRequestPage(driver);
		login("ins.swk");
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search("TIM/118573/SWK22");
		objInspection.clickComplete();
//		objInspection.clickRelease();
		objInspection.clickSeize();
//		objInspection.ExitGate(); //Declaration status updated "Exit Released"
//		objInspection.clickRejectInspection();
//		logOut();
	}
}
