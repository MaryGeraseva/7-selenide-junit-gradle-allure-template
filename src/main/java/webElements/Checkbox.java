package webElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Checkbox extends BaseElement{

    By statusLocator;
    SelenideElement status;

    public Checkbox(By locator) {
        super(locator);
    }

    public Checkbox(By actionLocator, By statusLocator) {
        super(actionLocator);
        this.statusLocator = statusLocator;
    }

    public Checkbox(SelenideElement element) {
        super(element);
    }

    public void select() {
        log.info(String.format("select checkbox %s %s", element.getText(), locator));
        element.shouldBe(Condition.visible, Condition.enabled).setSelected(true);
    }

    public void unselect() {
        log.info(String.format("unselect checkbox %s %s", element.getText(), locator));
        element.shouldBe(Condition.visible, Condition.enabled).setSelected(false);
    }

    public void selectWithClick() {
        log.info(String.format("select checkbox %s %s", element.getText(), locator));
        getCheckboxStatus();
        if(!status.isSelected()) {
            element.click();
        }
    }

    public void unselectWithClick() {
        log.info(String.format("unselect checkbox %s %s", element.getText(), locator));
        getCheckboxStatus();
        if(status.isSelected()) {
            element.click();
        }
    }

    private void getCheckboxStatus() {
        if(statusLocator == null) {
            status = element;
        } else {
            status = $(statusLocator);
        }
    }

    public SelenideElement getStatus() {
        return status;
    }
}
