package com.fork.pages;

import com.fork.commonFn.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonFunctions {

    private WebDriver driver;

    @FindBy(xpath = "//button[@id='_evidon-accept-button']")
    private WebElement cookieAcceptBtn;
    @FindBy(xpath = "//button[@data-testid='user-space']")
    private WebElement userMenuBtn;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void acceptCookie(){
        cookieAcceptBtn.click();

    }
    public void clickUserMenu(){
        userMenuBtn.click();
    }
}
