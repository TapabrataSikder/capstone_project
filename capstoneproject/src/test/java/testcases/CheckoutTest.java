package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutCompletePage;

public class CheckoutTest extends BaseTest {

    @BeforeMethod
    public void setup() {
        initializeDriver();
    }

    @Test
    public void testCompleteCheckoutFlow() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage prod = new ProductsPage(driver);
        prod.addProductToCart("Sauce Labs Backpack");

        CartPage cart = new CartPage(driver);
        cart.goToCart();
        cart.proceedToCheckout();

        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        String summaryTotal = driver.findElement(By.className("summary_total_label")).getText();
        Assert.assertTrue(summaryTotal.contains("32.39"), "Price validation failed!");
        
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        String actualMsg = completePage.getConfirmationMessage();
        
        Assert.assertEquals(actualMsg, "Thank you for your order!", "Order confirmation failed!");
        
        completePage.clickBackHome();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}