package pageObjects.examples;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.BasePageObject;
import webElements.Button;

public class LoginPage extends BasePageObject {

    public LoginPage() {
        super("http://the-internet.herokuapp.com/secure");
    }

    Button logoutButton = new Button(By.xpath("//i[@class='icon-2x icon-signout']"));


    @Step("click on the logout button")
    public MainPage clickLogoutButton() {
        logoutButton.click();
        return new MainPage();
    }
}
