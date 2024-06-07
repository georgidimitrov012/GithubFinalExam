package dev.Selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReposPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href,\"To-Rename\")]")
    private WebElement repoToRename;

    @FindBy(xpath = "//a[contains(@href,\"To-Delete\")]")
    private WebElement repoToDelete;

    @FindBy(id = "settings-tab")
    private WebElement settingsTab;

    @FindBy(id = "rename-field")
    private WebElement renameField;

    @FindBy(css = "form>button.flex-self-end")
    private WebElement renameButton;

    @FindBy(css = "#repo-title-component a")
    private WebElement repoName;

    @FindBy(id = "dialog-show-repo-delete-menu-dialog")
    private WebElement deleteButton;

    @FindBy(id = "repo-delete-proceed-button")
    private WebElement confirmRepoDelete;

    @FindBy(id = "repo-delete-proceed-button")
    private WebElement confirmRepoDelete2;

    @FindBy(name = "verification_field")
    private WebElement verificationInput;

    @Step("Click the repo to rename")
    public void clickRepoToRename() {
        try {
            repoToRename.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            repoToRename.click();
        }
    }

    @Step("Click the repo to delete")
    public void clickRepoToDelete() {
        try {
            repoToDelete.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            repoToDelete.click();
        }
    }

    @Step("Click on settings tab")
    public void clickSettingsTab() {
        settingsTab.click();
    }

    @Step("Set the new name for the repo ")
    public void renameInputField(String newName) {
        renameField.clear();
        renameField.sendKeys(newName);
    }

    @Step("Click rename button")
    public void clickRenameButton() {
        waitForElementToBeEnabled(renameButton);
        renameButton.click();
    }

    @Step("Check new repo name")
    public String checkNewRepoName() {
        return repoName.getText();
    }

    @Step("Scroll to the bottom of the page")
    public void scrollToBottom() {
        waitForElementToBeVisible(renameButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @Step("Click delete repo button")
    public void clickDeleteRepoButton() {
        deleteButton.click();
    }

    @Step("Click confirm to delete")
    public void clickConfirmRepoDelete() {
        confirmRepoDelete.click();
    }

    @Step("Click confirm to delete2")
    public void clickConfirmRepoDelete2() {
        confirmRepoDelete2.click();
    }

    @Step("Set the verification input")
    public void verificationInput(String verification) {
        verificationInput.sendKeys(verification);
    }
}
