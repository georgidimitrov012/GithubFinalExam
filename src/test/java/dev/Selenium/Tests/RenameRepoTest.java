package dev.Selenium.Tests;

import com.opencsv.exceptions.CsvException;
import dev.Selenium.base.MainTest;
import dev.Selenium.pages.CreateProjectPage;
import dev.Selenium.pages.HeaderComponent;
import dev.Selenium.pages.ReposPage;
import dev.Selenium.pages.SignInPage;
import dev.Selenium.utils.CSVReader;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Rename Repository")
public class RenameRepoTest extends MainTest {
    HeaderComponent signIn;
    SignInPage signInPage;
    CreateProjectPage createProject;
    ReposPage reposPage;

    static final String REPO_EP = "https://api.github.com/user/repos";
    static final String TOKEN = "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";

    @Test(description = "Create repo")
    void createRepo() {
        RestAssured
                .given()
                .header("Authorization", "token " + TOKEN)
                /*.auth()
                .oauth2(TOKEN)*/
                .body("{\"name\": \"To Rename\"}")
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }

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

        reposPage = new ReposPage();

        reposPage.clickRepoToRename();

        reposPage.clickSettingsTab();

        reposPage.renameInputField("THIS IS RENAMED");

        reposPage.clickRenameButton();

        Assert.assertEquals(reposPage.checkNewRepoName(), "THIS-IS-RENAMED");
    }

    @Test
    void deleteRepo() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete("https://api.github.com/repos/totestgithubproject1/THIS-IS-RENAMED")
                .then()
                .statusCode(204);
    }
}
