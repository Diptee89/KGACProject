package test;

import org.testng.annotations.Test;

import com.base.BaseClass;

public class DriverClass extends BaseClass {
@Test
public void setup() {
	launchBrowser("ie");
	navigateUrl();
	login("nas.csa");
	logOut();
}
}
