package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import reporting.LogInstance;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;

public class BasePageObject {

    private String url;
    public Logger log = LogInstance.getLogger();

    public BasePageObject() {
    }

    public BasePageObject(String url) {
        this.url = url;
    }

    @Step("open page")
    public void open() {
        log.info(String.format("opening page: %s", url));
        Selenide.open(url);
    }

    @Step("add cookie")
    public void addCookie(Cookie cookie) {
        log.info(String.format("adding cookie: %s", cookie.getName()));
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
    }

    @Step("get cookie")
    public String getCookie(String cookieName) {
        log.info("getting value of cookie: " + cookieName);
        return WebDriverRunner.getWebDriver().manage().getCookieNamed(cookieName).getValue();
    }

    @Step("get html of page")
    public String getHtml() {
        log.info("getting html of page");
        return WebDriverRunner.source();
    }

    public String getExpectedUrl() {
        return url;
    }
}
