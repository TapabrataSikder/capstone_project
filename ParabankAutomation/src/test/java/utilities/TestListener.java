package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener extends BaseTest implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {        
        try {
            ScreenshotUtil.takeScreenshot(BaseTest.getDriver(), result.getName());
            System.out.println("Screenshot taken for failed test: " + result.getName());
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}