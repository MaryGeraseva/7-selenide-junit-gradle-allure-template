package examples;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import assertions.ExtendedAssertions;


public class PositiveLogInTest extends BaseTest {



    @Test
    @Step("positiveLogInTest started")
    @Description(value = "test checks logIn with correct user data")
    public void positiveLogInTest(String username, String password) {
        ExtendedAssertions assertions =new ExtendedAssertions();
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.openWelcomePage();
        MainPage mainPage = welcomePage.clickOnMainPageLink();
        assertions.url(mainPage.getExpectedUrl());

        LoginPage loginPage = mainPage.registration(username, password);
        assertLogInByPageHeading(loginPage.getExpectedHeading(), loginPage.getHeading());
        MainPage newMainPage = loginPage.clickLogoutButton();
    }

    @Step("verification logIn by expected page heading")
    private void assertLogInByPageHeading(String expectedHeading, String heading) {
        Assertions.assertTrue(expectedHeading.contains(heading));
    }

    @Step("verification logOut by expected page heading")
    private void assertLogOutByPageHeading(String expectedHeading, String heading) {
        Assertions.assertTrue(expectedHeading.contains(heading));
    }
}

