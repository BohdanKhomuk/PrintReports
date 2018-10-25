package com.test.PrintReports;

import com.test.Methods.Frame;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class VerificationStatus {
    private Frame frame;

    public VerificationStatus (WebDriver driver) {
        this.frame = new Frame( (EventFiringWebDriver) driver );
    }

    @FindBy(xpath = "(//span[text() = '1']/following::td/span)[1]")
    @CacheLookup
    private WebElement statusReports1;
    @FindBy(xpath = "(//span[text() = '2']/following::td/span)[1]")
    @CacheLookup
    private WebElement statusReports2;
    @FindBy(xpath = "(//span[text() = '4']/following::td/span)[1]")
    @CacheLookup
    private WebElement statusReports4;
    @FindBy(xpath = "(//span[text() = '3030']/following::td/span)[1]")
    @CacheLookup
    private WebElement statusReports3030;
    @FindBy(xpath = "(//span[text() = '5502']/following::td/span)[1]")
    @CacheLookup
    private WebElement statusReports5502;


    public String getStatusR1(){
        frame.toMainFrame();
        return  statusReports1.getText();
    }

    public String getStatusR2(){
        frame.toMainFrame();
        return  statusReports2.getText();
    }

    public String getStatusR4(){
        return  statusReports4.getText();
    }

    public String getStatusR3030(){
        return  statusReports3030.getText();
    }

    public String getStatusR5502(){
        return  statusReports5502.getText();
    }
}
