package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Collection;

public class UploadAndDownloadPage extends BasePage {

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "uploadFile")
    WebElement uploadFile;

    public UploadAndDownloadPage performEventKeyUsingRobot() throws AWTException {
        pause(500);
        clickWithRectangle(uploadFile, 12,2);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        return this;
    }
    @FindBy(id= "uploadFilePath")
    WebElement uploadFilePath;

    public String getPath() {
        return uploadFilePath.getText();
    }

    public UploadAndDownloadPage performMouseEventUsingRobot() {
        pause(1000);
        clickWithRectangle(uploadFile, 12,2);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Dimension i = driver.manage().window().getSize();
        System.out.println("x -->" + i.getWidth() + "y -->" + i.getHeight());

        int x = i.getWidth() / 2 + 250;
        int y = i.getWidth() / 5 + 120;

        robot.mouseMove(x,y);
        pause(200);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;

    }
}
