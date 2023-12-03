package TestGestures;

import org.testng.annotations.Test;


import config.AndroidCap;
import io.appium.java_client.android.AndroidDriver;
import util.GenerateReport;
import util.ScreenShot_Handler;
import util.CmdTrigger;

public class AndroidGestureTest {

	AndroidCap android;
	AndroidDriver driver;
	ScreenShot_Handler ss;
	CmdTrigger cmd;

	@Test
	public void test() {
		
		
		android = new AndroidCap("C:\\Users\\kurtb\\eclipse-workspace\\Practice_Appium\\TestApp\\MUBTABIRD.apk");

		driver = android.getDriver();
		
        GenerateReport.closeExtentReports();

	}

}
