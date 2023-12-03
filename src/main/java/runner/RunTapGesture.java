package runner;


import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import config.AndroidCap;
import io.appium.java_client.android.AndroidDriver;


public class RunTapGesture {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidCap android;
		AndroidDriver driver;

		android = new AndroidCap("C:\\Users\\kurtb\\eclipse-workspace\\Practice_Appium\\TestApp\\METROBIRD.apk");

		driver = android.getDriver();
		
		WebElement sourceElement = driver.findElement(By.xpath("//android.view.View"));
		WebElement targetElement = driver.findElement(By.xpath("//android.view.View"));
		
		Point sourceElementCenter = getCenterOfElement(sourceElement.getLocation(), sourceElement.getSize());
		
		Point targetElementCenter = getCenterOfElement(targetElement.getLocation(), targetElement.getSize());
		
		
		
		
		
	}
	
	static Point getCenterOfElement(Point location, Dimension size) {
		
		return new Point(location.getX() + size.getWidth()/2,
				location.getY() + size.getHeight()/2);
		
	}
	
	
}
