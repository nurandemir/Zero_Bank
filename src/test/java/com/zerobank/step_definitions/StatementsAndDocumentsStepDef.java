package com.zerobank.step_definitions;

import com.zerobank.pages.StatementsAdDocumentsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementsAndDocumentsStepDef {

    StatementsAdDocumentsPage sdPage = new StatementsAdDocumentsPage();

    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        sdPage.clickOnlineStatementTab();
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer int1) {
        sdPage.selectYear(int1);
    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(Integer int1) {
        long count = int1;
        Assert.assertEquals(sdPage.countStatementList(), count);
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String string) {
       sdPage.clickStatement(string);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String string) {
        Assert.assertTrue(sdPage.isDownloaded(string));
    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
        Assert.assertTrue(sdPage.isDownloadedType("pdf"));
    }


}
