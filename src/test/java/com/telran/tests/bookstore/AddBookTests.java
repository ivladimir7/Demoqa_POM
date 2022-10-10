package com.telran.tests.bookstore;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.bookstore.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.pages.bookstore.LoginPage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }

    @Test
    public void addBookToNewCollection() {
        new BookStorePage(driver).typeInSearchBookInput(BookData.BOOK_NAME)
        .clickOnBookTittlelLink().clickOnAddBookButton().acceptAlert();
        new SidePanelPage(driver).selectProfile();
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_NAME));
    }

}
