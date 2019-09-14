package webElements;

import com.codeborne.selenide.SelenideElement;
import common.reporting.LogInstance;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Link {

    private Logger log = LogInstance.getLogger();

    @Step("click by link")
    public void click(By locator) {
        SelenideElement link = $(locator);
        link.click();
        log.info(String.format("clicked by link %s", link.getValue()));
    }

    @Step("click by link")
    public void click(SelenideElement link) {
        link.click();
        log.info(String.format("clicked by link %s", link.getValue()));
    }
}
