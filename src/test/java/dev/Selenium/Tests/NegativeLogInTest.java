package dev.Selenium.Tests;

import com.opencsv.exceptions.CsvException;
import dev.Selenium.base.MainTest;
import dev.Selenium.pages.CreateProjectPage;
import dev.Selenium.pages.HeaderComponent;
import dev.Selenium.pages.SignInPage;
import dev.Selenium.utils.CSVReader;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

@Feature("Negative Log In")
public class NegativeLogInTest extends MainTest {
    HeaderComponent signIn;
    SignInPage signInPage;

    @DataProvider(name = "negative-login-data-file")
    public static Object[][] negativeLogInProviderFromCSVFile() throws IOException, CsvException {
        return CSVReader.readFile("src/test/resources/negative-login-data.csv");
    }

    @Test(dataProvider = "negative-login-data-file")
    public void negativeSignInTest(String email, String password, String username, String errorMessage) {
        signIn = new HeaderComponent();
        signIn.clickSignInButton();

        signInPage = new SignInPage();
        Assert.assertEquals(signInPage.getSignInTittle(), "Sign in to GitHub");

        signInPage.setEmailInput(email);
        signInPage.setPasswordInput(password);
        signInPage.clickSignInButton();
        Assert.assertEquals(signInPage.logInErrorMessage(), errorMessage);




    }
}
