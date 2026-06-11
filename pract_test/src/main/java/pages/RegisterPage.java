package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	By myAccount=By.xpath("//span[text()='My Account']");
	By registerOption=By.linkText("Register");
	
	public void openRegisterPage() {
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		wait.until(ExpectedConditions.elementToBeClickable(registerOption)).click();
	}
	
	By firstName=By.id("input-firstname");
	By lastName=By.id("input-lastname");
	By email=By.id("input-email");
	By telephone=By.id("input-telephone");
	By password=By.id("input-password");
	By confirmPassword=By.id("input-confirm");
	By privacyPolicy=By.name("agree");
	By continueButton=By.xpath("//input[@type='submit' and @value='Continue']");
	
	public void registration(String fName, String lName, String emailId, String phone, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
		driver.findElement(lastName).sendKeys(lName);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirmPassword).sendKeys(pass);
		driver.findElement(privacyPolicy).click();
		driver.findElement(continueButton).click();
		
	}

}
