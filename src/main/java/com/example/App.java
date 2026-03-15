package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class App {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://automationexercise.com");

        // Login page
        driver.findElement(By.linkText("Signup / Login")).click();

        driver.findElement(By.name("email")).sendKeys("sumana.selenium@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test123");

        driver.findElement(By.xpath("//button[text()='Login']")).click();

        // Open products
        driver.get("https://automationexercise.com/products");

        // Scroll down to products
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        // Click Add to Cart using JavaScript (avoids ad blocking)
        WebElement addToCart = driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]"));
        js.executeScript("arguments[0].click();", addToCart);

        System.out.println("Product added successfully!");
    }
}
