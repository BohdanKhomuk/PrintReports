package com.test.PrintReports;

import com.test.Methods.Frame;
import com.test.Methods.Pause;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Print {

    private WebDriver driver;
    private Frame frame;
    private Pause pause;

    public Print (WebDriver driver) {
        this.driver = driver;
        this.frame = new Frame( (EventFiringWebDriver) driver );
        this.pause = new Pause();
    }

    private By reports1 = By.id( "gvVCbirepReplist_ctl02_ibQuery" );
    private By reports2 = By.id( "gvVCbirepReplist_ctl03_ibQuery" );
    private By reports4 = By.id( "gvVCbirepReplist_ctl05_ibQuery" );
    private By reports3030 = By.id( "gvVCbirepReplist_ctl346_ibQuery" );
    private By reports5502 = By.id( "gvVCbirepReplist_ctl376_ibQuery" );
    private By btSend = By.id( "btSend" );
    private By btUpdate = By.xpath( "(//*[@alt = 'Перечитати данi'])[1]" );




    private void pressReports1(){
        frame.toMainFrame();
        WebElement element = driver.findElement(reports1);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    private void pressReports2(){
        frame.toMainFrame();
        WebElement element = driver.findElement(reports2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    private void pressReports4(){
        frame.toMainFrame();
        WebElement element = driver.findElement(reports4);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    private void pressReports3030(){
        frame.toMainFrame();
        WebElement element = driver.findElement(reports3030);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    private void pressReports5502(){
        frame.toMainFrame();
        WebElement element = driver.findElement(reports5502);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    private void pressBtSend(){
        pause.userDelay( 2000 );
        driver.findElement( btSend ).click();
        pause.userDelay( 1200 );
        Alert alert = driver.switchTo().alert();
        alert.accept();
        /*Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();*/
        new Print( driver );
    }

    private void pressBtUpdate(){
        driver.findElement( btUpdate ).click();
        new Print( driver );
    }

    public void print(){
        this.pressReports1();
        this.pressBtSend();
        pause.userDelay( 2000 );
        this.pressReports2();
        this.pressBtSend();
        pause.userDelay( 2000 );
        this.pressReports4();
        this.pressBtSend();
        pause.userDelay( 2000 );
        this.pressReports3030();
        this.pressBtSend();
        pause.userDelay( 2000 );
        this.pressReports5502();
        this.pressBtSend();
        this.pressBtUpdate();
        new Print( driver );
    }

}
