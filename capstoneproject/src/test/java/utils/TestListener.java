package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest; 
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed! Capturing Screenshot...");

        TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        try {
            // Save the file in the project directory
            String dest = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";
            FileHandler.copy(source, new File(dest));
            System.out.println("Screenshot saved at: " + dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}