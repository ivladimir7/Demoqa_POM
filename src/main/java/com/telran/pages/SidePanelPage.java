package com.telran.pages;

import com.telran.pages.alerts.AlertsPage;
import com.telran.pages.alerts.BrowserWindowsPage;
import com.telran.pages.alerts.FramePage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.pages.elements.ButtonsPage;
import com.telran.pages.widgets.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SidePanelPage extends BasePage {

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profileButton;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profileButton, 0, 300);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    WebElement alertsButton;

    public AlertsPage selectAlerts() {
        click(alertsButton);
        return new AlertsPage(driver);
    }
    @FindBy(xpath= "//span[.='Browser Windows']" )
    WebElement browserWindowsButton;

    public BrowserWindowsPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindowsButton,300,0);
        return new BrowserWindowsPage(driver);
    }
    @FindBy(xpath= "//span[.='Buttons']" )
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons,0,500);
        return new ButtonsPage(driver);
    }
    @FindBy(xpath="//span[. = 'Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJSExecutor(selectMenu, 0, 500);
        return  new SelectMenuPage(driver);
    }
    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramePage selectFrame() {
        clickWithJSExecutor(frames,0,300);
        return new FramePage(driver);
    }
}
//span[contains(.,'Profile')]