package com.Trex.DeckDesiner.Automation.SetUp;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Trex.DeckDesiner.Automation.Utils.CommonVariables;
import com.Trex.DeckDesiner.Automation.Utils.ConfigProperty;
import com.Trex.DeckDesiner.Automation.Utils.ExcelReader;
import com.Trex.DeckDesiner.Automation.Utils.ExtentManager;
import com.Trex.DeckDesiner.Automation.Utils.TestUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestSetup {

	public static ConfigProperty configProperty;
	public static RequestSpecification requestSpecification=null;
	public static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static Date date = new Date();
	
	/*
	 * public static ExtentReports extentReport; public static
	 * ThreadLocal<ExtentTest> testCaseLogger=new ThreadLocal<ExtentTest>();
	 */

	// public ExcelReader excel = new ExcelReader(
	// System.getProperty("user.dir") + "/src/test/resources/testData/simple.xlsx");

	@BeforeSuite(alwaysRun = true)
	public void setup() {
		

		configProperty = ConfigFactory.create(ConfigProperty.class);

		RestAssured.baseURI = configProperty.getBaseURI();
		RestAssured.basePath = configProperty.getBasePath();
		setBasicRequestSpecification();

		CommonVariables.setTestReportName(configProperty.getTestReportName());
		CommonVariables.setArchivedReportName(TestUtils.getArchivedReportName());

		CommonVariables.extentReport = ExtentManager.GetExtent(configProperty.getTestReportFilePath());
		CommonVariables.setScreenshotsPath(configProperty.getScreenShotsPath());

	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {

	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		

		CommonVariables.setCurrentTestClassName(getClass().getSimpleName());

		ExtentTest classTest = CommonVariables.extentReport.createTest(CommonVariables.getCurrentTestClassName());
		CommonVariables.setCurrentTestClassLog(classTest);

	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		
		
		CommonVariables.setCurrentTestCaseName(method.getName());
		ExtentTest test = CommonVariables.getCurrentTestClassLog().createNode(CommonVariables.getCurrentTestCaseName());
		CommonVariables.setCurrentTestCaseLog(test);
		
		CommonVariables.getCurrentTestCaseLog()
				.info("Execution Of Test Case- " + CommonVariables.getCurrentTestCaseName() + " Started");

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		CommonVariables.extentReport.flush();

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {

	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {

	}
	
	public static void setBasicRequestSpecification()
	{
		requestSpecification= given().contentType(ContentType.JSON);
		
	}

}
