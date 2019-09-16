package webElements;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import reporting.LogInstance;

import static com.codeborne.selenide.Selenide.$;

public class BaseElement {

    By locator;
    SelenideElement element;
    Logger log = LogInstance.getLogger();

    public BaseElement(By locator) {
        this.locator = locator;
        this.element = $(locator);
    }

    public BaseElement(SelenideElement element) {
        this.element = element;
    }

    public By getLocator() {
        return locator;
    }

    public SelenideElement getElement() {
        return element;
    }
}
