package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase{

    //@FindBy(id = "user_login")
    @FindBy(css="input[id='user_login']")
    private WebElement loginInput;

    @FindBy(id = "user_password")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement signinBtn;

    @FindBy(css = "div[class='alert alert-error']")
    private WebElement loginError;


    /**
     * Method to login, version #1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) {
        loginInput.sendKeys(usernameValue);
        passwordInput.sendKeys(passwordValue, Keys.ENTER);

        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
//    public void login() {
//        loginInput.sendKeys(ConfigurationReader.getProperty("username"));
//        passwordInput.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
//        BrowserUtils.waitForPageToLoad(10);
//        BrowserUtils.wait(3);
//    }

    public String getLoginError(){
        return loginError.getText();
    }
}








