package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class OtusStreamPage extends BasePage {


    private List<String> streamCoursesNumberXpath = Arrays.asList("(//section)[3]//a");


    public String checkCheckboxIsTrue(String tabName) {
        String streamCheckBoxInstalled = "//label[contains(text(), '" + tabName + "')]/..";
        return waitForElement(By.xpath(streamCheckBoxInstalled)).getAttribute("value");
    }

    public Integer getNumberOfCourses() {
        int totalCourses = 0;
        for (String xpath : streamCoursesNumberXpath) {
            totalCourses += waitForElements(By.xpath(xpath)).size();
        }
        return totalCourses;
    }
}
