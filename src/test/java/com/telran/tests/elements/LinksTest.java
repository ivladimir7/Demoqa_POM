package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.LinksPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTest extends TestBase {

    @BeforeMethod
    public void EnsurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectLinks();
    }

    @Test
    public void checkLinksTest() {
        new LinksPage(driver).checkAllLinks().checkBrokenLinks();
        Assert.assertTrue(new LinksPage(driver).getAPIResponsetext("No Content").contains("staus 204"));
    }

}