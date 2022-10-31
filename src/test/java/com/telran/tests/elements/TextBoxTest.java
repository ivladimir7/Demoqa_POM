package com.telran.tests.elements;


import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.TextBoxPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectTextBox();
    }

    @Test(dataProvider = "usingNewGuestFile", dataProviderClass = DataProviders.class)
    public void createNewGuestTest(String FullName, String email, String currentAddress,
                                   String permanentAddress) {
        new TextBoxPage(driver).createNewGuest(FullName, email, currentAddress, permanentAddress);
        Assert.assertTrue(new TextBoxPage(driver).getGuestDate().contains("Current Address"));

    }
    @Test
    public void keyBoardEventTest() {
        new TextBoxPage(driver).keyboardEvent();
    }

}
