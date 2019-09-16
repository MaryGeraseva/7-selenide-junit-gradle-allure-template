package pageObjects.examples.checkboxes;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.BasePageObject;
import webElements.Checkbox;
import webElements.CheckboxesGroup;

import static com.codeborne.selenide.Selenide.$;

public class CheckBoxPage2 extends BasePageObject {

    public CheckBoxPage2() {
        super("https://material.angular.io/components/checkbox/overview");
    }

    private Checkbox checkBoxDiv = new Checkbox(By.xpath("//div[@class='mat-checkbox-inner-container']"),
            By.xpath("//input[@id='mat-checkbox-1-input']"));

    @Step("select checkbox")
    public void selectCheckBox(Checkbox checkBox) {
        checkBox.selectWithClick();
    }

    @Step("unselect checkbox")
    public void unselectCheckbox(Checkbox checkBox) {
        checkBox.unselectWithClick();
    }

    @Step("select checkboxes group")
    public void selectAllCheckboxes(CheckboxesGroup checkBoxes) {
        checkBoxes.select();
    }

    @Step("unselect checkboxes group")
    public void unselectAllCheckboxes(CheckboxesGroup checkBoxes) {
        checkBoxes.unselect();
    }

    public Checkbox getCheckBoxDiv() {
        return checkBoxDiv;
    }

}
