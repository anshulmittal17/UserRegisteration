package com.Trex.DeckDesiner.Automation.Utils;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Trex.DeckDesiner.Automation.SetUp.TestSetup;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners extends TestSetup implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		CommonVariables.getCurrentTestCaseLog().assignAuthor(System.getProperty("user.name").replace(".", " "));

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		CommonVariables.getCurrentTestCaseLog().pass(m);

	}

	public void onTestFailure(ITestResult result) {
		
		String testClassName=result.getName().getClass().getSimpleName();
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		
		if(testClassName.contains("API"))
		{
			CommonVariables.getCurrentTestCaseLog()
			.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
					+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
					+ " \n");


		
		}
		else
		{
			try {
				TestUtils.captureScreenshot();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			CommonVariables.getCurrentTestCaseLog().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
					+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
			
			try {

				CommonVariables.getCurrentTestCaseLog().fail("<b>" + "<font color=" + "red>" + "ScreenShot of failure" + "</font>" + "</b>",
						MediaEntityBuilder.createScreenCaptureFromPath(CommonVariables.getScreenshotsPath()+ CommonVariables.getScreenShotName())
								.build());
			} catch (IOException e) {

			}

		}
		
		String failureLogg = "This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		CommonVariables.getCurrentTestCaseLog().log(Status.FAIL, m);
		
		
		//extentLogger().info()

			
				
	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		CommonVariables.getCurrentTestCaseLog().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {

	}

}
