package com.test;

//import com.test.Methods.Pause;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;
    //private Pause pause;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        //this.pause = new Pause();
    }

    private By armPrintReport = By.xpath("//*[text() = 'АРМ Друк звітів ']");
    private By funcPrintReport = By.xpath( "(//*[text() = 'АРМ Друк звітів ']/following::*[@data-codeapp = '$RM_DRU1'])[1]" );


    private void clickArmPrintReport(){
        WebElement element = driver.findElement(armPrintReport);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new LoginPage( driver );
    }

    private void clickFuncPrintReport(){
        WebElement element = driver.findElement(funcPrintReport);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new LoginPage( driver );
    }

    public void enterFunction(){
        //pause.userDelay( 2000 );
        this.clickArmPrintReport();
        //pause.userDelay( 3000 );
        this.clickFuncPrintReport();
        new MainPage( driver );
    }
}
