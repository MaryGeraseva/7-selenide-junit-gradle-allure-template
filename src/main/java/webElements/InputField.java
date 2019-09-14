package webElements;

import com.codeborne.selenide.SelenideElement;
import common.reporting.LogInstance;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InputField {

    private Logger log = LogInstance.getLogger();
    private By locator;
    private SelenideElement inputField;

    InputField(By locator) {
        this.locator = locator;
        this.inputField = $(locator);
    }

    InputField(SelenideElement inputField) {
        this.inputField = inputField;
    }

    @Step("type in input field")
    public void type(By locator, String text) {
        $(locator).setValue(text);
        log.info(String.format("typed in input field: %s", text));
    }

    @Step("type in input field")
    public void type(SelenideElement input, String text) {
        input.setValue(text);
        log.info(String.format("typed in input field: %s", text));
    }

    @Step("clear input field")
    public void clear(By locator) {
        $(locator).clear();
        log.info("input field was cleared");
    }

    @Step("clear input field")
    public void clear(SelenideElement input) {
        input.clear();
        log.info("input field was cleared");
    }
}
