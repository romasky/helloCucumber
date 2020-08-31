package com.cucumber.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class OtusMainPage extends BasePage {

    private String streamNameXpath = "//div[@id='categories_id']//a[@title='%s']";

    public void selectStream(String streamName) {
        waitForElement(By.xpath(format(streamNameXpath, streamName))).click();
    }
}
