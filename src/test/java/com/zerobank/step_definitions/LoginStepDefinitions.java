package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String URL = ConfigurationReader.getProperty("URL");
        Driver.getDriver().get(URL);
        BrowserUtils.wait(3);
    }

    @When("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String username, String password) {
        BrowserUtils.waitForPageToLoad(10);

        loginPage.login(username, password);
        //loginPage.login();

    }

    @Then("user should verify that title is a Account summary page")
    public void user_should_verify_that_title_is_a_Account_summary_page() {

        BrowserUtils.waitForPageToLoad(10);
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver().getTitle());

    }


    @Then("user will see error message {string}")
    public void userWillSeeErrorMessage(String errorMsg) {
        Assert.assertEquals(errorMsg, loginPage.getLoginError());
    }
}
