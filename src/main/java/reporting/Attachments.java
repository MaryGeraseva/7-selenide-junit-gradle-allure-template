package reporting;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Attachments {

    protected void addLogsToReport(ExtensionContext context) {
        try {
            attachLogsFile(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void addScreenshotToReport(ExtensionContext context) {
        getScreenshotFile(getScreenshotPath(context));
        attachScreenshot(getScreenshotByte());
    }

    @Attachment
    private static byte[] attachLogsFile(ExtensionContext context) throws IOException {
        return Files.readAllBytes(getLogsFilePath(context));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] attachScreenshot(byte[] screenShot) {
        return screenShot;
    }

    private void getScreenshotFile(String path) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getScreenshotByte() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public void getErrorTrace(Throwable cause) {
        Logger log = LogInstance.getLogger();
        log.error(cause.getMessage());
        String stackTrace = "\n\n";
        for (StackTraceElement element : cause.getStackTrace()) {
            stackTrace += element.toString() + "\n";
        }
        log.error(stackTrace);
    }

    private static Path getLogsFilePath(ExtensionContext context) {
        return Paths.get(String.format("%s\\build\\reports\\logsByTestMethod\\%s\\%s.log",
                System.getProperty("user.dir"), context.getTestMethod().get().getName(), context.getDisplayName()));
    }

    private String getScreenshotPath(ExtensionContext context) {
        return String.format("%s\\build\\reports\\screenshots\\test\\%s\\%s\\%s.png",
                System.getProperty("user.dir"), getTodayDate(), context.getDisplayName(), getSystemTime());
    }

    private static String getTodayDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    private String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }
}
