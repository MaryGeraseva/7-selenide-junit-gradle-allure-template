package pageObjects.examples;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.BasePageObject;
import webElements.Button;
import webElements.InputField;
import webElements.TextField;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class MainPage extends BasePageObject {

    private InputField usernameField = new InputField(By.id("username"));
    private InputField passwordField = new InputField(By.id("password"));
    private Button loginButton = new Button($(byText("Login")));
    private TextField errorMessage = new TextField(By.id("flash"));

    private String expectedErrorText = "Your username is invalid!";

    public MainPage() {
        super("http://the-internet.herokuapp.com/login");
    }

    @Step("type user name")
    public MainPage typeUserName(String username) {
        usernameField.type(username);
        log.info(String.format("input login %s", username));
        return this;
    }

    @Step("type password")
    public MainPage typePassword(String password) {
        passwordField.type(password);
        return this;
    }

    @Step("click on the login button")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage();
    }

    @Step("make registration with valid data")
    public LoginPage registration(String username, String password) {
        typeUserName(username);
        typePassword(password);
        clickLoginButton();
        log.info("valid registration was completed");
        return new LoginPage();
    }

    @Step("make registration with invalid data")
    public MainPage registrationInvalid(String username, String password) {
        typeUserName(username);
        typePassword(password);
        clickLoginButton();
        log.info("invalid registration was completed");
        return this;
    }

    @Step("get error message")
    public String getActualError() {
        String errorText = errorMessage.getText();
        log.info("got error message: " + errorText.split("!")[0]);
        return errorText;
    }

    public String getExpectedError() {
        return expectedErrorText;
    }
}
