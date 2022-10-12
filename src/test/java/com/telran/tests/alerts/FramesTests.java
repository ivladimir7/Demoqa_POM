package com.telran.tests.alerts;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.alerts.FramePage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectFrame();
    }
    @Test
    public  void framesTest() {
         new FramePage(driver).returnListofFrames();
    }
    @Test
    public void switchToFrameByIndexTest() {
        new FramePage(driver).switchToFrameId();

    }
    @Test
    public void switchToFrameByIdTest() {
        new FramePage(driver).switchToFrameId();
        Assert.assertTrue(new FramePage(driver).getFrameText().contains("This is a"));
    }
}
