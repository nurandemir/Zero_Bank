package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

public class AddNewPayeePage extends AbstractPageBase {

    @FindBy(linkText = "Add New Payee")
    private WebElement addNewPayeeTab;

    @FindBy(id = "np_new_payee_name")
    private WebElement payeeNameBox;

    @FindBy(id = "np_new_payee_address")
    private WebElement payeeAddressBox;

    @FindBy(id = "np_new_payee_account")
    private WebElement accountBox;

    @FindBy(id = "np_new_payee_details")
    private WebElement payeeDetails;

    @FindBy(id = "add_new_payee")
    private WebElement addBtn;

    @FindBy(id="alert_content")
    private WebElement successMsg;

    public void clickAddNewPayee() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewPayeeTab)).click();
        BrowserUtils.wait(2);
    }

    public void enterNewPayeeInfo(Map<String, String> dataTable) {
        payeeNameBox.sendKeys(dataTable.get("Payee Name"));
        payeeAddressBox.sendKeys(dataTable.get("Payee Address"));
        accountBox.sendKeys(dataTable.get("Account"));
        payeeDetails.sendKeys(dataTable.get("Payee details"));
        addBtn.click();

    }

    public String getSuccessMsg(){
      return wait.until(ExpectedConditions.visibilityOf(successMsg)).getText();
    }







}
