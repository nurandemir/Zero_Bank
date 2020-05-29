package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class PurchaseForeignCurrencyPage extends AbstractPageBase {

    @FindBy(linkText="Purchase Foreign Currency")
    private WebElement purchaseForeignCur;

    @FindBy(id="pc_currency")
    private WebElement currencySelect;

    @FindBy(id="pc_amount")
    private WebElement amount;

    @FindBy(id="pc_calculate_costs")
    private WebElement calculateCost;

    public void clickPurchaseForeignCurrency(){
        wait.until(ExpectedConditions.elementToBeClickable(purchaseForeignCur)).click();
        BrowserUtils.wait(3);
    }

    public boolean verifyCurrencyList(List<String>dataList){
        Select select=new Select(currencySelect);
        int selectCount=select.getOptions().size();
        List<String> optionText=new ArrayList<>();
        for (int i = 0; i <selectCount ; i++) {
            optionText.add(select.getOptions().get(i).getText());
        }
        return optionText.containsAll(dataList);

    }

    public void enterAmount(String amnt){
        wait.until(ExpectedConditions.visibilityOf(amount)).sendKeys(amnt);
    }

    public void clickCalculateCosts(){
      wait.until(ExpectedConditions.elementToBeClickable(calculateCost)).click();
    }

    public String verifyError(){
       return driver.switchTo().alert().getText();
    }




}
