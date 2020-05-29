package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavPage extends AbstractPageBase{

    @FindBy(id="aa_accountId")
    private WebElement accountDropdown;

    public void clickAccount(String accountName){
       driver.findElement(By.linkText(accountName)).click();
        BrowserUtils.waitForPageToLoad(3);
    }


    public String getSelectedOption(){
        Select select=new Select(accountDropdown);
        return select.getFirstSelectedOption().getText();

    }



}
