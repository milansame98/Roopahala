package com.selenium.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    @Test
    public void testGoogleSearch() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        driver.get("https://roopahala.com.au/");
        System.out.println("Title: " + driver.getTitle());

        driver.manage().window().maximize();

        WebElement ModalClose = driver.findElement(By.xpath("//*[@id=\"newsletter-popup\"]/div/div/div/div/span/div"));
		ModalClose.click();
		
		WebElement SignInbutton = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div/div/div/div/nav/div[2]/ul/li[2]/a"));
		SignInbutton.click();	
		
        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
		
		WebElement namefield = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
		
		namefield.sendKeys("Milan Jayasinghe");
		passwordfield.sendKeys("123456");


        driver.close(); 
    }
}

