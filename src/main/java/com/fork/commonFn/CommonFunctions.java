package com.fork.commonFn;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class CommonFunctions {

    public boolean elementIsPresent(WebElement element) {
        try {
            if (element.isDisplayed()) {
                return true;
            }
        } catch (NoSuchElementException n) {
            System.out.println("Element not present");
        }
        return false;
    }

    public boolean radioButtonEnabled(WebElement element) {
        try {
            if (element.isEnabled()) {
                return true;
            }
        } catch (NoSuchElementException n) {
            System.out.println("Element is not present in the page");
           }

        return false;
    }

    public boolean verifyUserData(WebElement element, String expectedValue) {
        try {
            return element.getAttribute("value").equals(expectedValue);
        } catch (NoSuchElementException e) {
            System.out.println("Element is not present in the page");
            return false;
        }

    }
    public boolean verifyDropDownValue(WebElement element, String expectedValue) {
        try {
            Select select = new Select(element);
            WebElement firstSelectedOption=select.getFirstSelectedOption();
            return firstSelectedOption.getText().equals(expectedValue);
        } catch (NoSuchElementException e) {
            System.out.println("Element is not present in the page");
            return false;
        }

    }


}