package com.test.PrintReports;

import com.test.Methods.Frame;
//import com.test.Methods.Pause;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class VerificationStatus {
    private WebDriver driver;
    private Frame frame;

    public VerificationStatus (WebDriver driver) {
        this.driver = driver;
        this.frame = new Frame( (EventFiringWebDriver) driver );
    }

    private By statusReports1 = By.xpath( "(//span[text() = '1']/following::td/span)[1]" );
    private By statusReports2 = By.xpath( "(//span[text() = '2']/following::td/span)[1]" );
    private By statusReports4 = By.xpath( "(//span[text() = '4']/following::td/span)[1]" );
    private By statusReports3030 = By.xpath( "(//span[text() = '3030']/following::td/span)[1]" );
    private By statusReports5502 = By.xpath( "(//span[text() = '5502']/following::td/span)[1]" );

    public String getStatusR1(){
        frame.toMainFrame();
        return  driver.findElement( statusReports1 ).getText();
    }

    public String getStatusR2(){
        frame.toMainFrame();
        return  driver.findElement( statusReports2 ).getText();
    }

    public String getStatusR4(){
        return  driver.findElement( statusReports4 ).getText();
    }

    public String getStatusR3030(){
        return  driver.findElement( statusReports3030 ).getText();
    }

    public String getStatusR5502(){
        return  driver.findElement( statusReports5502 ).getText();
    }
}
