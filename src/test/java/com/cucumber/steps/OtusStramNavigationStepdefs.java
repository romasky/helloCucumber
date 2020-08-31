package com.cucumber.steps;

import com.cucumber.pages.OtusMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cucumber.driver.DriverManager.getWebDriver;

public class OtusStramNavigationStepdefs {

    @Given("I navigate to Otus main page by {string}")
    public void navigateToMainPage(String url) {
        getWebDriver().navigate().to(url);
    }

    @When("I select tab {string}")
    public void selectTab(String tabName) {
        OtusMainPage otusMainPage =  new OtusMainPage();
        otusMainPage.selectStream(tabName);
    }

    @Then("I should see {int} courses on {string} page")
    public void verifyCourses(Integer coursesNumber, String pageName) {

    }
}
