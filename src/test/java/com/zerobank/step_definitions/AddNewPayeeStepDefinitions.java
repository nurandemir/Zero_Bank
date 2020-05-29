package com.zerobank.step_definitions;

import com.zerobank.pages.AddNewPayeePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefinitions {

    AddNewPayeePage addNewPayeePage=new AddNewPayeePage();

    @Then("user clicks Add New Payee tab")
    public void user_clicks_Add_New_Payee_tab() {
        addNewPayeePage.clickAddNewPayee();
    }

    @Then("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
       addNewPayeePage.enterNewPayeeInfo(dataTable);
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        Assert.assertEquals(addNewPayeePage.getSuccessMsg(),string);
    }






}
