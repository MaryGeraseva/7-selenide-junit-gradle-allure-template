package assertions;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

public class ExtendedAssertions {

    @Step("check page by current url")
    public void url(String expectedUrl) {
        String currentUrl = WebDriverRunner.url();
        Assertions.assertEquals(expectedUrl, currentUrl,
                String.format("expected page with url %s wasn't opened, current url is %s", expectedUrl, currentUrl));
    }
}
