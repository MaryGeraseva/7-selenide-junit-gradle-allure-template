package pageObjects.examples;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.BasePageObject;
import pageObjects.examples.checkboxes.CheckBoxPage;
import webElements.Link;


public class WelcomePage extends BasePageObject {

    public WelcomePage() {
        super("http://the-internet.herokuapp.com/");
    }

    private Link mainPage = new Link(By.linkText("Form Authentication"));
    private Link checkboxPage = new Link(By.linkText("Checkboxes"));

    @Step("click on the link and go to main page")
    public MainPage clickOnMainPageLink() {
        mainPage.click();
        return new MainPage();
    }

    @Step("click on the link and go to checkbox page")
    public CheckBoxPage clickOnCheckboxPagePageLink() {
        checkboxPage.click();
        return new CheckBoxPage();
    }
}
