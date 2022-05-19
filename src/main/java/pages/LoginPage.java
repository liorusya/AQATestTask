package pages;

import io.qameta.allure.Step;
import lib.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends ParentPage {

    @FindBy(tagName = "h1")
    private WebElement loginHeader;
    @FindBy(xpath = ".//input[@name='username']")
    private WebElement userNameField;
    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = ".//input[@class='btn btn-success']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[1]/span[@class='help-block']")
    private WebElement errorMessageForUserName;
    @FindBy(xpath = "//div[2]/span[@class='help-block']")
    private WebElement errorMessageForPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public String getRelativeUrl() {
        return "/registerlogin/registerlogin.php";
    }

    @Step
    public void openLoginPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Base url was opened");

        } catch (Exception e) {
            logger.error("Can not open LoginPage " + e);
            Assert.fail("Can not open LoginPage " + e);
        }

    }

    @Step
    public LoginPage verifyTheLoginPageIsOpened() {
        checkUrl();
        Assert.assertEquals("Header 'AQA internship Login'  was not displayed",
                "AQA internship Login", loginHeader.getText());
        return this;
    }

    @Step
    public LoginPage enterUserName(String userName) {
        enterTextInToElement(userNameField, userName);
        return this;
    }

    @Step
    public LoginPage enterPassword(String password) {
        enterTextInToElement(passwordField, password);
        return this;
    }

    @Step
    public LoginPage clickLoginBtn() {
        //NOTICE: in the test task mentioned - SIGNUP button ??? instead of Login button
        clickOnElement(loginButton);
        return this;
    }

    @Step
    public LoginPage verifyTheUserNameEntered(String userName) {
        isElementDisplayed(webDriver.findElement(By.xpath(".//input[@name='username' and @value ='" + userName + "']")));
        return this;
    }

    @Step
    public LoginPage verifyIfUserNameFieldIsDisplayed() {

        Assert.assertTrue("The UserName field is Not displayed",
                isElementDisplayed(userNameField));
        return this;
    }

    @Step
    public LoginPage verifyIfPasswordFieldIsDisplayed() {

        Assert.assertTrue("The passwordField field is NOT displayed",
                isElementDisplayed(passwordField));
        return this;
    }

    @Step
    public LoginPage verifyIfLoginBtnDisplayed() {

        Assert.assertTrue("The login BTN is NOT displayed",
                isElementDisplayed(loginButton));
        return this;
    }

    @Step
    public LoginPage verifyIfErrorMessagesAppearedInCaseEmptyFields() {
        isElementDisplayed(errorMessageForUserName);
        Assert.assertEquals("incorrect Error message", TestData.ERROR_ENTER_USER_NAME,
                errorMessageForUserName.getText());
        isElementDisplayed(errorMessageForPassword);
        Assert.assertEquals("incorrect Error message", TestData.ERROR_ENTER_PASSWORD, errorMessageForPassword.getText());
        return this;
    }

    @Step
    public LoginPage verifyIfErrorMessageAppearedInCaseInvalidPassword() {
        isElementDisplayed(errorMessageForPassword);
        Assert.assertEquals("incorrect Error message", TestData.ERROR_PASSWORD_INVALID, errorMessageForPassword.getText());
        return this;
    }

    @Step
    public LoginPage verifyIfErrorMessageAppearedInCaseNoAccount() {
        isElementDisplayed(errorMessageForUserName);
        Assert.assertEquals("incorrect Error message", TestData.ERROR_NO_ACCOUNT, errorMessageForUserName.getText());
        return this;
    }

    @Step
    public LoginPage verifyIfUserNameFieldIsNOTDisplayed() {

        Assert.assertFalse("The UserName field is displayed",
                isElementDisplayed(userNameField));
        return this;
    }

}
