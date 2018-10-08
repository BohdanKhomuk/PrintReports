package com.test.PrintReports;

import com.test.Methods.Frame;
import com.test.Methods.Pause;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Delete {
    private WebDriver driver;
    private Frame frame;
    private Pause pause;

    public Delete (WebDriver driver) {
        this.driver = driver;
        this.frame = new Frame( (EventFiringWebDriver) driver );
        this.pause = new Pause();
    }

    private By delReports1 = By.xpath( "//span[text() = '1']/preceding::td[@align = 'center'][1]" );
    private By delReports2 = By.xpath( "//span[text() = '2']/preceding::td[@align = 'center'][1]" );
    private By delReports4 = By.xpath( "//span[text() = '4']/preceding::td[@align = 'center'][1]" );
    private By delReports3030 = By.xpath( "//span[text() = '3030']/preceding::td[@align = 'center'][1]" );
    private By delReports5502 = By.xpath( "//span[text() = '5502']/preceding::td[@align = 'center'][1]" );

    private void pressBtDelR1(){
        driver.findElement( delReports1 ).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        /*Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();*/
        new Print( driver );
    }

    private void pressBtDelR2(){
        driver.findElement( delReports2 ).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        /*Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();*/
        new Print( driver );
    }

    private void pressBtDelR4(){
        driver.findElement( delReports4 ).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        /*Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();*/
        new Print( driver );
    }

    private void pressBtDelR3030(){
        driver.findElement( delReports3030 ).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        /*Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();*/
        new Print( driver );
    }

    private void pressBtDelR5502(){
        driver.findElement( delReports5502 ).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pause.userDelay( 1000 );
        alert.accept();
        /*Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();*/
        new Print( driver );
    }

    public void deleteReports(){
        frame.toMainFrame();
        this.pressBtDelR1();
        this.pressBtDelR2();
        this.pressBtDelR4();
        this.pressBtDelR3030();
        this.pressBtDelR5502();
        new Print( driver );
    }

}
