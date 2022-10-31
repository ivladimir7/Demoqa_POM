package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void createNewStudentTest() {
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
                StudentData.EMAIL, StudentData.TEL_NUM, StudentData.ADDRESS);
        new PracticeFormPage(driver).selectGender(StudentData.GENDER)
                .typeOfDate(StudentData.DATE)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY);

        new PracticeFormPage(driver).clickSubmitButton();

        Assert.assertTrue(new PracticeFormPage(driver).getStudentNameText().contains("Tom Sorer"));
    }
}
//    @Test
//            (dataProviderClass = DataProviders.class, dataProvider  = "DPFile")
//    public void createNewStudentWithDataprovidesTest(String firstName, String lastName, String email, String phone, String birthDate, String file, String address) {
//        new PracticeFormPage(driver).
//                hideIframes().
//                enterStudentData(StudentData).clickSubmitButton();
//        new PracticeFormPage(driver).selectGender(StudentData.GENDER)
//                .chooseHobby(StudentData.HOBBIES)
//                .uploadFile(StudentData.PHOTO_PATH)
//                .clickSubmitButton();
//
//        Assert.assertTrue(new PracticeFormPage(driver).getModalTitle().contains("Thanks for submitting the form"));
//        new PracticeFormPage(driver).closeModal();
//    }
//}