package com.telran.pages.alerts;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);

    }
    @FindBy (tagName = "iframe")
    List<WebElement> frames;


    public FramePage returnListofFrames() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of Frames are" + numberOfFrames);
        System.out.println("Number of Frames are" + frames.size());
        return this;
    }
    @FindBy (id = "frame1")
    WebElement frame1;

    public FramePage switchToFrameId() {
        driver.switchTo().frame(frame1);
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy (id = "sampleHeading")
    WebElement frameText;

    public String getFrameText() {
        driver.switchTo().frame(frame1);
        return frameText.getText();
    }

}
