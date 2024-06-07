package dev.Selenium.Tests;

import com.opencsv.exceptions.CsvException;
import dev.Selenium.base.MainTest;
import dev.Selenium.pages.*;
import dev.Selenium.pages.CreateProjectPage;
import dev.Selenium.utils.CSVReader;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Create Repository")
public class CreateRepoTest extends MainTest {
    HeaderComponent signIn;
    SignInPage signInPage;
    CreateProjectPage createProject;

    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";

    @DataProvider(name = "login-data-file")
    public static Object[][] logInProviderFromCSVFile() throws IOException, CsvException {
        return CSVReader.readFile("src/test/resources/login-data.csv");
    }

    @Test(dataProvider = "login-data-file")
    public void signInTest(String email, String password, String username) {
        signIn = new HeaderComponent();
        signIn.clickSignInButton();

        signInPage = new SignInPage();
        Assert.assertEquals(signInPage.getSignInTittle(), "Sign in to GitHub");

        signInPage.setEmailInput(email);
        signInPage.setPasswordInput(password);
        signInPage.clickSignInButton();

        createProject = new CreateProjectPage();

        createProject.clickProfileAvatar();
        createProject.clickYourReposTab();

        createProject.clickNewRepo();
        createProject.newRepoInput("This is A new Repo");
        Assert.assertEquals(createProject.checkRepoNameConfirmation(), "This-is-A-new-Repo");

        createProject.scrollToBottom();

        createProject.clickCreateRepoButton();
    }

    @Test
    void deleteRepo() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete("https://api.github.com/repos/totestgithubproject1/This-is-A-new-Repo")
                .then()
                .statusCode(204);
    }

}
