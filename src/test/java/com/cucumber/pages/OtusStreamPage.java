package com.cucumber.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class OtusStreamPage extends BasePage {

    private String streamTileXpath = "//div[@class ='title-new__text']/h1";
    private String streamCoursesNumberXpath = "//div[@class ='title-new__info']/div[1]";

    public String getCourseTitle() {
        return waitForElement(By.xpath(streamTileXpath)).getText().trim();
    }

    public Integer getNumberOfCourses() {
        String courses = waitForElement(By.xpath(streamCoursesNumberXpath)).getText();
        return Integer.valueOf(courses.substring(courses.indexOf(' ')).trim());
    }
}
