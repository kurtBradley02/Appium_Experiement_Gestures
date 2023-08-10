package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class ScreenShot_Handler {

    AndroidDriver driver;
    String project;

    public ScreenShot_Handler(AndroidDriver driver, String project) {
        this.driver = driver;
        this.project = project;
    }

    public byte[] takeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}