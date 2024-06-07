package dev.Selenium.Tests;

import com.opencsv.exceptions.CsvException;
import dev.Selenium.base.MainTest;
import dev.Selenium.pages.CreateAccountPage;
import dev.Selenium.pages.HeaderComponent;
import dev.Selenium.utils.CSVReader;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

@Feature("Negative Create Account")
public class NegativeCreateAccountTest extends MainTest {
    CreateAccountPage createAccountPage;
    HeaderComponent signUp;


    @DataProvider(name = "negative-email-file")
    public static Object[][] negativeEmailProviderFromCSVFile() throws IOException, CsvException {
        return CSVReader.readFile("src/test/resources/negative-email-data.csv");
    }

    @Story("Negative Create with negative email data")
    @Test(dataProvider = "negative-email-file")
    public void createAccountEmailField(String email, String errorMessage) throws InterruptedException {

        signUp = new HeaderComponent();
        signUp.clickSignUpButton();
        createAccountPage = new CreateAccountPage();
        createAccountPage.setEmail(email);
        Assert.assertFalse(createAccountPage.checkIfDisabledButtonEmail());
        assertEquals(createAccountPage.getEmailErrorMessage(), errorMessage);
    }

    @DataProvider(name = "negative-password-file")
    public static Object[][] negativePasswordProviderFromCSVFile() throws IOException, CsvException {
        return CSVReader.readFile("src/test/resources/negative-password-data.csv");
    }

    @Story("Negative Create with negative password data")
    @Test(dataProvider = "negative-password-file")
    public void setPasswordField(String password, String errorMessage, String errorMessageColor, String errorGuidance) throws InterruptedException {
        signUp = new HeaderComponent();
        signUp.clickSignUpButton();
        createAccountPage = new CreateAccountPage();
        createAccountPage.setEmail("1234542@gmail.com");
        createAccountPage.checkIfEnabledButtonEmail();
        createAccountPage.clickContinueButtonEmail();
        Assert.assertTrue(createAccountPage.checkEmailGreenMark());
        createAccountPage.setPassword(password);
        createAccountPage.clickShowPassword();
        assertEquals(createAccountPage.getPasswordErrorMessage(), errorMessage);
        assertEquals(createAccountPage.checkPasswordMessageColor(), errorMessageColor);
        assertEquals(createAccountPage.getPasswordGuidance(), errorGuidance);
    }

    @DataProvider(name = "negative-username-file")
    public static Object[][] negativeUsernameProviderFromCSVFile() throws IOException, CsvException {
        return CSVReader.readFile("src/test/resources/negative-username-data.csv");
    }

    @Story("Negative Create with negative Username data")
    @Test(dataProvider = "negative-username-file")
    public void setUsernameField(String username, String errorGuidance) {
        signUp = new HeaderComponent();
        signUp.clickSignUpButton();
        createAccountPage = new CreateAccountPage();
        createAccountPage.setEmail("1234542@gmail.com");
        createAccountPage.checkIfEnabledButtonEmail();
        createAccountPage.clickContinueButtonEmail();
        Assert.assertTrue(createAccountPage.checkEmailGreenMark());
        createAccountPage.setPassword("Thispasswordworks!$");
        createAccountPage.clickShowPassword();

        Assert.assertTrue(createAccountPage.checkPasswordGreenMark());
        createAccountPage.clickContinuePassword();
        createAccountPage.setUsernameInput(username);
        createAccountPage.checkIfDisabledButtonUsername();
        assertEquals(createAccountPage.getUsernameErrorMessage(), errorGuidance);

        assertEquals(createAccountPage.checkVerificationPageTitle(), "Welcome to GitHub!\n" + "Let’s begin the adventure");
    }
}
