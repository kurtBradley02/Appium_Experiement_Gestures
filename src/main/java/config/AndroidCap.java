package config;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidCap {
	
	public AndroidDriver driver;
	
	public AndroidCap() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\kurtb\\OneDrive\\Desktop\\app-debug.apk");
		
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public AndroidDriver getDriver() {
		return this.driver;
	}

}
