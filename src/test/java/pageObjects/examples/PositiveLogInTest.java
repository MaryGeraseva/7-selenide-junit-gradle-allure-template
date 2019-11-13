package pageObjects.examples;

import assertions.ExtendedAssertions;
import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class PositiveLogInTest extends BaseTest {

    @ParameterizedTest(name = "positive login test #{0}")
    @CsvSource({
            "1, 'tomsmith', 'SuperSecretPassword!'",
            "2, 'user', 'password'"
    })
    @Step("positiveLogInTest started")
    @Description(value = "test checks logIn with correct user data")
    public void positiveLogInTest(int testId, String username, String password) {
//        ExtendedAssertions assertions = new ExtendedAssertions();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        MainPage mainPage = welcomePage.clickOnMainPageLink();
        assertions.url(mainPage.getExpectedUrl());
        LoginPage loginPage = mainPage.registration(username, password);
        assertions.url(loginPage.getExpectedUrl());
        MainPage newMainPage = loginPage.clickLogoutButton();
        assertions.url(newMainPage.getExpectedUrl());
    }

    @ParameterizedTest(name = "negative login test #{0}")
    @CsvSource({
            "1, 'test', 'SuperSecretPassword!'",
            "2, 'user', 'password'"
    })
    @Step("positiveLogInTest started")
    @Description(value = "test checks logIn with correct user data")
    public void negativeLogInTest(int testId, String username, String password) {
//        ExtendedAssertions assertions = new ExtendedAssertions();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        MainPage mainPage = welcomePage.clickOnMainPageLink();
        assertions.url(mainPage.getExpectedUrl());
        MainPage newMainPage = mainPage.registrationInvalid(username, password);
        Assertions.assertEquals(newMainPage.getActualError(), newMainPage.getExpectedError());
    }
}

