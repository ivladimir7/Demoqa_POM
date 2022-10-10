package com.telran.tests.alerts;

import com.telran.pages.alerts.BrowserWindowsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(driver).clickOnNewTabButton();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFormNewTab().contains("sample"));
    }

    @Test
    public void newWindowTest() {
        new BrowserWindowsPage(driver).clickOnNewWindow();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFormNewTab().contains("sample"));

    }

    @Test
    public void newWindowMessageTest() {
        new BrowserWindowsPage(driver).clickOnNewWindowMessage();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFormNewTab().contains("Knowlege"));
    }
}