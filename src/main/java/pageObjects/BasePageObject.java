package pageObjects;

import com.codeborne.selenide.WebDriverRunner;
import common.reporting.LogInstance;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;

public class BasePageObject {

    private String url;
    public Logger log = LogInstance.getLogger();

    @Step("open page")
    public void openPage(String url) {
        open(url);
        log.info(String.format("opened page: %s", url));
    }

    @Step("set cookie")
    public void addCookie(Cookie cookie) {
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        log.info(String.format("added cookie: %s", cookie.getName()));
    }

    @Step("get cookie")
    public String getCookie(String cookieName) {
        String cookie = WebDriverRunner.getWebDriver().manage().getCookieNamed(cookieName).getValue();
        log.info("getting value of cookie: " + cookieName);
        return cookie;
    }

    @Step("get html of page")
    public String getHtml() {
        String html = WebDriverRunner.source();
        log.info("got html of page");
        return html;
    }

    public String getExpectedUrl() {
        return url;
    }
}
