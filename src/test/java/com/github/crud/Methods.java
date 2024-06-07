package com.github.crud;

import dev.Selenium.pages.BasePage;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Methods extends BasePage {
    static final String REPO_EP = "https://api.github.com/user/projects";
    static final String TOKEN = "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";

    @Test(description = "Create repo")
    void postTest() {
        RestAssured
                .given()
                //.header("Authorization", "token " + TOKEN)
                .auth()
                .oauth2(TOKEN)
                .body("{\"name\": \"To Rename\"}")
                .when()
                .post(REPO_EP)
                .then()
                .statusCode(201);
    }

    /*@Test(description = "Update repo")
    void patchTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .body("{\"name\": \"deleteme-patched1\"}")
                .when()
                .patch("https://api.github.com/repos/totestgithubproject1/deleteme")
                .then()
                .statusCode(200);
    }

    @Test
    void deleteTest() {
        RestAssured
                .given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete("https://api.github.com/repos/totestgithubproject/deleteme-patched1")
                .then()
                .statusCode(204);
    }*/
 }
