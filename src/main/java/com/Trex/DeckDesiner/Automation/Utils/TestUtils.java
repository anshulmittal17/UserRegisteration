package com.Trex.DeckDesiner.Automation.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;

public class TestUtils extends TestSetup {

	public static void captureScreenshot() throws IOException {

		TestUtils.setScreenShotName();

		CommonVariables.getScreenshotsPath();
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile,
				new File(CommonVariables.getScreenshotsPath() + CommonVariables.getScreenShotName()));

	}

	public static void setScreenShotName() {
		Date date = new Date();
		String screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".png";
		CommonVariables.setScreenShotName(screenshotName);
	}

	public static void archiveTestReport() {
		File lastTestReportFile = new File(
				configProperty.getTestReportFilePath() + CommonVariables.getTestReportName());

		File newFile = new File(configProperty.getArchivedTestReportsPath() + CommonVariables.getArchivedReportName());

		lastTestReportFile.renameTo(newFile);
		lastTestReportFile.delete();

	}

	public static String getArchivedReportName() {
		String date = new SimpleDateFormat("dd_MM_yyyy").format(new Date());

		String reportName = CommonVariables.testReportName;
		String newReportName = reportName.substring(0, reportName.indexOf(".")) + "_" + date + ".html";
		return newReportName;
	}
	
	
}
