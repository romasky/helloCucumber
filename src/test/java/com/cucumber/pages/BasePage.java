package com.cucumber.pages;

import com.cucumber.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.cucumber.driver.DriverManager.getWebDriver;

public abstract class BasePage {

    protected WebElement waitForElement(By elementBy) {
        WebDriverWait waitForOne = new WebDriverWait(getWebDriver(), 15);
        waitForOne.until(ExpectedConditions.presenceOfElementLocated(elementBy));
        return getWebDriver().findElement(elementBy);
    }
}
