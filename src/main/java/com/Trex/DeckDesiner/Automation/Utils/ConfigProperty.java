package com.Trex.DeckDesiner.Automation.Utils;

import org.aeonbits.owner.Mutable;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:src\\test\\resources\\propertyFiles\\config.properties" // mention the property file name
})
public interface ConfigProperty extends Mutable {

	@Key("baseURI")
	String getBaseURI();

	@Key("basePath")
	String getBasePath();
	
	@Key("userLoginAPIEndPoint")
	String getUserLoginAPIEndPoint();
	
	@Key("userRegistrationAPIEndPoint")
	String getUserRegistrationAPIEndPoint();
	
	@Key("modelAPIEndPoint")
	String getModelAPIEndPoint();
	
	@Key("userListAPiEndPoint")
	String getUserListAPiEndPoint();

	@Key("testReportFilePath")
	String getTestReportFilePath();

	@Key("screenshotsPath")
	String getScreenShotsPath();

	@Key("archivedTestReportsPath")
	String getArchivedTestReportsPath();

	@Key("implicitWaitTime")
	int getImplicitWaitTime();
	
	
	@Key("testReportName")
	String getTestReportName();
	
	@Key("extentConfigFilePath")
	String getExtentConfigFilePath();

	@Key("trexDeckDesignLandingPageURL")
	String getTrexDeckDesignLandingPageURL();
	
	@Key("trexAdminLandingPageURL")
	String getTrexAdminLandingPageURL();
	
	
	
	
	
	// Mobile config Properties

	@Key("driverType")
	String getDriverType();

	@Key("newCommandTimeout")
	String getNewCommandTimeout();

	// android config properties

	@Key("androidDeviceName")
	String getAndroidDeviceName();

	@Key("androidDeviceVersion")
	String getandroidDeviceVersion();

	@Key("androidDeviceId")
	String getAndroidDeviceId();

	@Key("apkFilePath")
	String getAPKFilePath();

	// iOS config properties

	@Key("iOSDeviceName")
	String getiOSDeviceName();

	@Key("iOSDeviceVersion")
	String getiOSDeviceVersion();

	@Key("iOSDeviceId")
	String getiOSDeviceId();

	@Key("appFilePath")
	String getAppFilePath();

}
