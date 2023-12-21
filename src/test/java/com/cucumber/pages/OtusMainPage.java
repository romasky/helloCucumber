package com.cucumber.pages;

import com.cucumber.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.String.format;

public class OtusMainPage extends BasePage {

    private By streamNameXpath = By.xpath("(//section)[3]//div//div[position() >= 2 and position() <= 10]");

    private By registrationButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");

    private By registrationText = By.xpath("//div[contains(text(),'ЗАРЕГИСТРИРУЙТЕ СВОЙ АККАУНТ')]");
    private By regName = By.xpath("//label[contains(text(),'Имя')]/../..");
    private By regSurname = By.xpath("//label[contains(text(),'Фамилия')]/../..");
    private By regEmail = By.xpath("(//label[contains(text(),'Электронная почта')]/../..)[2]");
    private By regButton = By.xpath("//div[contains(text(), 'Зарегистрироваться')]");
    private By numberOfNotifications = By.xpath("//section//div//div[contains(text(),106)]");


    public List<WebElement> findStreamElements() {
        return waitForElements(streamNameXpath);
    }

    public void selectStream(String streamName) {
        List<WebElement> streamElements = findStreamElements();
        for (WebElement element : streamElements) {
            // Производите необходимые действия для сравнения текста элемента с переданным streamName
            if (element.getText().equals(streamName)) {
                element.click();
                break;
            }
        }
    }

    public void clickOnRegistrationButton() {
        waitForElement(registrationButton).click();
    }

    public String checkRegistrationPopupIsOpen() {
        return waitForElement(registrationText).getText();
    }

    public void fillRegForm(String name, String surname, String email) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(regName));
        waitForElement(regName).sendKeys(name);
        waitForElement(regSurname).sendKeys(surname);
        waitForElement(regEmail).sendKeys(email);
        waitForElement(regButton).click();
    }

    public String checkNumberOfNotifications() {
        return waitForElement(numberOfNotifications).getText();
    }

    public String checkRegistrationName(String name) {
        By registrationName = By.xpath("//span[contains(text(), '" + name + "')");
        return waitForElement(registrationName).getText();
    }



}
