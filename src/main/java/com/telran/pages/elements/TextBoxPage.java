package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(id="userName")
    WebElement userNameField;

    @FindBy(id="userEmail")
    WebElement userEmailField;

    @FindBy(id="currentAddress")
    WebElement currentAddressField;

    @FindBy(id="permanentAddress")
    WebElement permanentAddressField;

    @FindBy(id="submit")
    WebElement submit;

    public TextBoxPage createNewGuest(String fullName, String email, String currentAddress,
                                      String permanentAddress) {
        type(userNameField, fullName);
        type(userEmailField, email);
        type(currentAddressField, currentAddress);
        type(permanentAddressField, permanentAddress);
        submit.click();
        return this;
    }

    @FindBy(xpath = "//*[@id='currentAddress']")
    WebElement guestDate;

    public String getGuestDate() {
        pause(500);
        System.out.println(guestDate.getText());
        return guestDate.getText();

    }

    public TextBoxPage keyboardEvent() {
        type(userNameField, "Tom Sorer");
        type(userEmailField, "test@gmx.de");
        typeWithJSExecutor(currentAddressField, "Halberd 101,72555 Stuttgart",0,200);
        Actions actions =new Actions(driver);
        pause(500);
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        actions.keyDown(Keys.TAB).perform();
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
        return this;
    }

}
