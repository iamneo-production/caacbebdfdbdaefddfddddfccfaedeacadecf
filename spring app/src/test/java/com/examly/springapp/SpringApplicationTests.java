package com.examly.springapp;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SpringApplicationTests {

    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = null;
   
    String fbUrl = "https://www.fb.com";
	String facebookUrl = "https://www.facebook.com";
    
    @BeforeTest
    public void beforeTest() throws Exception
     {
   // replace seleniumhost and port with correct values
   System.setProperty("webdriver.chrome.driver", "/home/coder/project/workspace/chromedriver");
   driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);

        driver.manage().window().maximize();
    }
    @Test
    public void Invoke()
    { 

    driver.get(fbUrl);
		
    String urlFromBrowser = driver.getCurrentUrl();
    
    Assert.assertEquals(urlFromBrowser, facebookUrl, "No redirection happened");
    
    
}


@Test
public void facebookSignUp() {
    
    driver.findElement(By.name("firstname")).sendKeys("Test");
    driver.findElement(By.name("lastname")).sendKeys("User");
    driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
    driver.findElement(By.name("reg_passwd__")).sendKeys("testPassword");
    
    Select selDate = new Select(driver.findElement(By.id("day")));
    Select selMonth = new Select(driver.findElement(By.id("month")));
    Select selYear = new Select(driver.findElement(By.id("year")));
    
    selDate.selectByVisibleText("21");
    selMonth.selectByVisibleText("Jun");
    selYear.selectByVisibleText("1989");
    
    driver.findElement(By.xpath("//input[@type='radio' and @value='2']")).click();
    
    driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
}


@AfterClass
public void closeBrowser(){
    
    driver.quit();
    
}

}