package com.Trex.DeckDesiner.Automation.Utils;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager extends TestSetup{

	
	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	//private static String filePath = "./extentreport.html";

	public static ExtentReports GetExtent(String reportFilePath) {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter(reportFilePath));
			extent.setSystemInfo("Host Name", "Trex QA Team");

			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}

	public static ExtentHtmlReporter getHtmlReporter(String reportFilePath) {

		htmlReporter = new ExtentHtmlReporter(reportFilePath+CommonVariables.getTestReportName());
		/*
		 * htmlReporter.config().setChartVisibilityOnOpen(true);
		 * htmlReporter.config().setDocumentTitle(" Automation Report");
		 * htmlReporter.config().setReportName("Automation");
		 * htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 */

		htmlReporter
				.loadXMLConfig(System.getProperty("user.dir")+configProperty.getExtentConfigFilePath());

		return htmlReporter;
	}

}
