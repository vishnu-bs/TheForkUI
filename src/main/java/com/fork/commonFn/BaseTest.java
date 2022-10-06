package com.fork.commonFn;

import com.fork.util.AutoConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest extends CommonFunctions implements AutoConstants {

    public WebDriver setupTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        return driver;
    }

    public void tearDown(WebDriver driver) {
        driver.quit();
    }

    public String getDataFromProperty(String keyValue) {
        Properties prop = new Properties();
        String value = "";
        try (InputStream fis = new FileInputStream(FILEPATH)) {
            prop.load(fis);
            value = prop.getProperty(keyValue);
        } catch (Exception e) {
            System.out.println("Unable to find the specified properties file");
            e.printStackTrace();
        }
        return value;
    }

    public void customWait(WebDriver driver, WebElement element, Duration timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

}
