package air;

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
//		login("abd.sadoon"); //Inspector
		login("im.alyaqoub");
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search("TIM/150831/KWI22");
		objInspection.clickComplete();
		objInspection.clickSeize();
		
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search("TIM/150832/KWI22");
		objInspection.clickComplete();
		objInspection.clickSeize();
		
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search("TIM/150833/KWI22");
		objInspection.clickComplete();
		objInspection.clickSeize();
		
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search("TIM/150834/KWI22");
		objInspection.clickComplete();
		objInspection.clickSeize();
		
		objInspection.clickIspectionRequestSubMenu();
		objInspection.search("TIM/150835/KWI22");
		objInspection.clickComplete();
		objInspection.clickSeize();
		
		
	}
}
