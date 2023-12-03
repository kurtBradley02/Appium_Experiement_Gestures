package config;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;


public class AndroidCap {
	
	public AndroidDriver driver;
	
	public AndroidCap(String app) {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:app", app);
		
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
