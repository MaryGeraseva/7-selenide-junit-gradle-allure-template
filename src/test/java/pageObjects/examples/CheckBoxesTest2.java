package pageObjects.examples;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pageObjects.examples.checkboxes.CheckBoxPage2;

public class CheckBoxesTest2 extends BaseTest {

    @Test
    @Step("checkboxes test started")
    @Description(value = "test checks interaction with checkboxes")
    public void checkboxesTest(){
        CheckBoxPage2 page = new CheckBoxPage2();
        page.open();
//        page.selectCheckBox(page.getCheckBoxDiv());
//        assertions.isSelected(page.getCheckBoxDiv());
//        page.unselectCheckbox(page.getCheckBoxDiv());
//        assertions.isUnselected(page.getCheckBoxDiv());
    }
}
