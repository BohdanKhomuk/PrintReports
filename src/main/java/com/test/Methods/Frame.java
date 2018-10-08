package com.test.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Frame {
    private EventFiringWebDriver eventDriver;

    public Frame(EventFiringWebDriver eventFiringWebDriver){
        this.eventDriver = eventFiringWebDriver;
    }

    private void todefCont(){
        eventDriver.switchTo().defaultContent();
    }

    public void toMainFrame(){
        todefCont();
        eventDriver.switchTo().frame(eventDriver.findElement(By.id("mainFrame")));
    }
}
