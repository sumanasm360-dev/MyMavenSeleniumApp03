package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        // Setup Chrome options for Jenkins/Linux environment
        ChromeOptions options = new ChromeOptions();

        // Required for CI/CD environments (Jenkins, Ubuntu server)
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");

        // Optional stability improvements
        options.addArguments("--disable-gpu");

        // Launch Chrome
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open website
            driver.get("https://www.google.com");

            // Print title (useful for Jenkins logs)
            System.out.println("Page Title: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
