package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.SliderPage;
import com.telran.tests.TestBase;
import com.telran.pages.widgets.MenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).selectWidgets();
    }

    @Test
    public void manuTest() {
        new SidePanelPage(driver).selectMenuItem();
        new MenuPage(driver).selectSubMenu();
    }

    @Test
    public void sliderTest() {
        new SidePanelPage(driver).selectSlider();
        new SliderPage(driver).moveSliderInHorizontalDirection();
        Assert.assertTrue(new SliderPage(driver).isSliderValueDisplayed(60));
    }
}
