package com.fork.pages;

import com.fork.commonFn.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage extends CommonFunctions {

    private WebDriver driver;

    @FindBy(xpath = "//input[@value='M']")
    private WebElement maleRadioBtn;
    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameFld;
    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameFld;
    @FindBy(xpath = "//input[@name='phoneNumber.nationalNumber']")
    private WebElement phoneNumFld;
    @FindBy(xpath = "//input[@name='birthDate.day']")
    private WebElement birthDayFld;
    @FindBy(xpath = "//select[@name='birthDate.month']")
    private WebElement birthMonthDrpDwn;
    @FindBy(xpath = "//input[@name='birthDate.year']")
    private WebElement birthYearFld;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailFld;
    @FindBy(id = "PHONE_CODE_FIELD")
    private WebElement phonecodeDrpDwn;
    @FindBy(id = "user_space_logout")
    private WebElement logoutBtn;



    public UserProfilePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

   public void verifyUserDetails(String fieldName,String expectedValue) {
    switch (fieldName){

        case "FIRSTNAME":
            if(verifyUserData(firstNameFld,expectedValue)){
                System.out.println("First Name is matched with the value"+expectedValue);
            }
            else {
                System.out.println("First Name Not matched with the value");
            }
            break;
        case "LASTNAME":
            if(verifyUserData(lastNameFld,expectedValue)){
                System.out.println("Profile Last Name is matched with the value"+expectedValue);
            }
            else {
                System.out.println("Profile Last Name Not matched with the value");
            }
            break;
        case "PHONE":
            if(verifyUserData(phoneNumFld,expectedValue)){
                System.out.println("Profile Phone Number is matched with the value"+expectedValue);
            }
            else {
                System.out.println("Profile Phone Number Not matched with the value");
            }
            break;
        case "COUNTRY-CODE":
            if(verifyDropDownValue(phonecodeDrpDwn,expectedValue)){
                System.out.println("Profile Phone Country Code is matched with the value"+expectedValue);
            }
            else {
                System.out.println("Profile Phone Country Code Not matched with the value");
            }
            break;
        case "EMAIL":
            if(verifyUserData(emailFld,expectedValue)){
                System.out.println("Profile Email ID  is matched with the value"+expectedValue);
            }
            else {
                System.out.println("Profile Email ID Not matched with the value");
            }
            break;
        case "DOB":
            String[] dateArray = expectedValue.split("/");
            if(verifyUserData(birthDayFld,dateArray[0])&&verifyDropDownValue(birthMonthDrpDwn,dateArray[1])&&verifyUserData(birthYearFld,dateArray[2])){
                System.out.println("Profile Date of Birth is matched with the value"+expectedValue);
            }
            else {
                System.out.println("Profile Phone Number Not matched with the value");
            }
            break;
    }


    }
}
