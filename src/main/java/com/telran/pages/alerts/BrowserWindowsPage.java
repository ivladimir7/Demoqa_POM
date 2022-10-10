package com.telran.pages.alerts;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {
    public Object clickOnNewTabButton;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id="tabButton")
    WebElement newTabButton;

    public BrowserWindowsPage clickOnNewTabButton() {
        click(newTabButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public String getTextFormNewTab() {

        return sampleHeading.getText();
    }
    @FindBy (id="windowButton")
    WebElement windowButton;

    public BrowserWindowsPage clickOnNewWindow() {
        click(windowButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
    @FindBy (id="messageWindowButton")
    WebElement messageWindowButton;
    public BrowserWindowsPage clickOnNewWindowMessage() {
        click(messageWindowButton);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

}
