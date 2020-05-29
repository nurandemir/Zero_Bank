package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage=new PayBillsPage();

    @Then("user clicks Pay Bills tab")
    public void user_clicks_Pay_Bills_tab() {
        payBillsPage.navigateTo("Pay Bills");
    }

    @Then("user should verify that title is Zero - Pay Bills")
    public void user_should_verify_that_title_is_Zero_Pay_Bills() {
        Assert.assertEquals(payBillsPage.getPageTitle(),"Zero - Pay Bills");
    }

    @Then("user should verify that {string} should be displayed")
    public void user_should_verify_that_should_be_displayed(String string) {
        payBillsPage.selectAPayee();
        payBillsPage.selectAccount();
        payBillsPage.enterAmount("50");
        payBillsPage.enterDate("2020-05-02");
        payBillsPage.clickPayBtn();
        Assert.assertEquals(payBillsPage.getSuccessfullMsg(),string);
    }

    @Then("user should verify that {string} should be displayed when without entering amount")
    public void user_should_verify_that_should_be_displayed_when_without_entering_amount(String string) {
        payBillsPage.selectAPayee();
        payBillsPage.selectAccount();
        payBillsPage.enterDate("2020-05-02");
        payBillsPage.clickPayBtn();
        Assert.assertEquals(payBillsPage.getAmountAlert(),string);
    }

    @Then("user should verify that {string} should be displayed when without entering date")
    public void user_should_verify_that_should_be_displayed_when_without_entering_date(String string) {
        payBillsPage.selectAPayee();
        payBillsPage.selectAccount();
        payBillsPage.enterAmount("50");
        payBillsPage.clickPayBtn();
        Assert.assertEquals(payBillsPage.getDateAlert(),string);

    }

    @Then("user should verify that alphabetical character should not be accepted as amount")
    public void user_should_verify_that_alphabetical_character_should_not_be_accepted_as_amount() {

        payBillsPage.selectAPayee();
        payBillsPage.selectAccount();
        payBillsPage.enterAmount("abcd");
        payBillsPage.enterDate("2020-05-02");
        Assert.assertEquals(payBillsPage.getAmountAlert(),"");

    }
    @Then("user should verify that special character should not be accepted as amount")
    public void user_should_verify_that_special_character_should_not_be_accepted_as_amount() {

        payBillsPage.selectAPayee();
        payBillsPage.selectAccount();
        payBillsPage.enterAmount("^&*");
        payBillsPage.enterDate("2020-05-02");
        Assert.assertEquals(payBillsPage.getAmountAlert(),"");

    }
    @Then("user should verify that special character should not be accepted as date")
    public void user_should_verify_that_special_character_should_not_be_accepted_as_date() {
        payBillsPage.selectAPayee();
        payBillsPage.selectAccount();
        payBillsPage.enterAmount("100");
        payBillsPage.enterDate("#$%");
        Assert.assertNotEquals(payBillsPage.getDateAlert(),"");
    }

    @Then("user should verify that alphabetical character should not be accepted as date")
    public void user_should_verify_that_alphabetical_character_should_not_be_accepted_as_date() {
        payBillsPage.selectAPayee();
        payBillsPage.selectAccount();
        payBillsPage.enterAmount("100");
        payBillsPage.enterDate("asd");
        Assert.assertNotEquals(payBillsPage.getDateAlert(),"");

    }





}
