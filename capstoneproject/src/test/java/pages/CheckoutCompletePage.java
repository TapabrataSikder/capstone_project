package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    WebDriver driver;
    
    // Locators
    private By successHeader = By.className("complete-header");
    private By backHomeBtn = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage() {
        return driver.findElement(successHeader).getText();
    }

    public void clickBackHome() {
        driver.findElement(backHomeBtn).click();
    }
}