package com.test.PrintReports;

import com.test.Methods.Frame;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static com.test.LoginPage.getPolygon;

public class Print {

    private WebDriver driver;
    private Frame frame;

    public Print(WebDriver driver) {
        this.driver = driver;
        this.frame = new Frame( (EventFiringWebDriver) driver );
    }


    @FindBy(id = "gvVCbirepReplist_ctl02_ibQuery")
    @CacheLookup
    private WebElement reports1;
    @FindBy(id = "gvVCbirepReplist_ctl03_ibQuery" )
    @CacheLookup
    private WebElement reports2;
    @FindBy(id = "gvVCbirepReplist_ctl05_ibQuery")
    @CacheLookup
    private WebElement reports4;
    @FindBy(id = "gvVCbirepReplist_ctl346_ibQuery")
    @CacheLookup
    private WebElement reports3030;
    @FindBy(id = "gvVCbirepReplist_ctl376_ibQuery")
    @CacheLookup
    private WebElement reports5502;
    @FindBy(id = "btSend")
    private WebElement btSend;
    @FindBy(xpath = "(//*[@alt = 'Перечитати данi'])[1]" )
    @CacheLookup
    private WebElement btUpdate;


    private void pressReports1(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", reports1);
        reports1.click();
        new Print ( driver );
    }

    private void pressReports2(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", reports2);
        reports2.click();
        new Print( driver );
    }

    private void pressReports4(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", reports4);
        reports4.click();
        new Print( driver );
    }

    private void pressReports3030(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", reports3030);
        reports3030.click();
        new Print( driver );
    }

    private void pressReports5502(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", reports5502);
        reports5502.click();
        new Print( driver );
    }

    private void pressBtSend(){
        btSend.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        new Print( driver );
    }

    private void pressBtUpdate(){
        btUpdate.click();
        new Print( driver );
    }

    public void print(){
        this.pressReports1();
        this.pressBtSend();
        this.pressReports2();
        this.pressBtSend();
        this.pressReports4();
        this.pressBtSend();
        this.pressReports3030();
        this.pressBtSend();
        if(/*getPolygon() == 22 ||*/ getPolygon() == 40) {
            this.pressReports5502 ( );
            this.pressBtSend ( );
        }
        this.pressBtUpdate();
        new Print( driver );
    }
}
