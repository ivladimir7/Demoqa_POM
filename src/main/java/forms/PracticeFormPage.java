package forms;

import com.telran.pages.BasePage;
import jdk.jfr.Percentage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//label[@for='gender-radio-1']")
    WebElement female;

    @FindBy (xpath = "//label[@for='gender-radio-2']")
    WebElement male;

    @FindBy (xpath = "//label[@for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender (String gender) {
        if (gender.equals("Male")) {
            clickWithJSExecutor(male,0,200);
        }else if (gender.equals("Female")) {
            clickWithJSExecutor(female,0,200);
        }else {
            clickWithJSExecutor(other,0,200);
        }
        return this;
    }
}
