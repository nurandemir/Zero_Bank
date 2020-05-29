package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityNavPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountActivityNavStepDefinitions {

    AccountActivityNavPage acActvtyNavPage=new AccountActivityNavPage();


    @Then("user clicks {string} account link")
    public void user_clicks_account_link(String string) {

        acActvtyNavPage.clickAccount(string);
    }

    @Then("user verifies {string} is selected in dropdown")
    public void user_verifies_is_selected_in_dropdown(String string) {
        Assert.assertEquals(acActvtyNavPage.getSelectedOption(),string);
    }
}
