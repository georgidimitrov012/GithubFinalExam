package dev.Selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateProjectPage extends BasePage {
    @FindBy(id = "projects-tab")
    private WebElement projectsTab;

    @FindBy(css = "form button.FormField-input>.Button-content")
    private WebElement newProjectButton;

    @FindBy(css = ".d-none>a.btn")
    private WebElement newRepo;

    @FindBy(css = "#RepoNameInput-message strong")
    private WebElement greenConfirmation;

    @FindBy(css = "fieldset span.TextInput-wrapper>input")
    private WebElement repoNameInput;

    @FindBy(xpath = "//*[text()='Create repository']")
    private WebElement createRepoButton;

    @FindBy(css = ".Dialog__Header-sc-uaxjsn-2>.Box-sc-g0xbh4-0")
    private WebElement xButtonPopup;

    @FindBy(css = "main h1")
    private WebElement projectName;

    @FindBy(id = "settings-project-name")
    private WebElement projectNameInput;

    @FindBy(className = "rFpke")
    private WebElement greenCheckProjectName;

    @FindBy(css = ".AppHeader-user button.AppHeader-logo")
    private WebElement profileAvatar;

    @FindBy(linkText = "Your repositories")
    private WebElement yourRepositories;

    @FindBy(linkText = "New")
    private WebElement newProjectButtonTEXT;

    @FindBy(xpath = "//*[text()='Save changes']")
    private WebElement saveChangesButton;

    @Step("Click new repo button")
    public void clickNewRepo() {
        newRepo.click();
    }

    @Step("Check repo name confirmation")
    public String checkRepoNameConfirmation() {
        return greenConfirmation.getText();
    }

    @Step("Scroll to the bottom of the page")
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @Step("Click create repo button")
    public void clickCreateRepoButton() {
        createRepoButton.click();
    }

    @Step("Enter new repo name")
    public void newRepoInput(String newRepoName) {
        repoNameInput.sendKeys(newRepoName);
    }

    @Step("Click profile avatar")
    public void clickProfileAvatar() {
        profileAvatar.click();
    }

    @Step("Click on repos tab")
    public void clickYourReposTab() {

        try {
            yourRepositories.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            yourRepositories.click();
        }
    }
}
