package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class App {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://automationexercise.com/products");

        // Search product
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")))
                .sendKeys("Men Tshirt");

        driver.findElement(By.id("submit_search")).click();

        // Locate product
        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("a[data-product-id='2']")
                )
        );

        // Hover on product
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        // Scroll to element (avoids ad interception)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", product);

        // Click Add to Cart
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();

        // Click View Cart
        WebElement viewCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("#cartModal a[href='/view_cart']")
                )
        );

        viewCart.click();

        System.out.println("Navigated to Cart page successfully");

        driver.quit();
    }
}
