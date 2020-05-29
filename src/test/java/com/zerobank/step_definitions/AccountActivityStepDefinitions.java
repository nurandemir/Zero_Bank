package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountActivityStepDefinitions {

    AccountActivityPage acActivityPage=new AccountActivityPage();

    @Then("user clicks Account Activity tab")
    public void user_clicks_Account_Activity_tab() {
        acActivityPage.navigateTo("Account Activity");
    }

    @And("user should verify that title is a Account activity page")
    public void user_should_verify_that_title_is_a_Account_activity_page() {
        Assert.assertEquals(acActivityPage.getPageTitle(),"Zero - Account Activity");
    }


    @And("user should verify that account dropdown option {string} exist")
    public void user_should_verify_that_account_dropdown_option_exist(String string) {
        Assert.assertTrue(acActivityPage.checkDropdownOptions(string));
    }

    @And("user should verify that transaction column name {string} exist")
    public void user_should_verify_that_transaction_column_name_exist(String string) {
        Assert.assertTrue(acActivityPage.doesTransactionColumnNameExist(string));
    }




}
