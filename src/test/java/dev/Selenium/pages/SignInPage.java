package dev.Selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(css = "#login h1")
    private WebElement signInTitle;

    @FindBy(id = "login_field")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "commit")
    private WebElement signInButton;

    @FindBy(css = ".flash-error .js-flash-alert")
    private WebElement logInErrorMessage;


    @Step("Get the sign in tittle")
    public String getSignInTittle() {
        return signInTitle.getText();
    }

    @Step("Set email")
    public void setEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Set password")
    public void setPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Click sign in button")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Get error message")
    public String logInErrorMessage() {
        return logInErrorMessage.getText();
    }


}
