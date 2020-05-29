package com.zerobank.step_definitions;

import com.zerobank.pages.FindTransactionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FindTransactionsStepDefinitions {
    FindTransactionPage findTransP=new FindTransactionPage();


    @And("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
       findTransP.clickFindTransactions();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from, String to) {
       findTransP.enterFromDates(from);
       findTransP.enterToDates(to);
    }

    @When("clicks search")
    public void clicks_search() {
       findTransP.clickFindBtn();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from, String to) {
        System.out.println("result");
        Assert.assertTrue(findTransP.checkBetweenDates(from, to));
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        Assert.assertTrue(findTransP.verifySort());
    }

    @Then("the results table should not contain transactions dated {string}")
    public void the_results_table_should_not_contain_transactions_dated(String string) {
        Assert.assertTrue(findTransP.checkDateNotExist(string));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        findTransP.enterDescription(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        Assert.assertTrue(findTransP.checkDescriptionExist(string));
    }

//    @Then("results table should not show descriptions containing {string}")
//    public void results_table_should_not_show_descriptions_containing(String string) {
//
//    }


    @Then("verify that uppercase and lowercase results are same")
    public void verify_that_uppercase_and_lowercase_results_are_same() {

        Assert.assertTrue(findTransP.verifyCaseInsensitive());
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        Assert.assertTrue(findTransP.checkDepositExist());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        Assert.assertTrue(findTransP.checkWithdrawalExist());
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        findTransP.chooseType(string);
        findTransP.clickFindBtn();


    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
    Assert.assertTrue(findTransP.checkWithdrawalNotExist());
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        Assert.assertTrue(findTransP.checkDepositNotExist());
    }



}
