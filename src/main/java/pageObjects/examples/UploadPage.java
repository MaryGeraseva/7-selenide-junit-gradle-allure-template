package pageObjects.examples;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageObjects.BasePageObject;
import webElements.Button;
import webElements.InputField;
import webElements.TextField;
import webElements.Upload;

public class UploadPage extends BasePageObject {

    public UploadPage() {
        super("http://the-internet.herokuapp.com/upload");
    }

    Upload addFileButton = new Upload(By.id("file-upload"));
    Button uploadFileButton = new Button(By.id("file-submit"));
    TextField result = new TextField(By.id("uploaded-files"));

    @Step("add the file")
    public void addFile(String fileName) {
        String filePath = String.format("%s\\src\\test\\resources\\files\\%s", System.getProperty("user.dir"), fileName);
        addFileButton.addFile(filePath);
    }

    @Step("click on the upload button")
    public void clickOnUploadButton() {
        uploadFileButton.click();
    }

    @Step("get uploaded file name")
    public String getFileName() {
        return result.getText();
    }
}
