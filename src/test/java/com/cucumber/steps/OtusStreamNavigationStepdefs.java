package com.cucumber.steps;

import com.cucumber.pages.OtusMainPage;
import com.cucumber.pages.OtusStreamPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cucumber.driver.DriverManager.getWebDriver;
import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class OtusStreamNavigationStepdefs {

    @Given("I navigate to Otus main page by {string}")
    public void navigateToMainPage(String url) {
        getWebDriver().navigate().to(url);
    }

    @When("I select tab {string}")
    public void selectTab(String tabName) {
        OtusMainPage otusMainPage =  new OtusMainPage();
        otusMainPage.selectStream(tabName);
    }



    @Then("I should see {int} courses on {string} and tabName should be {string} selected")
    public void iShouldSeeNumberOfCoursesCoursesOnAndTabNameShouldBeSelected(int coursesNumber, String tabName, String isTabVisible) {
        OtusStreamPage otusStreamPage = new OtusStreamPage();
        assertEquals("error", isTabVisible,otusStreamPage.checkCheckboxIsTrue(tabName));
        assertThat(otusStreamPage.getNumberOfCourses()).isEqualTo(coursesNumber);
    }

    @When("I click on the registration button")
    public void iClickOnTheRegistrationButton() {
        OtusMainPage otusMainPage =  new OtusMainPage();
        otusMainPage.clickOnRegistrationButton();
    }


    @Then("I should see the open registration form")
    public void iShouldSeeTheOpenRegistrationForm() {
        OtusMainPage otusMainPage =  new OtusMainPage();
        assertEquals("equals error", "ЗАРЕГИСТРИРУЙТЕ СВОЙ АККАУНТ",otusMainPage.checkRegistrationPopupIsOpen());
    }


    @When("I enter {string} in the name field, {string} in the surname field, {string} in the email field, and tap the registration button")
    public void iEnterNameInTheNameFieldSurnameInTheSurnameFieldEmailInTheEmailFieldAndTapTheRegistrationButton(String name, String surname, String email) {
        OtusMainPage otusMainPage =  new OtusMainPage();
        otusMainPage.fillRegForm(name,surname,email);
    }




    @Then("I should see {string} notifications and the users {string}")
    public void iShouldSeeNumberOfNotificationsNotificationsAndTheUsersName(String number, String name) {
        OtusMainPage otusMainPage =  new OtusMainPage();
        assertEquals("equals error", number,otusMainPage.checkNumberOfNotifications());
        assertEquals("equals error", name,otusMainPage.checkRegistrationName(name));
    }
    }