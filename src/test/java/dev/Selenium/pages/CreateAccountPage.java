package dev.Selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    /*------EMAIL ELEMENTS------*/
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(css = "#email-err>p")
    private WebElement emailErrorMessage;

    @FindBy(css = "#email-container button")
    private WebElement continueButtonEmail;

    @FindBy(css = "#email-container .signup-continue-prompt")
    private WebElement greencheckEmail;

    /*------EMAIL ELEMENTS END------*/

    /*------PASSWORD ELEMENTS------*/

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "#password-err>.password-validity-summary")
    private WebElement passwordErrorMessage;

    @FindBy(css = "visible-password>button")
    private WebElement showPassword;

    @FindBy(css = "#password-container button.js-continue-button")
    private WebElement continueButtonPassword;

    @FindBy(css = "#password-container .signup-continue-prompt")
    private WebElement greenCheckPassword;

    @FindBy(xpath = "//*[@id=\"password-err\"]/p[2]")
    private WebElement passwordGuidance;

    /*------PASSWORD ELEMENTS END------*/

    /*------USERNAME ELEMENTS------*/
    @FindBy(id = "login")
    private WebElement usernameInput;

    @FindBy(css = "#username-container button")
    private WebElement continueButtonUsername;

    @FindBy(css = "#login-err .mb-1")
    private WebElement usernameErrorMessage;

    /*------USERNAME ELEMENTS END------*/

    /*------VERIFICATION PAGE ELEMENTS-----*/

    @FindBy(css = ".js-signup-typed-welcome>.text-mono")
    private WebElement verificationPageTitle;

    /*------VERIFICATION PAGE ELEMENTS END-----*/

    /*------EMAIL------*/
    @Step("Set email")
    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    @Step("Get Email Error Message")
    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }
    @Step("Click Continue Button")
    public void clickContinueButtonEmail() {
        continueButtonEmail.click();
    }

    @Step("Check if continue button is enabled")
    public boolean checkIfEnabledButtonEmail() {
        waitForElementToBeEnabled(continueButtonEmail);
        return continueButtonEmail.isEnabled();
    }

    @Step("Check if continue button is disabled")
    public boolean checkIfDisabledButtonEmail() {
        return continueButtonEmail.isEnabled();
    }

    @Step("Check for green checkmark")
    public boolean checkEmailGreenMark() {
        return greencheckEmail.isDisplayed();
    }
    /*------EMAIL END------*/

    /*------PASSWORD------*/

    @Step("Set Password")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    @Step("Get password error message")
    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    @Step("Check password error message color")
    public String checkPasswordMessageColor() {
        return passwordErrorMessage.getCssValue("color");
    }

    @Step("Click shoe password")
    public void clickShowPassword() {
        showPassword.click();
    }

    @Step("Click continue on password")
    public void clickContinuePassword() {
        waitForElementToBeEnabled(continueButtonPassword);
        continueButtonPassword.click();
    }

    @Step("Check for green checkmark on password")
    public boolean checkPasswordGreenMark() {
        return greenCheckPassword.isDisplayed();
    }

    @Step("Get password guidance message")
    public String getPasswordGuidance() {
        return passwordGuidance.getText();
    }
    /*------PASSWORD END------*/

    /*------USERNAME------*/

    @Step("Set username")
    public void setUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    @Step("Check if username continue is enabled")
    public boolean checkIfDisabledButtonUsername() {
        return continueButtonUsername.isEnabled();
    }

    @Step("Get username error message")
    public String getUsernameErrorMessage() {
        return usernameErrorMessage.getText();
    }
    /*------USERNAME END------*/

    /*------VERIFICATION PAGE-----*/

    @Step("Check verification page tittle")
    public String checkVerificationPageTitle() {
        return verificationPageTitle.getText();
    }

    /*------VERIFICATION PAGE END-----*/
}
