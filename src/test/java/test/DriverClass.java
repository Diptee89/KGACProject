package test;

import org.testng.annotations.Test;

import com.base.BaseClass;

public class DriverClass extends BaseClass {
@Test
public void setup() throws InterruptedException {
	launchBrowser("ie");
	navigateUrl();
	switchToWindow();
	login("nas.csa");
	logOut();
}
}
