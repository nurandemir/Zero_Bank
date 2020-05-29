package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends AbstractPageBase {


    @FindBy(id="aa_accountId")
    private WebElement accountDropdown;

    @FindBy(xpath = "//div[@id=\"all_transactions_for_account\"]//th")
    private List<WebElement> transactionColumnNames;



    public boolean checkDropdownOptions(String option){
        BrowserUtils.wait(3);
        Select select=new Select(accountDropdown);
        for(WebElement each: select.getOptions()){
            if(each.getText().equals(option)){
                return true;
            }
        }
        return false;
    }

    public boolean doesTransactionColumnNameExist(String columnName){
        BrowserUtils.wait(3);
        for (WebElement each : transactionColumnNames) {
            if(each.getText().equals(columnName)){
                return true;
            }
        }
        return false;
    }


}
