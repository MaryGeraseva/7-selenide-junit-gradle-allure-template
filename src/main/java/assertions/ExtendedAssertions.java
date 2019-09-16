package assertions;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import reporting.LogInstance;
import webElements.BaseGroup;
import webElements.Checkbox;

public class ExtendedAssertions {

    private Logger log = LogInstance.getLogger();

    @Step("check page by current url")
    public void url(String expectedUrl) {
        String currentUrl = WebDriverRunner.url();
        Assertions.assertEquals(expectedUrl, currentUrl,
                String.format("expected page with url %s wasn't opened, current url is %s", expectedUrl, currentUrl));
        log.info(String.format("checked page by url %s", currentUrl));
    }

    @Step("check that checkbox is selected")
    public void isSelected(Checkbox checkbox) {
        Assertions.assertTrue(checkbox.getStatus().isSelected(), String.format("checkbox %s wasn't selected",
                checkbox.getElement().getText()));
        log.info(String.format("checkbox was selected %s %s", checkbox.getElement().getText(), checkbox.getLocator()));
    }

    @Step("check that checkbox is unselected")
    public void isUnselected(Checkbox checkbox) {
        Assertions.assertFalse(checkbox.getStatus().isSelected(), String.format("checkbox %s wasn't unselected",
                checkbox.getElement().getText()));
        log.info(String.format("checkbox was unselected %s %s", checkbox.getElement().getText(), checkbox.getLocator()));
    }

    @Step("check that elements group is selected")
    public void isAllSelected(BaseGroup collection) {
        Assertions.assertTrue(groupIsSelect(collection), "web collection wasn't selected");
        log.info("web collection was selected");
    }

    @Step("check that elements group is unselected")
    public void isAllUnselected(BaseGroup collection) {
        Assertions.assertFalse(groupIsSelect(collection), "web collection wasn't unselected");
        log.info("web collection was unselected");
    }

    private boolean groupIsSelect(BaseGroup collection) {
        for(SelenideElement element : collection.getCollection()) {
            if(!element.isSelected()) {
                return false;
            }
        }
        return true;
    }
}
