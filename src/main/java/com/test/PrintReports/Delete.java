package com.test.PrintReports;

import com.test.Methods.Frame;
import com.test.Methods.Pause;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static com.test.LoginPage.getPolygon;

public class Delete {
    private WebDriver driver;
    private Frame frame;
    private Pause pause;

    public Delete (WebDriver driver) {
        this.driver = driver;
        this.frame = new Frame( (EventFiringWebDriver) driver );
        this.pause = new Pause();
    }

    @FindBy(xpath = "//span[text() = '1']/preceding::td[@align = 'center'][1]")
    @CacheLookup
    private WebElement delReports1;
    @FindBy(xpath = "//span[text() = '2']/preceding::td[@align = 'center'][1]")
    @CacheLookup
    private WebElement delReports2;
    @FindBy(xpath = "//span[text() = '4']/preceding::td[@align = 'center'][1]")
    @CacheLookup
    private WebElement delReports4;
    @FindBy(xpath = "//span[text() = '3030']/preceding::td[@align = 'center'][1]")
    @CacheLookup
    private WebElement delReports3030;
    @FindBy(xpath = "//span[text() = '5502']/preceding::td[@align = 'center'][1]")
    @CacheLookup
    private WebElement delReports5502;


    private void pressBtDelR1(){
        delReports1.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        new Print( driver );
    }

    private void pressBtDelR2(){
        delReports2.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();pause.userDelay( 1000 );
        alert.accept();
        new Print( driver );
    }

    private void pressBtDelR4(){
        delReports4.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        new Print( driver );
    }

    private void pressBtDelR3030(){
        delReports3030.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        new Print( driver );
    }

    private void pressBtDelR5502(){
        delReports5502.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        new Print( driver );
    }

    public void deleteReports(){
        frame.toMainFrame();
        this.pressBtDelR1();
        this.pressBtDelR2();
        this.pressBtDelR4();
        this.pressBtDelR3030();
        if(/*getPolygon() == 22 ||*/ getPolygon() == 40) {
            this.pressBtDelR5502();
        }
        new Print( driver );
    }
}
