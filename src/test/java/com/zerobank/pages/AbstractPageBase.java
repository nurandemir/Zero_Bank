package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void navigateTo(String component) {
        String locator = "//a[text() = '" + component + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

    public void waitForLoaderMask() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[class*='loader-mask']")));
    }








}
