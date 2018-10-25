package com.test.PrintReports;

import com.test.Methods.Frame;
import com.test.Methods.Pause;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FormationAndVerification {
    private WebDriver driver;
    private Frame frame;
    private Pause pause;

    public FormationAndVerification (WebDriver driver) {
        this.driver = driver;
        this.frame = new Frame( (EventFiringWebDriver) driver );
        this.pause = new Pause();
    }

    @FindBy(xpath = "//span[text() = '1']/preceding::td[@align = 'center'][2]")
    @CacheLookup
    private WebElement prntReports1;
    @FindBy(xpath = "//span[text() = '2']/preceding::td[@align = 'center'][2]")
    @CacheLookup
    private WebElement prntReports2;
    @FindBy(xpath = "//span[text() = '4']/preceding::td[@align = 'center'][2]")
    @CacheLookup
    private WebElement prntReports4;
    @FindBy(xpath = "//span[text() = '3030']/preceding::td[@align = 'center'][2]")
    @CacheLookup
    private WebElement prntReports3030;
    @FindBy(xpath = "//span[text() = '5502']/preceding::td[@align = 'center'][2]")
    @CacheLookup
    private WebElement prntReports5502;
    @FindBy(id = "btBack")
    private WebElement btBack;
    @FindBy(id = "lbPageTitle")
    private WebElement lbPageTitle;

    public void pressReports1(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", prntReports1);
        prntReports1.click();
        new Print( driver );
    }

    public void pressReports2(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", prntReports2);
        prntReports2.click();
        new Print( driver );
    }

    public void pressReports4(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", prntReports4);
        prntReports4.click();
        new Print( driver );
    }

    public void pressReports3030(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", prntReports3030);
        prntReports3030.click();
        new Print( driver );
    }

    public void pressReports5502(){
        frame.toMainFrame();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", prntReports5502);
        prntReports5502.click();
        new Print( driver );
    }

    public void pressBtBack(){
        btBack.click();
        new Print( driver );
    }

    public String getTextTitle(){
        pause.userDelay( 1500 );
        return  lbPageTitle.getText();
    }


}
