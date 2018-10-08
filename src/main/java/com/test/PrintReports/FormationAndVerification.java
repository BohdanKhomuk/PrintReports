package com.test.PrintReports;

import com.test.Methods.Frame;
import com.test.Methods.Pause;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    //print
    private By prntReports1 = By.xpath( "//span[text() = '1']/preceding::td[@align = 'center'][2]" );
    private By prntReports2 = By.xpath( "//span[text() = '2']/preceding::td[@align = 'center'][2]" );
    private By prntReports4 = By.xpath( "//span[text() = '4']/preceding::td[@align = 'center'][2]" );
    private By prntReports3030 = By.xpath( "//span[text() = '3030']/preceding::td[@align = 'center'][2]" );
    private By prntReports5502 = By.xpath( "//span[text() = '5502']/preceding::td[@align = 'center'][2]" );

    private By btBack = By.id( "btBack" );

    private By lbPageTitle = By.id( "lbPageTitle" );


    public void pressReports1(){
        frame.toMainFrame();
        WebElement element = driver.findElement(prntReports1);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    public void pressReports2(){
        frame.toMainFrame();
        WebElement element = driver.findElement(prntReports2);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    public void pressReports4(){
        frame.toMainFrame();
        WebElement element = driver.findElement(prntReports4);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    public void pressReports3030(){
        frame.toMainFrame();
        WebElement element = driver.findElement(prntReports3030);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    public void pressReports5502(){
        frame.toMainFrame();
        WebElement element = driver.findElement(prntReports5502);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new Print( driver );
    }

    public void pressBtBack(){
        driver.findElement( btBack ).click();
        new Print( driver );
    }

    public String getTextTitle(){
        pause.userDelay( 2000 );
        return  driver.findElement( lbPageTitle ).getText();
    }


}
