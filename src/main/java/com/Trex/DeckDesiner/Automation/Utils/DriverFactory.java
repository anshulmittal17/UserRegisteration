package com.Trex.DeckDesiner.Automation.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory extends TestSetup{
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static String DeviceName;
	public static String deviceVersion;
	public static String platformName;
	public static String automationName;
	public static String deviceID;
	public static String newCommandTimeout;
	public String driverType = null;

	public static String chromeExeFilePath;
	public static String ieExeFilePath;
	public static String firefoxExeFilePath;

	public static String getChromeExeFilePath() {
		return chromeExeFilePath;
	}

	public static void setChromeExeFilePath(String chromeExeFilePath) {
		DriverFactory.chromeExeFilePath = chromeExeFilePath;
	}

	public static String getIeExeFilePath() {
		return ieExeFilePath;
	}

	public static void setIeExeFilePath(String ieExeFilePath) {
		DriverFactory.ieExeFilePath = ieExeFilePath;
	}

	public static String getFirefoxExeFilePath() {
		return firefoxExeFilePath;
	}

	public static void setFirefoxExeFilePath(String firefoxExeFilePath) {
		DriverFactory.firefoxExeFilePath = firefoxExeFilePath;
	}

	public static WebDriver createDriverInstance(String browserName,String driverType) throws MalformedURLException {
		WebDriver driver = null;
		if (System.getProperty("os.name").contains("Windows")) {
			if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
				DriverManager.maximizeBrowser(driver);
				DriverManager.setImplicitWait(driver);

			} else if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				DriverManager.setDriver(driver);
				DriverManager.maximizeBrowser(driver);
				DriverManager.setImplicitWait(driver);
			} else if (browserName.equalsIgnoreCase("ie")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				DriverManager.setDriver(driver);
				DriverManager.maximizeBrowser(driver);
				DriverManager.setImplicitWait(driver);
			} else if (browserName.equalsIgnoreCase("safari")) {

			}
			else if(driverType.equalsIgnoreCase("android"))
			{
				driver=getAndroidDriver();
				DriverManager.setDriver(driver);
			}
			else if(driverType.equalsIgnoreCase("iOS"))
			{
				driver=getIOSDriver();
				DriverManager.setDriver(driver);
				
			}

		} else {

		}
		return null;

	}

	public static AndroidDriver<MobileElement> getAndroidDriver() throws MalformedURLException {

		//configProperty = ConfigFactory.create(ConfigProperty.class);
		DeviceName = configProperty.getAndroidDeviceName();
		deviceVersion = configProperty.getandroidDeviceVersion();
		deviceID = configProperty.getAndroidDeviceId();
		newCommandTimeout = configProperty.getNewCommandTimeout();
		// apk file path
		String apkPath = configProperty.getAPKFilePath();
		File app = new File(configProperty.getAPKFilePath());

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator");
		capabilities.setCapability(MobileCapabilityType.UDID, deviceID);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, newCommandTimeout);
		capabilities.setCapability("appPackage", "com.lulu.lulubox");
		capabilities.setCapability("appActivity", ".main.ui.MainActivity");
		// capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+apkPath);
		// capabilities.setCapability(MobileCapabilityType.APP,apkPath);
		return new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

	}

	public static WebDriver getIOSDriver() throws MalformedURLException {
		//configProperty = ConfigFactory.create(ConfigProperty.class);
		DeviceName = configProperty.getiOSDeviceName();
		deviceVersion = configProperty.getiOSDeviceVersion();
		deviceID = configProperty.getiOSDeviceId();
		newCommandTimeout = configProperty.getNewCommandTimeout();
		// .ipa or .app file path
		File app = new File(System.getProperty("user.dir") + configProperty.getAppFilePath());
		/*
		 * capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
		 * capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
		 * deviceVersion);
		 * capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
		 * AutomationName.IOS_XCUI_TEST);
		 * capabilities.setCapability(MobileCapabilityType.UDID,deviceID);
		 * capabilities.setCapability("bundleId", "com.apple.mobilecal");
		 * capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		 * //capabilities.setCapability("usePrebuiltWDA", true);
		 * //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
		 * newCommandTimeout); //capabilities.setCapability("noReset",true);
		 * //capabilities.setCapability(MobileCapabilityType.APP,
		 * app.getAbsolutePath());
		 */
		capabilities.setCapability("deviceName", DeviceName);
		capabilities.setCapability("platformVersion", deviceVersion);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("udid", deviceID);
		capabilities.setCapability("browserName", "Safari");
		System.out.println("iOS capabilities loaded");
		return new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

	}

	public static void destroyDriver() {
		if (DriverManager.getDriver() != null)
			DriverManager.getDriver().quit();
	}

}
