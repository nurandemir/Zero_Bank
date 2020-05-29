package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class StatementsAdDocumentsPage extends AbstractPageBase{

    private String fileName;

    @FindBy(linkText="Online Statements")
    private WebElement onlineStatement;

    @FindBy(partialLinkText = "Statement ")
    private List<WebElement> statementLinks;

    public void clickOnlineStatementTab(){
        wait.until(ExpectedConditions.elementToBeClickable(onlineStatement)).click();
        BrowserUtils.wait(3);
    }

    public void selectYear(int year){
        WebElement yearLink = driver.findElement(By.linkText(""+year));
        yearLink.click();
    }

    public long countStatementList() {
        return statementLinks.size();
    }

    public void clickStatement(String name) {
        WebElement statementLink = driver.findElement(By.partialLinkText(name));
        statementLink.click();
        BrowserUtils.wait(3);
    }



    /**
     * This methods verifies download process.
     * @param fileName searched file
     * @return true if file exist in local directory
     *          false if file doesn't exist in local directory
     */
    public boolean isDownloaded(String fileName) {
        this.fileName=fileName;
        String file=findFile(this.fileName);
        return file != null;
    }

    /**
     * This method verifies downloaded file type
     * @param format searched format
     * @return true if file name contains searched format type
     *          false if file name doesn't contain searched format type
     */
    public boolean isDownloadedType(String format){
        String file=findFile(fileName);
        return file.endsWith(format);
    }

    /**
     * Search local download directory and return searched file full name if exist
     * @param fileName searched file name. Full or partial.
     * @return full file name as string. (including file type)
     *         if file doesn't exist return null
     */
    public String findFile(String fileName){
        try {
            File folder = new File("/Users/nuran/Downloads/");
            File[] files=folder.listFiles();
            assert files != null;
            for (File file : files) {
                if(file.getName().contains(fileName)){
                    return file.getName();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }





}
