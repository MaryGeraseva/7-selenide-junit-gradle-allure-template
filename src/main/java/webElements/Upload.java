package webElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Upload extends BaseElement {

    public Upload(By locator) {
        super(locator);
    }

    public Upload(SelenideElement element) {
        super(element);
    }

    public void addFile(String path) {
        log.info(String.format("add file with path: %s", path));
        element.shouldBe(Condition.visible, Condition.enabled).setValue(path);
    }
}
