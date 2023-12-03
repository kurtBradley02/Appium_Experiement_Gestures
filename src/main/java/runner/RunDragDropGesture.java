package runner;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import config.AndroidCap;
import io.appium.java_client.android.AndroidDriver;

public class RunDragDropGesture {

    public static void main(String[] args) throws InterruptedException {
        AndroidCap android;
        AndroidDriver driver;

        android = new AndroidCap("C:\\Users\\kurtb\\eclipse-workspace\\Practice_Appium\\app_tests\\TestDraggable.apk");

        driver = android.getDriver();
        
        WebElement button = driver.findElement(By.id("com.example.testdraggable:id/button"));

        Point sourceCenter = getCenterOfElement(button.getLocation(), button.getSize());
        Point targetCenter = getCenterOfElement(new Point(500, 1000), new Dimension(10,10));

        dragAndDrop(driver, sourceCenter, targetCenter);
        
    }
    
    static Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

    static void dragAndDrop(AndroidDriver driver, Point source, Point target) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.x, source.y));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(new Pause(finger, Duration.ofMillis(600))); // pause for hold
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), target.x, target.y));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));
    }
}
