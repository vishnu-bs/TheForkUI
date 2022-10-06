package com.fork.test;

import com.fork.pages.CaptchaPage;
import com.fork.pages.HomePage;
import com.fork.pages.LoginMenuPage;
import com.fork.pages.UserProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyUserDetails {
    public static void main(String[] args) {

        @Test
        public void openApp(){

        }
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.thefork.fr/");
        driver.manage().window().maximize();
        CaptchaPage captchaPage=new CaptchaPage(driver);
        HomePage homePage=new HomePage(driver);
        LoginMenuPage loginMenuPage=new LoginMenuPage(driver);
        UserProfilePage userProfilePage=new UserProfilePage(driver);

        captchaPage.clickCaptcha();
        homePage.acceptCookie();
        loginMenuPage.userLogin("v4uvishnubs@gmail.com","Fork@123");
        loginMenuPage.verifyLogin();




        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement iFrameName1 = driver.findElement(By.xpath("//iframe"));
       //webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameName1));
        driver.switchTo().frame(iFrameName1);
        WebElement iFrameName2 = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(iFrameName2);
       //webDriverWait.until(ExpectedConditions.elementToBeClickable(iFrameName2));
        WebElement radioBox=driver.findElement(By.xpath("//span[@id='recaptcha-anchor']"));
        radioBox.click();

      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@id='_evidon-accept-button']")).click();
        driver.findElement(By.xpath("//button[@data-testid='user-space']")).click();
        driver.findElement(By.id("identification_email")).sendKeys("v4uvishnubs@gmail.com");
        driver.findElement(By.xpath("//button[@data-testid='checkout-submit-email']")).click();
        driver.findElement(By.id("password")).sendKeys("Fork@123");
        driver.findElement(By.xpath("//button[@data-testid='submit-password']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Mes informations personnelles')]")).click();




    }
}