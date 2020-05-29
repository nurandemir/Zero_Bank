package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends AbstractPageBase {

    @FindBy(id = "sp_payee")
    private WebElement payee;

    @FindBy(id = "sp_account")
    private WebElement account;

    @FindBy(id = "sp_amount")
    private WebElement amount;

    @FindBy(id = "sp_date")
    private WebElement date;

    @FindBy(id = "sp_description")
    private WebElement description;

    @FindBy(id = "pay_saved_payees")
    private WebElement pay;

    @FindBy(xpath = "//span[text()='The payment was successfully submitted.']")
    private WebElement successfulSubmitMsg;



    public String getAmountAlert() {
        return amount.getAttribute("validationMessage");
    }


    public String getDateAlert() {
        return date.getAttribute("validationMessage");
    }


    public void selectAPayee() {
        Select select = new Select(payee);
        select.getOptions().get(0).click();
    }

    public void selectAccount(){
        Select select = new Select(account);
        select.getOptions().get(0).click();
    }

    public void enterAmount(String amnt){
        wait.until(ExpectedConditions.visibilityOf(amount)).sendKeys(amnt);
    }
    public void enterDate(String dateValue){
        wait.until(ExpectedConditions.visibilityOf(date)).sendKeys(dateValue);
    }

    public void clickPayBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(pay)).click();
    }

    public String getSuccessfullMsg(){
        return wait.until(ExpectedConditions.visibilityOf(successfulSubmitMsg)).getText();
    }





}
