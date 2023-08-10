package A_Basic;

import java.util.Base64;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.AndroidCap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import util.GenerateReport;
import util.ScreenShot_Handler;
import util.CmdTrigger;

public class TestUI01 {

	AndroidCap android;
	AndroidDriver driver;
	ScreenShot_Handler ss;
	CmdTrigger cmd;

	@Test
	public void test() {

		android = new AndroidCap();

		driver = android.getDriver();

		ss = new ScreenShot_Handler(android.getDriver(), "Practice_Appium");

		String textView = driver.findElement(AppiumBy.id("com.example.testapp1:id/textView")).getText();

		System.out.println(textView);

		String hint = driver.findElement(AppiumBy.id("com.example.testapp1:id/editTextText")).getText();

		System.out.println(hint);

		driver.findElement(AppiumBy.id("com.example.testapp1:id/editTextText")).sendKeys("Test Headles 2");

		driver.findElement(AppiumBy.id("com.example.testapp1:id/button")).click();

		ExtentTest test = GenerateReport.generateExtentReports("Practice_Appium", "Test extent test");

		byte[] screenshotBytes = (byte[]) ss.takeScreenShot();
		
		test.log(LogStatus.PASS, "Test test", "Screenshot: " + test.addBase64ScreenShot("data:image/png;base64," + Base64.getEncoder().encodeToString(screenshotBytes)));
		
        GenerateReport.closeExtentReports();


	}

}
