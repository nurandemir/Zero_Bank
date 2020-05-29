package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionPage extends AbstractPageBase {

    @FindBy(linkText = "Find Transactions")
    private WebElement findTransactions;

    @FindBy(id = "aa_fromDate")
    private WebElement datesFrom;

    @FindBy(id = "aa_toDate")
    private WebElement datesTo;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement findBtn;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tr/td[1]")
    private List<WebElement> resultDates;

    @FindBy(id = "aa_description")
    private WebElement description;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tr/td[2]")
    private List<WebElement> resultDescription;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//td[3]")
    private List<WebElement>resultDeposit;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//td[4]")
    private List<WebElement>resultWithdrawal;

    @FindBy(id="aa_type")
    private WebElement typeBox;



    public void clickFindTransactions() {
        wait.until(ExpectedConditions.elementToBeClickable(findTransactions)).click();
        BrowserUtils.wait(3);


    }

    public void enterFromDates(String string) {
        datesFrom.clear();
        wait.until(ExpectedConditions.visibilityOf(datesFrom)).sendKeys(string);
    }

    public void enterToDates(String string) {
        datesTo.clear();
        wait.until(ExpectedConditions.visibilityOf(datesTo)).sendKeys(string);
    }

    public void clickFindBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(findBtn)).click();
        BrowserUtils.wait(3);
    }

    public boolean checkBetweenDates(String from, String to) {
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date fromDate = (Date) formatter.parse(from);
            Date toDate = (Date) formatter.parse(to);
            for (WebElement each : resultDates) {
                String tableStrDate=each.getText();
                Date tableDate = (Date) formatter.parse(tableStrDate);
                if(tableDate.compareTo(fromDate)<0||tableDate.compareTo(toDate)>0){
                    return false;
                }
            }
        } catch (Exception e) {

        }
        return true;
    }

    public boolean verifySort(){
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        int size=resultDates.size();
        for (int i = 0; i <size-1 ; i++) {
            for (int j = i+1; j <size ; j++) {
                try {
                    String date1Str = resultDates.get(i).getText();
                    Date date1 = (Date) formatter.parse(date1Str);
                    String date2Str = resultDates.get(j).getText();
                    Date date2 = (Date) formatter.parse(date1Str);
                    if(date1.compareTo(date2)<0){
                        return false;
                    }
                } catch (Exception e) {

                }
            }
        }
        return true;
    }

    public boolean checkDateNotExist(String dateStr) {
        for (WebElement each : resultDates) {
            if(dateStr.equals(each.getText())){
                return false;
            }
        }
        return true;
    }

    public void enterDescription(String str){
        description.clear();
        wait.until(ExpectedConditions.visibilityOf(description)).sendKeys(str);

    }

    public boolean checkDescriptionExist(String desc) {
        for (WebElement each : resultDescription) {
            if(!each.getText().contains(desc)){
                return false;
            }
        }
        return true;
    }

    public boolean verifyCaseInsensitive(){
        enterDescription("ONLINE");
        clickFindBtn();
        List<WebElement>search1=resultDescription;
        enterDescription("online");
        clickFindBtn();
        List<WebElement>search2=resultDescription;
        return search1.equals(search2);
    }

    public boolean checkDepositExist() {
        for (WebElement each : resultDeposit) {
            if(!each.getText().isEmpty()){
                return true;
            }
        }
        return false;
    }

    public boolean checkWithdrawalExist() {
        for (WebElement each : resultWithdrawal) {
            if(!each.getText().isEmpty()){
                return true;
            }
        }
        return false;
    }

    public void chooseType(String str){
        Select select=new Select(typeBox);
        if(str.equals("Deposit")) {
            select.selectByIndex(1);
        }else if(str.equals("Withdrawal")){
            select.selectByIndex(2);
        }
    }

    public boolean checkWithdrawalNotExist() {
        for (WebElement each : resultWithdrawal) {
            if(!each.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public boolean checkDepositNotExist() {
        for (WebElement each : resultDeposit) {
            if(!each.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }








}
