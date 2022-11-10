package air;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.InspectionRequestPage;

public class TestInspection extends BaseClass{
	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
	}

	
	@Test(priority = 1)
	public void completeInspection() {
		InspectionRequestPage objInspection=new InspectionRequestPage(driver);
		login("ins.kwi");
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search("TIM/29805/KWI22");
		objInspection.clickComplete();
		objInspection.clickRelease();
		objInspection.ExitGate(); //Declaration status updated "Exit Released"
//		objInspection.clickRejectInspection();
		logOut();
	}
}
