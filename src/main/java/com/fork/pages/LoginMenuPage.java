package com.fork.pages;

import com.fork.commonFn.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMenuPage extends CommonFunctions {

    private WebDriver driver;

    @FindBy(id = "identification_email")
    private WebElement emailTextBox;
    @FindBy(xpath = "//button[@data-testid='checkout-submit-email']")
    private WebElement emailSubmitBtn;
    @FindBy(id = "password")
    private WebElement pwdTextBox;
    @FindBy(xpath = "//button[@data-testid='submit-password']")
    private WebElement pwdSubmitBtn;
    @FindBy(xpath = "//li[@data-test='USER_PROFILE_TOTAL_YUMS']")
    private WebElement yumField;
    @FindBy(id = "user_space_logout")
    private WebElement logoutBtn;



    public LoginMenuPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void userLogin(String userName,String password){
       emailTextBox.sendKeys(userName);
       emailSubmitBtn.click();
       pwdTextBox.sendKeys(password);
       pwdSubmitBtn.click();
    }

    public void verifyLogin(){
       if(elementIsPresent(yumField)){
           System.out.println("Logged in successfully.");
       }
        System.out.println("Login Failed..!");
    }


}
