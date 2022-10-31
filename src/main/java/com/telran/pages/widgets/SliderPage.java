package com.telran.pages.widgets;
import com.telran.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver wd) {
        super(wd);
    }

    @FindBy(css = ".range-slider.range-slider--primary")
    WebElement slider;

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage moveSliderInHorizontalDirection() {
        Actions actions = new Actions(driver);

        int x = slider.getSize().width;
        int width = slider.getSize().getWidth();
//        actions.dragAndDropBy(slider, x, 0).perform();
//        System.out.println(x);
        actions.moveToElement(slider, width/10, 0).click().perform();
        return this;
    }

    public boolean isSliderValueDisplayed(int value) {
        should(sliderValue,10);
        return driver.findElement(By.cssSelector("#sliderValue[value=']"+ value +"']")).isDisplayed();
    }

    private void should(WebElement element, int time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }
}
