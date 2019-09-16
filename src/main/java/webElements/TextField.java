package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class TextField extends BaseElement {

    public TextField(By locator) {
        super(locator);
    }

    public TextField(SelenideElement element) {
        super(element);
    }

    public String getText() {
        String text = element.getText();
        log.info("got text field value: %s");
        return text;
    }
}
