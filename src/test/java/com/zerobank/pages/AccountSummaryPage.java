package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;



public class AccountSummaryPage extends AbstractPageBase{

    @FindBy(tagName = "h2")
    private List<WebElement> accountTypes;

    @FindBy(xpath = "(//table)[3]//th")
    private List<WebElement> creditHeaders;

    public boolean doesAccountTypeExist(String account){
        for (WebElement each : accountTypes) {
            if(each.getText().equals(account)){
                return true;
            }
        }
        return false;
    }


    public boolean creditAccountsHeaderExist(String header){
        for (WebElement each : creditHeaders) {
            if(each.getText().equals(header)){
                return true;
            }
        }
        return false;
    }


}
