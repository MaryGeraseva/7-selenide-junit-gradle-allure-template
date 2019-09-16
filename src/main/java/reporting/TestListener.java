package reporting;


import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestListener implements TestWatcher{

    private Attachments attachment = new Attachments();
    private Logger log;

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log = LogInstance.getLogger();
        log.info(String.format("%s disabled", context.getDisplayName()));
        attachment.addLogsToReport(context);
        LogInstance.resetLog();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log = LogInstance.getLogger();
        log.info(String.format("%s finished successfully", context.getDisplayName()));
        attachment.addLogsToReport(context);
        LogInstance.resetLog();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log = LogInstance.getLogger();
        attachment.getErrorTrace(cause);
        log.info(String.format("%s aborted", context.getDisplayName()));
        attachment.addLogsToReport(context);
        attachment.addScreenshotToReport(context);
        LogInstance.resetLog();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log = LogInstance.getLogger();
        attachment.getErrorTrace(cause);
        log.info(String.format("%s failed", context.getDisplayName()));
        attachment.addLogsToReport(context);
        attachment.addScreenshotToReport(context);
        LogInstance.resetLog();
    }
}
