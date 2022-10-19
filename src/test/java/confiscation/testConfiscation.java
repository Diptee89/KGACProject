package confiscation;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bam.pages.MissingLuggagePage;
import com.base.BaseClass;
import com.pages.ConfiscationBasicInformation;

public class testConfiscation extends BaseClass {
	public ConfiscationBasicInformation objConfiscation;

	@BeforeTest
	public void setUp() {
		launchBrowser("ie");
		navigateUrl();
		login("inswriter.kwi");
	}

	@Test(priority = 0)
	public void createConfiscation() {
		objConfiscation = new ConfiscationBasicInformation(driver);
		objConfiscation.navigateToConfiscation_List();
		objConfiscation.createConfiscation();

	}
}
