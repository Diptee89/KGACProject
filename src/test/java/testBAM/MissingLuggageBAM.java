package testBAM;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bam.pages.MissingLuggagePage;
import com.bam.pages.TransferRequestPage;
import com.base.BaseClass;

public class MissingLuggageBAM extends BaseClass {
	public MissingLuggagePage obj;

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
		login("inspector.sea");
	}

	@Test(priority = 0)
	public void regMiggingLuggage() {

//		login("inspector.sea");
		obj = new MissingLuggagePage(driver);
		obj.createMissingLuggage();
		obj.addItems();
		obj.receivedMissing_Luggage();
		driver.close();
	}

//	@Test(priority = 1)
	public void TR() {
		TransferRequestPage objTR = new TransferRequestPage(driver);
		objTR.subMenuTransfer_Request();
		objTR.createTransferRequest();
		objTR.addTransferredGoods("TGML/9/SLB22");//TGML/18/SWK22 obj.strMissingLuggageNo
		objTR.submitTR();
		objTR.approveTR();
	}
}
