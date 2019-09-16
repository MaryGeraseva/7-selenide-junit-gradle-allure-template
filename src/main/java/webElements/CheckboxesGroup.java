package webElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

public class CheckboxesGroup extends BaseGroup {

    public CheckboxesGroup(By locator) {
        super(locator);
    }

    public CheckboxesGroup(ElementsCollection collection) {
        super(collection);
    }

    public void select() {
        log.info("select checkbox group");
        List<SelenideElement> checkboxes = collection;
        for (SelenideElement checkbox : checkboxes) {
            log.info(String.format("select checkbox %s %s", checkbox.getText(), locator));
            checkbox.setSelected(true);
        }
    }

    public void unselect() {
        log.info("unselect checkbox group");
        List<SelenideElement> checkboxes = collection;
        for (SelenideElement checkbox : checkboxes) {
            log.info(String.format("unselect checkbox %s %s", checkbox.getText(), locator));
            checkbox.setSelected(false);
        }
    }
}
