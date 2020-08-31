package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OtusStramNavigationStepdefs {

    @Given("I navigate to Otus main page by {string}")
    public void navigateToMainPage(String url) {

    }

    @When("I select tab {string}")
    public void selectTab(String tabName) {

    }

    @Then("I should see {int} courses on {string} page")
    public void verifyCourses(Integer coursesNumber, String pageName) {

    }
}
