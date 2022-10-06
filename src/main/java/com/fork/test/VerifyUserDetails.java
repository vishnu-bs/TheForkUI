package com.fork.test;

import com.fork.commonFn.BaseTest;
import com.fork.pages.CaptchaPage;
import com.fork.pages.HomePage;
import com.fork.pages.LoginMenuPage;
import com.fork.pages.UserProfilePage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class VerifyUserDetails extends BaseTest {

    @Test
    public void verifyUserDetails() {
        //Initialisation
        WebDriver driver = setupTest();
        CaptchaPage captchaPage = new CaptchaPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginMenuPage loginMenuPage = new LoginMenuPage(driver);
        UserProfilePage userProfilePage = new UserProfilePage(driver);

        //Test
        //captchaPage.clickCaptcha(); //Please add break point in line no 23 and complete the captcha and resume the test.
        homePage.acceptCookie();
        homePage.clickUserMenu();
        loginMenuPage.userLogin(getDataFromProperty("UserName"), getDataFromProperty("Password"));
        loginMenuPage.verifyLogin();
        loginMenuPage.clickOnPersonalInfo();
        userProfilePage.verifyUserDetails("FIRSTNAME", getDataFromProperty("FirstName"));
        userProfilePage.verifyUserDetails("LASTNAME", getDataFromProperty("LastName"));
        userProfilePage.verifyUserDetails("PHONE", getDataFromProperty("PhoneNumber"));
        userProfilePage.verifyUserDetails("EMAIL", getDataFromProperty("emailID"));
        userProfilePage.verifyUserDetails("COUNTRY-CODE", getDataFromProperty("CountryCode"));
        userProfilePage.verifyUserDetails("DOB", getDataFromProperty("DOB"));
        userProfilePage.verifyGender(getDataFromProperty("Gender"));
        loginMenuPage.logoutUser();
        homePage.verifyLogOut();
        tearDown(driver);
    }
}
