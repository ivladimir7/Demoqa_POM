package com.telran.pages.forms;

import com.telran.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement male;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement female;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            clickWithJSExecutor(male, 0, 200);
        } else if (gender.equals("Female")) {
            clickWithJSExecutor(female, 0, 200);
        } else {
            clickWithJSExecutor(other, 0, 200);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String bDay) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage chooseHobby(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                clickWithJSExecutor(sports, 0, 300);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String picturePath) {
        uploadPicture.sendKeys(picturePath);
        return this;
    }

    @FindBy(id = "firstName")
    WebElement FirstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "userNumber")
    WebElement userNumberField;

    @FindBy(id = "currentAddress")
    WebElement currentAddressField;

    public PracticeFormPage enterPersonalData(String firstName, String lastName, String email,
                                              String mobile, String currentAddress) {
        typeWithJSExecutor(FirstNameField, firstName, 0, 700);
        typeWithJSExecutor(lastNameField, lastName, 0, 700);
        typeWithJSExecutor(userEmailField, email, 0, 700);
        typeWithJSExecutor(userNumberField, mobile, 0, 700);
        typeWithJSExecutor(currentAddressField, currentAddress, 0, 700);
        return this;
    }

    @FindBy(xpath = "//div[.='Select State']")
    WebElement selectState;

    public PracticeFormPage enterState(String state) {
        clickWithJSExecutor(selectState, 0, 900);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", state)));
        clickWithJSExecutor(element, 0, 900);
        pause(800);
        return this;
    }

    @FindBy(xpath = "//div[.='Select City']")
    WebElement selectCity;

    public PracticeFormPage enterCity(String city) {
        clickWithJSExecutor(selectCity, 0, 800);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", city)));
        clickWithJSExecutor(element, 0, 800);
        pause(500);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage clickSubmitButton() {
        clickWithJSExecutor(submit, 0, 700);
        return this;

    }

    @FindBy(xpath = "//*[.='Tom Sorer']")
    WebElement getFirstNameText;

    public String getStudentNameText() {
        return getFirstNameText.getText();
    }

    public PracticeFormPage hideIframes() {
        hideAd();
        hideFooter();
        return this;
    }

    public PracticeFormPage enterAddress(String address) {
        typeWithJSExecutor(currentAddressField, address, 0, 300);
        return this;
    }
}