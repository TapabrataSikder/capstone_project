package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NinjaPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public NinjaPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	}
	
	By myAcc = By.xpath("//span[text()='My Account']");
	By register = By.linkText("Register");
	
	public void openRegister() {
		wait.until(ExpectedConditions.elementToBeClickable(myAcc)).click();
		wait.until(ExpectedConditions.elementToBeClickable(register)).click();
	}
	
	By fname = By.id("input-firstname");
	 By lname = By.id("input-lastname");
	 By email = By.id("input-email");
	 By phone = By.id("input-telephone");
	 By pass = By.id("input-password");
	 By cnfpass = By.id("input-confirm");
	 By privacyBtn = By.name("agree");
	 By continueBtn = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]");
	
	 public void registration(String firstName, String lastName, String mail, String telephone, String password, String cnfpwd) throws InterruptedException {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(fname)).sendKeys(firstName);
	        driver.findElement(lname).sendKeys(lastName);
	        driver.findElement(email).sendKeys(mail);
	        driver.findElement(phone).sendKeys(telephone);
	        driver.findElement(pass).sendKeys(password);
	        driver.findElement(cnfpass).sendKeys(password);
	        driver.findElement(privacyBtn).click();
	        driver.findElement(continueBtn).click();
	        
			System.out.println("Registration completed");
		}
	
}
