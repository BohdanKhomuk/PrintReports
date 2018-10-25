package com.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[text() = 'АРМ Друк звітів ']")
    @CacheLookup
    private WebElement armPrintReport;
    @FindBy(xpath = "(//*[text() = 'АРМ Друк звітів ']/following::*[@data-codeapp = '$RM_DRU1'])[1]")
    @CacheLookup
    private WebElement funcPrintReport;


    private void clickArmPrintReport(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", armPrintReport);
        armPrintReport.click();
        new LoginPage( driver );
    }

    private void clickFuncPrintReport(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", funcPrintReport);
        funcPrintReport.click();
        new LoginPage( driver );
    }

    public void enterFunction(){
        this.clickArmPrintReport();
        this.clickFuncPrintReport();
        new MainPage( driver );
    }
}
