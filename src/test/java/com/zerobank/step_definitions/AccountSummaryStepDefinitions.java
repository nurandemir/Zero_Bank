package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccountSummaryStepDefinitions {

    AccountSummaryPage acSumPage=new AccountSummaryPage();

    @Then("user should verify that account type {string} exist")
    public void user_should_verify_that_account_type_exist(String string) {
        Assert.assertTrue(acSumPage.doesAccountTypeExist(string));
    }

    @Then("user should verify that column name {string} exist")
    public void user_should_verify_that_column_name_exist(String string) {
        Assert.assertTrue(acSumPage.creditAccountsHeaderExist(string));
    }





}
