package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class InputField extends BaseElement{

    public InputField(By locator) {
        super(locator);
    }

    public InputField(SelenideElement element) {
        super(element);
    }

    public void type(String text) {
        log.info(String.format("type in the input field: %s", text));
        element.setValue(text);
    }

    public void clear() {
        log.info("clear input field");
        element.clear();
    }
}
