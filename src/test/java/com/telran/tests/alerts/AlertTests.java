package com.telran.tests.alerts;

import com.telran.pages.alerts.AlertsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectAlerts();

    }
    @Test
    public void alertTest() {
        new AlertsPage(driver).acceptButtonAlert();
    }
    @Test
    public void alertWaitTest() {
        new AlertsPage(driver).acceptTimerAlert();
}

    @Test
    public void alertConfirmTest() {
        new AlertsPage(driver).chooseConfirmButton("Cancel");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Cancel"));
    }

    @Test
    public void alertSendTextTest() {
        new AlertsPage(driver).sendTextToAlert("Hi everyone");
        //Assert.assertTrue(new AlertsPage(driver).getConfirmMessageResult().contains("Hi"));
    }

}