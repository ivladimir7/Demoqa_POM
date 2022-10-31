package com.telran.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;
import java.net.URI;
import java.net.URL;

public class JSExecutor extends BasePage {
    JavascriptExecutor js;


    public JSExecutor(WebDriver driver) {
        super(driver);
    }

    public JSExecutor enterDataWithJS(String userName, String userEmail) {
        if (userName != null && userEmail != null) {
            js.executeScript("document.getElementById('userName').value'" + userName + "';");
            js.executeScript("document.getElementById('userEmail').style.border =5 px solid red ';");
            js.executeScript("document.getElementById('userEmail').value'" + userEmail + "';");
        }
        return this;
    }
    public JSExecutor clickOnSubmitWithJS() {
        js.executeScript("document.getElementById('#submit').style.backgroundColor = 'red';");
        js.executeScript("document.getElementById('submit').click();");
        return this;
    }

    public JSExecutor  checkBoxWithJS() {
        js.executeScript("document.getElementById('hobbies-checkbox-1').ch=false;");
        js.executeScript("document.getElementById('hobbies-checkbox-1').ch=true;");
        return this;
    }
    public  JSExecutor getTitlePageAndURLWithJS() {
        String text =js.executeScript("return document.title;").toString();
        System.out.println(text);
        String url = js.executeScript("return document.URl;").toString();
        System.out.println(url);
        return this;
    }
}