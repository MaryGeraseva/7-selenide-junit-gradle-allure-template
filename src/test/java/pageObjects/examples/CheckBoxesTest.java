package pageObjects.examples;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import pageObjects.examples.checkboxes.CheckBoxPage;

public class CheckBoxesTest extends BaseTest {

    @Test
    @Step("checkboxes test started")
    @Description(value = "test checks interaction with checkboxes")
    public void checkboxesTest(){
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        CheckBoxPage checkBoxPage = welcomePage.clickOnCheckboxPagePageLink();
        assertions.url(checkBoxPage.getExpectedUrl());
        checkBoxPage.selectCheckBox(checkBoxPage.getCheckBox1());
        assertions.isSelected(checkBoxPage.getCheckBox1());

        checkBoxPage.selectCheckBox(checkBoxPage.checkBoxTest);
        assertions.isSelected(checkBoxPage.checkBoxTest);

        checkBoxPage.unselectAllCheckboxes(checkBoxPage.getCheckBoxGroup());
        assertions.isAllUnselected(checkBoxPage.getCheckBoxGroup());
        checkBoxPage.selectAllCheckboxes(checkBoxPage.getCheckBoxGroup());
        assertions.isAllSelected(checkBoxPage.getCheckBoxGroup());
        checkBoxPage.unselectCheckbox(checkBoxPage.getCheckBox2());
        assertions.isUnselected(checkBoxPage.getCheckBox2());
        assertions.isSelected(checkBoxPage.getCheckBox2());
    }
}
