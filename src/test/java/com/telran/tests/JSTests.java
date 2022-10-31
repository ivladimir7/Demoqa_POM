package com.telran.tests;

import com.telran.data.UserData;

import com.telran.pages.HomePage;
import com.telran.pages.JSExecutor;
import com.telran.pages.SidePanelPage;

import org.testng.annotations.Test;

public class JSTests extends TestBase {

    @Test
    public void typeAndClickWithJSTest() {
    new HomePage(driver).selectElements();
    new SidePanelPage(driver).selectTextBox();
    new JSExecutor(driver).enterDataWithJS(UserData.USER_NAME,UserData.USER_EMAIL);

        }
    @Test
    public void CheckBoxWithJS() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectTextBox();
        new JSExecutor(driver).checkBoxWithJS();
    }
}

