package pageObjects.examples.checkboxes;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.BasePageObject;
import webElements.Checkbox;
import webElements.CheckboxesGroup;

import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxPage extends BasePageObject {

    public CheckBoxPage() {
        super("http://the-internet.herokuapp.com/checkboxes");
    }

    private Checkbox checkBox1 = new Checkbox(By.xpath("//form[@id='checkboxes']//input[1]"));
    private Checkbox checkBox2 = new Checkbox(By.xpath("//form[@id='checkboxes']//input[2]"));
    public Checkbox checkBoxTest = new Checkbox($x("//form[@id='checkboxes']").$x("input[1]"));
    private CheckboxesGroup checkBoxGroup = new CheckboxesGroup(By.xpath("//form[@id='checkboxes']//input"));

    @Step("select checkbox")
    public void selectCheckBox(Checkbox checkBox) {
        checkBox.select();
    }

    @Step("unselect checkbox")
    public void unselectCheckbox(Checkbox checkBox) {
        checkBox.unselect();
    }

    @Step("select checkboxes group")
    public void selectAllCheckboxes(CheckboxesGroup checkBoxes) {
        checkBoxes.select();
    }

    @Step("unselect checkboxes group")
    public void unselectAllCheckboxes(CheckboxesGroup checkBoxes) {
        checkBoxes.unselect();
    }

    public Checkbox getCheckBox1() {
        return checkBox1;
    }

    public Checkbox getCheckBox2() {
        return checkBox2;
    }

    public CheckboxesGroup getCheckBoxGroup() {
        return checkBoxGroup;
    }
}
