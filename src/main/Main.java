package main;

/*
open app
tap - settings
tap night mode
verify three settings present
done
*/

// Other JUnit Annotations:
// @Before - executes before any test methods, such as executing logins, etc
// @After - executes after any test methods

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import io.appium.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;

public class Main
{
	RemoteWebDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.0.1");
		capabilities.setCapability("app", "/Users/dandouston/Automation_Project/sgtpuzzles/app/build/outputs/apk/app-debug.apk");
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		//AppiumDriver<WebElement> driver = new AppiumDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);	
	}
	
	@Test
	public void testSettingsNightMode()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.name("Settings")).click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[1]")).click();
		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.CheckedTextView[3]")).click();
		driver.findElement(By.name("Navigate up")).click();
		driver.close();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
