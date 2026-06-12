package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Parabank_POM {
	WebDriver driver;
	WebDriverWait wait;
	
	public Parabank_POM(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By regLink = By.linkText("Register");
	By firsName = By.id("customer.firstName");
	By lastName = By.id("customer.lastName");
	By address = By.id("customer.address.street");
	By city = By.id("customer.address.city");
	By state = By.id("customer.address.state");
	By zip = By.id("customer.address.zipCode");
	By phone = By.id("customer.phoneNumber");
	By ssnField = By.id("customer.ssn");
	By username = By.id("customer.username");
	By pass = By.id("customer.password");
	By cnfpass = By.id("repeatedPassword");
	By regBtn = By.xpath("//input[@value='Register']");
	
	public void register(String fname, String lname, String adr, String cty, String st, String zp, String phn, String ssn, String uname, String pwd) {
		wait.until(ExpectedConditions.elementToBeClickable(regLink)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(firsName)).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(address).sendKeys(adr);
		driver.findElement(city).sendKeys(cty);
		driver.findElement(state).sendKeys(st);
		driver.findElement(zip).sendKeys(zp);
		driver.findElement(phone).sendKeys(phn);
		driver.findElement(ssnField).sendKeys(ssn);
		driver.findElement(username).sendKeys(uname);
		driver.findElement(pass).sendKeys(pwd);
		driver.findElement(cnfpass).sendKeys(pwd);
		driver.findElement(regBtn).click();
	}

}
