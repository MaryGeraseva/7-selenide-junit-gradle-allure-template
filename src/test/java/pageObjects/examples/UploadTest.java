package pageObjects.examples;

import assertions.ExtendedAssertions;
import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class UploadTest extends BaseTest {

    @ParameterizedTest(name = "upload test #{0}")
    @CsvSource({
            "1, 'index.html'",
            "2, 'logo.png'",
            "3, 'text.txt'"
    })
    @Step("upload test started")
    @Description(value = "test checks file upload")
    public void uploadTest(int testId, String fileName) {
        UploadPage page = new UploadPage();
        page.open();
        page.addFile(fileName);
        page.clickOnUploadButton();
        String currentFileName = page.getFileName();
        Assertions.assertEquals(fileName, currentFileName);
    }
}

