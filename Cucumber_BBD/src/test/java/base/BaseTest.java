package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {
	
	public static WebDriver driver;
	String capturedAccountId;
	String newAccountId;
	
	public static void setupDriver() {
        if (driver == null) {
        	ChromeOptions options = new ChromeOptions();
        	String headless = System.getProperty("headless", "true"); 
            if ("true".equals(headless)) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
	}
}
