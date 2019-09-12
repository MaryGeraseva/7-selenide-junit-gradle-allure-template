package common.reporting;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Attachments {

    private Logger log = LogInstance.getLogger();

    public void getScreenshotFile(String path) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    public byte[] getScreenshotByte() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        return  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String getTodayDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    public String getSystemTime() {
        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    public List<LogEntry> getBrowserLogs() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        LogEntries logs = driver.manage().logs().get("browser");
        return logs.getAll();
    }

    public void getErrorTrace(Throwable cause) {
        log.error(cause.getMessage());
        String stackTrace = "\n\n";
        for (StackTraceElement element : cause.getStackTrace()) {
            stackTrace += element.toString() + "\n";
        }
        log.error(stackTrace);
    }

    @Attachment
    public static byte[] attachment(ExtensionContext context) throws IOException {
        return Files.readAllBytes(getLogsFilePath(context));
    }

    public static Path getLogsFilePath(ExtensionContext context) {
        return Paths.get(String.format("%s\\build\\reports\\logsByTestMethod\\%s\\%s.log",
                System.getProperty("user.dir"), context.getTestMethod().get().getName(), context.getDisplayName()));
    }

    public String getScreenshotPath(ExtensionContext context) {
        return String.format("%s\\build\\reports\\screenshots\\test\\%s\\%s\\%s.png",
                System.getProperty("user.dir"), getTodayDate(), context.getDisplayName(), getSystemTime());
    }

    public void addLogsToReport(ExtensionContext context) {
        try {
            attachment(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addScreenshotToReport(ExtensionContext context) {
        getScreenshotFile(getScreenshotPath(context));
        saveScreenshot(getScreenshotByte());
    }
}
