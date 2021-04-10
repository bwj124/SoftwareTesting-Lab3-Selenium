package com.bwj.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class SeleniumTest {
	 public static String url = "http://118.178.137.170:8080/";
	 
	 public static String getStudentID(String name) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();;
         driver.get(url);
         WebElement inputBox = driver.findElement(By.xpath("//*[@id='username']"));
         WebElement loginButton = driver.findElement(By.xpath("//*[@class='btn btn-primary btn-block']"));
         inputBox.sendKeys(name);
         loginButton.click();
         WebElement studentID = driver.findElement(By.xpath("//*[@class='table table-striped']/tbody/tr/td[2]"));
         String idString = studentID.getText();
         // driver.navigate().back(); // ∑µªÿ…œ“ª“≥
	     driver.quit();
	     return idString;
	}
}
