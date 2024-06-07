package dev.Selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {
    @FindBy(className = "HeaderMenu-link--sign-up")
    private WebElement signUpButton;

    @FindBy(className = "HeaderMenu-link--sign-in")
    private WebElement signInButton;

    @Step("Click sign up button")
    public void clickSignUpButton() {
        signUpButton.click();
    }

    @Step("Click sign in button")
    public void clickSignInButton() {
        signInButton.click();
    }
}
