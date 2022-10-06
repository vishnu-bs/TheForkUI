package com.fork.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CaptchaPage {

    private WebDriver driver;
    @FindBy(xpath = "//iframe")
    private WebElement iFrame1;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement iFrame2;
    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    private WebElement tickBox;



      public CaptchaPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void clickCaptcha(){
          driver.switchTo().frame(iFrame1).switchTo().frame(iFrame2);
          tickBox.click();
    }
}
