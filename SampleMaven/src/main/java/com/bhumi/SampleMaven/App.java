package com.bhumi.SampleMaven;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class App {
  public static void main(String[] args) throws InterruptedException {
    //System.out.println("Hello World!");
    
    WebDriverManager.getInstance(CHROME).setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://google.com");
    String title = driver.getTitle();
    driver.wait(50000);
    System.out.println(title);
  }
}
